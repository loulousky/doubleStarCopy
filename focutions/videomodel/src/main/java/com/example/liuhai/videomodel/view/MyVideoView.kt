package com.example.liuhai.videomodel.view

import android.content.Context
import android.util.AttributeSet
import cn.jzvd.JzvdStd
import com.example.liuhai.videomodel.R

/**
 * 作者：liuhai
 * 时间：2019/10/24:15:52
 * 邮箱：185587041@qq.com
 * 说明：自定义饺子播放器
 */
class MyVideoView :JzvdStd{
    constructor(context:Context): super(context){
    }

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet){

    }

    override fun onAutoCompletion() {
        super.onAutoCompletion()
        startVideo()
    }

    override fun getLayoutId(): Int {
        return R.layout.myvideo
    }



}