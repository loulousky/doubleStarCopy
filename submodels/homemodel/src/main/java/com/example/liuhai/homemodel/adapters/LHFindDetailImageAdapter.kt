package com.example.liuhai.homemodel.adapters

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.liuhai.homemodel.R
import com.example.liuhai.homemodel.bean.LHFindDetailBean
import kotlinx.android.synthetic.main.fragment_detail_image_item.view.*

/**
 * 作者：liuhai
 * 时间：2019/10/22:11:59
 * 邮箱：185587041@qq.com
 * 说明：
 */
class LHFindDetailImageAdapter(layoutResId:Int, data:List<String>, var fragment: Fragment):
    BaseQuickAdapter<String, BaseViewHolder>(layoutResId,data) {
    override fun convert(helper: BaseViewHolder, item: String?) {
        val image=helper.itemView.findViewById<ImageView>(R.id.imageView6)
    }
}