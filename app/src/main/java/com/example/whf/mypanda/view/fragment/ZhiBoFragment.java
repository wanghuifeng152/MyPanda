package com.example.whf.mypanda.view.fragment;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.whf.mypanda.activity.PersonalActivity;
import com.example.whf.mypanda.adapter.MyPandaZhB;

import com.example.whf.mypanda.fragment.FuYonFragment;
import com.example.whf.mypanda.fragment.NewFragment;
import com.example.whf.mypanda.R;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.PandaZhibBt;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiBoFragment extends BaseFragment {
    private HomePersenter mshouYFragment;

    private ImageView image_my;
    private TabLayout tab_layout;
    private ViewPager vp;
    private View view;
    private List<String> list;
    private List<Fragment> fragmentList;

    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL4, this,PandaZhibBt.class);
        mshouYFragment.start();
    }


    protected void initView(View view) {
        image_my = (ImageView) view.findViewById(R.id.image_my);
        tab_layout = (TabLayout) view.findViewById(R.id.tab_layout);
        vp = (ViewPager) view.findViewById(R.id.vp);
        setUserVisibleHint(true);
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
        return R.layout.fragment_zhi_bo;

    }

    @Override
    public void onSucess(Object o) {
            if (o instanceof PandaZhibBt&&isAdded()){

                list = new ArrayList<>();
                fragmentList = new ArrayList<>();
                List<PandaZhibBt.TablistBean> tablist = ((PandaZhibBt) o).getTablist();

                for (int i = 0; i < tablist.size(); i++) {
                    list.add(tablist.get(i).getTitle());
                }
                fragmentList.add(new NewFragment());
                for (int i = 0; i < tablist.size() - 1; i++) {
                    fragmentList.add(new FuYonFragment(Urls.BASEURLS[i]));
                }

                MyPandaZhB myPandaZhB = new MyPandaZhB(getChildFragmentManager(), list, fragmentList);
                tab_layout.setupWithViewPager(vp);
                vp.setAdapter(myPandaZhB);
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

