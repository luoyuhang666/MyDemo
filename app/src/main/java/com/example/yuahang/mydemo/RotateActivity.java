package com.example.yuahang.mydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/7/25 0025.
 */

public class RotateActivity extends AppCompatActivity {
    private RotateImageView rotate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        rotate = new RotateImageView(this);
        rotate.setScaleType(ImageView.ScaleType.FIT_XY  );
        rotate.stopRotate(false);
    }
}
