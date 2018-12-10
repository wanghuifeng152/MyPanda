package com.example.whf.mypanda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.whf.mypanda.R;
import com.example.whf.mypanda.adapter.MyPandaHD;
import com.example.whf.mypanda.constants.Urls;
import com.example.whf.mypanda.entity.PandaHD;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HuDongActivity extends AppCompatActivity {

    private ImageView image_fanh;
    private RecyclerView recycl;
    private PandaHD pandaHD;
    private List<PandaHD.InteractiveBean> interactive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu_dong);
        initView();
        initData();
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(new Cache(HuDongActivity.this.getCacheDir(), 1024)).build();
        Request request = new Request.Builder().get().url(Urls.BASEURL).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {



                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        pandaHD = gson.fromJson(string, PandaHD.class);
                        interactive = pandaHD.getInteractive();
                        MyPandaHD myPandaHD = new MyPandaHD(interactive, HuDongActivity.this);
                        LinearLayoutManager manager = new LinearLayoutManager(HuDongActivity.this, LinearLayoutManager.VERTICAL, false);
                        recycl.setLayoutManager(manager);
                        recycl.setAdapter(myPandaHD);
                        myPandaHD.setOnClickListenre(new MyPandaHD.OnClickListenre() {
                            @Override
                            public void OnClick(int position) {
                                Intent intent = new Intent(HuDongActivity.this, HuDongXActivity.class);
                                intent.putExtra("url",interactive.get(position).getUrl());
                                startActivity(intent);
                            }
                        });

                    }
                });
            }
        });

    }

    private void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        recycl = (RecyclerView) findViewById(R.id.recycl);
    }
}
