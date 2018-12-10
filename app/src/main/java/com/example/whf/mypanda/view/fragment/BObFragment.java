package com.example.whf.mypanda.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.activity.BoBaoActivity;
import com.example.whf.mypanda.activity.PersonalActivity;
import com.example.whf.mypanda.adapter.MyAdapterBobao;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.MyPadnaGUNg;
import com.example.whf.mypanda.entity.MyPandaBoRecyc;
import com.example.whf.mypanda.entity.MyPandaBoba;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BObFragment extends BaseFragment {
    public HomePersenter mshouYFragment;

    private ImageView image_my;
    private ImageView image_a;
    private TextView textView;
    private RecyclerView recycl;
    private List<MyPandaBoRecyc.ListBean> list;

    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL7, this, MyPandaBoba.class);
        mshouYFragment.start();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_bob, container, false);
        initView(inflate);
        return inflate;
    }

    protected void initView(View inflate) {
        setUserVisibleHint(true);
        image_my = (ImageView) inflate.findViewById(R.id.image_my);
        image_a = (ImageView) inflate.findViewById(R.id.image_a);
        textView = (TextView) inflate.findViewById(R.id.textView);
        recycl = (RecyclerView) inflate.findViewById(R.id.recycl);
        image_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonalActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getFragmentLayoutId() {

        return R.layout.fragment_bob;
    }

    @Override
    public void onSucess(Object o) {
        if (o instanceof MyPandaBoba&&isAdded()){
            List<MyPandaBoba.DataBean.BigImgBean> bigImg = ((MyPandaBoba) o).getData().getBigImg();
            Picasso.with(getActivity()).load(bigImg.get(0).getImage()).into(image_a);
            textView.setText(bigImg.get(0).getTitle());

            String listurl = ((MyPandaBoba) o).getData().getListurl();
            mshouYFragment = new HomePersenter(listurl, this, MyPandaBoRecyc.class);
            mshouYFragment.start();

        }else if (o instanceof MyPandaBoRecyc&&isAdded()){
            list = ((MyPandaBoRecyc) o).getList();
            MyAdapterBobao myAdapterBobao = new MyAdapterBobao(list, getActivity());
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            recycl.setLayoutManager(manager);
            recycl.setAdapter(myAdapterBobao);
            myAdapterBobao.setOnClickListenre(new MyAdapterBobao.OnClickListenre() {
                @Override
                public void OnClick(int position) {
                    Intent intent = new Intent(getActivity(), BoBaoActivity.class);
                    intent.putExtra("title",list.get(position).getTitle());
                    intent.putExtra("imge",list.get(position).getPicurl());
                    intent.putExtra("url",list.get(position).getUrl());
                    startActivity(intent);
                }
            });

        }

    }

    @Override
    public void onFaile(String msg) {

    }

    @Override
    public void setPresenter(HomePersenter presenter) {
            this.mshouYFragment=presenter;
    }
}
