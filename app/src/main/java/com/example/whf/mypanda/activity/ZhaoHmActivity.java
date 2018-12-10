package com.example.whf.mypanda.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.whf.mypanda.R;

public class ZhaoHmActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image_fanh;
    private EditText edit_zh;
    private EditText edit_pas;
    private Button rad_zc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhao_hm);
        initView();
    }

    private void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        edit_zh = (EditText) findViewById(R.id.edit_zh);
        edit_pas = (EditText) findViewById(R.id.edit_pas);
        rad_zc = (Button) findViewById(R.id.rad_zc);
        rad_zc.setOnClickListener(this);
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rad_zc:

                break;
        }
    }

    private void submit() {
        // validate
        String zh = edit_zh.getText().toString().trim();
        if (TextUtils.isEmpty(zh)) {
            Toast.makeText(this, "请输入注册时的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String pas = edit_pas.getText().toString().trim();
        if (TextUtils.isEmpty(pas)) {
            Toast.makeText(this, "请设置新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
