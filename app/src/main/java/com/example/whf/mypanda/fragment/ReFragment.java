package com.example.whf.mypanda.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.adapter.ListViewAdapter4;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.entity.MyPandaJinC;
import com.example.whf.mypanda.entity.MyZGPanda;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ReFragment extends BaseFragment {
    public HomePersenter mshouYFragment;
    private String url;
    private ListView lv;
    private List<MyPandaJinC.LiveBean> live;

    public ReFragment(String url) {
    this.url=url;
    }


    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(url, this, MyPandaJinC.class);
        mshouYFragment.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_re, container, false);
        initView(inflate);
        return inflate;
    }

    protected void initView(View inflate) {
        lv = (ListView) inflate.findViewById(R.id.lv);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_re;
    }

    @Override
    public void onSucess(Object o) {
        live = ((MyPandaJinC) o).getLive();
        ListViewAdapter4 adapter4 = new ListViewAdapter4(live, getActivity());
        lv.setAdapter(adapter4);
    }

    @Override
    public void onFaile(String msg) {

    }

    @Override
    public void setPresenter(HomePersenter presenter) {

    }
}
