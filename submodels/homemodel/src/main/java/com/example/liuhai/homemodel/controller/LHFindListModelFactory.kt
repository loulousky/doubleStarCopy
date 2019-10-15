package com.example.liuhai.homemodel.controller

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * 作者：liuhai
 * 时间：2019/10/15:15:18
 * 邮箱：185587041@qq.com
 * 说明：构造带参数的VIEWMODEL
 */
class LHFindListModelFactory(var type:String,var application:Application):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LHFindListModel(type,application ) as T
    }
}