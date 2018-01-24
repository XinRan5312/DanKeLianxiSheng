package com.xinran.studyindanke.recylerview;

import android.support.annotation.IdRes;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by houqixin on 2018/1/23.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArrayCompat<View> mViews;
    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews=new SparseArrayCompat<>();
    }

    public <V extends View> V getViewById(@IdRes int id){
        View view=mViews.get(id);
        if(view==null){
            view=itemView.findViewById(id);
            mViews.put(id,view);
        }
        return (V) view;

    }
}
