package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.IUpdateUi;
import com.example.myapplication.MainPresenter;
import com.example.myapplication.R;

public class MainFragment extends BaseFragment<MainPresenter> implements IUpdateUi {

    private RecyclerView mRecyclerView;

    public static Fragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter(new MainPresenter());
        initUI();
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresetner().getPrivalionInfo();
    }

    @Override
    public void UpdateUi(int updateUiReason, Object data) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    private void initUI(){
        mRecyclerView  = mMainLayout.findViewById(R.id.recycler_view);
    }
}
