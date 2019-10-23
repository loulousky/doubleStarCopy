package com.example.liuhai.homemodel.bean

/**
 * 作者：liuhai
 * 时间：2019/10/22:11:17
 * 邮箱：185587041@qq.com
 * 说明：内页数据类
 */
data class LHFindDetailBean(var icon:String,var name:String,var images:List<String>,var desc:String,var collect:Int,var message:Int,var love:Int,var messages:List<LHUserMessage>)