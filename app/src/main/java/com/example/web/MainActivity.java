package com.example.web;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        WebView web_view = findViewById(R.id.web_view);
        WebView web_view_vnd = findViewById(R.id.web_view_vnd);
        web_view.requestFocus();
        web_view_vnd.requestFocus();
        web_view.getSettings().setLightTouchEnabled(true);
        web_view_vnd.getSettings().setLightTouchEnabled(true);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view_vnd.getSettings().setJavaScriptEnabled(true);
        web_view.getSettings().setGeolocationEnabled(true);
        web_view_vnd.getSettings().setGeolocationEnabled(true);
        web_view_vnd.getSettings().setUseWideViewPort(true);
        web_view_vnd.getSettings().setJavaScriptEnabled(true);
        web_view_vnd.getSettings().setDomStorageEnabled(true);
        web_view.setSoundEffectsEnabled(true);
        web_view_vnd.setSoundEffectsEnabled(true);
        web_view.loadDataWithBaseURL(null,"<div id=\"dnse-market-  index\" class=\"dnse-market-index\"><script src=https://cdn.dnse.com.vn/dnse-price/_embed/embed-widget-1.0.7.js>{\"width\":100%,\"height\":100%,\"indexes\":[\"VNINDEX\",\"VN30\",\"HNX30\",\"HNX\",\"UPCOM\"],\"theme\":\"dark\"}</script></div>",  "text/html", "UTF-8",null);
        web_view_vnd.loadUrl("https://banggia.vndirect.com.vn/chung-khoan/danh-muc");
        //web_view_vnd.loadUrl("https://banggia.vps.com.vn/chung-khoan/VN30");
            //web_view.loadData("<div id=\"dnse-market-index\" class=\"dnse-market-index\"><script src=https://cdn.dnse.com.vn/dnse-price/_embed/embed-widget-1.0.7.js>{\"width\":100%,\"height\":100%,\"indexes\":[\"VNINDEX\",\"VN30\",\"HNX30\",\"HNX\",\"UPCOM\"],\"theme\":\"dark\"}</script></div>", "text/html", "UTF-8");

        setDesktopMode(web_view_vnd,true);
        setDesktopMode(web_view,false);

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
        web_view_vnd.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });

    }
    public void setDesktopMode(WebView webView,boolean enabled) {
        String newUserAgent = webView.getSettings().getUserAgentString();
        if (enabled) {
            try {
                String ua = webView.getSettings().getUserAgentString();
                String androidOSString = webView.getSettings().getUserAgentString().substring(ua.indexOf("("), ua.indexOf(")") + 1);
                newUserAgent = webView.getSettings().getUserAgentString().replace(androidOSString, "(X11; Linux x86_64)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            newUserAgent = null;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.getSettings().setUserAgentString(newUserAgent);
        webView.getSettings().setUseWideViewPort(enabled);
        webView.getSettings().setLoadWithOverviewMode(enabled);
        webView.reload();
    }
}