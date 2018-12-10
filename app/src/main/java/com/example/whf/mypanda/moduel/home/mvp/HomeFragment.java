package com.example.whf.mypanda.moduel.home.mvp;

import android.view.View;

import com.example.whf.mypanda.adapter.MyPandaHD;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.moduel.home.HomeContract;

/**
 * Created by WHF
 * on 2018/4/2.
 * at 北京
 */

public class HomeFragment extends BaseFragment implements HomeContract.BaseHomeView {

    private HomePersenter mhomePersenter;


    @Override
    public void onSucess(Object o) {

    }

    @Override
    public void onFaile(String msg) {

    }


    protected void loadData() {
        mhomePersenter = new HomePersenter(null,this, MyPandaHD.class);
        mhomePersenter.start();
    }



    public void setPresenter(HomePersenter presenter) {
        mhomePersenter = presenter;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getFragmentLayoutId() {
        return 0;
    }

}
