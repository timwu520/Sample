package com.example.myapplication.presenter;

import android.util.Log;

import com.example.myapplication.api.ApiManager;
import com.example.myapplication.data.PlantData;
import com.example.myapplication.data.PlantResponse;
import com.example.myapplication.util.IUpdateUi;
import com.example.myapplication.util.UpdateUiReason;
import com.example.myapplication.data.PavilionData;

public class DetailPresenter extends BasePresenter {

    private static final String TAG = DetailPresenter.class.getSimpleName();

    public DetailPresenter(IUpdateUi updateUi) {
        super(updateUi);
    }

    public void getBundleData(PavilionData data) {
        if (null != data) {
            UpdateUi(UpdateUiReason.SHOW_DETAIL_INFO, data);

            String name = data.getName();
            ApiManager.getInstance().sendData(ApiManager.ServiceCode.GET_PLANT_INFORMATION, name, mOnResponseListener);
        }
    }

    private final ApiManager.OnResponseListener mOnResponseListener = new ApiManager.OnResponseListener() {
        @Override
        public void onResponse(Object object) {
            if (object instanceof PlantResponse) {
                PlantResponse response = (PlantResponse) object;

                PlantData result = response.getResult();
                if (null != result) {
                    UpdateUi(UpdateUiReason.SHOW_PLANT_LIST, result.getResults());
                }
            }
        }
    };
}
