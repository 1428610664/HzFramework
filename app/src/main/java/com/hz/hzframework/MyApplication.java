package com.hz.hzframework;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class MyApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();

    }
}
