package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myapplication.util.OnItemClickListener;
import com.example.myapplication.PavilionDetailActivity;
import com.example.myapplication.R;
import com.example.myapplication.util.UpdateUiReason;
import com.example.myapplication.adapter.StoreListAdapter;
import com.example.myapplication.data.PavilionData;
import com.example.myapplication.data.PavilionResponse;
import com.example.myapplication.presenter.MainPresenter;

public class MainFragment extends BaseFragment<MainPresenter> {

    private RecyclerView mRecyclerView;
    private StoreListAdapter mStoreListAdapter;

    public static Fragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter(new MainPresenter(MainFragment.this));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().getPavilionInfo();
    }

    @MainThread
    @Override
    public void UpdateUi(int updateUiReason, Object data) {
        switch (updateUiReason){
            case UpdateUiReason.SHOW_HOME_DATA:
                final PavilionResponse response = (PavilionResponse) data;
                syncData(response);
                break;
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    private void initUI(){
        mRecyclerView  = mMainLayout.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mStoreListAdapter = new StoreListAdapter(mOnItemClickListener);
        mRecyclerView.setAdapter(mStoreListAdapter);
    }

    private void syncData(final PavilionResponse response) {
        if (null != response) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (null != mStoreListAdapter) {
                        mStoreListAdapter.setData(response.getResult().getResults());
                    }
                }
            });
        }
    }

    private final OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(Object object) {
            if (!isAdded()){
                return;
            }

            if (object instanceof PavilionData){
                PavilionData data = (PavilionData) object;
                PavilionDetailActivity.start(getContext(), data);
            }
        }
    };
}
