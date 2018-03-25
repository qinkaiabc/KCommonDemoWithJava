package com.blackflagbin.kcommondemowithjava.mvp.contract;

import com.blackflagbin.kcommon.base.IBaseRefreshAndLoadMorePresenter;
import com.blackflagbin.kcommon.base.IBaseRefreshAndLoadMoreView;
import com.blackflagbin.kcommondemowithjava.common.entity.net.DataItem;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public interface MainPageContract {
    interface IMainPageModel {
        Observable<List<DataItem>> getData(String type, int pageNo, int limit);
    }

    interface IMainPagePresenter extends IBaseRefreshAndLoadMorePresenter {
    }

    interface IMainPageView extends IBaseRefreshAndLoadMoreView<List<DataItem>> {
    }
}
