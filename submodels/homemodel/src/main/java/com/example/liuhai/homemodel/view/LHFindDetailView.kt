package com.example.liuhai.homemodel.view


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.liuhai.base.BaseFragment
import com.example.liuhai.homemodel.R
import com.example.liuhai.homemodel.adapters.LHFindDetaileAdapter
import com.example.liuhai.homemodel.bean.LHFindDetailBean
import com.example.liuhai.homemodel.controller.LHFindDetailModels
import com.example.liuhai.homemodel.databinding.FragmentLhfindDetailViewBinding
import com.example.liuhai.statusbar.StatusBarUtils


/**
 * A simple [Fragment] subclass.
 */
class LHFindDetailView : BaseFragment<FragmentLhfindDetailViewBinding>() {
    val models: LHFindDetailModels by lazy {
        ViewModelProviders.of(this).get(LHFindDetailModels::class.java)
    }

    private var datas: ArrayList<LHFindDetailBean> = ArrayList()
    override fun bindToViewModel() {


        binding.lifecycleOwner = this
        val adapter=LHFindDetaileAdapter(R.layout.find_detail_item, datas, this)
        binding.recyclerView.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter

        }
        //监听
        models.findDetailList.observe(this, Observer {
            datas.addAll(it)
        })
        models.loadList()

        binding.imageView8.setOnClickListener {

            activity?.finish()

        }


    }

    override fun getContentViewId(): Int {
        return R.layout.fragment_lhfind_detail_view
    }


    override fun onResume() {
        super.onResume()
        StatusBarUtils.setStatusBarColor(activity, Color.parseColor("#ffffff"))
        StatusBarUtils.setStatusbarWithLightorDark(activity,false)
    }

}
