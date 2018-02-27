package com.luoyuhang.androidutils.rxbus;

import android.support.annotation.NonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by Android on 2017/8/9 0009.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
    @NonNull int tag();

    EventThread thread() default EventThread.MAIN_THREAD;
}
