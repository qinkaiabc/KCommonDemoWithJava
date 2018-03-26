package com.blackflagbin.kcommondemowithjava.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blackflagbin.kcommon.base.BaseActivity;
import com.blackflagbin.kcommondemowithjava.R;
import com.blackflagbin.kcommondemowithjava.common.http.ApiService;
import com.blackflagbin.kcommondemowithjava.common.http.CacheService;
import com.blackflagbin.kcommondemowithjava.mvp.contract.WebContract;
import com.blackflagbin.kcommondemowithjava.mvp.presenter.WebPresenter;
import com.kennyc.view.MultiStateView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WebActivity extends BaseActivity<ApiService, CacheService, WebPresenter, Object> implements WebContract.IWebView {


    private String         mUrl;
    private String         mTitle;
    private RelativeLayout rl_left;
    private TextView       tv_middle;
    private WebView        webView;
    private ProgressBar    progress_bar;

    @Nullable
    @Override
    protected SwipeRefreshLayout getSwipeRefreshView() {
        return null;
    }

    @Nullable
    @Override
    protected MultiStateView getMultiStateView() {
        return null;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web;
    }

    @NotNull
    @Override
    protected WebPresenter getPresenter() {
        return new WebPresenter(this);
    }

    @Override
    protected void onExtraBundleReceived(Bundle bundle) {
        super.onExtraBundleReceived(bundle);
        mUrl = bundle.getString("url");
        mTitle = bundle.getString("title");
    }

    @Override
    protected void initView() {
        super.initView();
        findView();
        rl_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tv_middle.setText(mTitle);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl(mUrl);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    if (progress_bar != null) {
                        progress_bar.setVisibility(View.GONE);
                    }
                } else {
                    if (progress_bar != null) {
                        progress_bar.setVisibility(View.VISIBLE);
                        progress_bar.setProgress(newProgress);
                    }
                }
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mUrl = url;
                try {
                    if (url.startsWith("http:") || url.startsWith("https:")) {
                        view.loadUrl(url);
                        return true;
                    } else {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                    return false;
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void showContentView(Object o) {

    }

    private void findView() {
        rl_left = findViewById(R.id.rl_left);
        tv_middle = findViewById(R.id.tv_middle);
        webView = findViewById(R.id.webView);
        progress_bar = findViewById(R.id.progress_bar);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
