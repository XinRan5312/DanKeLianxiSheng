package com.xinran.studyindanke.recylerview_adapter_helper.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by houqixin on 2018/2/9.
 */

public class SectionBean extends SectionEntity<Student>{
    public SectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public SectionBean(Student student) {
        super(student);
    }
}
