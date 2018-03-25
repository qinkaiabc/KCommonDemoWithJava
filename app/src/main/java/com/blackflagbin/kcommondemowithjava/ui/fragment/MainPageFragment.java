package com.blackflagbin.kcommondemowithjava.ui.fragment;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.blackflagbin.kcommon.base.BaseRefreshAndLoadMoreFragment;
import com.blackflagbin.kcommondemowithjava.R;
import com.blackflagbin.kcommondemowithjava.common.entity.net.DataItem;
import com.blackflagbin.kcommondemowithjava.common.http.ApiService;
import com.blackflagbin.kcommondemowithjava.common.http.CacheService;
import com.blackflagbin.kcommondemowithjava.mvp.contract.MainPageContract;
import com.blackflagbin.kcommondemowithjava.mvp.presenter.MainPagePresenter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kennyc.view.MultiStateView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by blackflagbin on 2018/3/25.
 */

@SuppressLint("ValidFragment")
public class MainPageFragment extends
        BaseRefreshAndLoadMoreFragment<ApiService, CacheService, MainPageContract.IMainPagePresenter, List<DataItem>> implements
        MainPageContract.IMainPageView {

    private static String[] mTypeArray = {"all", "Android", "iOS", "休息视频", "福利", "拓展资源", "前端", "瞎推荐", "App"};
    private String mType;

    public MainPageFragment(int position) {
        mType = mTypeArray[position];
    }

    @Nullable
    @Override
    protected BaseQuickAdapter<?, ?> getAdapter() {
        return null;
    }

    @Nullable
    @Override
    protected RecyclerView getRecyclerView() {
        return null;
    }

    @Nullable
    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }

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
        return R.layout.fragment_main_page;
    }

    @NotNull
    @Override
    protected MainPageContract.IMainPagePresenter getPresenter() {
        return new MainPagePresenter(this);
    }

    @Override
    protected void initData() {
        getMDataMap().put("type", mType);
        mPresenter.initData(getMDataMap());
    }

    @Override
    protected void showContentView(List<DataItem> dataItems) {

    }
}
