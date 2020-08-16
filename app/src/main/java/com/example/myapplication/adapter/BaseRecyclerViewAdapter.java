package com.example.myapplication.adapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<Data> extends RecyclerView.Adapter {

    private List<Data> mData = new ArrayList<>();

    public void setData(List<Data> list){
        mData.clear();
        mData = list;
        notifyDataSetChanged();
    }

    public void addData(List<Data> list){
        mData.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected Data getData(int position){
        return mData.get(position);
    }
}
