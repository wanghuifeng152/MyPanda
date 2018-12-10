package com.example.whf.mypanda.network;

import android.util.Log;

import com.example.whf.mypanda.entity.PandaGung;
import com.example.whf.mypanda.global.BaseApp;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public class OkHttpDemo implements IHttp{
    private static OkHttpDemo okHttpDemo = new OkHttpDemo();

    private OkHttpDemo(){

    }
   public static OkHttpDemo getOkHttpDemo(){
        return okHttpDemo;
    }

    @Override
    public <T> void get(String url, Map<String, String> map, final Class c, final ICallBack<T> callBack) {
        StringBuffer sb = new StringBuffer(url);
        if (map!=null&&map.size()>0){
            sb.append("?");
            for (String key:map.keySet()){
                String value = map.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            sb.substring(0,sb.length()-1).trim().toString();
        }
        new OkHttpClient().newCall(new Request.Builder().get().url(url).build())
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String string = response.body().string();
                        BaseApp.mcontext.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                Object o = gson.fromJson(string, c);
                                callBack.onSucess(o);

                            }
                        });
                    }
                });

    }

//    private <T> T getGsong(String string, ICallBack<T> callBack) {
//        Type[] interfaces = callBack.getClass().getGenericInterfaces();
//        Type[] typeArguments = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
//        Gson gson = new Gson();
//        T t = gson.fromJson(string, typeArguments[0]);
//        return t;
//    }
    @Override
    public <T> void post(String url, Map<String, String> map, ICallBack<T> callBack) {

    }
}
