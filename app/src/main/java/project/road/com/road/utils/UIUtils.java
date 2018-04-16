package project.road.com.road.utils;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;

/**
 * Created by Administrator on 2017/11/16.
 *
 * 封装常用UI操作代码
 * 和UI操作相关的便捷类
 */

public class UIUtils {


    public static Context getContext(){
        return Aplication_Road.context;
    }

    public static View getXmlView(int layoutId){
        return View.inflate(getContext(),layoutId,null);
    }

    public static Handler handler(){
        return Aplication_Road.handler;
    }


    public static int getcolor(int colorId){
        return ContextCompat.getColor(getContext(),colorId);
    }


    public static String[] getStringArr(int arrId){
        return getContext().getResources().getStringArray(arrId);
    }
}
