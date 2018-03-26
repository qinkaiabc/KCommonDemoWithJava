package com.blackflagbin.kcommondemowithjava.mvp.model;

import com.blackflagbin.kcommon.base.BaseModel;
import com.blackflagbin.kcommondemowithjava.common.http.ApiService;
import com.blackflagbin.kcommondemowithjava.common.http.CacheService;
import com.blackflagbin.kcommondemowithjava.mvp.contract.MainContract;
import com.blackflagbin.kcommondemowithjava.mvp.contract.WebContract;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class WebModel extends BaseModel<ApiService, CacheService> implements WebContract.IWebModel {
}
