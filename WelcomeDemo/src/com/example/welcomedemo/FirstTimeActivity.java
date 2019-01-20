package com.example.welcomedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.welcomedemo.adapter.PicAdapter;
import com.example.welcomedemo.listener.ToMainActivityListener;
import com.example.welcomedemo.view.CircleFlowIndicator;
import com.example.welcomedemo.view.ViewFlow;

public class FirstTimeActivity extends Activity{
	private ViewFlow viewFlow;
	private ToMainActivityListener listener = new ToMainActivityListener() {
		
		@Override
		public void toMain() {
			// TODO 自动生成的方法存根
			startActivity(new Intent(FirstTimeActivity.this, MainActivity.class));
			finish();
		}
	};
	public int[] pics = { R.drawable.first_time_post_1, R.drawable.first_time_post_2, R.drawable.first_time_post_3, R.drawable.first_time_post_4 };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_first);
		viewFlow = (ViewFlow) findViewById(R.id.viewflow);
		viewFlow.setAdapter(new PicAdapter(this,pics,listener));
		viewFlow.setmSideBuffer(pics.length);
		CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
		viewFlow.setFlowIndicator(indic);
		viewFlow.setSelection(0);
	}

}
