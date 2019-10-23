package com.example.liuhai.homemodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.liuhai.homemodel.R
import com.example.liuhai.statusbar.StatusBarUtils

class LHFindDeataileContainer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lhfind_deataile_container)
        StatusBarUtils.setStatusbarWithLightorDark(this,false)
    }
}
