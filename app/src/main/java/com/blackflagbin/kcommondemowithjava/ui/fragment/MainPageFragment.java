package com.blackflagbin.kcommondemowithjava.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blackflagbin.kcommon.base.BaseRefreshAndLoadMoreFragment;
import com.blackflagbin.kcommon.widget.FixedLinearLayoutManager;
import com.blackflagbin.kcommondemowithjava.R;
import com.blackflagbin.kcommondemowithjava.common.entity.net.DataItem;
import com.blackflagbin.kcommondemowithjava.common.http.ApiService;
import com.blackflagbin.kcommondemowithjava.common.http.CacheService;
import com.blackflagbin.kcommondemowithjava.mvp.contract.MainPageContract;
import com.blackflagbin.kcommondemowithjava.mvp.presenter.MainPagePresenter;
import com.blackflagbin.kcommondemowithjava.ui.activity.WebActivity;
import com.blackflagbin.kcommondemowithjava.ui.adapter.listadapter.MainPageAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kennyc.view.MultiStateView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
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
        return new MainPageAdapter(new ArrayList<DataItem>());
    }

    @Nullable
    @Override
    protected RecyclerView getRecyclerView() {
        return getMRootView().findViewById(R.id.rv_list);
    }

    @Nullable
    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new FixedLinearLayoutManager(getActivity());
    }

    @Nullable
    @Override
    protected SwipeRefreshLayout getSwipeRefreshView() {
        return getMRootView().findViewById(R.id.swipe_refresh);
    }

    @Nullable
    @Override
    protected MultiStateView getMultiStateView() {
        return getMRootView().findViewById(R.id.multi_state_view);
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
        getMAdapter().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                DataItem item = (DataItem) getMAdapter().getData().get(position);
                bundle.putString("url", item.url);
                bundle.putString("title", item.desc);
                startActivity(WebActivity.class, bundle);
            }
        });
    }
}
