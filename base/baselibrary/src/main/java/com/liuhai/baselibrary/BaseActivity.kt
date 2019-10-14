package com.example.liuhai.base

import android.database.DatabaseUtils
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.liuhai.event.RxBusManager
import com.liuhai.logger.LoggerManager

/**
 * 作者：liuhai
 * 时间：2019/10/14:15:53
 * 邮箱：185587041@qq.com
 * 说明：基类，具体的ACITIVITY的模型应该对应于每个页面的实现接口
 *
 */
abstract  class BaseActivity< T : ViewDataBinding> :AppCompatActivity(){


    lateinit var binding:T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoggerManager.getInstace().tag(this.toString())
        RxBusManager.getInstance().register(this)
        binding= DataBindingUtil.setContentView<T>(this,getContentViewId())
        binding.lifecycleOwner=this
        bindToViewModel()
        initCreate()

    }


    /**
     * 需要更多初始化的时候可重写
     */
    fun initCreate(){

    }


    /**
     * 显示Toast
     */
    fun  showToast(content:String?){
        content?.let {
            Toast.makeText(application,content,Toast.LENGTH_SHORT).show()
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

    override fun onResume() {
        super.onResume()
    }


    override fun onStop() {
        super.onStop()
    }


    override fun onDestroy() {
        RxBusManager.getInstance().unregister(this)
        super.onDestroy()


    }


}