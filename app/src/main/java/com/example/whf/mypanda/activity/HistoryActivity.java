package com.example.whf.mypanda.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.greendao.Collection;
import com.example.greendao.History;
import com.example.greendaodemo.gen.CollectionDao;
import com.example.greendaodemo.gen.HistoryDao;
import com.example.whf.mypanda.R;
import com.example.whf.mypanda.adapter.MyAdapterColler;
import com.example.whf.mypanda.adapter.MyAdapterHisto;
import com.example.whf.mypanda.utils.MyApplication;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private ImageView image_fanh;
    private TextView login_zc;
    private RecyclerView recycle;
    private TextView text_qx;
    private TextView text_sc;
    private LinearLayout lienar;
    private List<History> histories;
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
    private MyAdapterHisto myAdapterHisto;
    private HistoryDao historyDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        initData();
        initListenre();
    }

    private void initListenre() {
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        login_zc.setSelected(false);
        login_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (login_zc.isSelected()){
                   login_zc.setSelected(false);
                   login_zc.setText("编辑");
                   text_qx.setText("全选");
                   a=0;
                   text_sc.setText("删除");
                   lienar.setVisibility(View.GONE);
                   myAdapterHisto.setEditMode(MYLIVE_MODE_FINISH);

               }else {
                   login_zc.setSelected(true);
                   login_zc.setText("取消");
                   text_qx.setSelected(false);
                   lienar.setVisibility(View.VISIBLE);
                   myAdapterHisto.setEditMode(MYLIVE_MODE_EDIT);

               }
            }
        });
        text_qx.setSelected(false);
        text_qx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text_qx.isSelected()){
                    text_qx.setSelected(false);
                    myAdapterHisto.setEditMode(MYLIVE_MODE_NOCHECK);
                    text_qx.setText("全选");
                    a=0;
                    text_sc.setText("删除");
                }else {
                    text_qx.setSelected(
                            true);
                    myAdapterHisto.setEditMode(MYLIVE_MODE_CHECK);
                    text_qx.setText("取消全选");
                    a=histories.size();
                    text_sc.setText("删除"+a);
                }

            }
        });
        text_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(HistoryActivity.this)
                        .setMessage("提示")
                        .setTitle("是否删除")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                List<History> histories = historyDao.loadAll();
                                historyDao.deleteByKey(histories.get(b).getId());
                                myAdapterHisto.notifyDataSetChanged();
                                histories.remove(b);
                            }
                        })
                        .setNegativeButton("否", null)
                        .create()
                        .show();
            }
        });

    }

    private void initData() {
        historyDao = MyApplication.getApplication().getDaoSession().getHistoryDao();
        histories = historyDao.loadAll();

        myAdapterHisto = new MyAdapterHisto(histories, HistoryActivity.this);
        LinearLayoutManager manager = new LinearLayoutManager(HistoryActivity.this, LinearLayoutManager.VERTICAL, false);
        recycle.setLayoutManager(manager);
        recycle.setAdapter(myAdapterHisto);
        myAdapterHisto.setOnClickListenre(new MyAdapterHisto.OnClickListenre() {
            @Override
            public void onclick(int position) {
                Toast.makeText(HistoryActivity.this, "lllll", Toast.LENGTH_SHORT).show();
            }
        });
        myAdapterHisto.SetOnClicklist(new MyAdapterHisto.onclicklist() {
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

                if (a!=histories.size()){
                    text_qx.setText("全选");
                    text_qx.setSelected(false);
                }else if (a==histories.size()){
                    text_qx.setText("取消全选");
                    text_qx.setSelected(true);
                }

            }
        });

        if (histories.size()==0){
            login_zc.setVisibility(View.INVISIBLE);
        }else {
            login_zc.setVisibility(View.VISIBLE);
        }


    }

    private void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        login_zc = (TextView) findViewById(R.id.login_zc);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        text_qx = (TextView) findViewById(R.id.text_qx);
        text_sc = (TextView) findViewById(R.id.text_sc);
        lienar = (LinearLayout) findViewById(R.id.lienar);
    }
}
