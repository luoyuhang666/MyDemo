package com.luoyuhang.androidutils.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class ToastUtils {
    private static Toast toast = null; //Toast的对象！

    public static void showToast(Context mContext, String id) {
        if (toast == null) {
            toast = Toast.makeText(mContext, id, Toast.LENGTH_SHORT);
        } else {
            toast.setText(id);
        }
        LogUtils.w("ToastUtils : " + id);
        toast.show();
    }

    public static void showToast(Context mContext, int id) {
        if (toast == null) {
            toast = Toast.makeText(mContext, id, Toast.LENGTH_SHORT);
        } else {
            toast.setText(id);
        }
        LogUtils.w("ToastUtils : " + mContext.getResources().getText(id));
        toast.show();
    }

    public static void showLongToast(Context mContext, String id) {
        if (toast == null) {
            toast = Toast.makeText(mContext, id, Toast.LENGTH_LONG);
        } else {
            toast.setText(id);
        }
        LogUtils.w("ToastUtils : " + id);
        toast.show();
    }
}
