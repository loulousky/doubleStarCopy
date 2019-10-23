package com.example.liuhai.comment
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.getSystemServiceName
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.liuhai.base.BaseFragment
import com.example.liuhai.comment.databinding.FragmentLhcommentViewBinding
import com.example.liuhai.statusbar.StatusBarUtils
import com.liuhai.other.SoftKeyBoardListener
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.BitmapFactory
import android.os.Environment
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.ViewModelProviders
import com.example.liuhai.comment.controller.LHCommentModels
import com.liuhai.other.BitmapUtil
import top.zibin.luban.Luban
import java.io.File


/**
 * A simple [Fragment] subclass.
 */
class LHCommentView : BaseFragment<FragmentLhcommentViewBinding>() {


    val model:LHCommentModels by lazy {

        ViewModelProviders.of(this).get(LHCommentModels::class.java)
    }
    override fun bindToViewModel() {
        binding.lifecycleOwner=this

    }

    override fun getContentViewId(): Int {
        return   R.layout.fragment_lhcomment_view
    }

    override fun letsDoThings() {
        super.letsDoThings()
        StatusBarUtils.setStatusBarTranslucent(activity)

        binding.imageView.let {

            val path=context!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES).toString()+File.separator+"temp1.jpg"
            val bitmapOptions=BitmapFactory.Options()
            bitmapOptions.inPreferredConfig=Bitmap.Config.RGB_565
           val bb= BitmapFactory.decodeFile(path,bitmapOptions)
            it.setImageBitmap(bb)

        }

        SoftKeyBoardListener.setListener(activity,object :SoftKeyBoardListener.OnSoftKeyBoardChangeListener{
            override fun keyBoardShow(height: Int) {
                //键盘弹起来
             binding.bottomlayout.layoutParams=   binding.bottomlayout.layoutParams.apply {
                 this.height=height
             }


            }

            override fun keyBoardHide(height: Int) {
                //键盘消失
                binding.bottomlayout.layoutParams=   binding.bottomlayout.layoutParams.apply {
                    this.height=1
                }

            }
        })


    }

    override fun onPause() {
        hideInput()
        super.onPause()
    }
    override fun onStop() {

        super.onStop()
        //关闭软键盘



    }



    /**
     * 隐藏键盘
     */
    fun  hideInput()
    {
        val imm = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
        val v =activity?.window?.peekDecorView()
        if (null != v) {
            //强制隐藏键盘
            imm!!.hideSoftInputFromWindow(binding.textInputEditText.windowToken, 0)
            binding.bottomlayout.layoutParams=   binding.bottomlayout.layoutParams.apply {
                this.height=1
            }
        }


    }

}
