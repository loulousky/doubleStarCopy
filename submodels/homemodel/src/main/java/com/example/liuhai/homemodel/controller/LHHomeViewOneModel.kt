package com.example.liuhai.homemodel.controller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.liuhai.homemodel.R

/**
 * 作者：liuhai
 * 时间：2019/10/15:11:08
 * 邮箱：185587041@qq.com
 * 说明：心心fragment的viewmodel
 */
class LHHomeViewOneModel(application: Application):AndroidViewModel(application) {



    /**
     * 返回四个tab的名称
     */
    fun getHomeTabTitle(): Array<String> {
        return arrayOf(
            getApplication<Application>().getString(R.string.home_rec),
            getApplication<Application>().getString(R.string.home_hot),
            getApplication<Application>().getString(R.string.home_new)
        )
    }





}