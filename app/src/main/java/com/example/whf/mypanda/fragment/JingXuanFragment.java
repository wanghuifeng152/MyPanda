package com.example.whf.mypanda.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.base.BaseFragment;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.MyPandaJinC;
import com.example.whf.mypanda.entity.MyPandaZhonG;
import com.example.whf.mypanda.moduel.home.mvp.HomePersenter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JingXuanFragment extends BaseFragment {

    public HomePersenter mshouYFragment;
    private ImageView iv_image;
    private TextView tv_title;
    private ImageView iv_triangle;
    private TextView text_Item;

    @Override
    protected void loadData() {
        mshouYFragment = new HomePersenter(Urls.BASEURL10, this, MyPandaJinC.class);
        mshouYFragment.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_jing_xuan, container, false);
        initView(inflate);

        return inflate;
    }

    protected void initView(View inflate) {
        setUserVisibleHint(true);
        iv_image = (ImageView) inflate.findViewById(R.id.iv_image);
        tv_title = (TextView) inflate.findViewById(R.id.tv_title);
        iv_triangle = (ImageView) inflate.findViewById(R.id.iv_triangle);
        text_Item = (TextView) inflate.findViewById(R.id.text_Item);
        iv_triangle.setSelected(false);
        iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!iv_triangle.isSelected()) {
                    text_Item.setVisibility(View.VISIBLE);
                    iv_triangle.setSelected(true);
                } else {
                    text_Item.setVisibility(View.GONE);
                    iv_triangle.setSelected(false);
                }
            }
        });
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_jing_xuan;
    }

    @Override
    public void onSucess(Object o) {
        List<MyPandaJinC.LiveBean> live = ((MyPandaJinC) o).getLive();
        MyPandaJinC.LiveBean liveBean = live.get(0);
        Picasso.with(getActivity()).load(liveBean.getImage()).into(iv_image);
        tv_title.setText(liveBean.getTitle());
        text_Item.setText(liveBean.getBrief());
    }

    @Override
    public void onFaile(String msg) {

    }

    @Override
    public void setPresenter(HomePersenter presenter) {
    this.mshouYFragment = presenter;
    }
}
