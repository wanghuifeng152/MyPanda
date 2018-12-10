package com.example.whf.mypanda.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.activity.HuDongActivity;
import com.example.whf.mypanda.activity.PersonalActivity;
import com.example.whf.mypanda.activity.VodeActivity;
import com.example.whf.mypanda.activity.VodeZhiBActivity;
import com.example.whf.mypanda.adapter.MyPabdaSyFour;
import com.example.whf.mypanda.adapter.MyPandaSyOne;
import com.example.whf.mypanda.adapter.MyPandaSyThree;
import com.example.whf.mypanda.adapter.MyPandaSyTow;
import com.example.whf.mypanda.adapter.MyPandasyGung;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.PandaGung;
import com.example.whf.mypanda.entity.PandaJinCai;
import com.example.whf.mypanda.entity.PandaShY;
import com.example.whf.mypanda.moduel.home.HomeContract;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class ShouYFragment extends BaseFragment implements HomeContract.BaseHomeView {

    private HomePersenter mshouYFragment;
    private ImageView image_hd;
    private ImageView image_my;
    private Banner banner;
    private List<String> imagephan;
    private List<String> titles;
    private RecyclerView recycl;
    private RecyclerView recycler2;
    private RecyclerView recycler3;
    private RecyclerView recycler4;
    private RecyclerView recycler5;
    private ImageView image_bo;

    //轮播图集合
    private List<PandaShY.DataBean.BigImgBean> bigImg;
    //熊猫播报
    private List<PandaShY.DataBean.PandaeyeBean.ItemsBean> items;
    //直播秀场
    private List<PandaShY.DataBean.PandaliveBean.ListBeanX> list;
    //直播中国
    private List<PandaShY.DataBean.ChinaliveBean.ListBean> list1;
   //精彩时刻
    private List<PandaJinCai.ListBean> listBeans;
    //滚滚视频
    private List<PandaGung.ListBean> listbeans;


    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL1, this,PandaShY.class);
        mshouYFragment.start();

    }

    private void initListenre() {
        //调到互动界面
        image_hd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HuDongActivity.class);
                startActivity(intent);
            }
        });
        //跳到个人中心界面
        image_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonalActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView(View inflate) {
        setUserVisibleHint(true);
        image_hd = (ImageView) inflate.findViewById(R.id.image_hd);
        image_my = (ImageView) inflate.findViewById(R.id.image_my);
        banner = (Banner) inflate.findViewById(R.id.banner);
        recycl = (RecyclerView) inflate.findViewById(R.id.recycl);
        recycler2 = (RecyclerView) inflate.findViewById(R.id.recycler2);
        recycler3 = (RecyclerView) inflate.findViewById(R.id.recycler3);
        recycler4 = (RecyclerView) inflate.findViewById(R.id.recycler4);
        recycler5 = (RecyclerView) inflate.findViewById(R.id.recycler5);
        image_bo = (ImageView) inflate.findViewById(R.id.image_bo);

    }


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_shou_y;
    }

    @Override
    public void onSucess(Object o) {
        if(isAdded()){
            if (o instanceof PandaShY){
                PandaShY.DataBean data = ((PandaShY) o).getData();
                bigImg = data.getBigImg();
                //精彩时刻字符串
                String listurl = data.getCctv().getListurl();
                mshouYFragment = new HomePersenter(listurl, this,PandaJinCai.class);
                mshouYFragment.start();
                //滚滚视频字符串
                String listUrl = data.getList().get(0).getListUrl();
                mshouYFragment = new HomePersenter(listUrl, this,PandaGung.class);
                mshouYFragment.start();


                //熊猫播报
                items =((PandaShY)o).getData().getPandaeye().getItems();
                String pandaeyelogo = ((PandaShY)o).getData().getPandaeye().getPandaeyelogo();
                Picasso.with(getActivity()).load(pandaeyelogo).into(image_bo);
                MyPandaSyOne myPandaSyOne = new MyPandaSyOne(items, getActivity());
                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                recycl.setLayoutManager(manager);
                recycl.setAdapter(myPandaSyOne);
                myPandaSyOne.setOnClickListenre(new MyPandaSyOne.OnClickListenre() {
                    @Override
                    public void OnClick(int position) {
                        Intent intent = new Intent(getActivity(), VodeActivity.class);
                        intent.putExtra("url",items.get(position).getVid());
                        intent.putExtra("title",items.get(position).getTitle());
                        startActivity(intent);
                    }
                });

                //直播秀场
                list = ((PandaShY)o).getData().getPandalive().getList();
                MyPandaSyTow myPandaSyTow = new MyPandaSyTow(list, getActivity());
                GridLayoutManager manager1 = new GridLayoutManager(getActivity(), 3);
                recycler2.setLayoutManager(manager1);
                recycler2.setAdapter(myPandaSyTow);
                myPandaSyTow.setOnClickListenre(new MyPandaSyTow.OnClickListenre() {
                    @Override
                    public void OnClick(int position) {
                        Intent intent = new Intent(getActivity(), VodeZhiBActivity.class);
                        //intent.putExtra("url",list.get(position).getVid());
                        //intent.putExtra("title",list.get(position).getTitle());
                        startActivity(intent);
                    }
                });

                //直播中国
                list1 = ((PandaShY)o).getData().getChinalive().getList();

                MyPandaSyThree myPandaSyThree = new MyPandaSyThree(list1, getActivity());
                GridLayoutManager manager2 = new GridLayoutManager(getActivity(), 3);
                recycler5.setLayoutManager(manager2);
                recycler5.setAdapter(myPandaSyThree);

                myPandaSyThree.setOnClickListenre(new MyPandaSyThree.OnClickListenre() {
                    @Override
                    public void OnClick(int position) {
                        Intent intent = new Intent(getActivity(), VodeZhiBActivity.class);
                        startActivity(intent);
                    }
                });



            }else if (o instanceof PandaJinCai&&isAdded()){
                //精彩时刻
                listBeans = ((PandaJinCai) o).getList();
                MyPabdaSyFour myPabdaSyFour = new MyPabdaSyFour(listBeans, getActivity());
                GridLayoutManager manager3 = new GridLayoutManager(getActivity(), 2);
                recycler3.setLayoutManager(manager3);
                recycler3.setAdapter(myPabdaSyFour);
            }else  if (o instanceof PandaGung&&isAdded()){
                //滚滚视频
                listbeans = ((PandaGung) o).getList();
                MyPandasyGung myPandasyGung = new MyPandasyGung(listbeans, getActivity());
                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                recycler4.setLayoutManager(manager);
                recycler4.setAdapter(myPandasyGung);

            }

            imagephan = new ArrayList<>();
            for (int i = 0; i < bigImg.size(); i++) {
                imagephan.add(bigImg.get(i).getImage());
            }
            titles = new ArrayList<>();
            for (int i = 0; i < bigImg.size(); i++) {
                titles.add(bigImg.get(i).getTitle());
            }


            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            banner.setImages(imagephan);
            banner.setBannerTitles(titles);
            banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Picasso.with(context).load((String) path).into(imageView);
                }
            });

            //设置点击事件，下标是从0开始
            banner.setOnBannerListener(new OnBannerListener() {

                public void OnBannerClick(int position) {
                    Toast.makeText(getActivity(), "你点击了：" + position, Toast.LENGTH_LONG).show();
                }
            });
            banner.start();
            initListenre();

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
