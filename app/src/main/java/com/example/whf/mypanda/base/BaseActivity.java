package com.example.whf.mypanda.base;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.example.whf.mypanda.global.BaseApp;


/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public abstract class BaseActivity extends AppCompatActivity{

    private FragmentManager manager;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActicityId());
        BaseApp.mcontext = this;
        manager=getSupportFragmentManager();
        initView();
    }

    protected abstract void initView();

    protected abstract int getActicityId();

    /*
    添加Fragment
     */
    protected void addFragment(int getFragmentId, Fragment fragment){
        manager.beginTransaction()
                .add(getFragmentId,fragment,fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }

    protected void replaceFragment(int getFragmentId, Fragment fragment){
        manager.beginTransaction()
                .replace(getFragmentId,fragment,fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }
    /*
    移除Fragment
     */

    protected void reomveFragment(){
        if (manager.getBackStackEntryCount()>1){
            manager.popBackStack();
        }else {
            finish();
        }
    }
//监听手机返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if (manager.getBackStackEntryCount()==1){
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
