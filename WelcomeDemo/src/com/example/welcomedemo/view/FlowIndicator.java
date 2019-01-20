package com.example.welcomedemo.view;

import com.example.welcomedemo.view.ViewFlow.ViewSwitchListener;
public interface FlowIndicator extends ViewSwitchListener {

	public void setViewFlow(ViewFlow view);
	public void onScrolled(int h, int v, int oldh, int oldv);
}
