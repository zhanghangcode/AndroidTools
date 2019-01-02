package com.uuun.androidtools.butter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.uuun.androidtools.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30 0030 20:37
 * @Description ButterKnife实例
 * @Email code_legend@163.com
 * @Version 1.0
 */

public class ButterKnifeActivity extends AppCompatActivity {
    //通过插件生成的代码
    @BindView(R.id.tv_butter)
    TextView tvButter;
    @BindView(R.id.et_butter)
    EditText etButter;
    @BindView(R.id.btn_butter)
    Button btnButter;

//    @BindView(R.id.tv_butter)
//    TextView tv_butter;
//    @BindView(R.id.et_butter)
//    EditText et_butter;
//    @BindString(R.string.app_name)
//    String app_name;
//    @BindColor(R.color.colorAccent)
//    int colorAccent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter);
        //首先将ButterKnife注入,这行代码要在setContentView()之后执行。
        ButterKnife.bind(this);
        tvButter.setText("绑定TextView");
        etButter.setText("绑定EditText");
    }

    @OnClick(R.id.btn_butter)
    public void onBtnClick(View view) {
        Toast.makeText(this, "btn_butter被点击了", Toast.LENGTH_SHORT).show();
    }


    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, ButterKnifeActivity.class);
        return intent;
    }
}
