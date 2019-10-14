package com.example.liuhai.statusbar

import android.app.Activity
import qiu.niorgai.StatusBarCompat
import qiu.niorgai.StatusBarCompat.*
import java.io.NotActiveException

/**
 * 作者：liuhai
 * 时间：2019/10/14:15:01
 * 邮箱：185587041@qq.com
 * 说明：APP状态栏工具类继承

//设置状态栏的颜色
StatusBarCompat.setStatusBarColor(Activity activity, int color)
//添加alpha值
StatusBarCompat.setStatusBarColor(Activity activity, int statusColor, int alpha)

//透明状态栏
StatusBarCompat.translucentStatusBar(activity);
//SDK >= 21时, 取消状态栏的阴影
StatusBarCompat.translucentStatusBar(Activity activity, boolean hideStatusBarBackground);

//为 CollapsingToolbarLayout 设置颜色
setStatusBarColorForCollapsingToolbar(Activity activity, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, int statusColor)

//SDK >= 23, 将状态栏改为浅色模式(状态栏 icon 和字体会变成深色)
changeToLightStatusBar(Activity activity)

//将状态栏改为深色模式(状态栏 icon 和字体会变成浅色, 即默认模式)
cancelLightStatusBar(Activity activity)
在 setContentView 方法调用后再设置.
如果要使用全屏 Activity , 调用 StatusBarCompat.translucentStatusBar(activity) .
如果想让状态栏图标变成深色, 记得最后调用 changeToLightStatusBar(activity) .
 */
object StatusBarUtils {


    /**
     * 设置状态栏的颜色
     */
    fun setStatusBarColor(activity: Activity?,color:Int){
        activity?.let {
            StatusBarCompat.setStatusBarColor( activity,  color)
        }
    }

    /**
     * 颜色和透明度
     */
    fun setStatusBarColorWithAlpha(activity: Activity?,color:Int,alpha:Int){
        activity?.let {
            StatusBarCompat.setStatusBarColor( activity,  color,alpha)
        }
    }

    /**
     * 透明状态栏
     *
     */

    fun setStatusBarTranslucentStatusBart(activity: Activity?,hideStatusBarBackground:Boolean){
        activity?.let {
            StatusBarCompat.translucentStatusBar( activity,  hideStatusBarBackground)
        }

    }

    /**
     * 透明状态栏
     */
    fun setStatusBarTranslucent(activity: Activity?){
        activity?.let {
            StatusBarCompat.translucentStatusBar( activity)
        }

    }

    /**
     * light statusbar
     * 浅色模式
     */
    fun setStatusbarWithLightorDark(activity: Activity?,isdark:Boolean){

//SDK >= 23, 将状态栏改为浅色模式(状态栏 icon 和字体会变成深色)
        activity?.let {
            if(isdark){
                cancelLightStatusBar( activity)
            }else {
                changeToLightStatusBar(activity)
            }
        }



    }

}