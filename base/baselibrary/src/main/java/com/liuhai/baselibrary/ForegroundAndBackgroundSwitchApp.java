package com.liuhai.baselibrary;

import android.app.Application;
import android.util.Log;

import com.example.liuhai.event.RxBusManager;
import com.liuhai.event.AppFrontBackEvent;

/**
 * Created by yfeng on 2019/1/28.
 * 监听项目前后台切换
 */

public class ForegroundAndBackgroundSwitchApp extends Application {
    private static final String TAG = "ForegroundAndBackgroundSwitchApp";
    /**
     * 当前Activity个数
     */
    private int activityNumber = 0;

    AppFrontBackHelper helper;
    @Override
    public void onCreate() {
        super.onCreate();
//        registerActivityLifecycleCallbacks(callbacks);

        helper = new AppFrontBackHelper();
        helper.register(this, new AppFrontBackHelper.OnAppStatusListener() {
            @Override
            public void onFront() {
                //应用切到前台处理
                Log.i("info===","前台");
                RxBusManager.INSTANCE.getInstance().post(new AppFrontBackEvent(true));
                

            }

            @Override
            public void onBack() {
                //应用切到后台处理
                Log.i("info===","后台");
              RxBusManager.INSTANCE.getInstance().post(new AppFrontBackEvent(false));
            }
        });
    }

    public boolean isFrontground(){
        if(helper != null){
            return helper.isFrontground();
        }
        return false;
    }
}
