package com.blackflagbin.kcommondemowithjava.ui.adapter.pageradapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.blackflagbin.kcommondemowithjava.ui.fragment.factory.FragmentFactory;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    private static String[] mTypeArray = {"all", "Android", "iOS", "休息视频", "福利", "拓展资源", "前端", "瞎推荐", "App"};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getFragment(position);
    }

    @Override
    public int getCount() {
        return mTypeArray.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTypeArray[position];
    }
}
