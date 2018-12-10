package com.example.whf.mypanda.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.base.BaseActivity;
import com.example.whf.mypanda.fragment.ShouJZFragment;
import com.example.whf.mypanda.fragment.YouXZFragment;
import com.example.whf.mypanda.view.fragment.ShouYFragment;

public class ZhuCActivity extends BaseActivity {

    private ImageView image_fanh;
    private RadioButton rad_sjzc;
    private RadioButton rad_yxzc;
    private RadioGroup rg;
    private FragmentManager manager;
    private FrameLayout frag_lay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_c);
        initView();
        inttListenre();
    }

    private void inttListenre() {
        manager = getSupportFragmentManager();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rad_sjzc:
                        replaceFragment(R.id.frag_lay,new ShouJZFragment());
                        break;
                    case R.id.rad_yxzc:
                        replaceFragment(R.id.frag_lay,new YouXZFragment());
                        break;

                }
            }
        });
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    protected void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        rad_sjzc = (RadioButton) findViewById(R.id.rad_sjzc);
        rad_yxzc = (RadioButton) findViewById(R.id.rad_yxzc);
        rg = (RadioGroup) findViewById(R.id.rg);
        frag_lay = (FrameLayout) findViewById(R.id.frag_lay);
        addFragment(R.id.frag_lay,new ShouJZFragment());

    }

    @Override
    protected int getActicityId() {
        return R.layout.activity_zhu_c;
    }
}
