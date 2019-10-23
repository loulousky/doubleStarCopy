package com.example.liuhai.homemodel.adapters

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.liuhai.homemodel.bean.LHFindDetailBean
import com.example.liuhai.homemodel.bean.LHUserMessage
import com.example.liuhai.homemodel.databinding.FragmentDetailMessageItemBinding

/**
 * 作者：liuhai
 * 时间：2019/10/22:12:17
 * 邮箱：185587041@qq.com
 * 说明：
 */
class LHFindDeatailMessageAdapter(layoutResId:Int, data:List<LHUserMessage>, var fragment: Fragment):
    BaseQuickAdapter<LHUserMessage, BaseViewHolder>(layoutResId,data) {

//    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
//        return mLayoutInflater.inflate(layoutResId, null)
//    }

    override fun convert(helper: BaseViewHolder, item: LHUserMessage?) {
     val binding=  DataBindingUtil.bind<FragmentDetailMessageItemBinding>(helper.itemView).apply {
         this?.lifecycleOwner=fragment
         this?.data=item
     }
    }
}