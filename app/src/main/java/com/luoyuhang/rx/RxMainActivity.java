package com.luoyuhang.rx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.yuahang.mydemo.R;
import com.luoyuhang.activity.MainActivity;
import com.luoyuhang.androidutils.utils.DownTimerUtils;
import com.luoyuhang.androidutils.utils.LogUtils;


import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Android on 2017/8/9 0009.
 */

public class RxMainActivity extends AppCompatActivity {
    private static final String TAG = "RxAndroidSamples";
    private DownTimerUtils timer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_ReactiveNetwork, R.id.bt_Agentweb,R.id.bt_frame})
    void viewsOnClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ReactiveNetwork:
                LogUtils.et("bt_ReactiveNetwork!");
                startActivity(new Intent(RxMainActivity.this, RXReactiveNetworkActivity.class));
                break;
            case R.id.bt_Agentweb:
                startActivity(new Intent(RxMainActivity.this, RxWebViewActivity.class));
                break;
            case R.id.bt_frame:
                startActivity(new Intent(RxMainActivity.this, MainActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
