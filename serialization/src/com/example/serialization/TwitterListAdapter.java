package com.example.serialization;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TwitterListAdapter extends MyListAdapter<String> {
	private Context myContext;
	private List<String> rows;
	public TwitterListAdapter(Context context, List<String> stringFeeds) {
		super(context,R.layout.list_row);
		myContext = context; 
		this.rows = stringFeeds;
	}
	
	@Override
	public int getCount() {
		return rows.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) myContext
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View itemview = convertView;
		if(itemview == null){
			itemview = inflater.inflate(R.layout.list_row, parent,false);
		}
		
		String s = rows.get(position);
		// Fill the View
		
		TextView title = (TextView) itemview.findViewById(R.id.list_row_title);
		title.setText(s);
		
		return itemview;
	}

}
