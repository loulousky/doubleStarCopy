package com.liuhai.doublestars.other

import android.content.Context
import androidx.multidex.MultiDex
import com.liuhai.baselibrary.BaseAppliction
import com.liuhai.logger.LoggerManager

/**
 * 作者：liuhai
 * 时间：2019/10/15:10:28
 * 邮箱：185587041@qq.com
 * 说明：
 */
class LHApplication :BaseAppliction() {


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    /**
     * 多进程实例化
     */
    override fun executeInMainProcess() {


    }

    /**
     * 主进程实例化
     */
    override fun executeInAnyProcess() {


    }


}