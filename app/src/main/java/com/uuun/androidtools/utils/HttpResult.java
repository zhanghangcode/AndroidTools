package com.uuun.androidtools.utils;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30
 * @Description HttpResult请求结果封装
 * @Email code_legend@163.com
 * @Version 1.0
 */

public class HttpResult<T> {
    public int code;
    public String msg;
    public T data;

    public static final int SUCCESS = 0;
    public static final int ERROR = 1;//服务器返回错误
    public static final int ERROR_TOKEN = 4001;//用户登陆凭证token异常
    public static final int ERROR_TOKEN_REPLACE = 4005;//用户被异地登录

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
