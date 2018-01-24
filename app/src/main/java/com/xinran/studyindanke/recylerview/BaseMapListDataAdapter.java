package com.xinran.studyindanke.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by houqixin on 2018/1/23.
 */

public abstract class BaseMapListDataAdapter<D> extends RecyclerView.Adapter<BaseViewHolder> {
    private Map<String, List<D>> mMap;

    public BaseMapListDataAdapter(Map<String, List<D>> map) {
        this.mMap = map;
    }

    public void setData(Map<String, List<D>> map) {
        mMap = map;
        notifyDataSetChanged();
    }

    public void addData(Map<String, List<D>> map) {
        if (map != null&&!map.isEmpty()) {
            for (Map.Entry<String, List<D>> enty : map.entrySet()) {
                mMap.put(enty.getKey(), enty.getValue());
            }
            notifyDataSetChanged();
        }

    }

    public void addData(String key,List<D> data) {
        mMap.put(key,data);
        notifyDataSetChanged();
    }

    public Map<String, List<D>> getData() {
        return mMap;
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
        onBindedViewHolder(holder, position, mMap.get(String.valueOf(position)));

    }

    @Override
    public int getItemCount() {
        return mMap == null ? 0 : mMap.size();
    }

    /**
     * 可以更改view的一些属性
     *
     * @param holder
     */
    protected abstract void onViewHolderCreated(BaseViewHolder holder);

    /**
     * 返回給ViewHolder绑定的View的id
     *
     * @return
     */

    protected abstract int getLayoutId();

    /**
     * 数据跟对应的Item绑定成功就可以设置对应view的数据了
     *
     * @param holder   view绑定的holder
     * @param position bean在数据源中的位置
     * @param bean     对应的bean
     */

    protected abstract void onBindedViewHolder(BaseViewHolder holder, int position, List<D> bean);
}
