package com.xinran.studyindanke.recylerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xinran.studyindanke.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by houqixin on 2018/1/23.
 */

public class RecylerViewActvity extends Activity {
    private RecyclerView mCaiDanRecylerView;
    private RecyclerView mContentRecylerView;
    private LinearLayoutManager mCainDanLayoutManager;
    private LinearLayoutManager mContentLayoutManager;
    private RecylerViewCaiDanAdapter mCaiDanAdapter;
    private RecylerViewContentAdapter mContentAdapter;
    public static int mSelectedPoint=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recylerview);
        initData();
        initListners();

    }

    private void initData() {
        mCaiDanRecylerView = (RecyclerView) findViewById(R.id.recyclerview_cai_dan);
        mContentRecylerView = (RecyclerView) findViewById(R.id.recyclerview_content);
        mCainDanLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mContentLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mCaiDanRecylerView.setLayoutManager(mCainDanLayoutManager);
        mContentRecylerView.setLayoutManager(mContentLayoutManager);
        mCaiDanAdapter=new RecylerViewCaiDanAdapter(createCaiDanData());
        mContentAdapter=new RecylerViewContentAdapter(createContentData(),this);
        mCaiDanRecylerView.setAdapter(mCaiDanAdapter);
        mContentRecylerView.setAdapter(mContentAdapter);


    }
    private void initListners() {
        mCaiDanAdapter.setCaiDanItemClickListener(new RecylerViewCaiDanAdapter.OnCaiDanItemClickListener() {
            @Override
            public void onCaiDanItemClick(int position,int x,int y) {
                if(mSelectedPoint!=position){
                    mContentRecylerView.scrollToPosition(position);
                    mSelectedPoint=position;
                    mCaiDanAdapter.notifyDataSetChanged();
                }
            }
        });
        mContentRecylerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
               int first= mContentLayoutManager.findFirstVisibleItemPosition();
                if(first!=mSelectedPoint){
                    mSelectedPoint=first;
                    mCaiDanAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    private List<String> createCaiDanData(){

        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<7;i++){
            list.add("菜单-"+i);
        }
        return list;
    }

    private Map<String,List<String>> createContentData(){
        HashMap<String,List<String>> map=new HashMap<>();
        for(int j=0;j<7;j++){
            ArrayList<String> list=new ArrayList<>();
            for(int i=0;i<7;i++){
                list.add("Title-"+i);
            }
            map.put(String.valueOf(j),list);
        }
        return map;
    }
}
