package com.hoon2c.callelevatorsds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hoon2c.callelevatorsds.service.AptApiInterface;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    Retrofit retrofit;
    AptApiInterface aptApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());

        mWebView.getSettings().setLoadsImagesAutomatically(true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);

        mWebView.addJavascriptInterface(new WebAppInterface(this, mWebView), "Android");

        mWebView.loadUrl("file:///android_asset/index.html");

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);

        BroadcastReceiver screenOnOff = new BroadcastReceiver()
        {
            public static final String ScreenOff = "android.intent.action.SCREEN_OFF";
            public static final String ScreenOn = "android.intent.action.SCREEN_ON";

            public void onReceive(Context contex, Intent intent)
            {
                if (intent.getAction().equals(ScreenOff))
                {
                    mWebView.loadUrl("file:///android_asset/ready.html");
                }
                else if (intent.getAction().equals(ScreenOn))
                {
                    mWebView.loadUrl("file:///android_asset/index.html");
                }
            }
        };

        registerReceiver(screenOnOff, intentFilter);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }
}