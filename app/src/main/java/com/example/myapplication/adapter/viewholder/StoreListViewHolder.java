package com.example.myapplication.adapter.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.util.OnItemClickListener;
import com.example.myapplication.R;
import com.example.myapplication.data.PavilionData;

public class StoreListViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImgIcon;
    private Context mContext;
    private TextView mTitle;
    private TextView mTextContent;
    private TextView mMemo;
    private PavilionData mData;

    private OnItemClickListener mOnItemClickListener;

    public StoreListViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        mOnItemClickListener = onItemClickListener;
        mContext = itemView.getContext();
        findView();
    }

    public void findView() {
        mImgIcon = itemView.findViewById(R.id.img_icon);
        mTitle = itemView.findViewById(R.id.title);
        mTextContent = itemView.findViewById(R.id.text_content);
        mMemo = itemView.findViewById(R.id.text_memo);
        itemView.setOnClickListener(mOnClickListener);
    }

    public void bindView(PavilionData results) {
        mData = results;

        String name = results.getName();
        String info = results.getInfo();
        String memo = results.getMemo();

        loadImage(results);

        setTitle(name);
        setContent(info);
        mMemo.setText(memo);
    }

    private void setContent(String info) {
        if (null != mTextContent) {
            mTextContent.setText(info);
        }
    }

    private void setTitle(String name) {
        if (null != mTitle) {
            mTitle.setText(name);
        }
    }

    private void loadImage(PavilionData results) {
        if (null != mImgIcon) {
            String picURL = results.getPicURL();
            if (!TextUtils.isEmpty(picURL)) {
                Glide.with(mContext).load(picURL).placeholder(R.drawable.ic_launcher_foreground).into(mImgIcon);
            }
        }
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (null != mOnItemClickListener){
                mOnItemClickListener.onItemClick(mData);
            }
        }
    };
}
