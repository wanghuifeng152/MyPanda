package com.example.whf.mypanda.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.activity.VodeActivity;
import com.example.whf.mypanda.activity.VodeZhiBActivity;
import com.example.whf.mypanda.adapter.MyPandaDuoSj;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.MyPandaShiJZ;
import com.example.whf.mypanda.entity.PandaZhibBt;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DuosFragment extends BaseFragment {
    private HomePersenter mshouYFragment;
    private RecyclerView recycl;
    private List<MyPandaShiJZ.ListBean> list;

    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL6, this,MyPandaShiJZ.class);
        mshouYFragment.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_duos, container, false);
        initView(view);
        return view;
    }

    protected void initView(View view) {
        setUserVisibleHint(true);
        recycl = (RecyclerView) view.findViewById(R.id.recycl);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_duos;
    }

    @Override
    public void onSucess(Object o) {
        if (o instanceof MyPandaShiJZ){
            list = ((MyPandaShiJZ) o).getList();
            Log.e("TAG", "onSucess: ------------>"+list.size() );
            MyPandaDuoSj myPandaDuoSj = new MyPandaDuoSj(list, getActivity());
            GridLayoutManager manager1 = new GridLayoutManager(getActivity(), 3);
            recycl.setLayoutManager(manager1);
            recycl.setAdapter(myPandaDuoSj);
            myPandaDuoSj.setOnClickListenre(new MyPandaDuoSj.OnClickListenre() {
                @Override
                public void OnClick(int position) {
                    Intent intent = new Intent(getActivity(), VodeZhiBActivity.class);
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
