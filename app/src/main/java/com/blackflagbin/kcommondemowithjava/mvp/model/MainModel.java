package com.blackflagbin.kcommondemowithjava.mvp.model;

import com.blackflagbin.kcommon.base.BaseModel;
import com.blackflagbin.kcommondemowithjava.common.http.ApiService;
import com.blackflagbin.kcommondemowithjava.common.http.CacheService;
import com.blackflagbin.kcommondemowithjava.mvp.contract.MainContract;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class MainModel extends BaseModel<ApiService, CacheService> implements MainContract.IMainModel {
}
