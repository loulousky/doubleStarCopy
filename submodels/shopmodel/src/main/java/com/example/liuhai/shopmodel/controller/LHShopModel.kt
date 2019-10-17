package com.example.liuhai.shopmodel.controller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.liuhai.shopmodel.beans.LHGood

/**
 * 作者：liuhai
 * 时间：2019/10/17:14:51
 * 邮箱：185587041@qq.com
 * 说明：商品列表VIEWMODEL
 */
class LHShopModel(application: Application):AndroidViewModel(application) {

    /**
     * 页码默认为0
     */
    private var page:MutableLiveData<Int>? = null
        get() {
                if(field==null){
                    field= MutableLiveData(0)
                }

                return field

            }


    //监听数据，每次监听变化更新UI
    val goodlist:MediatorLiveData<MutableList<LHGood>> =MediatorLiveData<MutableList<LHGood>>().apply {
        addSource(page!!) {
            this.value = loadDataWithPage(it)
        }
    }


    /**
     * 首次和刷新加载调用
     */
    fun loadData(){

       page!!.postValue(0)

    }

    /**
     * 下拉刷新调用
     */
    fun nextPage(){
        page!!.postValue(page!!.value!!.plus(1))

    }


    /**
     * 根据页数获取数据
     */
    fun loadDataWithPage(page:Int):MutableList<LHGood>{
        val datas= arrayListOf<LHGood>()
        for(i in 0..20)
        {
            datas.add(LHGood("","${i}",i,"商品描述${i}"))
        }

        return datas

    }

}