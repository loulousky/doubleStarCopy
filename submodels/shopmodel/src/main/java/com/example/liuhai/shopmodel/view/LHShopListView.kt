package com.example.liuhai.shopmodel.view


import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.liuhai.base.BaseFragment

import com.example.liuhai.shopmodel.R
import com.example.liuhai.shopmodel.adapters.LHGoodAdapter
import com.example.liuhai.shopmodel.beans.LHGood
import com.example.liuhai.shopmodel.controller.LHShopModel
import com.example.liuhai.shopmodel.databinding.FragmentLhshopListViewBinding

/**
 * A simple [Fragment] subclass.
 * 商品列表
 */
class LHShopListView : BaseFragment<FragmentLhshopListViewBinding>() {
    private val shops=ArrayList<LHGood>()
    private val models:LHShopModel by lazy {
        ViewModelProviders.of(this).get(LHShopModel::class.java)

    }
   private lateinit var headView:View
    override fun bindToViewModel() {
       binding.lifecycleOwner=this
        val adapter=LHGoodAdapter(R.layout.shop_item,shops)
        binding.recyclview.layoutManager=GridLayoutManager(context,2)
        binding.recyclview.adapter=adapter
        adapter.setHeaderView(headViewload())
        adapter.setEnableLoadMore(true)
        adapter.setOnLoadMoreListener({
            models.nextPage()
            adapter.loadMoreComplete()
        },binding.recyclview)
        binding.swiper.setOnRefreshListener {
            shops.clear()
            models.loadData()
            binding.swiper.isRefreshing=false
        }
        models.goodlist.observe(this, Observer {
            val pre=shops.size-1;
            shops.addAll(it)
            adapter.notifyItemRangeInserted(pre,it.size)

        })
        //不满一页的时候出现加载更多解决
        adapter.disableLoadMoreIfNotFullPage()
        models.loadData()
    }

    override fun getContentViewId(): Int {
        return R.layout.fragment_lhshop_list_view
    }

    /**
     * 加载Rv的头部VIEW
     */
    private fun headViewload():View{
        headView=View.inflate(context,R.layout.shop_head,null)
        return  headView

    }


}
