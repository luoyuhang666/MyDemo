package com.luoyuhang.androidutils.rxbus;

/**
 * Created by Android on 2017/8/9 0009.
 */
public class Msg {
    public int code;
    public Object object;

    public Msg(int code, Object object){
        this.code = code;
        this.object = object;
    }

}
