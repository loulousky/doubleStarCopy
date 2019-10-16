package com.example.liuhai.homemodel.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.liuhai.base.BaseFragment

import com.example.liuhai.homemodel.R
import com.example.liuhai.homemodel.controller.LHFindListModel
import com.example.liuhai.homemodel.controller.LHFindListModelFactory
import com.example.liuhai.homemodel.databinding.FragmentLhfindListViewBinding
import com.liuhai.baselibrary.BaseAppliction

/**
 * A simple [Fragment] subclass.
 */
class LHFindListView : BaseFragment<FragmentLhfindListViewBinding>() {
    private var type: String? = null
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
        type=arguments?.getString("type")
        binding.data=viewModel
        binding.lifecycleOwner=this

    }


    override fun getContentViewId(): Int {
        return R.layout.fragment_lhfind_list_view
    }


}
