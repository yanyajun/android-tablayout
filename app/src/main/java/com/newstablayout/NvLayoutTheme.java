package com.newstablayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by ms on 2019/4/12.
 */
public class NvLayoutTheme extends RelativeLayout {
    private final String TAG = "NvLayoutTheme";
    private Context mContext;

    // 滤镜
    private RecyclerView theme_recyclerview;
    private NvFilterAdapter mFilterAdapter;

    public NvLayoutTheme(Context context) {
        this(context, null);
    }

    public NvLayoutTheme(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        View rootView = LayoutInflater.from(context).inflate(R.layout.nv_layout_theme, this);
        theme_recyclerview = (RecyclerView) rootView.findViewById(R.id.theme_recyclerview);
        initFilterRecyclerView();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void initFilterRecyclerView() {
        GridLayoutManager linearLayoutManager = new GridLayoutManager(mContext, 5, LinearLayoutManager.VERTICAL, false);
        theme_recyclerview.setLayoutManager(linearLayoutManager);
        mFilterAdapter = new NvFilterAdapter(mContext);
        theme_recyclerview.setAdapter(mFilterAdapter);
    }
}
