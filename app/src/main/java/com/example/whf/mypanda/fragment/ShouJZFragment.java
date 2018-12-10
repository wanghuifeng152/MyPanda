package com.example.whf.mypanda.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.example.whf.mypanda.R;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouJZFragment extends Fragment implements View.OnClickListener {


    private EditText edit_zh;
    private Button but_yz;
    private EditText edit_pas;
    private Button rad_zc;
    private String string;
    private CountDownTimer timer;
    private TextView image_tp;
    private TextView text_sj;
    private EditText edit_tp;
    private TextView text_tp;
    private TextView text_nu;
    private EditText edi_sjm;
    private TextView text_null;
    private TextView text_psw;

    private String s;
    private String tImageChcek;
    private byte[] bytes;
    private FormBody formBody;
    private String phoneString;
    private String phonecheck;
    private Request post;
    private String pass;
    private Handler handler;
    private Handler handler1;
    private TimeCount mTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_shou_jz, container, false);
        initView(inflate);
        initListenre();
        return inflate;
    }

    private void initListenre() {
        /*image_tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_tp.setImageBitmap(CodeUtils.getInstance().createBitmap());
            }
        });*/
        edit_tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_zh.getText().toString().equals("")){
                    text_sj.setVisibility(View.VISIBLE);
                }
            }
        });
        edi_sjm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_tp.getText().toString().equals("")) {
                    text_tp.setVisibility(View.INVISIBLE);
                    text_nu.setVisibility(View.VISIBLE);
                }
            }
        });
        edit_pas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edi_sjm.getText().toString().equals("")){
                    text_null.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    private void initView(View inflate) {
        edit_zh = (EditText) inflate.findViewById(R.id.edit_zh);
        but_yz = (Button) inflate.findViewById(R.id.but_yz);
        edit_pas = (EditText) inflate.findViewById(R.id.edit_pas);
        rad_zc = (Button) inflate.findViewById(R.id.rad_zc);
        image_tp = (TextView) inflate.findViewById(R.id.image_tp);
        text_sj = (TextView) inflate.findViewById(R.id.text_sj);
        edit_tp = (EditText) inflate.findViewById(R.id.edit_tp);
        text_tp = (TextView) inflate.findViewById(R.id.text_tp);
        text_nu = (TextView) inflate.findViewById(R.id.text_nu);
        edi_sjm = (EditText) inflate.findViewById(R.id.edi_sjm);
        text_null = (TextView) inflate.findViewById(R.id.text_null);
        text_psw = (TextView) inflate.findViewById(R.id.text_psw);
        //构造CountDownTimer对象
        mTime = new TimeCount(60000, 1000);

        image_tp.setOnClickListener(this);
        but_yz.setOnClickListener(this);
        rad_zc.setOnClickListener(this);
        sendCaptchaHttpMessage();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.image_tp:
                sendCaptchaHttpMessage();
                break;
            case R.id.but_yz:
                edit_zh.clearFocus();
                edit_tp.clearFocus();
                edi_sjm.clearFocus();

                tImageChcek = edit_tp.getText().toString().trim();

                if (TextUtils.isEmpty(tImageChcek)) {
                    text_nu.setText("图片验证码输入有误");
                }
                if(!checkPhone()){
                    return;
                }
                if(!checkCaptcha()){
                    return;
                }else {

                    text_null.setText("");
                    text_sj.setText("");

                    sendCaptchaSmsHttpMessage();
                }

                break;
            case R.id.rad_zc:
                edit_zh.clearFocus();
                edit_tp.clearFocus();
                edit_pas.clearFocus();
                edi_sjm.clearFocus();


                //点击注册
                if (!checkPhone()) {
                    return;
                }


                if (!checkCaptcha()) {
                    return;
                }

                if (!checkPhoneCheck()) {

                    return;
                }
                if (!checkPasswork()) {
                    return;
                }


                sendPhoneRegistHttp();

                break;
        }
    }

    /**
     * 注册请求
     */
    @SuppressLint("HandlerLeak")
    private void sendPhoneRegistHttp() {


        String url = "https://reg.cntv.cn/regist/mobileRegist.do";
        pass = edit_pas.getText().toString();
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody formBody =  null;
        try {
            formBody = new FormBody.Builder()
                    .add("method","saveMobileRegisterM")
                    .add("mobile", phoneString)
                    .add("verfiCode", phonecheck)
                    .add("verfiCodeType", "1")
                    .add("passWd", URLEncoder.encode(pass, "UTF-8"))
                    .add("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Request request = null;
        try {
            request = new Request.Builder().url(url)
                    .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .method("POST", formBody)
                    .build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Request build = new Request.Builder().url("https://reg.cctv.com/register/mobileRegister.action?callback=jQuery17208356351393710961_1524071134757&mobile="+phoneString+"&verfiCode="+phonecheck+"&passWd=1222r422&verifyPasswd=1222r422&addons=http%3A%2F%2Fwww.ipanda.com&verfiCodeType=1&method=saveMobileRegisterM&_"+System.currentTimeMillis()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                android.util.Log.e("::::::",e.getMessage()+"shibai");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                android.util.Log.e("::::::",string);

                handler1.obtainMessage(1,string).sendToTarget();
            }
        });


        handler1 = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                String tString = (String) msg.obj;
                Log.i("aaaa", tString);
                if (tString.endsWith("success")) {
                    Toast.makeText(getContext(), "手机号注册成功,2秒后返回到登陆页面！", Toast.LENGTH_SHORT).show();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = getActivity().getIntent();
                            intent.putExtra("username",edit_zh.getText().toString());
                            intent.putExtra("password",edit_pas.getText().toString());
                            getActivity().setResult(1,intent);
                            getActivity().finish();
                        }
                    }, 3000);
                } else if (tString.endsWith("registered")) {
                    Toast.makeText(getContext(), "该手机号已注册", Toast.LENGTH_SHORT).show();
                } else if (tString.endsWith("error")) {
                    Toast.makeText(getContext(), "验证码输入有误", Toast.LENGTH_SHORT).show();
                } else if (tString.endsWith("mobilenull")) {
                    Toast.makeText(getContext(), "手机号为空", Toast.LENGTH_SHORT).show();
                } else if (tString.endsWith("timeout")) {
                    Toast.makeText(getContext(), "校验码已超过有效时间", Toast.LENGTH_SHORT).show();
                } else if (tString.endsWith("passwordnull")) {
                    Toast.makeText(getContext(), "密码为空", Toast.LENGTH_SHORT).show();
                }
            }
        };

    }


    /**
     * 检查密码
     *
     * @return
     */
    private boolean checkPasswork() {
        String editpasswordsString = edit_pas.getText().toString();

        if (TextUtils.isEmpty(editpasswordsString)) {
            text_psw.setText("密码不能为空");
            return false;
        } else if (editpasswordsString.length() < 6 || editpasswordsString.length() > 16) {
            text_psw.setText("密码仅限6-16个字符");
            return false;
        } else {
            text_psw.setText("");
            return true;
        }
    }

    /**
     * 检查手机验证码
     */

    private boolean checkPhoneCheck() {
        phonecheck = edi_sjm.getText().toString().trim();

        if (TextUtils.isEmpty(phonecheck)) {
            text_null.setText("验证码不能为空");
            return false;
        } else {
            text_null.setText(" ");
            return true;
        }
    }


    /**
     * 检查验证码
     *
     * @return
     */
    private boolean checkCaptcha() {
        if (bytes == null) {
            Toast.makeText(getActivity(), "未获取验证码", Toast.LENGTH_SHORT).show();
            return false;
        }

        tImageChcek = edit_tp.getText().toString().trim();
        if(tImageChcek.contains(" ")){
            text_nu.setText("验证码不正确");
            return false;
        }
        if (tImageChcek == null || "".equals(tImageChcek)) {
            text_nu.setText("验证码不能为空");
            return false;
        } else {
            text_nu.setText("");
            return true;
        }

    }


    //检查手机号
    private boolean checkPhone() {
        String phoneString = edit_zh.getText().toString().trim();
        if (TextUtils.isEmpty(phoneString)) {
            text_sj.setText("手机号码不能为空");
            return false;
        }
        Pattern pattern = Pattern.compile("^1[3578]\\d{9}$");
        Matcher matcher = pattern.matcher(phoneString);
        if (matcher.matches()) {
            text_sj.setText("");
            return true;
        } else {
            text_sj.setText("手机格式不正确");
            return false;
        }
    }


    /**
     * 短信验证码的请求
     */
    private void sendCaptchaSmsHttpMessage() {


        phoneString = edit_zh.getText().toString().trim();
        String phoneyanzhengma = edit_tp.getText().toString().trim();
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";

        OkHttpClient okHttpClient = new OkHttpClient();

        formBody = new FormBody.Builder()
                .add("method","getRequestVerifiCodeM")
                .add("mobile", phoneString)
                .add("verfiCodeType","1")
                .add("verificationCode",phoneyanzhengma)
                .build();
        try {
            post = new Request.Builder().url(url)
                    .addHeader("Referer", URLEncoder.encode(from, "UTF-8"))
                    .addHeader("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie",s).method("POST", formBody).build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // Request build = new Request.Builder().url("http://reg.cctv.com/regist/getVerifiCode.action?callback=jQuery172006025648444264009_1524067452911&mobile="+ phoneString +"&isCheckCode=1&verfiCodeType=1&method=getRequestVerifiCodeM&_="+System.currentTimeMillis()).build();
        okHttpClient.newCall(post).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                android.util.Log.e("::::::",e.getMessage()+"shibai");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                android.util.Log.e("::::",string);

                handler.obtainMessage(1,string).sendToTarget();
            }
        });


        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                String string = (String) msg.obj;
                if (string.endsWith("success")) {
                    Toast.makeText(getContext(), "发送成功", Toast.LENGTH_SHORT).show();
                    mTime.start();
                } else if (string.endsWith("registered")) {
                    Toast.makeText(getContext(), "您的手机号已注册", Toast.LENGTH_SHORT).show();

                } else if (string.endsWith("sendfailure")) {
                    Toast.makeText(getContext(), "验证码发送失败", Toast.LENGTH_SHORT).show();
                } else if (string.endsWith("sendagain")) {
                    Toast.makeText(getContext(), "三分钟内只能获取一次", Toast.LENGTH_SHORT).show();
                } else if (string.endsWith("ipsendagain")) {
                    Toast.makeText(getContext(), "同一IP用户请求校验码超过5次", Toast.LENGTH_SHORT).show();
                } else if (string.endsWith("mobileoften")) {
                    Toast.makeText(getContext(), "同一手机号用户请求校验码超过3次", Toast.LENGTH_SHORT).show();
                } else if (string.endsWith("mobilecodeerror")) {
                    Toast.makeText(getContext(), "验证码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        };

    }


    /**
     * 获取图片验证码
     */
    private void sendCaptchaHttpMessage() {


        String from = "http://reg.cntv.cn/simple/verificationCode.action";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(from).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        image_tp.setText("图形验证码");
                        sendCaptchaHttpMessage();
                        image_tp.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response1) throws IOException {
                Response response =  response1;

                Headers headers = response.headers();
                s = headers.get("Set-Cookie");

                bytes = response.body().bytes();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Drawable captchaImage = byteToDrawable(bytes);
                        image_tp.setBackgroundDrawable(captchaImage);
                        image_tp.setText("");
                    }
                });
            }
        });


    }

    public static Drawable byteToDrawable(byte[] byteArray) {
        try {
            String string = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }


    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {//计时完毕时触发
            but_yz.setText("获取验证码");
            but_yz.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            but_yz.setClickable(false);
            but_yz.setText("重新获取"+"("+millisUntilFinished / 1000 +")" );
        }
    }
}
