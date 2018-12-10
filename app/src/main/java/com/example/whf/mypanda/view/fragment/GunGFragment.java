package com.example.whf.mypanda.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.greendao.History;
import com.example.greendaodemo.gen.HistoryDao;
import com.example.whf.mypanda.R;
import com.example.whf.mypanda.activity.GungVodeActivity;
import com.example.whf.mypanda.activity.PersonalActivity;
import com.example.whf.mypanda.activity.VodeZhiBActivity;
import com.example.whf.mypanda.adapter.MyAdapterGung;
import com.example.whf.mypanda.adapter.MyPandasyGung;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.MyPadnaGUNg;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;
import com.example.whf.mypanda.utils.MyApplication;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GunGFragment extends BaseFragment {

    public HomePersenter mshouYFragment;

    private ImageView image_my;
    private ImageView image_a;
    private RecyclerView recycl;
    private TextView textView;
    private List<MyPadnaGUNg.ListBean> list;

    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL2, this, MyPadnaGUNg.class);
        mshouYFragment.start();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gun_g, container, false);
        initView(view);
        return view;
    }

    protected void initView(View view) {
        setUserVisibleHint(true);
        image_my = (ImageView) view.findViewById(R.id.image_my);
        image_a = (ImageView) view.findViewById(R.id.image_a);
        recycl = (RecyclerView) view.findViewById(R.id.recycl);
        textView = (TextView) view.findViewById(R.id.textView);
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

        return R.layout.fragment_gun_g;
    }

    @Override
    public void onSucess(Object o) {
        if (o instanceof MyPadnaGUNg&&isAdded()) {


            List<MyPadnaGUNg.BigImgBean> bigImg = ((MyPadnaGUNg) o).getBigImg();
            Picasso.with(getActivity()).load(bigImg.get(0).getImage()).into(image_a);
            textView.setText(bigImg.get(0).getTitle());

            list = ((MyPadnaGUNg) o).getList();
            MyAdapterGung myAdapterGung = new MyAdapterGung(list, getActivity());
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            recycl.setLayoutManager(manager);
            recycl.setAdapter(myAdapterGung);
            myAdapterGung.setOnClickListenre(new MyAdapterGung.OnClickListenre() {
                @Override
                public void OnClick(int position) {

                    HistoryDao historyDao = MyApplication.getApplication().getDaoSession().getHistoryDao();
                    History history = new History();
                    history.setTitlr(list.get(position).getTitle());
                    history.setImage(list.get(position).getImage());
                    history.setStims(list.get(position).getVideoLength());
                    history.setSum(list.get(position).getBrief());
                    historyDao.insert(history);


                    Intent intent = new Intent(getActivity(), GungVodeActivity.class);
                    intent.putExtra("id","http:api.cntv.cn/video/videolistById?vsid="
                            +list.get(position).getId()+"&n=7&serviceId=panda&o=desc&of=time&p=1");
                    intent.putExtra("url",list.get(position).getUrl());
                    intent.putExtra("title",list.get(position).getTitle());


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
