package com.blackflagbin.kcommondemowithjava.ui.fragment.factory;

import android.support.v4.app.Fragment;

import com.blackflagbin.kcommondemowithjava.ui.fragment.MainPageFragment;

import java.util.HashMap;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class FragmentFactory {
    private static HashMap<Integer, Fragment> mFragmentMap = new HashMap<>();

    public static Fragment getFragment(int position) {
        if (mFragmentMap.get(position) == null) {
            mFragmentMap.put(position, new MainPageFragment(position));
        }
        return mFragmentMap.get(position);
    }

}
