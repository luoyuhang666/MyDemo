package com.luoyuhang.androidutils.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/**
 * 倒计时工具类
 * <b>1.实例化后必须设置倒计时的总时间（totalTime）和每隔多久时间（intervalTime）回调</b><br>
 * <b>2.有start()、 cancel()、 pause()、resume() 四个方法 </b>
 * Created by luoyuhang on 2017/8/22 0022.
 */

public class DownTimerUtils {
    private static final int TIME = 1;
    private long totalTime = -1;
    private long intervalTime = 0;
    private long remainTime;
    private long systemAddTotalTime;
    private TimeListener listener;
    private long curReminTime;
    private boolean isPause = false;
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TIME:
                    if (!isPause)
                        soloveTime();
                    break;
                case 2:
                    isPause = true;
                    break;
                default:
                    break;
            }
        }
    };
    //实例化
    public DownTimerUtils() {
    }

    public long getIntervalTime() {
        return intervalTime;
    }
    //设置间隔数
    public void setIntervalTime(long intervalTime) {
        this.intervalTime = intervalTime;
    }

    public long getTotalTime() {
        return totalTime;
    }
    //设置毫秒数
    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public void start() {
        if (totalTime <= 0 && intervalTime <= 0) {
            throw new RuntimeException("you must set the totalTime > 0 or intervalTime >0");
        }

        systemAddTotalTime = SystemClock.elapsedRealtime() + totalTime;

        if (null != mHandler)
            mHandler.sendEmptyMessage(TIME);
    }

    public void cancel() {
        if (mHandler != null) {
            mHandler.removeMessages(TIME);
            mHandler = null;
        }

    }

    public void pause() {
        if (mHandler != null) {
            mHandler.removeMessages(TIME);
            isPause = true;
            curReminTime = remainTime;
            if (listener != null) {
                listener.onPause();
            }
        }

    }

    public void resume() {
        if (isPause == true) {
            isPause = false;
            totalTime = curReminTime;
            start();
        }

    }

    public void restart() {
        if (isPause == true) {
            isPause = false;
            start();
        }
    }

    private void soloveTime() {
        remainTime = systemAddTotalTime - SystemClock.elapsedRealtime();
        if (remainTime <= 0) {
            if (listener != null) {
                listener.onFinish();
                pause();
//                cancel();
            }
        } else if (remainTime < intervalTime) {
            if (null != mHandler)
                mHandler.sendEmptyMessageDelayed(TIME, remainTime);
        } else {
            long curSystemTime = SystemClock.elapsedRealtime();
            if (listener != null) {
                listener.onInterval(remainTime);
            }

            long delay = curSystemTime + intervalTime - SystemClock.elapsedRealtime();

            while (delay < 0) delay += intervalTime;

            if (null != mHandler) {
                mHandler.sendEmptyMessageDelayed(TIME, delay);
            }
        }
    }

    public void setTimerLiener(TimeListener listener) {
        this.listener = listener;
    }

    public interface TimeListener {
        public void onFinish();

        public void onPause();

        public void onInterval(long remainTime);
    }
}
