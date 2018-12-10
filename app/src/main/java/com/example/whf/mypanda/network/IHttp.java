package com.example.whf.mypanda.network;

import java.util.Map;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public interface IHttp {
    <T> void get(String url, Map<String,String> map,Class c,ICallBack<T> callBack);
    <T> void post(String url, Map<String,String> map,ICallBack<T> callBack);
}
