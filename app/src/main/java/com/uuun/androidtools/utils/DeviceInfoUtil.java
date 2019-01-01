package com.uuun.androidtools.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30
 * @Description 获取设备的信息
 * @Email code_legend@163.com
 * @Version 1.0
 */
public class DeviceInfoUtil {
    /**
     * 获取IMEI
     * 需要android.permission.READ_PHONE_STATE权限
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context) ;
        String mImei = prefs.getString("imei","");
        if (StringUtil.isNullOrEmpty(mImei)){
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String imei = null;
            try {
                imei = telephonyManager.getDeviceId();
                prefs.edit().putString("imei",imei);
            } catch (Exception e) {
            }
            return imei;
        }else{
            return mImei;
        }
    }

    /**
     * 获取IMSI
     * 需要android.permission.READ_PHONE_STATE权限
     *
     * @param context
     * @return
     */
    public static String getIMSI(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context) ;
        String mImsi = prefs.getString("imsi","");
        if (StringUtil.isNullOrEmpty(mImsi)){
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String imsi = null;
            try {
                imsi = telephonyManager.getSubscriberId();
                prefs.edit().putString("imsi",imsi);
            } catch (Exception e) {

            }
            return imsi;
        }else{
            return mImsi;
        }
    }

    /**
     * 获取wifi的mac地址
     * 需要android.permission.ACCESS_WIFI_STATE权限
     *
     * @param context
     * @return
     */
    public static String getWifiMAC(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager.getConnectionInfo().getMacAddress();
    }

    /**
     * 获取应用版本
     *
     * @param context
     * @return
     */
    public static String getVersion(Context context) {
        String versionName = "";
        String pkName = context.getPackageName();
        try {
            versionName = context.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        int versionCode = 0;
        String pkName = context.getPackageName();
        try {
            versionCode = context.getPackageManager().getPackageInfo(
                    pkName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getBrand() {
        return Build.BRAND;
    }

    /**
     * 通过设备信息拼凑获取的唯一id
     *
     * @return
     */
    private static String getPseudoUniqueID() {
        return "31" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 +
                Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 +
                Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +
                Build.USER.length() % 10;
    }

    /**
     * 获取androidID
     *
     * @param context
     * @return
     */
    private static String getAndroidID(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取设备唯一ID的MD5加密值
     *
     * @param context
     * @return
     */
    public static String getDeviceID(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context) ;
        String devieceId = prefs.getString("devieceId","");
        if (StringUtil.isNullOrEmpty(devieceId)){
            String longID = getPseudoUniqueID() + getAndroidID(context) + getWifiMAC(context);
            MessageDigest messageDigest = null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            messageDigest.update(longID.getBytes(), 0, longID.length());
            byte md5Data[] = messageDigest.digest();
            String md5ID = new String();
            for (int i = 0; i < md5Data.length; i++) {
                int b = (0xFF & md5Data[i]);
                if (b <= 0xF)
                    md5ID += "0";
                md5ID += Integer.toHexString(b);
            }
            prefs.edit().putString("devieceId",md5ID.toLowerCase()).commit();
            return md5ID.toUpperCase();
        }else{
            return devieceId;
        }
    }
}
