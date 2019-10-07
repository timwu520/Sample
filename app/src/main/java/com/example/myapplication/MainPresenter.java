package com.example.myapplication;

import android.util.Log;

import com.example.myapplication.data.PrivalionResponse;

public class MainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    public MainPresenter() {

    }

    public void getPrivalionInfo(){
        ApiManager.getInstance().sendData(ApiManager.ServiceCode.GET_PAVILION_INFORMATION, null, mOnResponseListener);
    }


    private final ApiManager.OnResponseListener mOnResponseListener = new ApiManager.OnResponseListener() {
        @Override
        public void onResponse(Object object) {
            if (object instanceof PrivalionResponse){
                PrivalionResponse response = (PrivalionResponse)object;
                Log.d(TAG, "PrivalionResponse:" + response.getResult().getSort());
            }
        }
    };
}
