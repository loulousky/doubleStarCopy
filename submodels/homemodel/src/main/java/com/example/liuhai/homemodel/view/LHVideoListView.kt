package com.example.liuhai.homemodel.view


import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import cn.jzvd.Jzvd
import cn.jzvd.JzvdStd
import com.example.liuhai.base.BaseFragment

import com.example.liuhai.homemodel.R
import com.example.liuhai.homemodel.adapters.LHFindDetailVideoAdapter
import com.example.liuhai.homemodel.bean.LHFindVideoBean
import com.example.liuhai.homemodel.controller.LHFindVideoModels
import com.example.liuhai.homemodel.databinding.FragmentLhvideoListBinding
import com.example.liuhai.homemodel.databinding.FragmentLhvideoListViewBinding
import com.example.liuhai.videomodel.view.MyVideoView
import com.liuhai.logger.LoggerManager
import kotlinx.android.synthetic.main.fragment_lhvideo_list_view.view.*

/**
 * A simple [Fragment] subclass.
 */
class LHVideoListView : BaseFragment<FragmentLhvideoListBinding>() {
    private lateinit var models: LHFindVideoModels
    //数据源
    private val datalist = ArrayList<LHFindVideoBean>()

    //当前的VIEW
    var currentposition=0
    override fun bindToViewModel() {
        //绑定对应的VIEWMODEL
        models = ViewModelProviders.of(this).get(LHFindVideoModels::class.java)
        binding.data = models
    }

    override fun getContentViewId(): Int {
        return R.layout.fragment_lhvideo_list
    }

    //处理控件
    override fun letsDoThings() {
        super.letsDoThings()

        binding.videolistview.apply {
            //设置viewpager
            this.layoutManager = LinearLayoutManager(context)

            this.adapter = LHFindDetailVideoAdapter(
                R.layout.fragment_lhvideo_list_view,
                datalist,
                this@LHVideoListView
            ).also {

                it.setEnableLoadMore(true)

                it.setOnLoadMoreListener({

                    showToast("下拉的反馈")
                    Thread {
                        SystemClock.sleep(2000)
                        models?.nextPage()

                        activity?.runOnUiThread {
                            it.loadMoreComplete()
                        }

                    }.start()


                }, binding.videolistview)
                //不满一屏幕不回调加载事件
                it.disableLoadMoreIfNotFullPage()


            }
            val pageSnaper = PagerSnapHelper()
            pageSnaper.attachToRecyclerView(this)

            this.addOnChildAttachStateChangeListener(object:RecyclerView.OnChildAttachStateChangeListener{
                override fun onChildViewAttachedToWindow(view: View) {
                }

                override fun onChildViewDetachedFromWindow(view: View) {
                    val jzvd=view.findViewById<MyVideoView>(R.id.jzvideo)
//                    videoView.
                    if (jzvd != null && Jzvd.CURRENT_JZVD != null &&
                        jzvd.jzDataSource.containsTheUrl(Jzvd.CURRENT_JZVD.jzDataSource.getCurrentUrl())) {
                        if (Jzvd.CURRENT_JZVD != null && Jzvd.CURRENT_JZVD.screen != Jzvd.SCREEN_FULLSCREEN) {
                            Jzvd.releaseAllVideos();
                        }
                    }

                    LoggerManager.getInstace().d("item划出")


                }



            })



            this.addOnScrollListener(object:RecyclerView.OnScrollListener(){

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                  val layoutManager=  recyclerView.layoutManager as LinearLayoutManager

                   var currentposition= layoutManager.findFirstVisibleItemPosition()

                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    when(newState){

                        RecyclerView.SCROLL_STATE_IDLE ->{
                            recyclerView.get(currentposition).findViewById<MyVideoView>(R.id.jzvideo).apply {
                                this.startVideo()

                            }

                        }

                        RecyclerView.SCROLL_STATE_DRAGGING ->{

                        }
                        RecyclerView.SCROLL_STATE_SETTLING ->{
                            JzvdStd.releaseAllVideos()
                        }

                    }
                }


            })


        }

        //页数变化来改变
        models.datalist.observe(this, Observer {

            datalist.addAll(it)

        })

        models.loadList()

    }

    override fun onPause() {
        super.onPause()
        JzvdStd.goOnPlayOnPause()

    }

    override fun onResume() {
        super.onResume()
        JzvdStd.goOnPlayOnResume()

    }

}
