package project.road.com.road.utils;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import org.xutils.x;

/**
 * Created by Administrator on 2018/3/17.
 */

public class Aplication_Road extends Application {


    public static Context context = null;

    public static Handler handler = null;

    public static Thread mainThread = null;

    public static int mainThreadId = 0;//判断当前代码是否在主线程中运行

    @Override
    public void onCreate() {
        context = getApplicationContext();
        handler = new Handler();
        mainThread = Thread.currentThread();//主线程
        mainThreadId = Process.myTid();//获取当前线程id。
        super.onCreate();
        x.Ext.init(this);
    }
}
