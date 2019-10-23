package com.liuhai.doublestars.view


import android.annotation.TargetApi
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.liuhai.base.BaseFragment
import com.example.liuhai.event.RxBusManager
import com.google.android.material.tabs.TabLayoutMediator
import com.hwangjr.rxbus.annotation.Subscribe
import com.hwangjr.rxbus.annotation.Tag
import com.liuhai.`interface`.LHHomeInterface

import com.liuhai.doublestars.R
import com.liuhai.doublestars.adapters.LHHomeAdapter
import com.liuhai.doublestars.databinding.FragmentLhhomeViewBinding
import com.liuhai.doublestars.controller.LHHomeViewModels
import com.liuhai.event.BaseEvent

/**
 * 主页面tabFragment
 */
class LHHomeView: BaseFragment<FragmentLhhomeViewBinding>() {
    val aa="aaaa"
   private  val viewmodel:LHHomeViewModels by lazy {
        ViewModelProviders.of(this).get(LHHomeViewModels::class.java)
    }

    override fun bindToViewModel() {
        binding.lifecycleOwner=this
        binding.data=viewmodel
        binding.homeViewpager.offscreenPageLimit=4
        binding.homeViewpager.adapter=LHHomeAdapter(this)
        binding.homeViewpager.isUserInputEnabled=false

        TabLayoutMediator(binding.tablayout,binding.homeViewpager){tab, position ->

            tab.setIcon(viewmodel.getHomeIcon()[position])
            tab.text = viewmodel.getHomeTabTitle()[position]
        }.attach()




    }


//    @Subscribe( tags = [Tag("LHFindDetaile")])
//    override fun <String> jumpToFindDetaile(data: BaseEvent<String>) {
//        Navigation.findNavController(view!!).navigate(R.id.action_LHHomeView_to_LHFindDetailView2)
//
//
//    }
//
//    override fun <String> jumoToFindVideoDetaile(data: BaseEvent<String>) {
//    }

    override fun getContentViewId(): Int {
        return R.layout.fragment_lhhome_view
    }






}
