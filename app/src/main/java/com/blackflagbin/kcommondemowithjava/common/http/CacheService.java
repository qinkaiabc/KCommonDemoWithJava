package com.blackflagbin.kcommondemowithjava.common.http;

import com.blackflagbin.kcommondemowithjava.common.entity.net.DataItem;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKeyGroup;
import io.rx_cache2.EvictDynamicKeyGroup;
import io.rx_cache2.LifeCache;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public interface CacheService {
    @LifeCache(duration = 10, timeUnit = TimeUnit.MINUTES)
    public Observable<List<DataItem>> getMainDataList(
            Observable<List<DataItem>> observable, DynamicKeyGroup keyGroup, EvictDynamicKeyGroup evictDynamicKeyGroup);

}
