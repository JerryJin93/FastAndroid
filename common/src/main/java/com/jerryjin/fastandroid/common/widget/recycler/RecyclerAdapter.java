package com.jerryjin.fastandroid.common.widget.recycler;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jerryjin.fastandroid.common.R;
import com.jerryjin.fastandroid.common.widget.AdapterCallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class RecyclerAdapter<T>
        extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder<T>>
        implements View.OnClickListener, View.OnLongClickListener, AdapterCallback<T> {

    private final List<T> mDataList;
    private AdapterListener<T> mListener;

    public RecyclerAdapter() {
        this(null);
    }

    public RecyclerAdapter(AdapterListener<T> listener) {
        this(new ArrayList<T>(), listener);
    }

    public RecyclerAdapter(List<T> dataList, AdapterListener<T> listener) {
        this.mDataList = dataList;
        this.mListener = listener;
    }


    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position, mDataList.get(position));
    }

    @LayoutRes
    protected abstract int getItemViewType(int position, T data);


    @NonNull
    @Override
    public ViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //得到LayoutInflater用于把XML初始化为View
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //把XML的id为viewType的文件初始化为一个root View
        View root = inflater.inflate(viewType, parent, false);
        //通过子类必须实现的方法得到一个ViewHolder
        ViewHolder<T> holder = onCreateViewHolder(root, viewType);
        //设置事件点击
        root.setOnClickListener(this);
        root.setOnLongClickListener(this);
        //设置View的tag为ViewHolder，进行双向绑定
        root.setTag(R.id.tag_recycler_view_holder, holder);
        //进行界面注解绑定
        holder.unbinder = ButterKnife.bind(holder, root);
        //绑定callback
        holder.callback = this;
        return holder;
    }


    @NonNull
    protected abstract ViewHolder<T> onCreateViewHolder(View root, int viewType);


    @Override
    public void onBindViewHolder(@NonNull ViewHolder<T> holder, int position) {
        T data = mDataList.get(position);
        holder.onBind(data);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void add(T data) {
        mDataList.add(data);
        notifyItemInserted(mDataList.size() - 1);
    }

    public void add(@Nullable T... dataList) {
        if (dataList != null && dataList.length > 0) {
            int startPosition = mDataList.size() - 1;
            Collections.addAll(mDataList, dataList);
            notifyItemRangeChanged(startPosition, dataList.length);
        }
    }

    public void add(@Nullable Collection<T> dataCollection) {
        if (dataCollection != null && dataCollection.size() > 0) {
            int startPosition = mDataList.size();
            mDataList.addAll(dataCollection);
            notifyItemRangeChanged(startPosition, dataCollection.size());
        }
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    public void replace(@Nullable Collection<T> dataCollection) {
        if (dataCollection == null || dataCollection.size() == 0){
            return;
        }
        mDataList.addAll(dataCollection);
        notifyDataSetChanged();
    }

    @Override
    public void update(T data, @NonNull ViewHolder<T> holder) {
        int pos = holder.getAdapterPosition();
        if (pos >= 0) {
            // mDataList.remove(pos);
            // mDataList.add(pos, data);
            mDataList.set(pos, data);
            notifyItemChanged(pos);
        }
    }

    @Override
    public void onClick(@NonNull View v) {
        ViewHolder holder = (ViewHolder) v.getTag(R.id.tag_recycler_view_holder);
        if (this.mListener != null) {
            int position = holder.getAdapterPosition();
            this.mListener.onItemClick(holder, mDataList.get(position));
        }
    }


    @Override
    public boolean onLongClick(@NonNull View v) {
        ViewHolder holder = (ViewHolder) v.getTag(R.id.tag_recycler_view_holder);
        if (this.mListener != null) {
            int position = holder.getAdapterPosition();
            this.mListener.onItemLongClick(holder, mDataList.get(position));
            return true;
        }
        return false;
    }

    public void setListener(AdapterListener<T> listener) {
        this.mListener = listener;
    }

    public interface AdapterListener<T> {

        void onItemClick(RecyclerAdapter.ViewHolder holder, T data);

        void onItemLongClick(RecyclerAdapter.ViewHolder holder, T data);
    }


    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {

        protected T mData;
        private Unbinder unbinder;
        private AdapterCallback<T> callback;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(T data) {
            this.mData = data;
            onBind(data);
        }

        protected abstract void onBind(T data);

        public void updateData(T data) {
            if (this.callback != null) {
                this.callback.update(data, this);
            }
        }
    }

    public static abstract class AdapterListenerImpl<T> implements AdapterListener<T> {

        @Override
        public void onItemClick(ViewHolder holder, T data) {

        }

        @Override
        public void onItemLongClick(ViewHolder holder, T data) {

        }
    }
}
