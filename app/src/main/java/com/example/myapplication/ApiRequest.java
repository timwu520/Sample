package com.example.myapplication;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ApiRequest {
    private OkHttpClient mOkHttpClient;
    private Request.Builder mRequestBuilder;
    private Request mRequest;
    private Callback mCallback;

    public ApiRequest() {
        mOkHttpClient  = new OkHttpClient();

        mRequestBuilder = new Request.Builder();
    }

    public void setUrl(String url){
        mRequest = mRequestBuilder.url(url).build();
    }

    public void setCallBack(Callback callBack){
        mCallback = callBack;
    }

    public void excute(){
        mOkHttpClient.newCall(mRequest).enqueue(mCallback);
    }
}
