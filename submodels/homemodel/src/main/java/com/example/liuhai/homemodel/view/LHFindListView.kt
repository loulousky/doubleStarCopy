package com.example.liuhai.homemodel.view


import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.liuhai.base.BaseFragment
import com.example.liuhai.event.RxBusManager

import com.example.liuhai.homemodel.R
import com.example.liuhai.homemodel.adapters.LHFindListAdapter
import com.example.liuhai.homemodel.bean.LHFindBean
import com.example.liuhai.homemodel.controller.LHFindListModel
import com.example.liuhai.homemodel.controller.LHFindListModelFactory
import com.example.liuhai.homemodel.databinding.FragmentLhfindListViewBinding
import com.liuhai.`interface`.LHHomeInterface
import com.liuhai.baselibrary.BaseAndroidViewModel
import com.liuhai.baselibrary.BaseAppliction
import com.liuhai.event.BaseEvent
import com.liuhai.logger.LoggerManager
import kotlinx.android.synthetic.main.fragment_lhfind_list_view.*

/**
 * A simple [Fragment] subclass.
 */
class LHFindListView : BaseFragment<FragmentLhfindListViewBinding>() {
    private var type: String? = null
    val datalist: ArrayList<LHFindBean>  by lazy {

        ArrayList<LHFindBean>()
    }
    private val viewModel by lazy {
        activity?.let {
            ViewModelProviders.of(this, LHFindListModelFactory(type!!, BaseAppliction.mContext))
                .get(LHFindListModel::class.java)
        }


    }

    companion object {
        fun getInstance(type: String): LHFindListView {
            val fragment = LHFindListView()
            val bundle = Bundle()
            bundle.putString("type", type)
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun bindToViewModel() {
        type = arguments?.getString("type")
        binding.data = viewModel
        binding.lifecycleOwner = this
        val layoutmananger = GridLayoutManager(context, 2)
        binding.recyclview.layoutManager = layoutmananger
        val adapter = LHFindListAdapter(R.layout.find_item, datalist, this)

        adapter.setOnItemClickListener { _, _, position ->

            if(datalist.get(position).video){
                startActivity(Intent(activity,LHFindDetaileVideoContainer::class.java))
            }else{
                startActivity(Intent(activity,LHFindDeataileContainer::class.java))
            }








        }
        binding.recyclview.adapter = adapter

        viewModel?.findlist?.observe(this, Observer {

            datalist.addAll(it)

        })



        viewModel?.loadList()

        binding.swiper.setOnRefreshListener {


            datalist.clear()
            viewModel?.loadList()

            binding.swiper.isRefreshing = false

        }



        adapter.setEnableLoadMore(true)

        adapter.setOnLoadMoreListener({

            showToast("下拉的反馈")
            Thread {
                SystemClock.sleep(2000)
                viewModel?.nextPage()

                activity?.runOnUiThread {
                    adapter.loadMoreComplete()
                }

            }.start()


        }, binding.recyclview)
        //不满一屏幕不回调加载事件
        adapter.disableLoadMoreIfNotFullPage()


    }


    override fun getContentViewId(): Int {
        return R.layout.fragment_lhfind_list_view
    }



}
