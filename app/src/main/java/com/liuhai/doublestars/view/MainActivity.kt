package com.liuhai.doublestars.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.liuhai.statusbar.StatusBarUtils
import com.liuhai.doublestars.R
import com.liuhai.logger.LoggerManager

class MainActivity : AppCompatActivity() {

    //主页面navgiation的容器activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBarUtils.setStatusbarWithLightorDark(this,false)

    }





}
