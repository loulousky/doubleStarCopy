package com.example.liuhai.homemodel.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * 作者：liuhai
 * 时间：2019/10/15:14:16
 * 邮箱：185587041@qq.com
 * 说明：第一个个栏目的三个tab
 */
class LHHomeadapters(fragment:Fragment):FragmentStateAdapter(fragment) {
    val tabs by lazy {

        arrayOf(Fragment(), Fragment(), Fragment())

    }
    override fun getItemCount(): Int {

        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {

        return tabs[position]
    }
}