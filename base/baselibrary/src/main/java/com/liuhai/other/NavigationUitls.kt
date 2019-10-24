package com.liuhai.other

import java.util.concurrent.ConcurrentHashMap

/**
 * 作者：liuhai
 * 时间：2019/10/24:10:50
 * 邮箱：185587041@qq.com
 * 说明：
 */
object  NavigationUitls {



    //定义一个MAP用来存储路径的ID
    private val hashMap= ConcurrentHashMap<String,Int>(10)
    /**
     * 保存
     */
    fun putNavigationId(name:String,id:Int){
        hashMap[name]=id
    }
    /**
     * 获取
     */
    fun getNavigationId(name: String):Int?{
        return hashMap[name]
    }


}