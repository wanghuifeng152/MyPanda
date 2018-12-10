package com.example.whf.mypanda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.whf.mypanda.R;
import com.example.whf.mypanda.adapter.MyAdapterGunVode;
import com.example.whf.mypanda.entity.MyGungVode;
import com.google.gson.Gson;
import com.xiao.nicevideoplayer.Clarity;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GungVodeActivity extends AppCompatActivity {

    private NiceVideoPlayer nice_video_player;
    private RecyclerView recycl;
    private TextView text_zhib;
    private ImageView image_off;
    private TextView text_t;
    private TextView text_bt;
    private List<MyGungVode.VideoBean> video;
    private ImageView image_fanh;
    private ImageView iv_collect;
    private ImageView iv_share;
    private boolean imagepd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gung_vode);
        initView();
        initData();
        initDaInt();
        initlistenre();
    }

    private void initlistenre() {
        //收藏
        iv_collect.setSelected(false);
        iv_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv_collect.isSelected()){
                    Toast.makeText(GungVodeActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                   iv_collect.setSelected(false);
                    iv_collect.setImageResource(R.mipmap.collect_no);
                }else {
                    Toast.makeText(GungVodeActivity.this, "已经收藏", Toast.LENGTH_SHORT).show();
                   iv_collect.setSelected(true);
                    iv_collect.setImageResource(R.mipmap.collect_yes);
                }

            }
        });
        //分享
        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GungVodeActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void initDaInt() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");
        text_bt.setText(title);
        text_t.setText(url);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(id).get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                GungVodeActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        MyGungVode myGungVode = gson.fromJson(string, MyGungVode.class);
                        video = myGungVode.getVideo();
                        MyAdapterGunVode myAdapterGunVode = new MyAdapterGunVode(video, GungVodeActivity.this);
                        LinearLayoutManager manager = new LinearLayoutManager(GungVodeActivity.this, LinearLayoutManager.VERTICAL, false);
                        recycl.setLayoutManager(manager);
                        recycl.setAdapter(myAdapterGunVode);


                    }
                });
            }
        });

    }

    private void initData() {
        nice_video_player.setPlayerType(NiceVideoPlayer.TYPE_IJK); // or NiceVideoPlayer.TYPE_NATIVE
        nice_video_player.setUp(getIntent().getStringExtra("vod"), null);

        TxVideoPlayerController controller = new TxVideoPlayerController(GungVodeActivity.this);

        Glide.with(GungVodeActivity.this)
                .load(getIntent().getStringExtra("img"))
                .placeholder(R.drawable.img_default)
                .crossFade()
                .into(controller.imageView());

        controller.setClarity(getClarites(), 0);
        nice_video_player.setController(controller);


    }

    public List<Clarity> getClarites() {
        List<Clarity> clarities = new ArrayList<>();
        clarities.add(new Clarity("标清", "270P", "http://play.g3proxy.lecloud.com/vod/v2/MjUxLzE2LzgvbGV0di11dHMvMTQvdmVyXzAwXzIyLTExMDc2NDEzODctYXZjLTE5OTgxOS1hYWMtNDgwMDAtNTI2MTEwLTE3MDg3NjEzLWY1OGY2YzM1NjkwZTA2ZGFmYjg2MTVlYzc5MjEyZjU4LTE0OTg1NTc2ODY4MjMubXA0?b=259&mmsid=65565355&tm=1499247143&key=f0eadb4f30c404d49ff8ebad673d3742&platid=3&splatid=345&playid=0&tss=no&vtype=21&cvid=2026135183914&payff=0&pip=08cc52f8b09acd3eff8bf31688ddeced&format=0&sign=mb&dname=mobile&expect=1&tag=mobile&xformat=super"));
        clarities.add(new Clarity("高清", "480P", "http://play.g3proxy.lecloud.com/vod/v2/MjQ5LzM3LzIwL2xldHYtdXRzLzE0L3Zlcl8wMF8yMi0xMTA3NjQxMzkwLWF2Yy00MTk4MTAtYWFjLTQ4MDAwLTUyNjExMC0zMTU1NTY1Mi00ZmJjYzFkNzA1NWMyNDc4MDc5OTYxODg1N2RjNzEwMi0xNDk4NTU3OTYxNzQ4Lm1wNA==?b=479&mmsid=65565355&tm=1499247143&key=98c7e781f1145aba07cb0d6ec06f6c12&platid=3&splatid=345&playid=0&tss=no&vtype=13&cvid=2026135183914&payff=0&pip=08cc52f8b09acd3eff8bf31688ddeced&format=0&sign=mb&dname=mobile&expect=1&tag=mobile&xformat=super"));
        clarities.add(new Clarity("超清", "720P", "http://play.g3proxy.lecloud.com/vod/v2/MjQ5LzM3LzIwL2xldHYtdXRzLzE0L3Zlcl8wMF8yMi0xMTA3NjQxMzkwLWF2Yy00MTk4MTAtYWFjLTQ4MDAwLTUyNjExMC0zMTU1NTY1Mi00ZmJjYzFkNzA1NWMyNDc4MDc5OTYxODg1N2RjNzEwMi0xNDk4NTU3OTYxNzQ4Lm1wNA==?b=479&mmsid=65565355&tm=1499247143&key=98c7e781f1145aba07cb0d6ec06f6c12&platid=3&splatid=345&playid=0&tss=no&vtype=13&cvid=2026135183914&payff=0&pip=08cc52f8b09acd3eff8bf31688ddeced&format=0&sign=mb&dname=mobile&expect=1&tag=mobile&xformat=super"));
        clarities.add(new Clarity("蓝光", "1080P", "http://play.g3proxy.lecloud.com/vod/v2/MjQ5LzM3LzIwL2xldHYtdXRzLzE0L3Zlcl8wMF8yMi0xMTA3NjQxMzkwLWF2Yy00MTk4MTAtYWFjLTQ4MDAwLTUyNjExMC0zMTU1NTY1Mi00ZmJjYzFkNzA1NWMyNDc4MDc5OTYxODg1N2RjNzEwMi0xNDk4NTU3OTYxNzQ4Lm1wNA==?b=479&mmsid=65565355&tm=1499247143&key=98c7e781f1145aba07cb0d6ec06f6c12&platid=3&splatid=345&playid=0&tss=no&vtype=13&cvid=2026135183914&payff=0&pip=08cc52f8b09acd3eff8bf31688ddeced&format=0&sign=mb&dname=mobile&expect=1&tag=mobile&xformat=super"));
        return clarities;
    }

    private void initView() {
        nice_video_player = (NiceVideoPlayer) findViewById(R.id.nice_video_player);
        recycl = (RecyclerView) findViewById(R.id.recycl);
        text_zhib = (TextView) findViewById(R.id.text_zhib);
        image_off = (ImageView) findViewById(R.id.image_off);
        text_t = (TextView) findViewById(R.id.text_t);
        text_bt = (TextView) findViewById(R.id.text_bt);
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
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
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv_collect = (ImageView) findViewById(R.id.iv_collect);
        iv_share = (ImageView) findViewById(R.id.iv_share);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 在 onStop 时释放掉播放器
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在 Activity 中 onBackPress 要交给 NiceVideoPlayer 先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }
}
