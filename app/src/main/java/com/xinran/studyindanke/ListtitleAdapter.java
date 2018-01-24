package com.xinran.studyindanke;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListtitleAdapter extends BaseAdapter {
	private Context context;
	private List<String> list = new ArrayList<String>();

	public ListtitleAdapter(Context context, List<String> list) {
		this.context = context;
		this.list = list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=View.inflate(context, R.layout.title, null);
		TextView view2=(TextView)view.findViewById(R.id.tv_id);
		view2.setText(list.get(position));
		if(position==MainActivity.position){
			view.setBackgroundColor(Color.CYAN);
		}
		return view;
	}

}
