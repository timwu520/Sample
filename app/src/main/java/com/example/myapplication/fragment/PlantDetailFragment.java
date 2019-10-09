package com.example.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.Plant;
import com.example.myapplication.util.BundleKey;

public class PlantDetailFragment extends BaseFragment {

    private ImageView mImgIcon;
    private TextView mChinesName;
    private TextView mEnglishName;
    private TextView mAlsoName;
    private TextView mInfo;
    private TextView mIdentificationMethod;
    private TextView mTextFeature;

    private Plant mPlant;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findExtra();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        initData();
    }

    @Override
    public void UpdateUi(int updateUiReason, Object data) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_plant_detail;
    }

    private void initUI() {
        mImgIcon = mMainLayout.findViewById(R.id.img_icon);
        mChinesName = mMainLayout.findViewById(R.id.text_chines_name);
        mEnglishName = mMainLayout.findViewById(R.id.text_english_name);
        mAlsoName = mMainLayout.findViewById(R.id.text_also_name);
        mInfo = mMainLayout.findViewById(R.id.text_info);
        mIdentificationMethod = mMainLayout.findViewById(R.id.text_identification_method);
        mTextFeature = mMainLayout.findViewById(R.id.text_feature);
    }

    private void findExtra() {
        Bundle bundle = getArguments();
        if (null != bundle) {
            mPlant = (Plant) bundle.getSerializable(BundleKey.KEY_PLANT_DATA);
        }
    }

    private void initData() {
        if (null != mPlant) {
            String chineseName = mPlant.getChineseName();

            showPageTitle(chineseName);
            String picUrl = mPlant.getPicUrl();
            String englishName = mPlant.getEnglishName();
            String alsoKnown = mPlant.getAlsoKnown();
            String brief = mPlant.getBrief();
            String feature = mPlant.getFeature();
            String function = mPlant.getFunction();

            showImage(picUrl);
            showChineseName(chineseName);
            showEnglishName(englishName);
            showAlsoName(alsoKnown);
            showInfo(brief);
            showIdentificationMethod(feature);
            showExtraInfo(function);
        }
    }

    private void showImage(String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(getActivity()).load(url).placeholder(R.drawable.ic_launcher_foreground).into(mImgIcon);
        }
    }

    private void showChineseName(String name) {
        if (null != mChinesName) {
            mChinesName.setText(name);
        }
    }

    private void showEnglishName(String englishName) {
        if (null != mEnglishName) {
            mEnglishName.setText(englishName);
        }
    }

    private void showAlsoName(String name) {
        if (null != mAlsoName) {
            mAlsoName.setText(name);
        }
    }

    private void showInfo(String info) {
        if (null != mInfo) {
            mInfo.setText(info);
        }
    }

    private void showIdentificationMethod(String method) {
        if (null != mIdentificationMethod) {
            mIdentificationMethod.setText(method);
        }
    }

    private void showExtraInfo(String info) {
        if (null != mTextFeature) {
            mTextFeature.setText(info);
        }
    }

}
