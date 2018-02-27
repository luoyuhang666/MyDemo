package com.example.yuahang.mydemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;

/**
 * Created by Administrator on 2017/6/22 0022.
 */

public class MarqueeActivity extends AppCompatActivity {

    AppCompatEditText etSpeed;
    AppCompatEditText etText;
    AppCompatButton btnSetting;
    CustomMarqueeTextView marqueeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marqueeview);
        etSpeed = (AppCompatEditText) findViewById(R.id.et_speed);
        etText = (AppCompatEditText) findViewById(R.id.et_text);
        btnSetting = (AppCompatButton) findViewById(R.id.btn_setting);
        marqueeTextView = (CustomMarqueeTextView) findViewById(R.id.marquee_text_view);

    //"系统跑马灯文本长度必须大于控件宽度才能滚动,自定义的跑马灯文本每次滚动完之后才会发生下一次滚动，首位没有衔接,文本或者滚动速度改变后都要调用init()方法"
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etText.getText().toString();
                if (!TextUtils.isEmpty(text)) {
                    marqueeTextView.setText(text);
                    marqueeTextView.init(getWindowManager());
                }
                try {
                    int speed = Integer.parseInt(etSpeed.getText().toString());
                    marqueeTextView.setSpeed(speed);
                    marqueeTextView.init(getWindowManager());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在这里初始化确保CustomMarqueeTextView 类中的getW
        marqueeTextView.postDelayed(new Runnable() {
            @Override
            public void run() {
                marqueeTextView.setText("你尽力而为即可，让我来全力以赴");
                marqueeTextView.setTextColor(Color.RED);
                marqueeTextView.init(getWindowManager());//文本或者滚动速度改变后都要调用该方法
                marqueeTextView.startScroll();
                marqueeTextView.setEnabled(false);
            }
        }, 300);
    }
}