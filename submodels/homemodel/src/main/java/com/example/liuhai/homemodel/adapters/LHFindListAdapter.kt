package com.example.liuhai.homemodel.adapters

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.liuhai.homemodel.bean.LHFindBean
import com.example.liuhai.homemodel.databinding.FindItemBinding

/**
 * 作者：liuhai
 * 时间：2019/10/15:16:23
 * 邮箱：185587041@qq.com
 * 说明：发现列表的adapters
 */
class LHFindListAdapter( layoutResId:Int, data:List<LHFindBean> ) :BaseQuickAdapter<LHFindBean,BaseViewHolder>(layoutResId,data){
    override fun convert(helper: BaseViewHolder, item: LHFindBean?) {
        val binding:FindItemBinding=DataBindingUtil.bind<FindItemBinding>(helper.itemView)!!
        binding.data=item
    }

}