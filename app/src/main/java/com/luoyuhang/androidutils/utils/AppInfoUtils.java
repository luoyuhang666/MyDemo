package com.luoyuhang.androidutils.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

/**
 * Created by Administrator on 2017/8/9 0009.
 */

public class AppInfoUtils {
    /**
     * 从context中检索应用程序的启动activity名称
     *
     * @param context 应用程序包的上下文
     * @return 启动器此应用程序的活动名称. 来自"android:name" 属性.
     */
    public static String getLauncherClassName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        // 通过设置一个,限制Intent将解决的组件.
        // explicit package name.
        intent.setPackage(context.getPackageName());
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        // 所有应用程序至少必须有1个活动。
        // Launcher activity must be found!
        ResolveInfo info = packageManager
                .resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        // get a ResolveInfo containing ACTION_MAIN, CATEGORY_LAUNCHER
        // if there is no Activity which has filtered by CATEGORY_DEFAULT
        if (info == null) {
            info = packageManager.resolveActivity(intent, 0);
        }
        //////////////////////另一种实现方式//////////////////////
        // ComponentName componentName = context.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName()).getComponent();
        // return componentName.getClassName();
        //////////////////////另一种实现方式//////////////////////
        return info.activityInfo.name;
    }
}
