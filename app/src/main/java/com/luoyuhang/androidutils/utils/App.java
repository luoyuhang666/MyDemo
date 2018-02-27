package com.luoyuhang.androidutils.utils;

import android.app.Application;

/**
 * Application单利工具类
 * Created by Administrator on 2017/8/9 0009.
 */

public class App {
    public static final Application INSTANCE;

    static {
        Application app = null;
        try {
            app = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
            if (app == null)
                throw new IllegalStateException("Static initialization of Applications must be on main thread.");
        } catch (final Exception e) {

            try {
                app = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
            } catch (final Exception ex) {

            }
        } finally {
            INSTANCE = app;
        }
    }

    public static void toast(String msg) {
        ToastUtils.showToast(INSTANCE, msg);
    }

    public static void toast(int msgId) {
        ToastUtils.showToast(INSTANCE, String.valueOf(msgId));
    }

    public static void longToast(String msg) {
        ToastUtils.showLongToast(INSTANCE, msg);
    }
}
