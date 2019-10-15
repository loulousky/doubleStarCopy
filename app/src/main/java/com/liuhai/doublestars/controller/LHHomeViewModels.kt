package com.liuhai.doublestars.controller
import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.Navigation
import com.liuhai.doublestars.R

class LHHomeViewModels(application:Application) :AndroidViewModel(application) {





    /**
     * 返回四个tab的名称
     */
    fun getHomeTabTitle(): Array<String> {
        return arrayOf(
            getApplication<Application>().getString(R.string.tabone),
            getApplication<Application>().getString(R.string.tabtwo),
            getApplication<Application>().getString(R.string.tabthree),
            getApplication<Application>().getString(R.string.tabfour)
        )
    }

    /**
     * 返回四个tab的样式
     */
    fun getHomeIcon(): Array<Int> {
        return arrayOf(R.drawable.zhuye,R.drawable.gouwu,R.drawable.sousuo,R.drawable.wode)
    }


    //结束的时候调用 viewmodel的生命周期比activity和 fragment的生命周期要长
    override fun onCleared() {
        super.onCleared()
    }
}