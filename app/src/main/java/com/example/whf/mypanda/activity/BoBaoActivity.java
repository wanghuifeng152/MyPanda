package com.example.whf.mypanda.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.greendao.Collection;
import com.example.greendaodemo.gen.CollectionDao;
import com.example.whf.mypanda.R;
import com.example.whf.mypanda.utils.MyApplication;

public class BoBaoActivity extends AppCompatActivity {

    private ImageView image_fanh;
    private WebView wed_v;
    private ImageView iv_collect;
    private ImageView iv_share;
    private CollectionDao collectionDao;
    private String url;
    private String imge;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bo_bao);
        initView();
        initData();
        initListenre();
    }

    private void initListenre() {
        collectionDao = MyApplication.getApplication().getDaoSession().getCollectionDao();
        iv_collect.setSelected(false);
        iv_collect.setOnClickListener(new View.OnClickListener() {

            private Collection collection;

            @Override
            public void onClick(View v) {
                if (iv_collect.isSelected()){
                    Toast.makeText(BoBaoActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
                    iv_collect.setSelected(false);
                    iv_collect.setImageResource(R.mipmap.collect_no);
                    collectionDao.deleteAll();

                }else {
                    Toast.makeText(BoBaoActivity.this, "已经收藏", Toast.LENGTH_SHORT).show();
                    iv_collect.setSelected(true);
                    iv_collect.setImageResource(R.mipmap.collect_yes);
                    collection = new Collection();
                    collection.setImage(imge);
                    collection.setTitlr(title);
                    collection.setUrl(url);
                    collectionDao.insert(collection);

                }

            }
        });
        //分享
        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BoBaoActivity.this, "分享成功", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        imge = intent.getStringExtra("imge");
        title = intent.getStringExtra("title");
        wed_v.loadUrl(url);
        WebSettings settings = wed_v.getSettings();
        settings.setJavaScriptEnabled(true);
        wed_v.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                wed_v.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    private void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        wed_v = (WebView) findViewById(R.id.wed_v);
        image_fanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv_collect = (ImageView) findViewById(R.id.iv_collect);
        iv_share = (ImageView) findViewById(R.id.iv_share);

    }
}
