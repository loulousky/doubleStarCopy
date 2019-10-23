package com.example.liuhai.homemodel.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.liuhai.comment.controller.LHCommentModels
import com.example.liuhai.homemodel.R
import com.example.liuhai.homemodel.bean.LHFindBean
import com.example.liuhai.homemodel.bean.LHFindDetailBean
import com.example.liuhai.homemodel.databinding.FindDetailItemBinding
import com.liuhai.other.BitmapUtil
import top.zibin.luban.Luban


/**
 * 作者：liuhai
 * 时间：2019/10/22:11:36
 * 邮箱：185587041@qq.com
 * 说明：
 */
class LHFindDetaileAdapter(layoutResId: Int, data: List<LHFindDetailBean>, var fragment: Fragment) :
    BaseQuickAdapter<LHFindDetailBean, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder, item: LHFindDetailBean?) {
        val binding = DataBindingUtil.bind<FindDetailItemBinding>(helper.itemView)
        binding?.lifecycleOwner = fragment
        binding?.data = item
        binding?.recyclerView?.apply {
            this.layoutManager = LinearLayoutManager(mContext).also {
                it.orientation = LinearLayoutManager.HORIZONTAL
            }

            this.adapter = LHFindDetailImageAdapter(
                R.layout.fragment_detail_image_item,
                item!!.images,
                fragment
            )
            this.setOnFlingListener(null)
            PagerSnapHelper().attachToRecyclerView(this)

        }
        binding?.recyclerView2?.let {
            it.layoutManager = LinearLayoutManager(mContext)
            it.adapter = LHFindDeatailMessageAdapter(
                com.example.liuhai.homemodel.R.layout.fragment_detail_message_item,
                item!!.messages,
                fragment
            )
        }

        binding?.textView2?.text = "查看全部${item?.messages?.size}条评论"

        binding?.textView3?.setOnClickListener {

            val bb = BitmapUtil.viewToBitmap(fragment.view)

            BitmapUtil.saveImage(mContext, bb)
            bb.recycle()



//
//

            fragment.findNavController().navigate(R.id.action_LHFindDetailView_to_LHCommentView)

        }

    }
}