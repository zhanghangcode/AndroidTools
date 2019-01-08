package com.uuun.androidtools.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author zh_legendd
 * @date 创建时间 2019/1/8 0008 22:13
 * @Description 反正就是很NB的功能
 * @Email code_legend@163.com
 * @Version 1.0
 */

public interface  GitHubService {
    @GET("getJoke?page=1&count=2&type=video")
    Call<String> getStringTest();
}
