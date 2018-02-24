package com.xinran.studyindanke.recylerview_adapter_helper;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinran.studyindanke.R;

import java.util.List;

/**
 * Created by houqixin on 2018/2/9.
 */

public class CommonRecylerViewUI<T> {
    private RecyclerView mRecyclerView;
    private Context mContext;
    private List<T> mData;
    private BaseQuickAdapter<T,BaseViewHolder> mQuickAdapter;
    private RecylerViewType mType;
    private LinearLayoutManager mLayoutManager;
    public CommonRecylerViewUI(Context context,List<T> data){
        this.mContext=context;
        this.mData=data;

    }

    public CommonRecylerViewUI setAdapter(BaseQuickAdapter<T,BaseViewHolder> quickAdapter){
        this.mQuickAdapter=quickAdapter;
        return this;
    }
    public CommonRecylerViewUI setRecylerViewType(RecylerViewType type){
        this.mType=type;
        return this;
    }
    public CommonRecylerViewUI setLinearLayoutManager(LinearLayoutManager layoutManager){
        this.mLayoutManager=layoutManager;
        return this;
    }

    public CommonRecylerViewUI setUIScrollListner(RecylerUIScrollListner uiScrollListner){
        this.mUIScrollListner = uiScrollListner;
        return this;
    }
    public RecyclerView build(){
        initViewAndData();
        return mRecyclerView;
    }

    private void initViewAndData() {
        mRecyclerView= (RecyclerView) LayoutInflater.from(mContext).inflate(R.layout.activity_recylerview_adapter_helper,null,false);
        if(mLayoutManager==null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        }else{
            mRecyclerView.setLayoutManager(mLayoutManager);
        }
        mRecyclerView.setAdapter(mQuickAdapter);
        if(mType.equals(RecylerViewType.COMMON)){
            mQuickAdapter.setUpFetchEnable(false);
            mQuickAdapter.setEnableLoadMore(false);
        }else if(mType.equals(RecylerViewType.ONLY_PULL_DOWN_RFRESH)){
            mQuickAdapter.setUpFetchEnable(true);
            mQuickAdapter.setEnableLoadMore(false);
            mQuickAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
                @Override
                public void onUpFetch() {
                    if(mUIScrollListner!=null)mUIScrollListner.onPullDownWillRefresh();
                }
            });
        }else if(mType.equals(RecylerViewType.ONLY_PULL_UP_LOAD_MORE)){
            mQuickAdapter.setUpFetchEnable(false);
            mQuickAdapter.setEnableLoadMore(true);
            mQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                @Override
                public void onLoadMoreRequested() {
                    if(mUIScrollListner!=null)mUIScrollListner.onPullUpWillLoadMore();
                }
            },mRecyclerView);
        }
    }

  public enum RecylerViewType{
      COMMON,ONLY_PULL_DOWN_RFRESH,ONLY_PULL_UP_LOAD_MORE,REFRESH_AND_LOAD_MORE;
  }

  private RecylerUIScrollListner mUIScrollListner;

    public interface RecylerUIScrollListner{
      void onPullDownWillRefresh();
       void onPullUpWillLoadMore();
   }
}
