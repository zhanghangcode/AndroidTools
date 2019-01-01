package com.uuun.androidtools.okhttp;

import android.content.Context;

import com.google.gson.Gson;
import com.uuun.androidtools.utils.DeviceInfoUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30
 * @Description 配置请求头信息的Interceptor
 * @Email code_legend@163.com
 * @Version 1.0
 */
public final class HeaderInterceptorTest implements Interceptor {

    /**
     * 请求头参数基础参数
     */
    private static final String HEADER_BASE_PARAM = "baseParam";
    private static String BASE_PARAM;

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();

        builder.addHeader(HEADER_BASE_PARAM, BASE_PARAM);
        return chain.proceed(builder.build());
    }

    public static void initBaseParam(Context context) {
        BaseParam baseParam = new BaseParam();
        String imei;
        String imsi;
        try {
            imei = DeviceInfoUtil.getIMEI(context);
        } catch (Exception e) {
            imei = null;
        }
        if (null == imei || imei.equals("")) {
            imei = DeviceInfoUtil.getDeviceID(context);
            imsi = DeviceInfoUtil.getDeviceID(context);
        } else {
            imei = DeviceInfoUtil.getIMEI(context);
            imsi = DeviceInfoUtil.getIMSI(context);
        }
        baseParam.setImei(imei);
        baseParam.setImsi(imsi);
        baseParam.setMac(DeviceInfoUtil.getWifiMAC(context));
        baseParam.setVersion(DeviceInfoUtil.getVersion(context));
        baseParam.setModel(DeviceInfoUtil.getModel());
        baseParam.setBrand(DeviceInfoUtil.getBrand());
        BASE_PARAM = new Gson().toJson(baseParam).toString();
    }

    private static class BaseParam {
        /**
         * imei :
         * imsi :
         * mac :
         * version :
         * model :
         * brand :
         * city :
         */
        private String imei;
        private String imsi;
        private String mac;
        private String version;
        private String model;
        private String brand;
        private String city;

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getImsi() {
            return imsi;
        }

        public void setImsi(String imsi) {
            this.imsi = imsi;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
