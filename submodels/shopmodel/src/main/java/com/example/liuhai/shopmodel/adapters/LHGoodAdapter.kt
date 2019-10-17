package com.example.liuhai.shopmodel.adapters

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.liuhai.shopmodel.beans.LHGood
import com.example.liuhai.shopmodel.databinding.ShopItemBinding

/**
 * 作者：liuhai
 * 时间：2019/10/17:15:28
 * 邮箱：185587041@qq.com
 * 说明：商品的adapter
 */
class LHGoodAdapter(layoutResId:Int, data:List<LHGood> ) :
    BaseQuickAdapter<LHGood, BaseViewHolder>(layoutResId,data){
    override fun convert(helper: BaseViewHolder, item: LHGood?) {
        val binding=   DataBindingUtil.bind<ShopItemBinding>(helper.itemView)
        binding?.data=item
    }


}