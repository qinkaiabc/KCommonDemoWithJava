package com.blackflagbin.kcommondemowithjava.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.blackflagbin.kcommon.facade.CommonLibrary;
import com.blackflagbin.kcommondemowithjava.BuildConfig;
import com.blackflagbin.kcommondemowithjava.common.http.ApiService;
import com.blackflagbin.kcommondemowithjava.common.http.CacheService;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class App extends Application {

    private static int START_PAGE = 1;
    private static int PAGE_SIZE  = 20;

    /**
     * 跳转到登录页面，同时清空之前的任务栈
     *
     * @param context    context
     * @param loginClazz 登录页面Activity的Class类
     */
    public static void startLoginActivity(Context context, Class loginClazz) {
        context.startActivity(new Intent(context, loginClazz).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CommonLibrary.Companion.getInstance()
                .initLibrary(this, BuildConfig.APP_URL, ApiService.class, CacheService.class, "KCommonDemoWithJava", BuildConfig.DEBUG, START_PAGE,
                        PAGE_SIZE, null, null, null, null, null, null);
    }
}
