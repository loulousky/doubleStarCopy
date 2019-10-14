package com.liuhai.doublestars.model
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
class LHHomeViewModels(application:Application) :AndroidViewModel(application) {





    //结束的时候调用 viewmodel的生命周期比activity和 fragment的生命周期要长
    override fun onCleared() {
        super.onCleared()
    }
}