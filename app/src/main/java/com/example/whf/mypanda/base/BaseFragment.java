package com.example.whf.mypanda.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whf.mypanda.moduel.home.HomeContract;
import com.example.whf.mypanda.network.ICallBack;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public abstract class BaseFragment extends Fragment implements HomeContract.BaseHomeView {

    private BaseActivity mactivity;

    //标记Fragment的view是否已经初始化
    private boolean mIsPrepared;
    //当前碎片是否可见
    private boolean mIsPreparedVisiable;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mIsPrepared = true;
        lazyLoad();
        super.onViewCreated(view, savedInstanceState);
    }

    //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            mIsPreparedVisiable = true;
            Log.e("TAG", "lazyLoad: "+"hello2" );
            lazyLoad();
        }else {
            Log.e("TAG", "lazyLoad: "+"hello1" );
            mIsPreparedVisiable = false;
        }
    }

    private void lazyLoad() {
        if (!mIsPrepared||!mIsPreparedVisiable)
        return;

        //当前碎片加载的视图已经初始化了并且当前碎片可见
        loadData();


    }
//加载数据
    protected abstract void loadData();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mactivity = (BaseActivity) context;
    }

    protected Activity getAttachActivity(){
        if (mactivity!=null)
            return mactivity;
        else
            return this.getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(mactivity,getFragmentLayoutId(),null);
        initView(view);
           return view;
    }

    protected abstract void initView(View view);

    protected abstract int getFragmentLayoutId();


}
