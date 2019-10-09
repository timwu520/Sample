package com.example.myapplication.presenter;

import com.example.myapplication.util.IUpdateUi;

public abstract class BasePresenter {

    private IUpdateUi mIUpdateUi;

    public BasePresenter(IUpdateUi updateUi) {
        mIUpdateUi = updateUi;
    }

    protected void UpdateUi(int updateUiReason, Object object){
        if (null != mIUpdateUi) {
            mIUpdateUi.UpdateUi(updateUiReason, object);
        }
    }
}
