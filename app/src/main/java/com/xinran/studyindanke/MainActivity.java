package com.xinran.studyindanke;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
	private ListView caiDanListView, contentListView;
	private List<String> caiDanListData = new ArrayList<String>();
	private Map<String, List<String>> contentMapData = new HashMap<String, List<String>>();
	private ContAdapter contentAdapter;
    public static int position =0;
    private ListtitleAdapter caiDanAdapter;
    private int currentid =0;
	private RecyclerView mRecylerView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		caiDanListView = (ListView) findViewById(R.id.title);
		contentListView = (ListView) findViewById(R.id.content);
		for (int i = 0; i < 8; ++i) {
			caiDanListData.add("菜单"+i+"标题");
		}
		 caiDanAdapter = new ListtitleAdapter(this, caiDanListData);
		caiDanListView.setAdapter(caiDanAdapter);
		for (int k = 0; k < 8; k++) {
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < 8; j++) {
				list.add("第"+k+"组"+"第" + j+ "个");
			}
			contentMapData.put(String.valueOf(k), list);
		}
		contentAdapter = new ContAdapter(MainActivity.this, contentMapData);
		contentListView.setAdapter(contentAdapter);
		contentAdapter.notifyDataSetChanged();
		contentListView.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if(firstVisibleItem!= currentid){
					currentid =firstVisibleItem;
					if(currentid != position)
					position = currentid;
			        caiDanAdapter.notifyDataSetChanged();
				}
			}
		});
		
		caiDanListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				MainActivity.position =position;
				caiDanAdapter.notifyDataSetChanged();
				contentAdapter.notifyDataSetChanged();
				contentListView.setSelection(position);
				contentListView.smoothScrollToPositionFromTop(position, 0, 100);
			}
		});
	}
}
