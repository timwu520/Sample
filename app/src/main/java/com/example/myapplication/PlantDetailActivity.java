package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.myapplication.data.Plant;
import com.example.myapplication.fragment.PlantDetailFragment;
import com.example.myapplication.util.BundleKey;

public class PlantDetailActivity extends BaseFragmentActivity {

    public static void start(Context context, Plant data) {
        Intent intent = new Intent(context, PlantDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleKey.KEY_PLANT_DATA, data);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switchFragment(new PlantDetailFragment(), getBundle());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_pavilion_detail;
    }

    private Bundle getBundle() {
        return getIntent().getExtras();
    }
}
