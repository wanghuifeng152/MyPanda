package com.example.whf.mypanda.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.PandaDuosj;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends BaseFragment {

    private HomePersenter mshouYFragment;
    private JCVideoPlayerStandard jiecao_Player;
    private TextView text_zhib;
    private ImageView image_off;
    private TextView text_t;
    private RadioButton butt_ds;
    private RadioButton butt_bk;
    private RadioGroup rg;
    private FrameLayout frag_lay;

    private FragmentManager manager;

    //测试地址
    String s1="https://txmov2.a.yximgs.com/upic/2017/12/19/19/BMjAxNzEyMTkxOTAxMDBfNzAyMzQ4Ml80Mjc0MDY2MDAzXzJfMw==_b_A11ffeb3a68cd7402684c6d13ef59fe04.mp4";
    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL5, this, PandaDuosj.class);
        mshouYFragment.start();
    }


    protected void initView(View inflate) {
        image_off = inflate.findViewById(R.id.image_off);
        text_t = inflate.findViewById(R.id.text_t);
        text_zhib = inflate.findViewById(R.id.text_zhib);
        jiecao_Player = inflate.findViewById(R.id.jiecao_Player);
        butt_ds = inflate.findViewById(R.id.butt_ds);
        butt_bk = inflate.findViewById(R.id.butt_bk);
        rg = inflate.findViewById(R.id.rg);
        frag_lay = inflate.findViewById(R.id.frag_lay);
        jiecao_Player.setUp(s1,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"盖世英雄");




        image_off.setSelected(false);
        image_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!image_off.isSelected()) {
                    text_t.setVisibility(View.VISIBLE);
                    image_off.setSelected(true);
                    image_off.setImageResource(R.mipmap.lpanda_off);
                } else if (image_off.isSelected()) {
                    text_t.setVisibility(View.GONE);
                    image_off.setSelected(false);
                    image_off.setImageResource(R.mipmap.lpanda_show);
                }
            }
        });
        initListenre();
    }




    private void initListenre() {

        manager =getChildFragmentManager();
        manager.beginTransaction().add(R.id.frag_lay,new DuosFragment()).commitAllowingStateLoss();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.butt_ds:
                       manager.beginTransaction().replace(R.id.frag_lay,new DuosFragment()).commitAllowingStateLoss();

                        break;
                    case R.id.butt_bk:
                        manager.beginTransaction().replace(R.id.frag_lay,new PinlFragment()).commitAllowingStateLoss();
                        break;

                }
            }
        });


    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_new;
    }

    @Override
    public void onSucess(Object o) {
        if (o instanceof PandaDuosj) {
            List<PandaDuosj.LiveBean> live = ((PandaDuosj) o).getLive();
            text_t.setText(live.get(0).getBrief());
            text_zhib.setText(live.get(0).getTitle());

        }
    }

    @Override
    public void onFaile(String msg) {

    }

    @Override
    public void setPresenter(HomePersenter presenter) {
        this.mshouYFragment = presenter;
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


}
