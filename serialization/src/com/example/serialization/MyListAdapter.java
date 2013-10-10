package com.example.serialization;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyListAdapter<T> extends ArrayAdapter<T>{

	public MyListAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		
	}

}
