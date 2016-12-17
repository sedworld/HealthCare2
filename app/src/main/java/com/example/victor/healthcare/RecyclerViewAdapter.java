package com.example.victor.healthcare;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

import java.util.List;

/**
 * Created by Victor on 17.12.2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private String[] mDataSource = null;

    public void setDataSource(String[] data){
        mDataSource = data;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        SwipeLayout swipeLayout;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            swipeLayout = (SwipeLayout)itemView.findViewById(R.id.swipe);
            swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }

    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        holder.textView.setText("" + mDataSource[position]);

    }

    @Override
    public int getItemCount() {
        return mDataSource == null ? 0 : mDataSource.length;
    }

}
