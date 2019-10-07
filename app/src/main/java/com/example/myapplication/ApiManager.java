package com.example.myapplication;

import android.util.Log;

import com.example.myapplication.data.PrivalionResponse;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ApiManager {

    private static final String TAG = ApiManager.class.getSimpleName();
    private static final ApiManager ourInstance = new ApiManager();

    public static class ServiceCode {
        public static final int GET_PAVILION_INFORMATION = 0;
    }

    public static ApiManager getInstance() {
        return ourInstance;
    }

    private ApiManager() {

    }

    public void sendData(int serviceCode, Object object, OnResponseListener onResponseListener) {
        switch (serviceCode){
            case ServiceCode.GET_PAVILION_INFORMATION:
                sendGetPavilionInformation(onResponseListener);
                break;
                default:
                    Log.w(TAG, "Unknown ServiceCode");
                    break;
        }
    }

    private void sendGetPavilionInformation(final OnResponseListener onResponseListener){
        ApiRequest request = new ApiRequest();
        request.setUrl(ApiUrl.GET_PAVILION_INFORMATION);
        request.setCallBack(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //do nothing here.
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = response.body().string();
                Log.i(TAG, result);
                Gson gson = new Gson();
                PrivalionResponse privalionResponse = gson.fromJson(result, PrivalionResponse.class);
                onResponseListener.onResponse(privalionResponse);
            }
        });
        request.excute();
    }


    public interface OnResponseListener{
        void onResponse(Object object);
    }
}
