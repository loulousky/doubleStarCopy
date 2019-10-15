package com.example.liuhai.homemodel.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.liuhai.base.BaseFragment

import com.example.liuhai.homemodel.R
import com.example.liuhai.homemodel.adapters.LHHomeadapters
import com.example.liuhai.homemodel.controller.LHHomeViewOneModel
import com.example.liuhai.homemodel.databinding.FragmentLhhomeViewOneBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * A simple [Fragment] subclass.
 */
class LHHomeVIEWOne : BaseFragment<FragmentLhhomeViewOneBinding>() {
  private  val viewmodel:LHHomeViewOneModel by lazy {
        ViewModelProviders.of(this).get(LHHomeViewOneModel::class.java)
    }
    override fun bindToViewModel() {
        binding.lifecycleOwner=this
        binding.data=viewmodel
        binding.viewpager.isUserInputEnabled=false
        binding.viewpager.adapter=LHHomeadapters(this)
        TabLayoutMediator(binding.tablayout,binding.viewpager){tab, position ->
            tab.text =viewmodel.getHomeTabTitle()[position]
        }.attach()

    }

    override fun getContentViewId(): Int {

       return R.layout.fragment_lhhome_view_one
    }

}
