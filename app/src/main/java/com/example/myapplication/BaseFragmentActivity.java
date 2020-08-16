package com.example.myapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseFragmentActivity extends FragmentActivity {

    private Toolbar mToolbar;
    private TextView mToolbarTitle;

    public void setToolbarTitle(String title) {
        if (null != mToolbarTitle) {
            mToolbarTitle.setText(title);
        }
    }

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

    protected int getLayout() {
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
