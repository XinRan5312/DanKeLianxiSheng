package com.xinran.studyindanke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.xinran.studyindanke.recylerview.RecylerViewCaiDanAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houqixin on 2018/1/25.
 */

public class MetarialDesignActvity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private List<String> mList;
    private RecylerViewCaiDanAdapter mAdapter;

    /**
     * 这里还得提醒一下,由于我们使用了ToolBar来替换系统默认的ActionBar,所以必须要在
     * /res/values/style.xml中配置隐藏ActionBar和title.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_metarial_design);
        inits();
    }

    private void inits() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        for (int i = 1; i < 20; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText("TAB" + i));
        }
        //TabLayout的切换监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                  mAdapter.setData(createCaiDanData(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.e("TAB-Unselected",tab.getText().toString());

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.e("TAB-Reselected",tab.getText().toString());
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mList=createCaiDanData(0);
        mAdapter=new RecylerViewCaiDanAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<String> createCaiDanData(int n) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("菜单-" + i + " Tab-" + n);
        }
        return list;
    }
}
