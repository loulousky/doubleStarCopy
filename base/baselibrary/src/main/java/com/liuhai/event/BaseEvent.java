package com.liuhai.event;

/**
 * 作者：liuhai
 * 时间：2019/10/22:17:44
 * 邮箱：185587041@qq.com
 * 说明：Rxbus baseEvent
 */
public class BaseEvent<T> {
    private  T aa;
    public BaseEvent(T a){
        this.aa=a;
    }


    public T getAa() {
        return aa;
    }

    public void setAa(T aa) {
        this.aa = aa;
    }
}
