package com.liuhai.logger

import com.liuhai.baselibrary.BuildConfig
import timber.log.Timber



/**
 * Logger管理类
 * @author liuhai
 */
class LoggerManager  private constructor(){
    companion object{
        private  val logger:LoggerManager by lazy {
            LoggerManager()
        }
        fun getInstace():LoggerManager{
            return logger
        }
    }


    fun init(){
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {

//          自定义tree实现log上传，这里没用release下pass  Timber.plant(Timber.())
        }
    }


    fun e(message:String,vararg any: Any){

        Timber.e(message,any)

    }


    fun i(message: String,vararg any: Any){

        Timber.i(message,any)
    }

    fun d(message: String,vararg any: Any){

        Timber.d(message,any)


    }

    fun v(message: String,vararg any: Any){

        Timber.v(message,any)
    }


    fun w(message: String,vararg any: Any)
    {
        Timber.w(message,any)

    }

    fun tag(tag:String){

        Timber.tag(tag)
    }
}