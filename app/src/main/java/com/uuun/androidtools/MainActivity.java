package com.uuun.androidtools;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.uuun.androidtools.butter.ButterKnifeActivity;
import com.uuun.androidtools.okhttp.OkhttpActivity;
import com.uuun.androidtools.retrofit.RetrofitActivity;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30 0030 18:35
 * @Description 主页面
 * @Email code_legend@163.com
 * @Version 1.0
 */
public class MainActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        String[] strings=getResources().getStringArray(R.array.works);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, strings));
    }

    @Override
    protected void onListItemClick(ListView listView, View v, int position, long id) {
        switch (position){
            case 0:
                Intent intentButter = ButterKnifeActivity.newIntent(this);
                startActivity(intentButter);
                break;
            case 1:
                Intent intentOkhttp = OkhttpActivity.newIntent(this);
                startActivity(intentOkhttp);
                break;
            case 2:
                Intent intentRetrofit = RetrofitActivity.newIntent(this);
                startActivity(intentRetrofit);
                break;
        }
    }
}
