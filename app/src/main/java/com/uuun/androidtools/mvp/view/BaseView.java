package com.uuun.androidtools.mvp.view;

/**
 * @Description:MVP中View的基类
 */


public interface BaseView {

    void showLoading();

    void hideLoading();

    void showError(String msg);

}
