package com.example.cartoonfilmapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private TextView cartoonDescriptionTextView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        cartoonDescriptionTextView = findViewById(R.id.cartoonDescriptionTextView);
        webView = findViewById(R.id.webView);


        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);


        Intent intent = getIntent();
        String cartoonName = intent.getStringExtra("cartoonName");
        String cartoonDescription = intent.getStringExtra("cartoonDescription");
        String cartoonVideoUrl = intent.getStringExtra("cartoonVideoUrl");


        String videoId = cartoonVideoUrl.substring(cartoonVideoUrl.lastIndexOf("/") + 1);
        String videoEmbedUrl = "https://www.youtube.com/embed/" + videoId;
        webView.loadUrl(videoEmbedUrl);


        cartoonDescriptionTextView.setText(cartoonDescription);
    }
}
