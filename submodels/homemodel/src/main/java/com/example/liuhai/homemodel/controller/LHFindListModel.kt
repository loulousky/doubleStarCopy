package com.example.liuhai.homemodel.controller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * 作者：liuhai
 * 时间：2019/10/15:14:35
 * 邮箱：185587041@qq.com
 * 说明：列表页的
 * type返回列表的数据分类
 */
class LHFindListModel(val type: String, application: Application) : AndroidViewModel(application) {












    interface LHView<T : Any> {
        //加载数据
        fun loadData(): List<T>

        //刷新数据
        fun refushData(): List<T>

        //添加新数据
        fun moreData(): List<T>

    }


}