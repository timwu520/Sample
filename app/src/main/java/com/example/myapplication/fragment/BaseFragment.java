package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.myapplication.BaseFragmentActivity;
import com.example.myapplication.util.IUpdateUi;

public abstract class BaseFragment<T> extends Fragment implements IUpdateUi {

    private T mPresenter;
    protected View mMainLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        mMainLayout = view;
        return view;
    }

    @Override
    public void UpdateUi(int updateUiReason, Object data) {

    }


    protected void showPageTitle(String title) {
        FragmentActivity activity = getActivity();
        if (null != activity) {
            ((BaseFragmentActivity) activity).setToolbarTitle(title);
        }
    }

    protected int getLayout() {
        return 0;
    }

    protected T getPresenter() {
        return mPresenter;
    }

    protected void initPresenter(T presenter) {
        mPresenter = presenter;
    }
}
