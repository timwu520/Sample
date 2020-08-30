package com.example.myapplication

import android.os.Bundle
import com.example.myapplication.fragment.MainFragment

class MainActivity : BaseFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        switchFragment(MainFragment.newInstance())
        setToolbarTitle(R.string.title_main)
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }
}