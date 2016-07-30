package com.example.qsr.fav_deal.globle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.example.qsr.fav_deal.BuildConfig;
import com.example.qsr.fav_deal.utils.LogUtil;
import com.example.qsr.fav_deal.utils.MySPUtil;
import com.example.qsr.fav_deal.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;

/**************************************
 * FileName : com.example.qsr.fav_deal.globle
 * Author : qsr
 * Time : 2016/7/25 17:18
 * Description :
 **************************************/
public class App extends Application{
    public static Context mContext = null;
    public static Handler handler = null;
    public static Thread mainThread = null;
    public static int mainThreadId = 0;//主线程id
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        handler = new Handler();
        mainThread = Thread.currentThread();
        mainThreadId = android.os.Process.myPid();
        initUtils();
    }

    /**
     * 各种工具类的初始化
     */
    private void initUtils() {
        EventBus eventBus=EventBus.builder().throwSubscriberException(BuildConfig.DEBUG).build();
        //初始化SharedPreferences
        MySPUtil.getInstance();
        //log信息是否打印
        LogUtil.openLog(true);
//        //全局异常捕获处理器
//        AppCrashHandle.getInstance().init(this);
        //网络切换监听器
    }
}
