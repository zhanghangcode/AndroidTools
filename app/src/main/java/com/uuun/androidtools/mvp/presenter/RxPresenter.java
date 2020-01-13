package com.uuun.androidtools.mvp.presenter;


import com.uuun.androidtools.mvp.view.BaseView;

/**
 * Created by hluo on 2017/9/18.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {


    protected T mView;
//    protected CompositeDisposable mCompositeDisposable;
//
//    protected void unSubscribe(){
//        if (mCompositeDisposable != null){
//            mCompositeDisposable.clear();
//        }
//    }
//
//    /**
//     * Disposable 它是个开关,调用它的dispose()方法时就会切断水管, 使得下游收不到事件, 既然收不到事件, 那么也就不会再去更新UI了
//     * CompositeDisposable RxJava中内置的一个容器，每当我们得到一个Disposable时就调用CompositeDisposable.add()将它添加到容器中,
//     * 在退出的时候, 调用CompositeDisposable.clear() 即可切断所有的水管
//     * @param subscription
//     */
//    protected void addSubscribe(Disposable subscription){
//        if (mCompositeDisposable == null){
//            mCompositeDisposable = new CompositeDisposable();
//        }
//        mCompositeDisposable.add(subscription);
//    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
//        unSubscribe();
    }
}
