package com.blackflagbin.kcommondemowithjava.mvp.presenter;

import com.blackflagbin.kcommon.base.BasePresenter;
import com.blackflagbin.kcommondemowithjava.mvp.contract.WebContract;
import com.blackflagbin.kcommondemowithjava.mvp.model.WebModel;

import java.util.Map;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class WebPresenter extends BasePresenter<WebContract.IWebModel, WebContract.IWebView> implements WebContract.IWebPresenter {

    public WebPresenter(WebContract.IWebView mView) {
        super(mView);
    }

    @Override
    protected WebContract.IWebModel getModel() {
        return new WebModel();
    }

    @Override
    public void initData(Map<String, String> map) {

    }
}
