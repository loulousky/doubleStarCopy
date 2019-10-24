package com.example.liuhai.comment


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.liuhai.base.BaseFragment
import com.example.liuhai.comment.databinding.FragmentLhcommentListViewBinding
import com.example.liuhai.event.RxBusManager
import com.example.liuhai.statusbar.StatusBarUtils
import com.liuhai.event.BaseEvent
import com.liuhai.other.BitmapUtil
import java.io.File

/**
 * A simple [Fragment] subclass.
 */
class LHCommentListView : BaseFragment<FragmentLhcommentListViewBinding>() {
    var bb: Bitmap?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        StatusBarUtils.setStatusBarTranslucent(activity)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun bindToViewModel() {
    }

    override fun getContentViewId(): Int {
     return  R.layout.fragment_lhcomment_list_view
    }


    override fun letsDoThings() {
        super.letsDoThings()


        //设置背景图片
        binding.imageView.let {
            val path=context!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES).toString()+ File.separator+"temp"+ File.separator+"temp1.jpg"
            val bitmapOptions= BitmapFactory.Options()
            bitmapOptions.inPreferredConfig=Bitmap.Config.RGB_565
            bb= BitmapFactory.decodeFile(path,bitmapOptions)
            it.setImageBitmap(bb)
        }

        binding.constraintLayout.setOnClickListener {
            //截图报错然后跳转到评论界面
            val bb = BitmapUtil.viewToBitmap(view)
            BitmapUtil.saveImage(context, bb,"temp2")
            bb.recycle()
            RxBusManager.getInstance().post("commentListTocomment",BaseEvent("评论列表到评论"))
        }
    }

    override fun onDestroy() {
        bb?.recycle()
        bb=null
        super.onDestroy()
    }
}
