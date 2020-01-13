package com.uuun.androidtools.mvp.contract;

import com.uuun.androidtools.mvp.presenter.BasePresenter;
import com.uuun.androidtools.mvp.view.BaseView;

/**
 * @author zh_legendd
 * @date 创建时间 2020/1/13 0013 17:35
 * @Description 反正就是很NB的功能
 * @Email code_legend@163.com
 * @Version 1.0
 */

public interface AdviceContract {
    interface View extends BaseView{
        void pushSuccess();
    }
    interface Presenter extends BasePresenter<View>{
        void pushAdvice(String token,String content);
    }
}
