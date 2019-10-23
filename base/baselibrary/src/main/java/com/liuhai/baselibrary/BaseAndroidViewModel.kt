package com.liuhai.baselibrary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * 作者：liuhai
 * 时间：2019/10/22:15:57
 * 邮箱：185587041@qq.com
 * 说明：基类，定义接力的viewmodel
 */
abstract  class BaseAndroidViewModel(appliction: Application):AndroidViewModel(appliction) {

    //首页TAB 监听这话来控制TAB
  var tabIndex:MutableLiveData<Int> =MutableLiveData(0)




}