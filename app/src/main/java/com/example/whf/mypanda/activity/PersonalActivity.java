package com.example.whf.mypanda.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.whf.mypanda.R;
import com.squareup.picasso.Picasso;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class PersonalActivity extends AppCompatActivity {

    private ImageView image_fanh;
    private TextView ls;
    private TextView sc;
    private LinearLayout linear_per;
    private TextView sz;
    private ImageView image_tx;
    private TextView text_tx;
    private String nametx;
    private String iconurltx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
        initListenre();
    }

    private void initListenre() {
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //跳到登录界面
        linear_per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences isLogin = getSharedPreferences("isLogin", 0);
                boolean login = isLogin.getBoolean("login", false);
                Log.e("TAG", "onClick: ----------->"+login );
                if (!login){

                    Intent intent = new Intent(PersonalActivity.this, LoginActivity.class);
                    startActivityForResult(intent,110);
                }else {
                    Intent intent = new Intent(PersonalActivity.this, InformaActivity.class);
                    intent.putExtra("image",iconurltx);
                    intent.putExtra("name",nametx);
                    startActivity(intent);
                }


            }
        });
        //查看观看历史
        ls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
        //跳到我的收藏界面
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, CollectionActivity.class);
                startActivity(intent);
            }
        });
        //跳到设置界面
        sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalActivity.this, SetupActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        ls = (TextView) findViewById(R.id.ls);
        sc = (TextView) findViewById(R.id.sc);
        linear_per = (LinearLayout) findViewById(R.id.linear_per);
        sz = (TextView) findViewById(R.id.sz);
        image_tx = (ImageView) findViewById(R.id.image_tx);
        text_tx = (TextView) findViewById(R.id.text_tx);
        final SharedPreferences sp = getSharedPreferences("isLogin", 0);

        if(sp.getBoolean("login", false)){
            String name = sp.getString("name", "点击登陆");
            String iconurl = sp.getString("iconurl", null);
            text_tx.setText(name);
            Glide.with(this)
                    .load(iconurl)
                    .bitmapTransform(new CropCircleTransformation(this))
                    .into(image_tx);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==110&&resultCode==111){
            nametx = data.getStringExtra("name");
            iconurltx = data.getStringExtra("iconurl");
            text_tx.setText(nametx);
            Picasso.with(PersonalActivity.this).load(iconurltx).into(image_tx);

        }else if(resultCode==1){
            SharedPreferences user = getSharedPreferences("user", 0);
            String name = user.getString("name", null);
            String pass = user.getString("pass", null);
            text_tx.setText(name);
            Picasso.with(PersonalActivity.this).load(pass).into(image_tx);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences isLogin = getSharedPreferences("isLogin", 0);
        boolean login = isLogin.getBoolean("login", false);
        if (login){
            image_tx.setImageResource(R.mipmap.personal_login_head);
            text_tx.setText("点击登录");
        }
    }
}
