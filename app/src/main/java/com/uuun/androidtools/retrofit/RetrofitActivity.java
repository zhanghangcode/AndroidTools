package com.uuun.androidtools.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.uuun.androidtools.R;
import com.uuun.androidtools.okhttp.OkhttpActivity;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * @author zh_legendd
 * @date 创建时间 2019/1/2 0002 21:31
 * @Description Retrofit实例
 * @Email code_legend@163.com
 * @Version 1.0
 */

public class RetrofitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        retrofitGet();


    }

    private void retrofitGet() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.apiopen.top/")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<String> repos = service.getStringTest();
    }

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, RetrofitActivity.class);
        return intent;
    }
}
