package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<T> extends Fragment {

    private T mPresenter;
    protected View mMainLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        mMainLayout = view;
        return view;
    }

    protected int getLayout() {
        return 0;
    }

    protected T getPresetner() {
        return mPresenter;
    }

    protected void initPresenter(T presenter){
        mPresenter = presenter;
    }
}
