package com.liuhai.baselibrary;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.liuhai.logger.LoggerManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by yfeng on 2019/1/28.
 * 项目内部初始化
 *
 */

public abstract class BaseAppliction extends ForegroundAndBackgroundSwitchApp{
    public static Application mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        LoggerManager.Companion.getInstace().init();
        executeInOnCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }



    /**
     * 判断是否是主线程
     * @param context
     * @return
     */
    public static boolean inMainProcess(Context context) {
        String mainProcessName = context.getApplicationInfo().processName;
        String processName = getProcessName();
        return TextUtils.equals(mainProcessName, processName);
    }

    /**
     * 获取当前进程名
     */
    public static String getProcessName() {
        BufferedReader reader = null;
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
            reader = new BufferedReader(new FileReader(file));
            return reader.readLine().trim();
        } catch (IOException e) {
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     */
    private void executeInOnCreate(){
       if(inMainProcess(this)){
           executeInMainProcess();
       }
       executeInAnyProcess();
    }

    /**
     * 必须在主线程执行的内容
     */
    protected abstract void executeInMainProcess();

    /**
     * 执行跟线程无关的内容
     */
    protected abstract void executeInAnyProcess();
}
