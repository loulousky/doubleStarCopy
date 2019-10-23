package com.example.liuhai.event

import com.hwangjr.rxbus.Bus
import com.hwangjr.rxbus.RxBus

/**
 * 作者：liuhai
 * 时间：2019/10/14:17:05
 * 邮箱：185587041@qq.com
 * 说明：RXbUS单例对象
 */
object  RxBusManager{


fun getInstance(): Bus {



return  RxBus.get()
}


}