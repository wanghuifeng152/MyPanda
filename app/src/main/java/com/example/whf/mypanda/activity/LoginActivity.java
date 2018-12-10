package com.example.whf.mypanda.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.entity.GetUesrId;
import com.example.whf.mypanda.entity.UserBean;
import com.google.gson.Gson;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image_fanh;
    private TextView login_zc;
    private ImageView image_vx;
    private ImageView image_qq;
    private ImageView image_wb;
    private EditText edit_name;
    private EditText edit_pas;
    private TextView text_wj;
    private Button butt_login;
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            String name = data.get("name");
            String iconurl = data.get("iconurl");
            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();

            SharedPreferences sp = getSharedPreferences("isLogin", 0);
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean("login", true);
            edit.putString("name", name);
            edit.putString("iconurl", iconurl);
            edit.commit();

            Intent intent = new Intent(LoginActivity.this,PersonalActivity.class);
            intent.putExtra("name",name);
            intent.putExtra("iconurl",iconurl);
            setResult(111, intent);
            finish();

        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };
    private String verifycodes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListenre();
    }

    private void initListenre() {
        //返回上一个界面
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //跳到下一个界面注册
        login_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ZhuCActivity.class);
                startActivity(intent);
            }
        });
        //登录微信界面
        image_vx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "登录微信成功", Toast.LENGTH_SHORT).show();
            }
        });
        //登录QQ界面
        image_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UMShareAPI.get(LoginActivity.this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
            }
        });
        //登录微博
        image_wb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "登录微博成功", Toast.LENGTH_SHORT).show();
            }
        });
        //找回密码界面
        text_wj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ZhaoHmActivity.class);
                startActivity(intent);
            }
        });
        //登录界面


    }

    private void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        login_zc = (TextView) findViewById(R.id.login_zc);
        image_vx = (ImageView) findViewById(R.id.image_vx);
        image_qq = (ImageView) findViewById(R.id.image_qq);
        image_wb = (ImageView) findViewById(R.id.image_wb);
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_pas = (EditText) findViewById(R.id.edit_pas);
        text_wj = (TextView) findViewById(R.id.text_wj);
        butt_login = (Button) findViewById(R.id.butt_login);
        butt_login.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String name = edit_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "账号：请输入邮箱或手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String pas = edit_pas.getText().toString().trim();
        if (TextUtils.isEmpty(pas)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
//登录
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.butt_login:
                String uname = edit_name.getText().toString();
                String upass = edit_pas.getText().toString();

                String from = "https://reg.cntv.cn/login/login.action";
                String url =null;
                try {
                    url = from + "?username="
                            + URLEncoder.encode(uname, "UTF-8")
                            + "&password=" + upass
                            + "&service=client_transaction" + "&from="
                            + URLEncoder.encode(from, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = null;
                try {
                    request  = new Request.Builder().url(url)
                            .addHeader("Referer", URLEncoder.encode(from, "UTF-8"))
                            .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CYNTV_MOBILE", "UTF-8"))
                            .build();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {


                        List<String> headers = response.headers("Set-Cookie");
                        String string = response.body().string();
                        GetUesrId getUesrId = new Gson().fromJson(string, GetUesrId.class);
                        String usrid = getUesrId.getUser_seq_id();
                        if(headers.size()==4){
                            verifycodes = headers.get(3);
                        }


                        Log.e("::::::;", verifycodes);

                        handler.obtainMessage(0,usrid).sendToTarget();
                    }
                });
                break;
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){

                case 0:

                    initNameAndFace((String)msg.obj);
                    Toast.makeText(LoginActivity.this, ""+(String)msg.obj, Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    };


    private void initNameAndFace(final String userid) {
        String url = "http://my.cntv.cn/intf/napi/api.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder()
                .add("client", "ipanda_mobile")
                .add("method", "user.getNickNameAndFace")
                .add("userid", userid)
                .build();

        SharedPreferences user = getSharedPreferences("isLogin", 0);
        verifycodes = user.getString("verifycode", null);
        Request request = new Request.Builder().url(url)
                .addHeader("Referer", "iPanda.Android")
                .addHeader("method", "user.getNickNameAndFace")
                .addHeader("Cookie", "verifycode=" + verifycodes).method("POST", body).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                UserBean userBean = new Gson().fromJson(response.body().string(), UserBean.class);
                String nickname = userBean.content.getNickname();
                String userface = userBean.content.getUserface();
                SharedPreferences user = getSharedPreferences("isLogin", 0);
                SharedPreferences.Editor edit = user.edit();
                edit.putBoolean("login",true);
                edit.putString("name",nickname);
                edit.putString("iconurl",userface);
                edit.putString("verifycode",verifycodes);
                edit.putString("userid",userid);
                edit.commit();
                setResult(1);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
    }
}
