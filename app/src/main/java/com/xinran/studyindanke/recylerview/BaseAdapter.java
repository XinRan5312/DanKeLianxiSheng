package com.xinran.studyindanke.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by houqixin on 2018/1/23.
 */

public abstract class BaseAdapter<D> extends RecyclerView.Adapter<BaseViewHolder> {
    private List<D> mList;

    public BaseAdapter(List<D> list){
        this.mList=list;
    }
    public void setData(List<D> list){
        mList=list;
        notifyDataSetChanged();
    }
    public void addData(List<D> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void addData(D data) {
        mList.add(data);
        notifyDataSetChanged();
    }

    public List<D> getData() {
        return mList;
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (0 == getLayoutId()) {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }
        View convertView = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        BaseViewHolder holder = new BaseViewHolder(convertView);
        onViewHolderCreated(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        onBindedViewHolder(holder,position,mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList==null?0:mList.size();
    }

    /**
     * 可以更改view的一些属性
     * @param holder
     */
    protected abstract void onViewHolderCreated(BaseViewHolder holder);

    /**
     * 返回給ViewHolder绑定的View的id
     * @return
     */

    protected abstract int getLayoutId();

    /**
     * 数据跟对应的Item绑定成功就可以设置对应view的数据了
     * @param holder view绑定的holder
     * @param position bean在数据源中的位置
     * @param bean  对应的bean
     */

    protected abstract void onBindedViewHolder(BaseViewHolder holder, int position, D bean);
}
