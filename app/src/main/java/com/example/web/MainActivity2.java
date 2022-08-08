package com.example.web;

import androidx.appcompat.app.AppCompatActivity;
import androidx.webkit.WebSettingsCompat;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        WebView web_view = findViewById(R.id.webviewer);
        web_view.requestFocus();
        web_view.getSettings().setLightTouchEnabled(true);
        web_view.getSettings().setGeolocationEnabled(true);
        web_view.getSettings().setDomStorageEnabled(true);
        web_view.getSettings().setSupportMultipleWindows(false);
        web_view.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        web_view.getSettings().setSaveFormData(false);
        web_view.getSettings().setSavePassword(false);

        web_view.getSettings().setAllowFileAccess(true);
        web_view.getSettings().setBuiltInZoomControls(true);
        web_view.getSettings().setUseWideViewPort(true);
        web_view.getSettings().setLoadWithOverviewMode(true);
        web_view.setBackgroundColor(0);
        web_view.setBackgroundColor(Color.BLACK);
        web_view.setSoundEffectsEnabled(true);
        
//        web_view.loadDataWithBaseURL(null,"<div id=\"dnse-market-  index\" class=\"dnse-market-index\"><script src=https://cdn.dnse.com.vn/dnse-price/_embed/embed-widget-1.0.7.js>{\"width\":100%,\"height\":100%,\"indexes\":[\"VNINDEX\",\"VN30\",\"HNX30\",\"HNX\",\"UPCOM\"],\"theme\":\"dark\"}</script></div>",  "text/html", "UTF-8",null);
        web_view.loadUrl("https://banggia.vps.com.vn/chung-khoan/VN30");

        WebSettings settings = web_view.getSettings();

        WebSettingsCompat.setForceDark(settings, WebSettingsCompat.FORCE_DARK_ON);
        //web_view.loadUrl("https://vn.tradingview.com/chart/?symbol=HOSE%3AVNINDEX");
        web_view.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
        web_view.getSettings();
    }
}