package com.uuun.androidtools.mvp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.uuun.androidtools.R;
import com.uuun.androidtools.mvp.contract.AdviceContract;
import com.uuun.androidtools.mvp.presenter.AdvicePresenter;

/**
 * @author zh_legendd
 * @date 创建时间 2020/1/13 0013 17:50
 * @Description 反正就是很NB的功能
 * @Email code_legend@163.com
 * @Version 1.0
 */

public class AdviceActivity extends AppCompatActivity implements AdviceContract.View {
    private AdvicePresenter mAdvicePresenter;


    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, AdviceActivity.class);
        return intent;
    }

    private void initPresenter() {
        mAdvicePresenter = new AdvicePresenter();
        mAdvicePresenter.attachView(this);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        //网络请求
        mAdvicePresenter.pushAdvice("","");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void pushSuccess() {
        //成功后的回调
    }
}
