package com.example.welcomedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.welcomedemo.R;
import com.example.welcomedemo.listener.ToMainActivityListener;

public class PicAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private Context context;
	private int[] pics;
	private ToMainActivityListener listener;
	public PicAdapter(Context context,int[] pics,ToMainActivityListener listener) {
		this.context = context;
		this.pics = pics;
		this.listener = listener;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return pics.length; 
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.image_item, null);
		}

		((ImageView) convertView.findViewById(R.id.imgView)).setImageResource(pics[position % pics.length]);
		if (position == pics.length-1) {
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if(listener!=null){
						listener.toMain();
					}
				}
			});
		}
		return convertView;
	}
}
