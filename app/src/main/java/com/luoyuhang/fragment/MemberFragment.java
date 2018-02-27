package com.luoyuhang.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuahang.mydemo.R;
import com.luoyuhang.androidutils.ui.UIHelper;
import com.luoyuhang.androidutils.ui.pulltozoomview.PullToZoomScrollViewEx;

public class MemberFragment extends Fragment {

    private Activity context;
    private View root;
    private PullToZoomScrollViewEx scrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.fragment_member, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        initData();
        initView();
    }

    void initView() {
        scrollView = (PullToZoomScrollViewEx) root.findViewById(R.id.scrollView);
        View headView = LayoutInflater.from(context).inflate(R.layout.member_head_view, null, false);
        View zoomView = LayoutInflater.from(context).inflate(R.layout.member_zoom_view, null, false);
        View contentView = LayoutInflater.from(context).inflate(R.layout.member_content_view, null, false);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);

        headView.findViewById(R.id.tv_register).setOnClickListener(v -> UIHelper.showLogin(getActivity()));

        headView.findViewById(R.id.tv_login).setOnClickListener(v -> UIHelper.showLogin(getActivity()));


        scrollView.getPullRootView().findViewById(R.id.textBalance).setOnClickListener(v -> {
        });
        scrollView.getPullRootView().findViewById(R.id.textRecord).setOnClickListener(v -> {
        });
        scrollView.getPullRootView().findViewById(R.id.textAttention).setOnClickListener(v -> {
        });
        scrollView.getPullRootView().findViewById(R.id.textHelp).setOnClickListener(v -> {
        });
        scrollView.getPullRootView().findViewById(R.id.textCalculator).setOnClickListener(v -> {
        });

        scrollView.getPullRootView().findViewById(R.id.textSetting).setOnClickListener(v -> {
        });

//        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
//        context.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
//        int mScreenHeight = localDisplayMetrics.heightPixels;
//        int mScreenWidth = localDisplayMetrics.widthPixels;
//        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
//        scrollView.setHeaderLayoutParams(localObject);
    }

    private void initData() {

    }
}