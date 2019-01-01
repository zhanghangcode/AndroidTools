package com.uuun.androidtools.utils;

import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30
 * @Description String工具类
 * @Email code_legend@163.com
 * @Version 1.0
 */
public class StringUtil {
    private StringUtil() {
    }


    public static boolean isNullOrEmpty(@Nullable String string) {
        return string == null || string.isEmpty();
    }


    public static boolean isNotNullOrEmpty(String inString) {
        return inString != null && !inString.equals("") && inString.length() > 0;
    }

    public static boolean notNullAndEmpty(@Nullable String string) {
        return !isNullOrEmpty(string);
    }

    @Nullable
    public static String emptyToNull(@Nullable String string) {
        return isNullOrEmpty(string) ? null : string;
    }

    @Nullable
    public static String nullToEmpty(@Nullable String string) {
        return isNullOrEmpty(string) ? "" : string;
    }

    public static SpannableString getUnderLineString(String str) {
        SpannableString content = new SpannableString(str);
        content.setSpan(new UnderlineSpan(), 0, str.length(), 0);
        return content;
    }

    public static String truncateStr(String str, int length){
        return str.substring(0,length) + "...";
    }
}
