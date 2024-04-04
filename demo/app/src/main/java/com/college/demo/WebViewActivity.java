package com.college.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebViewActivity extends AppCompatActivity {
    WebView browser;
    Button forwardBtn;
    Button backwardBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        forwardBtn = (Button)findViewById(R.id.forwardBtn);
        backwardBtn = (Button)findViewById(R.id.backwardBtn);

        browser = (WebView) findViewById(R.id.webkit);
        browser.getSettings().setJavaScriptEnabled(true); // allow scripts
        browser.setWebViewClient(new WebViewClient());   // page navigation
        browser.loadUrl("https://www.naver.com");


        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browser.goForward();
            }
        });
        backwardBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                browser.goBack();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String option = item.getTitle().toString();
        if(option.equals("Forward Page"))
            browser.goForward();
        if(option.equals("Back Page"))
            browser.goBack();
        return true;
    }
}