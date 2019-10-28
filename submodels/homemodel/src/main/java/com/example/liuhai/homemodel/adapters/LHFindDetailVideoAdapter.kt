package com.example.liuhai.homemodel.adapters

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import cn.jzvd.Jzvd
import cn.jzvd.JzvdStd
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.liuhai.homemodel.bean.LHFindBean
import com.example.liuhai.homemodel.bean.LHFindVideoBean
import com.example.liuhai.homemodel.databinding.FragmentLhvideoListViewBinding

/**
 * 作者：liuhai
 * 时间：2019/10/28:10:00
 * 邮箱：185587041@qq.com
 * 说明：视频adapter
 */
class LHFindDetailVideoAdapter(layoutResId:Int, data:List<LHFindVideoBean>, val fragment: Fragment) :BaseQuickAdapter<LHFindVideoBean,BaseViewHolder>(layoutResId,data){

    override fun convert(helper: BaseViewHolder, item: LHFindVideoBean?) {
        val binding=    DataBindingUtil.bind<FragmentLhvideoListViewBinding>(helper.itemView)
        binding?.let {
            //设置视频数据
            binding.lifecycleOwner=fragment

            binding.jzvideo.fullscreenButton.visibility= View.GONE
            binding.jzvideo.titleTextView.visibility= View.GONE

            binding.jzvideo.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , "视频标题${item?.videodesc}",Jzvd.SCREEN_NORMAL)
            //自动播放
            binding.jzvideo.startVideo()

        }




    }
}