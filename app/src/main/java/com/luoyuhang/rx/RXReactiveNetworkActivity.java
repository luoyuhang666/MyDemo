package com.luoyuhang.rx;

import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.yuahang.mydemo.R;
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork;
import com.luoyuhang.androidutils.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/8/21 0021.
 */

public class RXReactiveNetworkActivity extends AppCompatActivity {
    @BindView(R.id.connectivity_status)
    TextView tvConnectivityStatus;
    @BindView(R.id.internet_status)
    TextView tvInternetStatus;
    private Disposable networkDisposable;
    private Disposable internetDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_reactive_network);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        networkDisposable = ReactiveNetwork.observeNetworkConnectivity(getApplicationContext())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(connectivity -> {
                    LogUtils.d(LogUtils.TAG(), connectivity.toString());
                    final NetworkInfo.State state = connectivity.getState();
                    final String name = connectivity.getTypeName();
                    tvConnectivityStatus.setText(String.format("state: %s, typeName: %s", state, name));
                });
        internetDisposable = ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isConnected -> tvInternetStatus.setText(isConnected.toString()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        safelyDispose(networkDisposable, internetDisposable);
    }

    private void safelyDispose(Disposable... disposables) {
        for (Disposable subscription : disposables) {
            if (subscription != null && !subscription.isDisposed()) {
                subscription.dispose();
            }
        }
    }
}
