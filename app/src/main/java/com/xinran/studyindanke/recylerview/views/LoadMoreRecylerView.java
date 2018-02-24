package com.xinran.studyindanke.recylerview.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by houqixin on 2018/2/24.
 * 一个可以上拉加载更多的RecylerView
 */

public class LoadMoreRecylerView extends RecyclerView {

    public LoadMoreRecylerView(Context context) {
        super(context);
        init();
    }

    public LoadMoreRecylerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadMoreRecylerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();

    }
    private void init(){
        addOnScrollListener(new OnRecylerViewScrollLisner());
    }

    private class OnRecylerViewScrollLisner extends OnScrollListener {
        private LayoutManager mLayoutManager;
        private Adapter mAdapter;
        private int mLastVisiblePosition = 0;

        /**
         * Callback method to be invoked when RecyclerView's scroll state changes.
         *
         * @param recyclerView The RecyclerView whose scroll state has changed.
         * @param newState     The updated scroll state. One of {@link #SCROLL_STATE_IDLE},
         *                     {@link #SCROLL_STATE_DRAGGING} or {@link #SCROLL_STATE_SETTLING}.
         */
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if(mAdapter==null)mAdapter=recyclerView.getAdapter();
            if (mAdapter != null && newState == RecyclerView.SCROLL_STATE_IDLE && mLastVisiblePosition + 1 == mAdapter.getItemCount()&&mOnLoadMoreListner!=null) {
                mOnLoadMoreListner.onLoadMore();

            }

        }

        /**
         * Callback method to be invoked when the RecyclerView has been scrolled. This will be
         * called after the scroll has completed.
         * <p>
         * This callback will also be called if visible item range changes after a layout
         * calculation. In that case, dx and dy will be 0.
         *
         * @param recyclerView The RecyclerView which scrolled.
         * @param dx           The amount of horizontal scroll.
         * @param dy           The amount of vertical scroll.
         */
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (mLayoutManager == null) {
                mLayoutManager = recyclerView.getLayoutManager();
            }
            if (mLayoutManager instanceof LinearLayoutManager) {
                mLastVisiblePosition = ((LinearLayoutManager) mLayoutManager)
                        .findLastVisibleItemPosition();
            } else if (mLayoutManager instanceof GridLayoutManager) {
                mLastVisiblePosition = ((GridLayoutManager) mLayoutManager)
                        .findLastVisibleItemPosition();
            }else{
                throw new RecylerViewException("暂时不支持其它LayoutManager");
            }

        }
    }
    private OnLoadMoreListner mOnLoadMoreListner;

    public void setOnLoadMoreListner(OnLoadMoreListner onLoadMoreListner) {
        mOnLoadMoreListner = onLoadMoreListner;
    }

    public interface OnLoadMoreListner{
        void onLoadMore();
    }
}
