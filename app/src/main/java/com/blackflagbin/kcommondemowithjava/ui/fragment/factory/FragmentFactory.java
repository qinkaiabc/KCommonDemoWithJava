package com.blackflagbin.kcommondemowithjava.ui.fragment.factory;

import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public class FragmentFactory {
    private static HashMap<Integer, Fragment> mFragmentMap = new HashMap<>();

    public static Fragment getFragment(int position) {
        if (mFragmentMap.get(position) == null) {
            mFragmentMap.put(position, new Fragment());
        }
        return mFragmentMap.get(position);
    }

}
