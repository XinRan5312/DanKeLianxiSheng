package com.xinran.studyindanke.recylerview;

import java.util.List;

/**
 * Created by houqixin on 2018/1/23.
 */

public class RecylerViewCaiDanAdapter extends BaseAdapter<String> {

    public RecylerViewCaiDanAdapter(List<String> list) {
        super(list);
    }

    @Override
    protected void onViewHolderCreated(BaseViewHolder holder) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void onBindedViewHolder(BaseViewHolder holder, int position, String bean) {

    }
}
