package com.xinran.studyindanke.recylerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.xinran.studyindanke.R;

/**
 * Created by houqixin on 2018/1/23.
 */

public class RecylerViewActvity extends Activity {
    private RecyclerView mCaiDanRecylerView;
    private RecyclerView mContentRecylerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recylerview);

        mCaiDanRecylerView= (RecyclerView) findViewById(R.id.recyclerview_cai_dan);
        mContentRecylerView= (RecyclerView) findViewById(R.id.recyclerview_content);

    }
}
