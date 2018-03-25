package com.blackflagbin.kcommondemowithjava.mvp.contract;

import com.blackflagbin.kcommon.base.IBasePresenter;
import com.blackflagbin.kcommon.base.IBaseView;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public interface MainContract {
    interface IMainModel {
    }

    interface IMainPresenter extends IBasePresenter {
    }

    interface IMainView extends IBaseView<Object> {
    }
}
