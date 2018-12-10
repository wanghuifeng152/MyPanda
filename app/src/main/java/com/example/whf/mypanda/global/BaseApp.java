package com.example.whf.mypanda.global;

import android.app.Application;
import android.content.Context;

import com.example.whf.mypanda.base.BaseActivity;

import java.util.Vector;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public class BaseApp extends Application {
    public static BaseActivity mcontext;
    public Vector vector;

    @Override
    public void onCreate() {
        vector = new Vector();
        super.onCreate();

    }
}
