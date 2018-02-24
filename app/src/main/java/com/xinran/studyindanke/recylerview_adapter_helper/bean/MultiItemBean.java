package com.xinran.studyindanke.recylerview_adapter_helper.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by houqixin on 2018/2/9.
 */

public class MultiItemBean implements MultiItemEntity{
    public static int TEXT_TYPE=0x01;
    public static int IMG_TYPE=TEXT_TYPE+1;
    public int mItemType;

    public Student mData;

    public MultiItemBean(int itemType, Student data) {
        mItemType = itemType;
        mData = data;
    }

    @Override
    public int getItemType() {
        return mItemType;
    }
}
