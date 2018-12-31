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

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30 0030 18:35
 * @Description Okhttp实例
 * @Email code_legend@163.com
 * @Version 1.0
 */

public class OkhttpActivity extends AppCompatActivity{

    private static final String url1="https://api.apiopen.top/getJoke?page=1&count=2&type=video";
    private static final String url="https://www.26uuun.com/list?name=jj&age=ll";
    private static final String url2="https://www.26uuun.com/list";
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public TextView tv_data;

    OkHttpClient client = new OkHttpClient();
    Runnable runnable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
         tv_data = (TextView)findViewById(R.id.tv_data);

        initData();
        new Thread(runnable).start();

    }

    private void initData()  {
        runnable = new Runnable(){
            @Override
            public void run() {
                try {

                    FormBody formBody = new FormBody.Builder()
                            .add("name", "admin")
                            .add("age", "admin")
                            .build();
                    Request request = new Request.Builder()
                            .url(url2)
                            .post(formBody)
                            .build();


                    Response response = client.newCall(request).execute();
//                  Toast.makeText(OkhttpActivity.this,response.body().string(),Toast.LENGTH_SHORT).show();
                    Log.e("error",response.body().string());
                } catch (IOException e) {
                    Toast.makeText(OkhttpActivity.this,"异常",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        };
    }

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("name","jj")
                .addHeader("age","18")
//                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, OkhttpActivity.class);
        return intent;
    }
}
