package com.example.whf.mypanda.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whf.mypanda.R;

public class UpdataNameActivity extends AppCompatActivity {

    private TextView tv_save;
    private Toolbar toolbar;
    private EditText et_updatename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_name);
        initView();

    }

    private void initView() {
        tv_save = (TextView) findViewById(R.id.tv_save);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        et_updatename = (EditText) findViewById(R.id.et_updatename);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        et_updatename.setText(name);

        et_updatename.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv_save.setTextColor(Color.parseColor("#ffffffff"));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void submit() {
        // validate
        String updatename = et_updatename.getText().toString().trim();
        if (TextUtils.isEmpty(updatename)) {
            Toast.makeText(this, "updatename不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
