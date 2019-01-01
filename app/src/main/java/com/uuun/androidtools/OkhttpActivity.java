package com.uuun.androidtools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

import static android.R.attr.name;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30 0030 18:35
 * @Description Okhttp实例
 * @Email code_legend@163.com
 * @Version 1.0
 */

public class OkhttpActivity extends AppCompatActivity{

    private static final String url1="https://api.apiopen.top/getJoke?page=1&count=2&type=video";
    private static final String url3="https://api.apiopen.top/getJoke";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private Runnable runnable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        okhttpPost();
        new Thread(runnable).start();
//        okhttpAsyncGet();
//        okhttpAsyncPost();
    }
    OkHttpClient client = new OkHttpClient()
            .newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS).build();
    private void okhttpAsyncGet(){
        Request request = new Request.Builder()
                .url("https://api.apiopen.top/getJoke?page=1&count=2&type=video")
                .build();



       client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("error",response.body().string());
            }
        });
    }
    private void okhttpAsyncPost(){
        RequestBody formBody = new FormBody.Builder()
                .add("page", "1")
                .add("count", "2")
                .add("type","video")
                .build();
        Request request = new Request.Builder()
                .url("https://api.apiopen.top/getJoke")
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("error",response.body().string());
            }
        });
    }

    private void okhttpPost()  {
        runnable = new Runnable(){
            @Override
            public void run() {
                try {

                    RequestBody formBody = new FormBody.Builder()
                            .add("page", "1")
                            .add("count", "2")
                            .add("type","video")
                            .build();
                    Request request = new Request.Builder()
                            .url("https://api.apiopen.top/getJoke")
                            .post(formBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    Log.e("error",response.body().string());
                } catch (Exception e) {
                    Toast.makeText(OkhttpActivity.this,"异常",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        };
    }



    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, OkhttpActivity.class);
        return intent;
    }
}
