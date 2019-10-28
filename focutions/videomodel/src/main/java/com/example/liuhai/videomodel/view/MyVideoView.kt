package com.example.liuhai.videomodel.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import cn.jzvd.Jzvd
import cn.jzvd.JzvdStd
import com.example.liuhai.videomodel.R

/**
 * 作者：liuhai
 * 时间：2019/10/24:15:52
 * 邮箱：185587041@qq.com
 * 说明：自定义饺子播放器
 */
class MyVideoView : JzvdStd {

    lateinit var desc: TextView
    lateinit var headIcon: ImageView
    lateinit var userIcon: ImageView
    lateinit var functions:RelativeLayout
    lateinit var bottom2:LinearLayout
    lateinit var commentname:TextView
    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    override fun init(context: Context?) {
        super.init(context)
        //顶部的ICON
        headIcon = findViewById(R.id.headicon)
        //底部的ICON
        userIcon = findViewById(R.id.usericon)
        //视频描述
        desc = findViewById(R.id.desc)
        //分享等那一行
        functions=findViewById(R.id.functions)
        //评论
        bottom2=findViewById(R.id.layout_bottom2)
        //给谁评论
        commentname=findViewById(R.id.commentname)


    }


    override fun dissmissControlView() {
        // super.dissmissControlView()
        if (state != Jzvd.STATE_NORMAL
            && state != Jzvd.STATE_ERROR
            && state != Jzvd.STATE_AUTO_COMPLETE
        ) {
            post {
                bottomContainer.visibility = View.INVISIBLE
                bottom2.visibility = View.VISIBLE
                desc.visibility = View.VISIBLE
                functions.visibility = View.VISIBLE
                if (clarityPopWindow != null) {
                    clarityPopWindow.dismiss()
                }
                if (screen != Jzvd.SCREEN_TINY) {
                    bottomProgressBar.visibility = View.VISIBLE
                }


            }
        }
    }

        override fun setScreenNormal() {
            super.setScreenNormal()
            backButton.visibility = View.VISIBLE
            headIcon.visibility = View.VISIBLE
            bottom2.visibility = View.VISIBLE
            desc.visibility = View.VISIBLE
            functions.visibility = View.VISIBLE


        }

        override fun onAutoCompletion() {
            super.onAutoCompletion()
            startVideo()
        }

        override fun getLayoutId(): Int {
            return R.layout.myvideo
        }


}