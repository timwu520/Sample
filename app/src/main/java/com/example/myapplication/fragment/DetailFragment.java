package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.adapter.PlantListAdapter;
import com.example.myapplication.data.PavilionData;
import com.example.myapplication.data.Plant;
import com.example.myapplication.presenter.DetailPresenter;
import com.example.myapplication.util.BundleKey;
import com.example.myapplication.util.OnItemClickListener;
import com.example.myapplication.util.UpdateUiReason;

import java.util.List;

public class DetailFragment extends BaseFragment<DetailPresenter> {

    private static final String TAG = DetailFragment.class.getSimpleName();

    private ImageView mImgPlant;
    private TextView mTextContent;
    private TextView mTextMemo;
    private RecyclerView mRecyclerView;
    private PlantListAdapter mPlantListAdapter;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter(new DetailPresenter(this));
        initUI();
        findExtra();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_detail;
    }

    private void initUI() {
        mImgPlant = mMainLayout.findViewById(R.id.img_plant);
        mTextContent = mMainLayout.findViewById(R.id.text_content);
        mTextMemo = mMainLayout.findViewById(R.id.text_memo);

        mPlantListAdapter = new PlantListAdapter(mOnItemClickListener);
        mRecyclerView = mMainLayout.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mPlantListAdapter);

    }

    @Override
    public void UpdateUi(int updateUiReason, Object data) {
        switch (updateUiReason) {
            case UpdateUiReason.SHOW_DETAIL_INFO:
                showPavilionInfo((PavilionData) data);
                break;
            case UpdateUiReason.SHOW_PLANT_LIST:
                showPlantList((List<Plant>) data);
                break;
        }
    }

    private void showPavilionInfo(PavilionData data) {
        if (null != data) {
            String picURL = data.getPicURL();
            String info = data.getInfo();
            String memo = data.getMemo();

            showImage(picURL);
            showContent(info);
            showMemo(memo);
        }
    }

    private void showPlantList(final List<Plant> list) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPlantListAdapter.setData(list);
            }
        });
    }

    private void findExtra() {
        Bundle arguments = getArguments();
        if (null != arguments) {
            PavilionData data = (PavilionData) arguments.getSerializable(BundleKey.KEY_PAVILION_DATA);
            getPresenter().getBundleData(data);
        }
    }

    private void showImage(String url) {
        if (null != mImgPlant) {
            if (!TextUtils.isEmpty(url)) {
                Glide.with(getActivity()).load(url).placeholder(R.drawable.ic_launcher_foreground).into(mImgPlant);
            }
        }
    }

    private void showContent(String content) {
        if (null != mTextContent) {
            if (!TextUtils.isEmpty(content)) {
                mTextContent.setText(content);
            }
        }
    }

    private void showMemo(String memo) {
        if (null != mTextMemo) {
            if (!TextUtils.isEmpty(memo)) {
                mTextMemo.setText(memo);
            }
        }
    }

    private final OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(Object object) {

        }
    };
}
