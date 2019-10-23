package com.example.liuhai.homemodel.adapters

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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
class LHFindListAdapter( layoutResId:Int, data:List<LHFindBean>,val fragment:Fragment ) :BaseQuickAdapter<LHFindBean,BaseViewHolder>(layoutResId,data){
    override fun convert(helper: BaseViewHolder, item: LHFindBean?) {
        val binding:FindItemBinding=DataBindingUtil.bind<FindItemBinding>(helper.itemView)!!
        binding.lifecycleOwner=fragment
        binding.data=item
    }

}