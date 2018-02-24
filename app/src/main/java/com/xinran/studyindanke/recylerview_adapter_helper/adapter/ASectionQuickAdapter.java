package com.xinran.studyindanke.recylerview_adapter_helper.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinran.studyindanke.R;
import com.xinran.studyindanke.recylerview_adapter_helper.bean.SectionBean;

import java.util.List;

/**
 * Created by houqixin on 2018/2/9.
 */

public class ASectionQuickAdapter extends BaseSectionQuickAdapter<SectionBean,BaseViewHolder> {

    public ASectionQuickAdapter(List<SectionBean> data) {
        super(R.layout.item_quick_adapter, R.layout.section_head_view, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, SectionBean item) {//设置headerView

        helper.setText(R.id.tv_section_head,item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, SectionBean item) {//设置ItemView

        helper.setText(R.id.tv_name, item.t.name)
                .setText(R.id.tv_age, String.valueOf(item.t.age))
                .addOnClickListener(R.id.tv_name)//可以连续加多个add 对应Actvity的Adapter设置setOnChirdClick
                .addOnClickListener(R.id.tv_age)
                .addOnLongClickListener(R.id.tv_name);
    }
}
