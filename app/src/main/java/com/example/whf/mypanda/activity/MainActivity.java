package com.example.whf.mypanda.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.base.BaseActivity;
import com.example.whf.mypanda.view.fragment.BObFragment;
import com.example.whf.mypanda.view.fragment.GunGFragment;
import com.example.whf.mypanda.view.fragment.ShouYFragment;
import com.example.whf.mypanda.view.fragment.ZhiBoFragment;
import com.example.whf.mypanda.view.fragment.ZhonGFragment;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private FrameLayout vp;
    private RadioButton rad_sy;
    private RadioButton rad_zb;
    private RadioButton rad_gg;
    private RadioButton rad_bb;
    private RadioButton rad_zg;
    private RadioGroup rg;
    private List<Fragment> list;
    private FragmentManager manager;

    @Override
    protected void initView() {
        vp = (FrameLayout) findViewById(R.id.vp);
        rad_sy = (RadioButton) findViewById(R.id.rad_sy);
        rad_zb = (RadioButton) findViewById(R.id.rad_zb);
        rad_gg = (RadioButton) findViewById(R.id.rad_gg);
        rad_bb = (RadioButton) findViewById(R.id.rad_bb);
        rad_zg = (RadioButton) findViewById(R.id.rad_zg);
        rg = (RadioGroup) findViewById(R.id.rg);
        addFragment(R.id.vp,new ShouYFragment());
        initListenre();
    }
    private void initListenre() {
        manager=getSupportFragmentManager();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rad_sy:
                        replaceFragment(R.id.vp,new ShouYFragment());
                        break;
                    case R.id.rad_zb:
                        replaceFragment(R.id.vp,new ZhiBoFragment());
                        break;
                    case R.id.rad_gg:
                        replaceFragment(R.id.vp,new GunGFragment());
                        break;
                    case R.id.rad_bb:
                        replaceFragment(R.id.vp,new BObFragment());
                        break;
                    case R.id.rad_zg:
                        replaceFragment(R.id.vp,new ZhonGFragment());
                        break;
                }
            }
        });


    }



    @Override
    protected int getActicityId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
