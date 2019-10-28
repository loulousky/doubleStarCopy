package com.example.liuhai.homemodel.controller

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.liuhai.homemodel.bean.LHFindBean
import com.example.liuhai.homemodel.bean.LHFindVideoBean
import com.liuhai.baselibrary.BaseAndroidViewModel

/**
 * 作者：liuhai
 * 时间：2019/10/28:10:02
 * 邮箱：185587041@qq.com
 * 说明：
 */
class LHFindVideoModels(application: Application) : BaseAndroidViewModel(application) {

    /**
     * 页数
     */
    private var pageNo: MutableLiveData<Int>? = null
        get() {
            if (field == null) {

                field = MutableLiveData(-1)
            }
            return field

        }

    /**
     * 数据源
     * 订阅这个
     */

    var datalist: MediatorLiveData<MutableList<LHFindVideoBean>> =
        MediatorLiveData<MutableList<LHFindVideoBean>>().apply {

            //监听页数变好，来改变数据
            addSource(pageNo!!, Observer {

                value = loadDataWithPage(it)


            })


        }


    /**
     * 下一页
     */
    fun nextPage() {
        pageNo?.postValue(pageNo?.value!! + 1)
    }

    /**
     * 第一次加载。或者下拉刷新的加载
     */
    fun loadList() {
        pageNo?.value = 0

    }

    /**
     * 加载下一页
     */
    private fun loadDataWithPage(page: Int): MutableList<LHFindVideoBean> {
        val data: MutableList<LHFindVideoBean> = ArrayList<LHFindVideoBean>()
        for (i in 0..19) {
            data.add(
                LHFindVideoBean(
                    "用户名${i}",
                    "图片URI${i}",
                    "这是视频的描述",
                    i,
                    true,
                    "http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                )
            )
        }
        return data
    }

}