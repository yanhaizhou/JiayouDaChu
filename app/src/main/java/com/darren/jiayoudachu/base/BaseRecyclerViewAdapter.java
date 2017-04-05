package com.darren.jiayoudachu.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darren on 17/3/31.
 * RecyclerView 的BaseAdapter
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter {
    private List<T> mList = null;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected OnItemClickListener mItemClickListener;
    protected OnItemSelectListener mItemSelectListener;

    public BaseRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public List<T> getList() {
        return mList;
    }

    public void setData(List<T> list) {
        if (list == null) {
            return;
        }

        mList = list;
        notifyDataSetChanged();
    }

    public void add(T t) {
        if (t == null) {
            return;
        }
        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList.add(t);
        notifyDataSetChanged();
    }

    public void add(List<T> list) {
        if (list == null) {
            return;
        }

        if (mList == null) {
            mList = list;
            notifyDataSetChanged();
            return;
        }

        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void addToTop(T t) {
        if (t == null) {
            return;
        }

        if (mList == null) {
            mList = new ArrayList<>();
        }

        mList.add(0, t);
        notifyDataSetChanged();
    }

    public void addToTopList(List<T> list) {
        if (list == null) {
            return;
        }

        if (mList == null) {
            mList = list;
            notifyDataSetChanged();
            return;
        }

        mList.addAll(0, list);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        if (mList == null) {
            return;
        }
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        if (mList != null) {
            mList.clear();
            mList = null;
        }

        notifyDataSetChanged();
    }


    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);


    }

    protected void onItemClickListener(RecyclerView.ViewHolder holder, final int position) {
        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(v, position);
                }
            });

        }
    }

    protected void onItemClickListenerByView(View view, final int position) {
        if (mItemClickListener != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(v, position);
                }
            });

        }
    }

    public void setItemSelectListener(OnItemSelectListener itemSelectListener) {
        this.mItemSelectListener = itemSelectListener;
    }

    public interface OnItemSelectListener {
        void onItemSelect(View view, int position);
    }


}
