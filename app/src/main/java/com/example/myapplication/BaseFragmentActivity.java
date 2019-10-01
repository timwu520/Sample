package com.example.myapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class BaseFragmentActivity extends FragmentActivity {

    private Toolbar mToolbar;
    private TextView mToolbarTitle;

    protected void switchFragment(Fragment fragment) {
        switchFragment(fragment, null);
    }

    protected void switchFragment(Fragment fragment, Bundle bundle) {
        if (null == fragment) {
            return;
        }

        if (null != bundle) {
            fragment.setArguments(bundle);
        }

        try {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(getFragmentHost().getId(), fragment);
            fragmentTransaction.setTransition(getFragmentTransition());
            fragmentTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void setToolbarTitle(@StringRes int resource) {
        if (null != mToolbarTitle) {
            try {
                mToolbarTitle.setText(resource);
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    protected int getLayout(){
        return 0;
    }

    protected int getFragmentTransition() {
        return FragmentTransaction.TRANSIT_FRAGMENT_FADE;
    }

    protected FrameLayout getFragmentHost() {
        return findViewById(R.id.view_frame);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initUI();
    }

    private void initUI() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbarTitle = findViewById(R.id.toolbar_title);
    }
}
