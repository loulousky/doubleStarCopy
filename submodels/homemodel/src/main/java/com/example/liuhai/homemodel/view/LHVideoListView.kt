package com.example.liuhai.homemodel.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.jzvd.JzvdStd
import com.example.liuhai.base.BaseFragment

import com.example.liuhai.homemodel.R
import com.example.liuhai.homemodel.databinding.FragmentLhvideoListViewBinding

/**
 * A simple [Fragment] subclass.
 */
class LHVideoListView : BaseFragment<FragmentLhvideoListViewBinding>() {
    override fun bindToViewModel() {
        //绑定对应的VIEWMODEL
    }

    override fun getContentViewId(): Int {
     return   R.layout.fragment_lhvideo_list_view
    }


    //处理控件
    override fun letsDoThings() {
        super.letsDoThings()


        binding.jzvideo.fullscreenButton.visibility=View.GONE
        binding.jzvideo.titleTextView.visibility=View.GONE

        binding.jzvideo.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
            , "饺子闭眼睛")
        //自动播放
        binding.jzvideo.startVideo()

    //    binding.jzvideo.thumbImageView.setImageURI("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");

    }

    override fun onPause() {
        super.onPause()
        JzvdStd.goOnPlayOnPause()

    }

    override fun onResume() {
        super.onResume()
        JzvdStd.goOnPlayOnResume()

    }

}
