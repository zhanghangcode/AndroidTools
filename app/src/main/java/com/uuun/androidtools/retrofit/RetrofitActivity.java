package com.uuun.androidtools.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Retrofit;

/**
 * @author zh_legendd
 * @date 创建时间 2019/1/2 0002 21:31
 * @Description 反正就是很NB的功能
 * @Email code_legend@163.com
 * @Version 1.0
 */

public class RetrofitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder().build();
    }
}
