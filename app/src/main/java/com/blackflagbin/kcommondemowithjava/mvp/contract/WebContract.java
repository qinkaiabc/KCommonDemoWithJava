package com.blackflagbin.kcommondemowithjava.mvp.contract;

import com.blackflagbin.kcommon.base.IBasePresenter;
import com.blackflagbin.kcommon.base.IBaseView;

/**
 * Created by blackflagbin on 2018/3/25.
 */

public interface WebContract {
    interface IWebModel {
    }

    interface IWebPresenter extends IBasePresenter {
    }

    interface IWebView extends IBaseView<Object> {
    }
}
