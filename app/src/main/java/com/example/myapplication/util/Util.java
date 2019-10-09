package com.example.myapplication.util;

public class Util {

    public static String appendHttps(String url) {
        if (null != url) {
            if (url.contains("http://")) {
                String replace = url.replace("http://", "https://");
                return replace;
            }
        }
        return "";
    }
}
