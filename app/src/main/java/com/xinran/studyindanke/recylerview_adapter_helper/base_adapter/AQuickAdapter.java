package com.xinran.studyindanke.recylerview_adapter_helper.base_adapter;

import android.animation.Animator;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinran.studyindanke.R;

import java.util.List;

/**
 * Created by houqixin on 2018/2/8.
 */

public abstract class AQuickAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public AQuickAdapter(@LayoutRes int layoutResId, @Nullable List<T> data){
        super(layoutResId,data);

    }

    public AQuickAdapter(@Nullable List<T> data) {
        super(R.layout.item_quick_adapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {

    }

    /**
     * 重写这个方法 就是为了让动画延迟  方便给item设置的动画可以看出来
     */
    @Override
    protected void startAnim(Animator anim, int index) {
        super.startAnim(anim, index);
        if (index < getItemCount())
            anim.setStartDelay(index * 150);
    }


}
