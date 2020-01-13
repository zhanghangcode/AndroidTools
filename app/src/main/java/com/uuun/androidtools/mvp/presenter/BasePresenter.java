package com.uuun.androidtools.mvp.presenter;

import com.uuun.androidtools.mvp.view.BaseView;

/**
 *
 * @Description:MVP中Presenter的基类
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}

