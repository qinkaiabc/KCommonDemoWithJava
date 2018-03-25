package com.blackflagbin.kcommondemowithjava.mvp.model;

import com.blackflagbin.kcommon.base.BaseModel;
import com.blackflagbin.kcommon.http.transformer.DefaultTransformer;
import com.blackflagbin.kcommondemowithjava.common.entity.net.DataItem;
import com.blackflagbin.kcommondemowithjava.common.http.ApiService;
import com.blackflagbin.kcommondemowithjava.common.http.CacheService;
import com.blackflagbin.kcommondemowithjava.mvp.contract.MainPageContract;
import com.blankj.utilcode.util.NetworkUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKeyGroup;
import io.rx_cache2.EvictDynamicKeyGroup;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class MainPageModel extends BaseModel<ApiService, CacheService> implements MainPageContract.IMainPageModel {
    @Override
    public Observable<List<DataItem>> getData(
            String type, int pageNo, int limit) {
        Observable<List<DataItem>> observable;
        if (NetworkUtils.isConnected()) {
            observable = getMCacheService().getMainDataList(
                    getMApiService().getMainDataList(type, limit, pageNo).compose(new DefaultTransformer<List<DataItem>>()),
                    new DynamicKeyGroup(type, pageNo), new EvictDynamicKeyGroup(true))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        } else {
            observable = getMCacheService().getMainDataList(
                    getMApiService().getMainDataList(type, limit, pageNo).compose(new DefaultTransformer<List<DataItem>>()),
                    new DynamicKeyGroup(type, pageNo), new EvictDynamicKeyGroup(false))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
        return observable;
    }
}
