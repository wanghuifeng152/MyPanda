package com.example.whf.mypanda.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.utils.DataCleanManager;

public class SetupActivity extends AppCompatActivity {

    private ImageView image_fanh;
    private ImageView image_xwx;
    private ImageView image_xxz;
    private ImageView image_bfwx;
    private ImageView image_bfxz;
    private TextView text_dele;
    private TextView text_bz;
    private TextView text_jc;
    private TextView text_pl;
    private TextView text_gy;
    private LinearLayout sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
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
        sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new AlertDialog.Builder(SetupActivity.this)
                        .setTitle("清除缓存提醒")
                        .setMessage("是否确认清除缓存？")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DataCleanManager.clearAllCache(SetupActivity.this);
                                try {
                                    String size = DataCleanManager.getTotalCacheSize(SetupActivity.this);
                                    text_dele.setText(size + "");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                Toast.makeText(SetupActivity.this, "缓存已清理", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .create();
                dialog.show();
            }
        });

    }

    private void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        image_xwx = (ImageView) findViewById(R.id.image_xwx);
        image_xxz = (ImageView) findViewById(R.id.image_xxz);
        image_bfwx = (ImageView) findViewById(R.id.image_bfwx);
        image_bfxz = (ImageView) findViewById(R.id.image_bfxz);
        text_dele = (TextView) findViewById(R.id.text_dele);
        text_bz = (TextView) findViewById(R.id.text_bz);
        text_jc = (TextView) findViewById(R.id.text_jc);
        text_pl = (TextView) findViewById(R.id.text_pl);
        text_gy = (TextView) findViewById(R.id.text_gy);
        sc = (LinearLayout) findViewById(R.id.sc);
        try {
            String size = DataCleanManager.getTotalCacheSize(SetupActivity.this);
            text_dele.setText(size + "");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
