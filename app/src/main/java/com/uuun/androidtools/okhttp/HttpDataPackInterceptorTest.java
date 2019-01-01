package com.uuun.androidtools.okhttp;


import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.uuun.androidtools.utils.JsonUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30
 * @Description 处理请求参数的数据封装
 * @Email code_legend@163.com
 * @Version 1.0
 */
public class HttpDataPackInterceptorTest implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder requestBuilder = chain.request().newBuilder();
        //请求数据处理
        if (request.url().toString().contains("uploads")) {
            //特殊接口的参数不需要处理的
        } else {
            //需要处理请求参数的
            if (request.body() instanceof FormBody) {
                FormBody.Builder newFormBody = new FormBody.Builder();
                //得到请求时设置的请求体
                FormBody oldFormBody = (FormBody) request.body();
                Buffer buffer = new Buffer();
                oldFormBody.writeTo(buffer);
                String postParams = JsonUtils.getJsonStrFromPostParams(buffer.readString(Charset.forName("UTF-8")));
                String data = URLDecoder.decode(postParams, "UTF-8");
                if (TextUtils.isEmpty(data)) {
                    newFormBody.add("data", "");
                } else {
                    //将请求的数据封装
                    newFormBody.add("data", data);
                }

                requestBuilder.method(request.method(), newFormBody.build());

            }
        }

        return chain.proceed(requestBuilder.build());
    }

}
