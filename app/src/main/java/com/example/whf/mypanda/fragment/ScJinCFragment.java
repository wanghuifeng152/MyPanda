package com.example.whf.mypanda.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.greendao.Collection;
import com.example.greendaodemo.gen.CollectionDao;
import com.example.whf.mypanda.R;
import com.example.whf.mypanda.activity.BoBaoActivity;
import com.example.whf.mypanda.activity.CollectionActivity;
import com.example.whf.mypanda.adapter.MyAdapterBobao;
import com.example.whf.mypanda.adapter.MyAdapterColler;
import com.example.whf.mypanda.utils.MyApplication;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScJinCFragment extends Fragment {

    private RecyclerView recycl;
    private TextView text_bj;
    private TextView text_qx;
    private TextView text_sc;
    private LinearLayout lienar;
    private MyAdapterColler myAdapterColler;
    private int b;
    //删除
    private int a;
    //全选
    private static final int MYLIVE_MODE_CHECK = 0;
    //编辑
    private static final int MYLIVE_MODE_EDIT = 1;
    //取消全选
    private static final int MYLIVE_MODE_NOCHECK = 2;
    //完成
    private static final int MYLIVE_MODE_FINISH = 3;
    private List<Collection> collections;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sc_jin_c, container, false);
        initView(view);
        initData();
        initListenre();
        return view;
    }

    private void initListenre() {
        text_bj.setSelected(false);
        text_bj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_bj.isSelected()) {
                    text_bj.setSelected(false);
                    text_bj.setText("编辑");
                    text_qx.setText("全选");
                    a=0;
                    text_sc.setText("删除");
                    lienar.setVisibility(View.GONE);
                    myAdapterColler.setEditMode(MYLIVE_MODE_FINISH);
                } else {
                    text_bj.setSelected(true);
                    text_bj.setText("取消");
                    text_qx.setSelected(false);
                    lienar.setVisibility(View.VISIBLE);
                    myAdapterColler.setEditMode(MYLIVE_MODE_EDIT);

                }
            }
        });

        myAdapterColler.SetOnClicklist(new MyAdapterColler.onclicklist() {
            @Override
            public void onCheckb(int position, boolean Checdbaod) {
                b = position;
                if (Checdbaod){
                    a++;
                }else {
                    a--;
                }
                if (a==0){
                    text_sc.setText("删除");
                }else {
                    text_sc.setText("删除"+a);
                }

                if (a!=collections.size()){
                    text_qx.setText("全选");
                    text_qx.setSelected(false);
                }else if (a==collections.size()){
                    text_qx.setText("取消全选");
                    text_qx.setSelected(true);
                }

            }
        });
        text_qx.setSelected(false);
        text_qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_qx.isSelected()){
                    text_qx.setSelected(false);
                    myAdapterColler.setEditMode(MYLIVE_MODE_NOCHECK);
                    text_qx.setText("全选");
                    a=0;
                   text_sc.setText("删除");
                }else {
                    text_qx.setSelected(
                            true);
                    myAdapterColler.setEditMode(MYLIVE_MODE_CHECK);
                    text_qx.setText("取消全选");
                    a=collections.size();
                    text_sc.setText("删除"+a);
                }

            }
        });
        text_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setMessage("提示")
                        .setTitle("是否删除")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                CollectionDao collectionDao = MyApplication.getApplication().getDaoSession().getCollectionDao();

                                List<Collection> collections = collectionDao.loadAll();
                                Log.e("TAG", "onClick:---------------- "+collections.size() );
                                collectionDao.deleteByKey(collections.get(b).getId());
                                myAdapterColler.notifyDataSetChanged();
                                collections.remove(b);

                            }
                        })
                        .setNegativeButton("否", null)
                        .create()
                        .show();
            }
        });

    }

    private void initData() {
        CollectionDao collectionDao = MyApplication.getApplication().getDaoSession().getCollectionDao();
        collections = collectionDao.loadAll();
        myAdapterColler = new MyAdapterColler(collections, getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycl.setLayoutManager(manager);
        recycl.setAdapter(myAdapterColler);

        myAdapterColler.setOnClickListenre(new MyAdapterColler.OnClickListenre() {
            @Override
            public void OnClick(int position) {
                Intent intent = new Intent(getActivity(), BoBaoActivity.class);
                intent.putExtra("title", collections.get(position).getTitlr());
                intent.putExtra("imge", collections.get(position).getImage());
                intent.putExtra("url", collections.get(position).getUrl());
                startActivity(intent);
            }
        });
        if (collectionDao.loadAll().size() == 0) {
            text_bj.setVisibility(View.INVISIBLE);

        } else {
            text_bj.setVisibility(View.VISIBLE);
        }
    }

    private void initView(View view) {
        recycl = (RecyclerView) view.findViewById(R.id.recycl);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof CollectionActivity) {
            CollectionActivity collec = (CollectionActivity) activity;
            text_bj = collec.findViewById(R.id.text_bj);
            text_qx = collec.findViewById(R.id.text_qx);
            text_sc = collec.findViewById(R.id.text_sc);
            lienar = collec.findViewById(R.id.lienar);
        }
    }
}
