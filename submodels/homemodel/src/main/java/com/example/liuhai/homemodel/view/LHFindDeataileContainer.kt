package com.example.liuhai.homemodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.liuhai.comment.`interface`.LHCommentNavigation
import com.example.liuhai.event.RxBusManager
import com.example.liuhai.homemodel.R
import com.example.liuhai.statusbar.StatusBarUtils
import com.hwangjr.rxbus.annotation.Subscribe
import com.hwangjr.rxbus.annotation.Tag
import com.liuhai.`interface`.LHHomeInterface
import com.liuhai.event.BaseEvent
import com.liuhai.logger.LoggerManager

class LHFindDeataileContainer : AppCompatActivity(),LHCommentNavigation{
    @Subscribe(tags = [Tag("commentListTocomment")])
    override fun <String> commentListTocomment(data: BaseEvent<String>) {
        LoggerManager.getInstace().d("是不是跳转了不知道")
        var bundle=Bundle()
        bundle.putString("imagename","temp2")
        Navigation.findNavController(this,R.id.fragment).navigate(R.id.action_LHCommentListView_to_LHCommentView,bundle)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RxBusManager.getInstance().register(this)
        setContentView(R.layout.activity_lhfind_deataile_container)
        StatusBarUtils.setStatusbarWithLightorDark(this,false)
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()

    }

    override fun onDestroy() {
        RxBusManager.getInstance().unregister(this)
        super.onDestroy()
    }
}
