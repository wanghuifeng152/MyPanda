package com.example.whf.mypanda.network;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public interface ICallBack<T> {
    public <T> void onSucess(T t);
    public void onFaile(String msg);
}
