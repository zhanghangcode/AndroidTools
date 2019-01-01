package com.uuun.androidtools.utils;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zh_legendd
 * @date 创建时间 2018/12/30
 * @Description json字符串处理工具类
 * @Email code_legend@163.com
 * @Version 1.0
 */
public class JsonUtils {

    /**
     * 将post请求的参数格式转化为json字符串样式
     *
     * @param params
     * @return
     */
    public static String getJsonStrFromPostParams(String params) {

//        Logger.e("原始params："+ params);

        if (!params.contains("&") && !params.contains("="))
            return params;
        String[] pairs = params.split("&");
 /*       if (pairs.length == 1) {
            String[] strs = pairs[0].split("=");
            if (strs.length == 1)
                return "";
            else
                return strs[1];
        }*/
        Map<String, String> maps = new HashMap<>();
        for (String s : pairs) {
            String[] strs = s.split("=");
            if (strs.length == 1)
                //如果分割后的传递参数,后面没有值的时候,这里默认设置为null
                maps.put(strs[0], null);
            else
                maps.put(strs[0], strs[1]);
        }
        Iterator<Map.Entry<String, String>> entries = maps.entrySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            appendString(stringBuilder, entry.getKey());
            if (entry.getValue() == null) {
//                Logger.i("没有对应的值");
                stringBuilder.append(":");
                stringBuilder.append("\"");
                stringBuilder.append("\"");
                stringBuilder.append(",");
            } else {
                if (entry.getValue().startsWith("{") && entry.getValue().endsWith("}")) {
                    stringBuilder.append(":");
                    stringBuilder.append(entry.getValue());
                    stringBuilder.append(",");
                } if (entry.getValue().startsWith("[") && entry.getValue().endsWith("]")) {
                    stringBuilder.append(":");
                    stringBuilder.append(entry.getValue());
                    stringBuilder.append(",");
                } else {
                    stringBuilder.append(":");
                    appendString(stringBuilder, entry.getValue());
                    stringBuilder.append(",");
                }
            }
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static void appendString(StringBuilder stringBuilder, String str) {
        stringBuilder.append("\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
    }
}
