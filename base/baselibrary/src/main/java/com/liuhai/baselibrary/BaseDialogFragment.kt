package com.liuhai.baselibrary


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 * 对话框fragment
 *
 */
class BaseDialogFragment : DialogFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(dialog!=null){
            try {
                dialog!!.setOnDismissListener(null)
                dialog!!.setOnCancelListener(null)
            }catch (e:Exception){

            }

        }


    }

}
