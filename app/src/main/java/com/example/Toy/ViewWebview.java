package com.example.Toy;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewWebview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_webview);

        WebView wv = (WebView) findViewById(R.id.webview);
        wv.loadUrl("https://www.toysrus.ca/en/toysrus/Category/Clearance");
    }
}
