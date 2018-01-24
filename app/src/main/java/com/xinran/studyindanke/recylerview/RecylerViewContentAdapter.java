package com.xinran.studyindanke.recylerview;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.xinran.studyindanke.GridViewAdapter;
import com.xinran.studyindanke.MyGridView;
import com.xinran.studyindanke.R;

import java.util.List;
import java.util.Map;

/**
 * Created by houqixin on 2018/1/24.
 */

public class RecylerViewContentAdapter extends BaseMapListDataAdapter<String> {
    private Context mContent;

    public RecylerViewContentAdapter(Map<String, List<String>> map, Context context) {
        super(map);
        this.mContent = context;
    }


    @Override
    protected void onViewHolderCreated(BaseViewHolder holder) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.contlist;
    }

    @Override
    protected void onBindedViewHolder(BaseViewHolder holder, final int position, final List<String> bean) {
        if (bean != null && bean.size() > 0) {
            TextView topTile = holder.getViewById(R.id.top);
            final MyGridView gridView = holder.getViewById(R.id.gridView);

            topTile.setText("第" + position + "Title");
            GridViewAdapter gridViewAdapter = new GridViewAdapter(mContent, bean);
            gridView.setAdapter(gridViewAdapter);
            gridView.setTag(position);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                    int tag = (int) gridView.getTag();
                    if (tag == position) {
                        Toast.makeText(mContent,"点击了："+ bean.get(index), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

    }
}
