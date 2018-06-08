package com.android.ct7liang.refresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.ct7liang.R;
import com.ct7liang.tangyuan.recyclerview.BaseRecyclerViewAdapter;

/**
 * Created by Administrator on 2018-06-08.
 *
 */

public class QQRefreshAdapter extends BaseRecyclerViewAdapter{

    private Context context;

    public QQRefreshAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleViewHolder(View.inflate(context, R.layout.item_simple, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SimpleViewHolder){
            ((SimpleViewHolder) holder).tv.setText("item: " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    private class SimpleViewHolder extends ContentViewHolder{
        public TextView tv;
        SimpleViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
}