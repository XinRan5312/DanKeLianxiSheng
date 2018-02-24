package com.xinran.studyindanke.recylerview_adapter_helper.adapter;

import android.animation.Animator;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinran.studyindanke.R;
import com.xinran.studyindanke.recylerview_adapter_helper.bean.Student;

import java.util.List;

/**
 * Created by houqixin on 2018/2/8.
 */

public class AQuickAdapter extends BaseQuickAdapter<Student, BaseViewHolder> {

    public AQuickAdapter(@Nullable List<Student> data) {
        super(R.layout.item_quick_adapter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Student item) {
        // TextView tv=helper.getView(R.id.tv_name);
        int itemPosition = helper.getLayoutPosition();

        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_age, String.valueOf(item.age))
                .addOnClickListener(R.id.tv_name)//可以连续加多个add 对应Actvity的Adapter设置setOnChirdClick
                .addOnClickListener(R.id.tv_age)
                .addOnLongClickListener(R.id.tv_name);
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
