package com.example.whf.mypanda.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.adapter.MyPandaZhB;
import com.example.whf.mypanda.fragment.ScJinCFragment;
import com.example.whf.mypanda.fragment.ShouCZbFragment;

import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends AppCompatActivity {


    private TabLayout tab_layout;
    private ViewPager vp;
    private ImageView image_fanh;
    private TextView text_qx;
    private TextView text_sc;
    private TextView text_bj;
    private LinearLayout lienar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        initView();
        initData();
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        list.add("直播");
        list.add("精彩看点");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ShouCZbFragment());
        fragmentList.add(new ScJinCFragment());
        MyPandaZhB myPandaZhB = new MyPandaZhB(getSupportFragmentManager(), list, fragmentList);
        tab_layout.setupWithViewPager(vp);
        vp.setAdapter(myPandaZhB);

    }


    private void initView() {
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        vp = (ViewPager) findViewById(R.id.vp);
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        text_qx = (TextView) findViewById(R.id.text_qx);
        text_sc = (TextView) findViewById(R.id.text_sc);
        text_bj = (TextView) findViewById(R.id.text_bj);
        lienar = (LinearLayout) findViewById(R.id.lienar);

    }
}
