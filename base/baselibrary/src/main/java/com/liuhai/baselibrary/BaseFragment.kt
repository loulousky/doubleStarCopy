package com.example.liuhai.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import com.liuhai.logger.LoggerManager

/**
 * 作者：liuhai
 * 时间：2019/10/14:16:18
 * 邮箱：185587041@qq.com
 * 说明：每个fragment的页面逻辑应该定义接口来实现
 */
abstract class BaseFragment<T:ViewDataBinding>:Fragment() {
    lateinit var binding:T;


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LoggerManager.getInstace().tag(this.toString())

        binding=DataBindingUtil.inflate(inflater,getContentViewId(),container,false)
        letsDoThings()
        return binding.root
    }


    /**
     * 要额外的操作可以重写这个方法来进行
     */
    fun letsDoThings(){

      }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindToViewModel()
    }

    /**
     * 显示Toast
     */
    fun  showToast(content:String?){
        content?.let {
            activity?.let {  Toast.makeText(activity?.applicationContext,content, Toast.LENGTH_SHORT).show()}

        }
    }


    /**
     * 绑定binding和viewmodel
     */
    abstract fun bindToViewModel()



    /**
     * 当前acitivity的布局layout传递
     */
    abstract  fun getContentViewId():Int



}