package com.example.whf.mypanda.utils;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo.gen.DaoMaster;
import com.example.greendaodemo.gen.DaoSession;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cn.jpush.android.api.JPushInterface;

public class MyApplication extends Application {
    public static MyApplication application;
    private DaoSession daoSession;
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac",                                      "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad",         "http://sns.whalecloud.com");
    }

    public static MyApplication getApplication() {
        return application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        UMShareAPI.get(this);
        createDB();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        UMConfigure.init(this, 0, null);
    }

    private void createDB() {
//        创建数据库辅助类对象
        DaoMaster.DevOpenHelper  devOpenHelper=new DaoMaster.DevOpenHelper(this,"greenDao.db");
//        数据库对象
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
//        连接数据库
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
