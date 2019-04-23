package com.newstablayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyj on 2017/12/19 0019.
 */

public class NvFilterAdapter extends RecyclerView.Adapter<NvFilterAdapter.ViewHolder> {
    private Context mContext;
    private Boolean mIsArface = false;
    private OnItemClickListener mClickListener;
    private List<String> mFilterDataList = new ArrayList<>();
    private int mSelectPos = 0;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemTouch(boolean touch);
    }

    public NvFilterAdapter(Context context) {
        mContext = context;

        for(int i = 0; i < 100; i++) {
            mFilterDataList.add("数据" + i);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }


    public void setSelectPos(int pos) {
        this.mSelectPos = pos;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private View item_assetShadow;
        private ImageView item_assetImage;
        private TextView item_assetName;

        public ViewHolder(View view) {
            super(view);
            item_assetShadow = view.findViewById(R.id.assetShadow);
            item_assetName = (TextView) view.findViewById(R.id.nameAsset);
            item_assetImage = (ImageView) view.findViewById(R.id.imageAsset);
        }
    }

    public void isArface(Boolean isArface) {
        mIsArface = isArface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nv_item_fx, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.item_assetName.setText(mFilterDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mFilterDataList.size();
    }
}
