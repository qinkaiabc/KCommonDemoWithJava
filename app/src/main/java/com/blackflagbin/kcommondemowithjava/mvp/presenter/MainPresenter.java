package com.blackflagbin.kcommondemowithjava.mvp.presenter;

import com.blackflagbin.kcommon.base.BasePresenter;
import com.blackflagbin.kcommondemowithjava.mvp.contract.MainContract;
import com.blackflagbin.kcommondemowithjava.mvp.model.MainModel;

import java.util.Map;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class MainPresenter extends BasePresenter<MainContract.IMainModel, MainContract.IMainView> implements MainContract.IMainPresenter {

    public MainPresenter(MainContract.IMainView mView) {
        super(mView);
    }

    @Override
    protected MainContract.IMainModel getModel() {
        return new MainModel();
    }

    @Override
    public void initData(Map<String, String> map) {

    }
}
