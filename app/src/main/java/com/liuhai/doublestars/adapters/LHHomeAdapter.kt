package com.liuhai.doublestars.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.liuhai.authenticatemodel.view.LHAuthenticateView
import com.example.liuhai.homemodel.view.LHHomeVIEWOne
import com.example.liuhai.shopmodel.view.LHShopListView
import com.example.liuhai.usermodel.LHUserView
import com.liuhai.doublestars.view.LHHomeView
import java.lang.Exception

/**
 * 作者：liuhai
 * 时间：2019/10/15:9:26
 * 邮箱：185587041@qq.com
 * 说明：首页fragment的适配器配合viewpager2
 */
class LHHomeAdapter(fragment:Fragment) :FragmentStateAdapter(fragment) {

  private  val pages= listOf(LHHomeVIEWOne(), LHShopListView(), LHAuthenticateView(), LHUserView())

    override fun getItemCount(): Int {

       return pages.size
    }

    override fun createFragment(position: Int): Fragment {
        return pages[position]?:throw Exception("主页的适配器必须要有数据")
    }
}