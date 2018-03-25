package com.blackflagbin.kcommondemowithjava.mvp.presenter;

import com.blackflagbin.kcommon.base.BasePresenter;
import com.blackflagbin.kcommon.facade.CommonLibrary;
import com.blackflagbin.kcommon.http.subscribers.NoProgressObserver;
import com.blackflagbin.kcommon.http.subscribers.ObserverCallBack;
import com.blackflagbin.kcommondemowithjava.common.entity.net.DataItem;
import com.blackflagbin.kcommondemowithjava.mvp.contract.MainPageContract;
import com.blackflagbin.kcommondemowithjava.mvp.model.MainPageModel;
import com.blankj.utilcode.util.NetworkUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class MainPagePresenter extends BasePresenter<MainPageContract.IMainPageModel, MainPageContract.IMainPageView> implements
        MainPageContract.IMainPagePresenter {


    public MainPagePresenter(MainPageContract.IMainPageView mView) {
        super(mView);
    }

    @Override
    protected MainPageContract.IMainPageModel getModel() {
        return new MainPageModel();
    }

    @Override
    public void initData(Map<String, String> dataMap) {
        initData(dataMap, CommonLibrary.Companion.getInstance().getStartPage());
    }

    @Override
    public void initData(Map<String, String> dataMap, int pageNo) {
        if (!NetworkUtils.isConnected()) {
            getMView().showTip("网络已断开，当前数据为缓存数据");
        }
        if (pageNo == CommonLibrary.Companion.getInstance().getStartPage()) {
            getMView().beforeInitData();
            getMModel().getData(dataMap.get("type"), pageNo, CommonLibrary.Companion.getInstance().getPageSize())
                    .subscribeWith(new NoProgressObserver<List<DataItem>>(getMView(), new ObserverCallBack<List<DataItem>>() {
                        @Override
                        public void onNext(List<DataItem> t) {
                            getMView().showSuccessView(t);
                            getMView().dismissLoading();
                        }

                        @Override
                        public void onError(Throwable e) {
                            getMView().showErrorView("");
                            getMView().dismissLoading();
                        }
                    }, false));
        } else {
            getMModel().getData(dataMap.get("type"), pageNo, CommonLibrary.Companion.getInstance().getPageSize())
                    .subscribeWith(new NoProgressObserver<List<DataItem>>(getMView(), null, true));
        }
    }
}
