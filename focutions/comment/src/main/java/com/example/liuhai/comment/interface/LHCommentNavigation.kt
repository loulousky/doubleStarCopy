package com.example.liuhai.comment.`interface`

import com.liuhai.event.BaseEvent

/**
 * 作者：liuhai
 * 时间：2019/10/24:11:13
 * 邮箱：185587041@qq.com
 * 说明：评论的跳转实现，宿主要实现这个接口
 */
interface LHCommentNavigation {

    /**
     * 从评论列表跳转到评论
     */
    fun  <T> commentListTocomment(data:BaseEvent<T>)

}