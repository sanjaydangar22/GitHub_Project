package com.example.bankdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WabViewActivity extends AppCompatActivity {


    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wab_view);


        // Find the WebView by its unique ID
        WebView webView = findViewById(R.id.wabView);

        // loading http://www.google.com url in the WebView.

        String url = getIntent().getExtras().getString("url");

        webView.loadUrl(url);

        // this will enable the javascript.
        webView.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.setWebViewClient(new WebViewClient());

    }
}