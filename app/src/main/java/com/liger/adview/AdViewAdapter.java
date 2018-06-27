package com.liger.adview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liger.adviewlib.AdImageView;

import java.util.List;

/**
 * @author Liger
 * @date 2018/6/20 00:12
 */
public class AdViewAdapter extends RecyclerView.Adapter<AdViewAdapter.ViewHolder> {

    private List<String> mList;

    public AdViewAdapter(List<String> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
        if (position > 0 && position % 10 == 0) {
            holder.mTextView.setVisibility(View.INVISIBLE);
            holder.mImageView.setVisibility(View.INVISIBLE);
            holder.mAdImageView.setVisibility(View.VISIBLE);
        } else {
            holder.mTextView.setVisibility(View.VISIBLE);
            holder.mImageView.setVisibility(View.VISIBLE);
            holder.mAdImageView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;
        ImageView mImageView;
        AdImageView mAdImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv);
            mAdImageView = itemView.findViewById(R.id.item_adview_adimg);
            mImageView = itemView.findViewById(R.id.iv);
        }
    }
}
