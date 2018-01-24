package com.xinran.studyindanke.recylerview;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.xinran.studyindanke.R;

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
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.title;
    }

    @Override
    protected void onBindedViewHolder(final BaseViewHolder holder, final int position, String bean) {

        if (!TextUtils.isEmpty(bean)) {
            final TextView title = holder.getViewById(R.id.tv_id);
            title.setText(bean);
            if(position==RecylerViewActvity.mSelectedPoint){
                title.setBackgroundColor(Color.BLUE);
            }else{
                title.setBackgroundColor(Color.WHITE);
            }
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag= (int) v.getTag();
                    if(tag==position&&mCaiDanItemClickListener!=null){
                        int[] location = new int[2];
                        v.getLocationOnScreen(location);
                        int x=location[0];
                        int y=location[1];
                        int w=v.getWidth();
                        mCaiDanItemClickListener.onCaiDanItemClick(position,w,y);
                    }

                }
            });
        }

    }
    private OnCaiDanItemClickListener mCaiDanItemClickListener;
    public void setCaiDanItemClickListener(OnCaiDanItemClickListener caiDanItemClickListener){
        this.mCaiDanItemClickListener=caiDanItemClickListener;

    }
    public interface OnCaiDanItemClickListener{
        void onCaiDanItemClick(int position,int w,int y);

    }
}
