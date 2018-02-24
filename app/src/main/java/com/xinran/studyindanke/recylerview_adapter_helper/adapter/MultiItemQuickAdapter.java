package com.xinran.studyindanke.recylerview_adapter_helper.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinran.studyindanke.R;
import com.xinran.studyindanke.recylerview_adapter_helper.bean.MultiItemBean;

import java.util.List;

/**
 * Created by houqixin on 2018/2/9.
 */

public class MultiItemQuickAdapter extends BaseMultiItemQuickAdapter<MultiItemBean,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultiItemQuickAdapter(List<MultiItemBean> data) {
        super(data);
        addItemType(MultiItemBean.TEXT_TYPE, R.layout.section_head_view);
        addItemType(MultiItemBean.IMG_TYPE,R.layout.item_quick_adapter);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemBean item) {
         int type=helper.getItemViewType();
        if(type==MultiItemBean.TEXT_TYPE){
            helper.setText(R.id.tv_section_head,item.mData.name);
        }else{
            helper.setText(R.id.tv_age, String.valueOf(item.mData.age));
        }
    }
}
