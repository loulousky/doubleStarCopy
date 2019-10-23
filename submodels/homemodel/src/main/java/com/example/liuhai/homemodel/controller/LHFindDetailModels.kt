package com.example.liuhai.homemodel.controller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.liuhai.homemodel.bean.LHFindBean
import com.example.liuhai.homemodel.bean.LHFindDetailBean
import com.example.liuhai.homemodel.bean.LHUserMessage

/**
 * 作者：liuhai
 * 时间：2019/10/22:11:08
 * 邮箱：185587041@qq.com
 * 说明：
 */
class LHFindDetailModels(application: Application):AndroidViewModel(application) {

    /**
     * 页码
     */
   private var page:MutableLiveData<Int>? = null
        get() {
            if(field==null){

                field= MutableLiveData(-1)
            }
            return  field
        }


    /**
     * 通过监听页数变化，返回数据
     */
    val findDetailList:MediatorLiveData<MutableList<LHFindDetailBean>> = MediatorLiveData<MutableList<LHFindDetailBean>>().apply {
        addSource(page!!, Observer {
            this.value=loadDataWithPage(it)
        })
    }


    /**
     * 下一页
     * 页数加一通知数据更新一页并添加到当前的列表中
     * 页面中只要监听了list数据更新reclview即可
     */
    fun nextPage() {
        page?.postValue(page?.value!!+1)
    }
    /**
     * 第一次加载。或者下拉刷新的加载
     */
    fun loadList(){
        page?.value=0

    }



    /**
     * 加载下一页
     */
    private fun loadDataWithPage(page:Int):MutableList<LHFindDetailBean>{
        val data:MutableList<LHFindDetailBean> =ArrayList<LHFindDetailBean>()
        for ( i in 0..19){
            data.add(LHFindDetailBean("","mylover", arrayListOf("1","2","3"),"${i}详细描述啊啊啊啊啊啊啊",0,0,0,
                arrayListOf(LHUserMessage("","${i}hahah","${i}adasdas","2019-05-24"),LHUserMessage("","${i}hahah","${i}adasdas","2019-05-24"),LHUserMessage("","${i}hahah","${i}adasdas","2019-05-24"))))
        }
        return data
    }


}