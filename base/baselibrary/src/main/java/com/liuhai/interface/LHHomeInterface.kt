package com.liuhai.`interface`

import android.view.View
import com.liuhai.event.BaseEvent

/**
 * 作者：liuhai
 * 时间：2019/10/22:15:59
 * 邮箱：185587041@qq.com
 * 说明：主APP的VIEWmodel 要实现这个接口，里面包含这个模块的列表的点击事件，与APP模块进行沟通的一个途经，因为互相之间不引用，不能直接获得VIEWMODEL
 */
interface LHHomeInterface {

    //跳转到发现的详情页
    fun <T>jumpToFindDetaile(data:BaseEvent<T>)
    //跳转到发现的视频详情页
    fun  <T>jumoToFindVideoDetaile(data:BaseEvent<T>)

}