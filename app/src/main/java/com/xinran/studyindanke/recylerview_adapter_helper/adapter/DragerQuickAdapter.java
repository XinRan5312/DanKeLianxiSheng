package com.xinran.studyindanke.recylerview_adapter_helper.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinran.studyindanke.R;
import com.xinran.studyindanke.recylerview_adapter_helper.bean.Student;

import java.util.List;

/**
 * Created by houqixin on 2018/2/9.
 */

public class DragerQuickAdapter extends BaseItemDraggableAdapter<Student,BaseViewHolder>{
    public DragerQuickAdapter(List<Student> data) {
        super(R.layout.item_quick_adapter,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Student item) {
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_age, String.valueOf(item.age))
                .addOnClickListener(R.id.tv_name)//可以连续加多个add 对应Actvity的Adapter设置setOnChirdClick
                .addOnClickListener(R.id.tv_age)
                .addOnLongClickListener(R.id.tv_name);
    }
}
