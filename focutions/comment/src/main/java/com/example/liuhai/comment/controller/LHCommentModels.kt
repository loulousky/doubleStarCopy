package com.example.liuhai.comment.controller

import android.app.Application
import android.graphics.Bitmap
import com.liuhai.baselibrary.BaseAndroidViewModel
import java.lang.Appendable

/**
 * 作者：liuhai
 * 时间：2019/10/23:14:53
 * 邮箱：185587041@qq.com
 * 说明：
 */
class LHCommentModels(application: Application):BaseAndroidViewModel(application) {

    var bitmap:Bitmap?=null
       set(value) {
           bitmap?.recycle()
           bitmap=value
       }
       get() = field


    override fun onCleared() {
        bitmap?.recycle()
        bitmap=null
        super.onCleared()
    }
}