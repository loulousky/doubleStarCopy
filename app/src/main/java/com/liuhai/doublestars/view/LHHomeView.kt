package com.liuhai.doublestars.view


import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.liuhai.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

import com.liuhai.doublestars.R
import com.liuhai.doublestars.adapters.LHHomeAdapter
import com.liuhai.doublestars.databinding.FragmentLhhomeViewBinding
import com.liuhai.doublestars.controller.LHHomeViewModels

/**
 * 主页面tabFragment
 */
class LHHomeView: BaseFragment<FragmentLhhomeViewBinding>() {
   private  val viewmodel:LHHomeViewModels by lazy {
        ViewModelProviders.of(this).get(LHHomeViewModels::class.java)
    }

    override fun bindToViewModel() {
        binding.lifecycleOwner=this
        binding.data=viewmodel
        binding.homeViewpager.adapter=LHHomeAdapter(this)
        binding.homeViewpager.isUserInputEnabled=false

        binding.test.setOnClickListener {

            Navigation.findNavController(view!!).navigate(R.id.action_LHHomeView_to_LHFindListView)
        }
        TabLayoutMediator(binding.tablayout,binding.homeViewpager){tab, position ->

            tab.setIcon(viewmodel.getHomeIcon()[position])
            tab.text = viewmodel.getHomeTabTitle()[position]
        }.attach()

    }

    override fun getContentViewId(): Int {
        return R.layout.fragment_lhhome_view
    }






}
