package com.luoyuhang.androidutils.utils;

import android.util.Log;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class LogUtils {
    private static boolean LOGV = true;
    private static boolean LOGD = true;
    private static boolean LOGI = true;
    private static boolean LOGW = true;
    private static boolean LOGE = true;

    public static void v(String info) {
        Log.v(FILE(), info);
    }

    public static void d(String info) {
        Log.d(FILE(), info);
    }

    public static void i(String info) {
        Log.i(FILE(), info);
    }

    public static void w(String info) {
        Log.w(FILE(), info);
    }

    public static void e(String info) {
        Log.e(FILE(), info);
    }

    public static void v(String tag, String mess) {
        if (LOGV) {
            Log.v(tag, mess);
        }
    }

    public static void d(String tag, String mess) {
        if (LOGD) {
            Log.d(tag, mess);
        }
    }


    public static void i(String tag, String mess) {
        if (LOGI) {
            Log.i(tag, mess);
        }
    }


    public static void w(String tag, String mess) {
        if (LOGW) {
            Log.w(tag, mess);
        }
    }


    public static void e(String tag, String mess) {
        if (LOGE) {
            Log.e(tag, mess);
        }
    }

    public static void et(String mess) {
        if (LOGE) {
            Log.e(LogUtils.TAG(), mess);
        }
    }

    public static String TAG(String... srcs) {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        StringBuffer toStringBuffer = new StringBuffer("[").append(traceElement.getFileName()).append(" | ")
                .append(traceElement.getLineNumber()).append(" | ").append(traceElement.getMethodName()).append("]#####");
        for (String src : srcs) {
            toStringBuffer.append(String.format("===%s", src));
        }
        return toStringBuffer.toString();
    }

    // 当前文件名
    public static String FILE() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getFileName();
    }

    // 当前方法名
    public static String FUNC() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getMethodName();
    }

    // 当前行号
    public static int LINE() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getLineNumber();
    }
}
