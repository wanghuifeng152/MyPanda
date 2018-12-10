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

import com.example.whf.mypanda.R;

public class HuDongXActivity extends AppCompatActivity {

    private ImageView image_fanh;
    private ImageView image_fx;
    private WebView wed_v;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu_dong_x);
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

        image_fx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent textIntent = new Intent(Intent.ACTION_SEND);
                textIntent.setType("text/plain");
                textIntent.putExtra(Intent.EXTRA_TEXT, url);
                startActivity(Intent.createChooser(textIntent, "分享"));

            }
        });


    }

    private void initData() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        wed_v.loadUrl(url);

        WebSettings settings = wed_v.getSettings();
        settings.setJavaScriptEnabled(true);
        wed_v.setWebViewClient(new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            wed_v.loadUrl(url);

			
            return super.shouldOverrideUrlLoading(view, request);
        }
});

    }

    private void initView() {
        image_fanh = (ImageView) findViewById(R.id.image_fanh);
        image_fx = (ImageView) findViewById(R.id.image_fx);
        wed_v = (WebView) findViewById(R.id.wed_v);
    }
}
