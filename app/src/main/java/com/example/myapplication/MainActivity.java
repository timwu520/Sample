package com.example.myapplication;


import android.os.Bundle;

import com.example.myapplication.fragment.MainFragment;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switchFragment(MainFragment.newInstance());
        setToolbarTitle(R.string.title_main);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
