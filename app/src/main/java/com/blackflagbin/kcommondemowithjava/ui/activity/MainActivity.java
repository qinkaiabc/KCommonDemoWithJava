package com.blackflagbin.kcommondemowithjava.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.blackflagbin.kcommon.base.BaseActivity;
import com.blackflagbin.kcommon.widget.GlideCircleTransform;
import com.blackflagbin.kcommondemowithjava.R;
import com.blackflagbin.kcommondemowithjava.common.http.ApiService;
import com.blackflagbin.kcommondemowithjava.common.http.CacheService;
import com.blackflagbin.kcommondemowithjava.mvp.contract.MainContract;
import com.blackflagbin.kcommondemowithjava.mvp.presenter.MainPresenter;
import com.blankj.utilcode.util.CacheUtils;
import com.bumptech.glide.Glide;
import com.kennyc.view.MultiStateView;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MainActivity extends BaseActivity<ApiService, CacheService, MainPresenter, Object> implements MainContract.IMainView {


    private static String   AVATAR_URL       = "https://avatars2.githubusercontent" + "" + "" + "" + "" + "" + "" + "" +
            ".com/u/17843145?s=400&u=d417a5a50d47426c0f0b6b9ff64d626a36bf0955&v=4";
    private static String   ABOUT_ME_URL     = "https://github.com/BlackFlagBin";
    private static String   READ_ME_URL      = "https://github.com/BlackFlagBin/KCommonProject/blob/master/README.md";
    private static String   MORE_PROJECT_URL = "https://github.com/BlackFlagBin?tab=repositories";
    private static String[] mTypeArray       = {"all", "Android", "iOS", "休息视频", "福利", "拓展资源", "前端", "瞎推荐", "App"};
    private RelativeLayout rl_right;
    private Toolbar        tb_main;
    private TabLayout      tl_type;
    private ViewPager      vp_content;
    private MultiStateView multi_state_view;
    private View      ll_read_me;
    private View      ll_more_project;
    private View      ll_clear_cache;

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
        return R.layout.activity_main;
    }

    @NotNull
    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
        findView();
        setupSlidingView();
        rl_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity();
            }
        });
        ll_read_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity();
            }
        });
        ll_more_project.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity();
            }
        });
        ll_clear_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCache();
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
        rl_right = findViewById(R.id.rl_right);
        tb_main = findViewById(R.id.tb_main);
        tl_type = findViewById(R.id.tl_type);
        vp_content = findViewById(R.id.vp_content);
        multi_state_view = findViewById(R.id.multi_state_view);
    }

    private void setupSlidingView() {
        final SlidingRootNav slidingRootNav = new SlidingRootNavBuilder(this).withToolbarMenuToggle(tb_main)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withMenuLayout(R.layout.menu_main_drawer)
                .inject();
        View ll_menu_root = findViewById(R.id.ll_menu_root);
        ImageView iv_user_avatar = findViewById(R.id.iv_user_avatar);
        ll_read_me = findViewById(R.id.ll_read_me);
        ll_more_project = findViewById(R.id.ll_more_project);
        ll_clear_cache = findViewById(R.id.ll_clear_cache);
        ll_menu_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingRootNav.closeMenu(true);
            }
        });

        Glide.with(this)
                .load(AVATAR_URL)
                .placeholder(R.mipmap.avatar)
                .error(R.mipmap.avatar)
                .dontAnimate()
                .transform(new GlideCircleTransform(this))
                .into(iv_user_avatar);

    }

    private void setupViewPager() {
        //vp_content.setAdapter();
    }

    private void clearCache() {
        CacheUtils cache = CacheUtils.getInstance(getCacheDir());
        String cacheSize = Formatter.formatFileSize(this, cache.getCacheSize());
        cache.clear();
        showTip("清除缓存" + cacheSize);
    }

}
