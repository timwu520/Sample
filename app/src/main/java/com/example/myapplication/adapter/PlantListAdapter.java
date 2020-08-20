package com.example.myapplication.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        Log.w("onCreateViewHolder", "onCreateViewHolder");
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_plant_list, viewGroup, false);
        return new PlantListViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Log.w("onBindViewHolder", "onBindViewHolder");
        if (viewHolder instanceof PlantListViewHolder){
            PlantListViewHolder listViewHolder = (PlantListViewHolder) viewHolder;
            listViewHolder.bindView(getData(i));
        }
    }
}
