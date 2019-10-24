package com.example.liuhai.homemodel.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.jzvd.Jzvd
import cn.jzvd.JzvdStd
import com.example.liuhai.homemodel.R
import com.example.liuhai.statusbar.StatusBarUtils

/**
 * 视频列表的容器VIEW
 */
class LHFindDetaileVideoContainer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtils.setStatusBarColor(this, Color.parseColor("#000000"))
        setContentView(R.layout.activity_lhfind_detaile_video_container)
    }

    override fun onBackPressed() {
        if (JzvdStd.backPress()) {
            return
        }
        super.onBackPressed();
    }

    override fun onResume() {
        super.onResume()
        Jzvd.releaseAllVideos();
    }
}
