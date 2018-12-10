package com.example.whf.mypanda.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.adapter.MyPandaFuyo;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.MyPandaFuYON;
import com.example.whf.mypanda.entity.PandaDuosj;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class FuYonFragment extends BaseFragment {

    private HomePersenter mshouYFragment;
    private RecyclerView recycl;
    private String url;
    private List<MyPandaFuYON.VideoBean> video;

    @SuppressLint("ValidFragment")
    public FuYonFragment(String url) {
        this.url = url;
    }

    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(url, this, MyPandaFuYON.class);
        mshouYFragment.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fu_yon, container, false);
        initView(inflate);
        return inflate;
    }

    protected void initView(View inflate) {
        setUserVisibleHint(true);
        recycl = (RecyclerView) inflate.findViewById(R.id.recycl);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_fu_yon;
    }

    @Override
    public void onSucess(Object o) {
        if (o instanceof MyPandaFuYON){
            video = ((MyPandaFuYON) o).getVideo();
            MyPandaFuyo myPandaFuyo = new MyPandaFuyo(video, getActivity());
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            recycl.setLayoutManager(manager);
          recycl.setAdapter(myPandaFuyo);


        }


    }

    @Override
    public void onFaile(String msg) {

    }

    @Override
    public void setPresenter(HomePersenter presenter) {
        this.mshouYFragment = presenter;
    }
}
