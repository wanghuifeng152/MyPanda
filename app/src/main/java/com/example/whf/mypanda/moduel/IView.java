package com.example.whf.mypanda.moduel;

/**
 * 爱生活，爱代码
 * 创建于：2018/4/2 09:59
 * 作 者：T
 * 微信：704003376
 */

public interface IView<T> {
    public <T> void onSucess(T t);
    public void onFaile(String msg);
}
