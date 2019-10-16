package com.example.liuhai.homemodel.controller

import android.app.Application
import androidx.lifecycle.*
import com.example.liuhai.homemodel.bean.LHFindBean

/**
 * 作者：liuhai
 * 时间：2019/10/15:14:35
 * 邮箱：185587041@qq.com
 * 说明：列表页的
 * type返回列表的数据分类
 */
class LHFindListModel(val type: String, application: Application) : AndroidViewModel(application){

    /**
     * 懒加载
     */
    private  var pageNo:MutableLiveData<Int>? = null
          get() {
            if(field==null){

                field= MutableLiveData(-1)
             }
              return field
         }

    //页面数据集合 页面只要监听这个数据集合即可
    val findlist: MediatorLiveData<MutableList<LHFindBean>> =
        MediatorLiveData<MutableList<LHFindBean>> ().apply {
            this.addSource(pageNo!!){
                if(it==0) {
                    this.value = loadDataWithPage(it)
                }else{

                    this.value?.addAll(loadDataWithPage(it))
                }
            }
        }


    /**
     * 下一页
     * 页数加一通知数据更新一页并添加到当前的列表中
     * 页面中只要监听了list数据更新reclview即可
     */
    fun nextPage() {
        pageNo?.postValue(pageNo?.value!!+1)

    }


    /**
     * 第一次加载。或者下拉刷新的加载
     */
   fun loadList(){
       pageNo?.value=0

   }


    /**
     * 加载下一页
     */
    private fun loadDataWithPage(page:Int):MutableList<LHFindBean>{
        val data:MutableList<LHFindBean> =ArrayList<LHFindBean>()
        for ( i in 0..19){
            data.add(  LHFindBean("测试账号${i}","测试描述${i}","","",false,i))
        }
        return data
   }















}

