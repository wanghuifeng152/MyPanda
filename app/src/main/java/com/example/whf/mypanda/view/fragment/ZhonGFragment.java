package com.example.whf.mypanda.view.fragment;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.greendaodemo.gen.ZGSongDao;
import com.example.greendaodemo.gen.ZGStudentDao;
import com.example.whf.mypanda.R;
import com.example.whf.mypanda.adapter.MyPandaZhB;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.MyPandaZhonG;
import com.example.whf.mypanda.fragment.JingXuanFragment;
import com.example.whf.mypanda.fragment.ReFragment;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;
import com.example.whf.mypanda.utils.DragableGridLayout;
import com.example.whf.mypanda.utils.MyApplication;
import com.example.whf.mypanda.utils.ZGSong;
import com.example.whf.mypanda.utils.ZGStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhonGFragment extends BaseFragment {

    public HomePersenter mshouYFragment;
    private ImageView image_my;
    private TabLayout tab_layout;
    private ImageView image_zhog;
    private ViewPager vp;
    private ImageView iv_delect;
    private TextView tag_a;
    private TextView tv_tell;
    private Button btn_change;
    private LinearLayout tag_b;
    private DragableGridLayout drable_grid1;
    private DragableGridLayout disdrable_grid1;
    private NavigationView nav;
    private boolean isRepeat;
    private DrawerLayout drawerLayout;
    private List<String> list1,list2;
    private ZGStudentDao zgStudentDao1;
    private ZGSongDao zgSongDao2;
    private List<MyPandaZhonG.TablistBean> tablist;
    private List<MyPandaZhonG.AlllistBean> alllist;


    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL8, this, MyPandaZhonG.class);
        mshouYFragment.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhon_g, container, false);
        initView(view);
        return view;
    }


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_zhon_g;
    }

    @Override
    public void onSucess(Object o) {
        if(isAdded()){
            tablist = ((MyPandaZhonG) o).getTablist();
            alllist = ((MyPandaZhonG) o).getAlllist();

            if (zgStudentDao1.loadAll().size() == 0) {
                Log.e("TAG", "onSuccess:=========== " + zgStudentDao1.loadAll().size());
                for (int i = 0; i < tablist.size(); i++) {
                    ZGStudent nollTagBean = new ZGStudent();
                    nollTagBean.setTitle(tablist.get(i).getTitle());
                    nollTagBean.setUrl(tablist.get(i).getUrl());
                    zgStudentDao1.insert(nollTagBean);
                }
            }
        /*
            去除重复
         */
            isRepeat = false;

            if (zgSongDao2.loadAll().size() == 0 && zgStudentDao1.loadAll().size() != alllist.size()) {
                for (int i = 0; i < alllist.size(); i++) {
                    for (int j = 0; j < tablist.size(); j++) {
                        if (tablist.get(j).getTitle().equals(alllist.get(i).getTitle())) {
                            isRepeat = true;
                        }
                    }
                    if (!isRepeat) {
                        ZGSong tagBean = new ZGSong();
                        tagBean.setTitle(alllist.get(i).getTitle());
                        tagBean.setUrl(alllist.get(i).getUrl());
                        zgSongDao2.insert(tagBean);
                    }
                    isRepeat = false;
                }
            }

            initFragmentAdapter();

            initData();
        }
    }

    private void initData() {
        drable_grid1.setDragable(true);
        list1 = new ArrayList<>();
        List<ZGStudent> zgStudents = zgStudentDao1.loadAll();
        for (int i = 0; i < zgStudents.size(); i++) {
            list1.add(zgStudents.get(i).getTitle());
        }
        drable_grid1.setItems(list1);

        drable_grid1.setDragable(false);
        list2 = new ArrayList<>();
        List<ZGSong> zgSongs = zgSongDao2.loadAll();
        for (int i = 0; i < zgSongs.size(); i++) {
            list2.add(zgSongs.get(i).getTitle());
        }
        disdrable_grid1.setItems(list2);

        drable_grid1.setOnItemClickListenner(new DragableGridLayout.onItemClickListenner() {
            @Override
            public void onDragItemClick(View view) {

                if (btn_change.isSelected()) {
                    if (view instanceof TextView) {
                        String text = ((TextView) view).getText().toString();
                        for (int i = 0; i < list1.size(); i++) {
                            if (list1.get(i).equals(text)) {
                                if (list1.size() > 4) {
                                    drable_grid1.removeViewAt(i);
                                    list1.remove(i);
                                    list2.add(text);
                                    disdrable_grid1.addItems(text);
                                }

                            }
                        }
                    }
                }
            }

            @Override
            public void onDisDragItemClick(View view) {

            }
        });


        disdrable_grid1.setOnItemClickListenner(new DragableGridLayout.onItemClickListenner() {
            @Override
            public void onDragItemClick(View view) {

            }

            @Override
            public void onDisDragItemClick(View view) {
                if (btn_change.isSelected()) {
                    if (view instanceof TextView) {
                        String text = ((TextView) view).getText().toString();
                        for (int i = 0; i < list2.size(); i++) {
                            if (list2.get(i).equals(text)) {
                                list1.add(text);
                                list2.remove(i);
                                disdrable_grid1.removeView(view);
                                drable_grid1.addItems(text);
                            }
                        }
                    }
                }
            }
        });
    }


    @Override
    public void onFaile(String msg) {

    }

    @Override
    public void setPresenter(HomePersenter presenter) {
        this.mshouYFragment = presenter;
    }

    protected void initView(View view) {
        image_my = (ImageView) view.findViewById(R.id.image_my);
        tab_layout = (TabLayout) view.findViewById(R.id.tab_layout);
        image_zhog = (ImageView) view.findViewById(R.id.image_zhog);
        vp = (ViewPager) view.findViewById(R.id.vp);
        iv_delect = (ImageView) view.findViewById(R.id.iv_delect);
        tag_a = (TextView) view.findViewById(R.id.tag_a);
        tv_tell = (TextView) view.findViewById(R.id.tv_tell);
        btn_change = (Button) view.findViewById(R.id.btn_change);
        tag_b = (LinearLayout) view.findViewById(R.id.tag_b);
        drable_grid1 = (DragableGridLayout) view.findViewById(R.id.drable_grid1);
        disdrable_grid1 = (DragableGridLayout) view.findViewById(R.id.disdrable_grid1);
        nav = (NavigationView) view.findViewById(R.id.nav);
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        //设置导航菜单宽度
        ViewGroup.LayoutParams params = nav.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels;
        nav.setLayoutParams(params);
        setUserVisibleHint(true);

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        zgStudentDao1 = MyApplication.getApplication().getDaoSession().getZGStudentDao();
        zgSongDao2 = MyApplication.getApplication().getDaoSession().getZGSongDao();
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        image_zhog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(nav);
            }
        });

        iv_delect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(nav);
                btn_change.setText("编辑");
                tv_tell.setVisibility(View.INVISIBLE);
                btn_change.setSelected(false);
            }
        });


        btn_change.setSelected(false);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_change.isSelected()) {
                    btn_change.setText("编辑");
                    tv_tell.setVisibility(View.INVISIBLE);
                    btn_change.setSelected(false);
                    drable_grid1.setChange(false);

                    zgStudentDao1.deleteAll();
                    for (int i = 0; i < list1.size(); i++) {
                        ZGStudent nollTabBean = new ZGStudent();
                        nollTabBean.setTitle(list1.get(i));
                        String url = "";
                        for (int j = 0; j < alllist.size(); j++) {
                            if (list1.get(i).equals(alllist.get(j).getTitle())) {
                                url = alllist.get(j).getUrl();
                                Log.e("TAG", "onClick: "+url+ list1.get(i)+alllist.get(j).getTitle());
                            }
                        }
                        nollTabBean.setUrl(url);
                        zgStudentDao1.insert(nollTabBean);
                    }

                    initFragmentAdapter();

                    zgSongDao2.deleteAll();
                    for (int i = 0; i < list2.size(); i++) {
                        ZGSong tagean = new ZGSong();
                        tagean.setTitle(list2.get(i));
                        String url = "";
                        for (int j = 0; j < alllist.size(); j++) {
                            if (list2.get(i).equals(alllist.get(j).getTitle())) {
                                url = alllist.get(j).getUrl();
                            }
                        }
                        tagean.setUrl(url);
                        zgSongDao2.insert(tagean);
                    }
                } else {
                    btn_change.setText("完成");
                    tv_tell.setVisibility(View.VISIBLE);
                    btn_change.setSelected(true);
                    drable_grid1.setChange(true);
                }
            }
        });


    }

    private void initFragmentAdapter() {
        List<ZGStudent> nollTabBeans = zgStudentDao1.loadAll();
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < nollTabBeans.size(); i++) {
            if (nollTabBeans.get(i).getTitle().equals(tablist.get(0).getTitle())) {
                fragmentList.add(new JingXuanFragment());
            } else {
                fragmentList.add(new ReFragment(nollTabBeans.get(i).getUrl()));
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < nollTabBeans.size(); i++) {
            list.add(nollTabBeans.get(i).getTitle());
        }

        MyPandaZhB myPandaZhB = new MyPandaZhB(getChildFragmentManager(), list, fragmentList);
        tab_layout.setupWithViewPager(vp);
        vp.setAdapter(myPandaZhB);
    }
}
