package com.luoyuhang.androidutils.rxbus;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 封装了线程调度
 * Created by Android on 2017/8/9 0009.
 */

public class RxSchedulersHelper {
    public static <T> FlowableTransformer<T,T> io_main(){
        return ob -> ob.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
