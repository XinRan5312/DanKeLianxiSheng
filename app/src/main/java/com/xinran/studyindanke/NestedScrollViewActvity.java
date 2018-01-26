package com.xinran.studyindanke;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houqixin on 2018/1/26.
 */

public class NestedScrollViewActvity extends AppCompatActivity {

    private List<String> mList;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_metarial_nested_scrollview);
        inits();
    }

    private void inits() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        linearLayout= (LinearLayout) findViewById(R.id.ll_container);

        for (int i = 1; i < 20; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText("TAB" + i));
        }
        mList=createCaiDanData(0);
        for(String name:mList){
            TextView tv=new TextView(this);
            tv.setTextColor(Color.BLUE);
            tv.setText(name);
            linearLayout.addView(tv);
        }
        //TabLayout的切换监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                upDataUI(tab.getPosition());
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

    }

    private void upDataUI(int position) {
        mList=createCaiDanData(position);
        linearLayout.removeAllViews();

        for(String name:mList){
            TextView tv=new TextView(this);
            tv.setTextColor(Color.BLUE);
            tv.setText(name);
            linearLayout.addView(tv);
        }
    }

    private List<String> createCaiDanData(int n) {

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("菜单-" + i + " Tab-" + n);
        }
        return list;
    }
}
