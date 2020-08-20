package com.example.myapplication.presenter;

import android.util.Log;

import com.example.myapplication.api.ApiManager;
import com.example.myapplication.data.PavilionResponse;
import com.example.myapplication.util.IUpdateUi;
import com.example.myapplication.util.UpdateUiReason;

public class MainPresenter extends BasePresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    public MainPresenter(IUpdateUi updateUi) {
        super(updateUi);
    }

    public void getPavilionInfo() {
        ApiManager.getInstance().sendData(ApiManager.ServiceCode.GET_PAVILION_INFORMATION, null, mOnResponseListener);
    }

    private final ApiManager.OnResponseListener mOnResponseListener = new ApiManager.OnResponseListener() {
        @Override
        public void onResponse(Object object) {
            Log.d(TAG, "PavilionResponse:" + object);
            if (object instanceof PavilionResponse) {
                PavilionResponse response = (PavilionResponse) object;
                UpdateUi(UpdateUiReason.SHOW_HOME_DATA, response);
            }
        }
    };
}
