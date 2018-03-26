package com.blackflagbin.kcommondemowithjava.common.http;

import com.blackflagbin.kcommondemowithjava.BuildConfig;
import com.blackflagbin.kcommondemowithjava.common.entity.net.DataItem;
import com.blackflagbin.kcommondemowithjava.common.entity.net.HttpResultEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public interface ApiService {

    @GET(BuildConfig.EXTRA_URL + "search/query/listview/category/{type}/count/{limit}/page/{pageNo} ")
    Observable<HttpResultEntity<List<DataItem>>> getMainDataList(
            @Path("type") String type, @Path("limit") int limit, @Path("pageNo") int pageNo);
}
