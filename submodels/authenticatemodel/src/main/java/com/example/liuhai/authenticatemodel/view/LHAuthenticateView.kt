package com.example.liuhai.authenticatemodel.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.liuhai.authenticatemodel.R
import com.example.liuhai.authenticatemodel.databinding.FragmentLhauthenticateViewBinding
import com.example.liuhai.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 */
class LHAuthenticateView : BaseFragment<FragmentLhauthenticateViewBinding>() {
    override fun bindToViewModel() {
    }

    override fun getContentViewId(): Int {
        return  R.layout.fragment_lhauthenticate_view
    }


}
