package com.xinran.studyindanke;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContAdapter extends BaseAdapter {
	private Context context;
	private Map<String, List<String>> map = new HashMap<String, List<String>>();

	public ContAdapter(Context context, Map<String, List<String>> map) {
		this.context = context;
		this.map = map;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return map.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HodeView hodeView=null;
		if(convertView==null){
			hodeView=new HodeView();
			convertView = View.inflate(context, R.layout.contlist, null);
			hodeView.gridView= (MyGridView) convertView.findViewById(R.id.gridView);
			hodeView.top=(TextView)convertView.findViewById(R.id.top);
			convertView.setTag(hodeView);
		}else{
			hodeView=(HodeView)convertView.getTag();
		}
		final GridViewAdapter adapter = new GridViewAdapter(context, map.get(String
				.valueOf(position)));
		hodeView.gridView.setAdapter(adapter);
		hodeView.top.setText("这是第"+position+"组Title");
		hodeView.gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(context, adapter.getItem(position),Toast.LENGTH_SHORT).show();
			}
		});
		return convertView;
	}

	class HodeView {
          public MyGridView gridView;
          public TextView top;
	}
}
