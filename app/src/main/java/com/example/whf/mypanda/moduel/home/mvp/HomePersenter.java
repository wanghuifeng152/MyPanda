package com.example.whf.mypanda.moduel.home.mvp;

import android.util.Log;
import android.widget.Toast;

import com.example.whf.mypanda.base.BaseActivity;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.moduel.home.HomeContract;
import com.example.whf.mypanda.network.ICallBack;
import com.example.whf.mypanda.network.OkHttpDemo;
import com.example.whf.mypanda.view.fragment.ShouYFragment;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public class HomePersenter implements HomeContract.BaseHomePresenter {
        private BaseFragment mhomeFragment;
        private OkHttpDemo okHttpDemo;
        private Class cass;
        private String phan;


    public HomePersenter(String url,BaseFragment homeFragment,Class css){
        this.cass=css;
        this.phan = url;
        okHttpDemo=OkHttpDemo.getOkHttpDemo();
        mhomeFragment = homeFragment;
        mhomeFragment.setPresenter(this);

    }





    @Override
    public void start() {

        okHttpDemo.get(phan, null,cass, new ICallBack<Object>() {
            @Override
            public <T> void onSucess(T t) {
                mhomeFragment.onSucess(t);
            }

            @Override
            public void onFaile(String msg) {
                Log.e("TAG", "onFaile:------------> "+msg );
            }
        });

    }
}
