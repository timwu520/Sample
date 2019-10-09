package com.example.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.viewholder.PlantListViewHolder;
import com.example.myapplication.data.Plant;
import com.example.myapplication.util.OnItemClickListener;

public class PlantListAdapter extends BaseRecyclerViewAdapter<Plant> {

    private OnItemClickListener mOnItemClickListener;

    public PlantListAdapter(OnItemClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_plant_list, viewGroup, false);
        return new PlantListViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof PlantListViewHolder){
            PlantListViewHolder listViewHolder = (PlantListViewHolder) viewHolder;
            listViewHolder.bindView(getData(i));
        }
    }
}
