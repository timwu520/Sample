package com.example.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.adapter.viewholder.StoreListViewHolder;
import com.example.myapplication.util.OnItemClickListener;
import com.example.myapplication.R;
import com.example.myapplication.data.PavilionData;

public class StoreListAdapter extends BaseRecyclerViewAdapter<PavilionData> {

    private OnItemClickListener mOnItemClickListener;

    public StoreListAdapter(OnItemClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_store_list, viewGroup, false);
        return new StoreListViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof StoreListViewHolder){
            StoreListViewHolder listViewHolder = (StoreListViewHolder) viewHolder;
            listViewHolder.bindView(getData(i));
        }
    }
}
