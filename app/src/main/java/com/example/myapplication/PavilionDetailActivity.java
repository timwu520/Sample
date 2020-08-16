package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.myapplication.data.PavilionData;
import com.example.myapplication.fragment.DetailFragment;
import com.example.myapplication.util.BundleKey;

public class PavilionDetailActivity extends BaseFragmentActivity {

    public static void start(Context context, PavilionData data) {
        Intent intent = new Intent(context, PavilionDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleKey.KEY_PAVILION_DATA, data);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switchFragment(new DetailFragment(), getBundle());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_pavilion_detail;
    }

    private Bundle getBundle(){
        return getIntent().getExtras();
    }
}
