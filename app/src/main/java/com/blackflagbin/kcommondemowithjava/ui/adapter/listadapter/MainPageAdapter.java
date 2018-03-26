package com.blackflagbin.kcommondemowithjava.ui.adapter.listadapter;

import android.support.annotation.Nullable;

import com.blackflagbin.kcommondemowithjava.R;
import com.blackflagbin.kcommondemowithjava.common.entity.net.DataItem;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by blackflagbin on 2018/3/26.
 */

public class MainPageAdapter extends BaseQuickAdapter<DataItem, BaseViewHolder> {

    public MainPageAdapter(
            @Nullable List<DataItem> data) {
        super(R.layout.item_list_data, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataItem item) {
        helper.setText(R.id.tv_title, item.desc);
        helper.setText(R.id.tv_date, item.publishedAt.split("T")[0]);
        helper.setText(R.id.tv_creator, item.who);
    }
}
