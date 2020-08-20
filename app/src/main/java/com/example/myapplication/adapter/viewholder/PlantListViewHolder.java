package com.example.myapplication.adapter.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.Plant;
import com.example.myapplication.util.OnItemClickListener;

public class PlantListViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = PlantListViewHolder.class.getSimpleName();

    private OnItemClickListener mOnItemClickListener;
    private ImageView mImgIcon;
    private TextView mTextName;
    private TextView mTextContent;
    private Context mContext;

    private Plant mPlant;

    public PlantListViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        mContext = itemView.getContext();
        mOnItemClickListener = onItemClickListener;
        findView();
    }

    public void findView() {
        mImgIcon = itemView.findViewById(R.id.img_icon);
        mTextContent = itemView.findViewById(R.id.text_content);
        mTextName = itemView.findViewById(R.id.text_name);
        itemView.setOnClickListener(mOnClickListener);
    }

    public void bindView(Plant plant) {
        Log.w("bindView", "bindView");
        if (null != plant) {
            mPlant = plant;
            String picUrl = plant.getPicUrl();
            String content = plant.getAlsoKnown();
            String name = plant.getChineseName();

            showImage(picUrl);
            showContent(content);
            showName(name);
        }
    }

    private void showImage(String url) {
        if (null != mImgIcon) {
            if (!TextUtils.isEmpty(url)) {
                Log.i(TAG, "url:" + url);
                Glide.with(mContext).load(url).placeholder(R.drawable.ic_launcher_foreground).into(mImgIcon);
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

    private void showName(String name) {
        if (null != mTextName) {
            if (!TextUtils.isEmpty(name)) {
                mTextName.setText(name);
            }
        }
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (null != mOnItemClickListener) {
                mOnItemClickListener.onItemClick(mPlant);
            }
        }
    };
}
