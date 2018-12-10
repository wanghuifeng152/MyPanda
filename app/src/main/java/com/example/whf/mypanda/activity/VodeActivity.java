package com.example.whf.mypanda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.whf.mypanda.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VodeActivity extends AppCompatActivity {

    private JCVideoPlayerStandard jiecao_Playe;
    //测试地址
    String s1="https://txmov2.a.yximgs.com/upic/2017/12/19/19/BMjAxNzEyMTkxOTAxMDBfNzAyMzQ4Ml80Mjc0MDY2MDAzXzJfMw==_b_A11ffeb3a68cd7402684c6d13ef59fe04.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vode);
        initView();
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        //设置标题 有需要的可以试一下
        //getSupportActionBar().setTitle("jiecaovideoplayer的使用");
        //找控件
        jiecao_Playe= (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        //设置视频上显示的文字
        jiecao_Playe.setUp(s1,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
    }

    private void initView() {
        jiecao_Playe = (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
