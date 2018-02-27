package com.luoyuhang.rx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.yuahang.mydemo.R;
import com.just.library.AgentWeb;
import com.just.library.BaseIndicatorView;
import com.just.library.ChromeClientCallbackManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/11 0011.
 */

public class RxRecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.baseindicatorview)
    BaseIndicatorView mAgentWeb;
    @BindView(R.id.mLinearLayout)
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_webview);
        ButterKnife.bind(this);
    }
}
