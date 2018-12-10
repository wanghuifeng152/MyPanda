package com.example.whf.mypanda.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.whf.mypanda.R;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class InformaActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView iv_iconurl;
    private LinearLayout linear1;
    private TextView tv_name;
    private LinearLayout linear2;
    private Button btn_edit, btn_takepic, btn_photo, btn_cancel, btn_ok;
    private PopupWindow popupWindow;
    private PopupWindow popupWindow2;
    private View view;
    private View view2;
    private LinearLayout linear;
    private String mFilename;
    private static final int CODE_GALLERY_REQUEST = 0;
    private static final int CODE_CAMERA_REQUEST = 1;
    public final static String BASE_URL = "http://my.cntv.cn/intf/napi/api.php";
    public static final String CLIENT = "ipanda_mobile";
    private String name;
    private static File cutfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informa);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        iv_iconurl = (ImageView) findViewById(R.id.iv_iconurl);
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        tv_name = (TextView) findViewById(R.id.tv_name);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        linear = (LinearLayout) findViewById(R.id.linear);

        btn_edit.setOnClickListener(this);
        linear1.setOnClickListener(this);
        linear2.setOnClickListener(this);
        linear.setOnClickListener(this);

        setSupportActionBar(toolbar);

        SharedPreferences isLogin = getSharedPreferences("isLogin", 0);
        name = isLogin.getString("name", null);
        String iconurl = isLogin.getString("iconurl", null);
        tv_name.setText(name);
        Glide.with(this)
                .load(iconurl)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(iv_iconurl);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        view = LinearLayout.inflate(this, R.layout.layout_pop, null);
        btn_photo = (Button) view.findViewById(R.id.btn_photo);
        btn_takepic = (Button) view.findViewById(R.id.btn_takepic);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);

        btn_photo.setOnClickListener(this);
        btn_takepic.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

        view2 = LinearLayout.inflate(this, R.layout.layout_pop2, null);
        btn_ok = (Button) view2.findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit:
                SharedPreferences sp = getSharedPreferences("isLogin", 0);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("login", false);
                edit.commit();

                Intent intent = new Intent(InformaActivity.this, PersonalActivity.class);
                setResult(311, intent);
                finish();
                break;
            case R.id.linear1:
                popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.showAtLocation(linear, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.linear2:
                Intent updataIntent = new Intent(InformaActivity.this, UpdataNameActivity.class);
                updataIntent.putExtra("name", name);
                startActivityForResult(updataIntent, 223);
                break;
            case R.id.btn_photo:
                Intent intentFromGallery = new Intent(Intent.ACTION_PICK, null);
                // 设置文件类型
                intentFromGallery.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
                popupWindow.dismiss();
                break;
            case R.id.btn_ok:
                popupWindow2.dismiss();
                break;
            case R.id.btn_takepic:
                String s = Environment
                        .getExternalStorageDirectory()
                        + File.separator
                        + "pandatv"
                        + File.separator
                        + "camera"
                        + File.separator;
                mFilename = s + android.text.format.DateFormat
                        .format("yyyyMMddkkmmss",
                                new Date()).toString() + ".jpg";

                Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri turi = Uri.fromFile(new File(mFilename));
                intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, turi);
                startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);
                popupWindow.dismiss();
                break;
            case R.id.btn_cancel:
                popupWindow.dismiss();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODE_GALLERY_REQUEST) {
            Intent cropImageIntent = getCropImageIntent(data.getData());
            startActivityForResult(cropImageIntent, 77);
        }

        if (requestCode == 77) {/*
            Bundle bundle = data.getExtras();
            Bitmap bitmap = bundle.getParcelable("data");
            iv_iconurl.setImageBitmap(bitmap);*/

            SharedPreferences isLogin = getSharedPreferences("isLogin", 0);
            String userid = isLogin.getString("userid", null);
            String verifycode = isLogin.getString("verifycode", null);

            OkHttpClient okHttpClient = new OkHttpClient();
            MultipartBody multipartBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("Referer", "iPanda.Android")
                    .addFormDataPart("User-Agent", "CNTV_APP_CLIENT_CBOX_MOBILE")
                    .addFormDataPart("Cookie", "verifycode=" + verifycode)
                    .addFormDataPart("client", CLIENT)//添加键值对参数
                    .addFormDataPart("method", "user.alterUserFace")
                    .addFormDataPart("userid", userid)
                    .addFormDataPart("file", cutfile.getName(), RequestBody.create(MediaType.parse("file/*"), cutfile))//添加文件
                    .build();
            Request request = new Request.Builder().post(multipartBody).url(BASE_URL).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("TAG", "onFailure: " + e.getMessage());
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Log.e("TAG", "run: ---------------------" + response.body().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            popupWindow2 = new PopupWindow(view2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            popupWindow2.setFocusable(true);
                            popupWindow2.setBackgroundDrawable(new BitmapDrawable());
                            popupWindow2.showAtLocation(linear, Gravity.CENTER, 0, 0);
                        }
                    });
                }
            });
        }
    }

    public static Intent getCropImageIntent(Uri photoUri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setData(photoUri);
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 80);
        intent.putExtra("outputY", 80);
        intent.putExtra("return-data", true);
        cutfile = new File(Environment.getExternalStorageDirectory().getPath(),
                "cutcamera.png");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(cutfile));
        return intent;
    }
}