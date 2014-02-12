package com.bebapay.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

public class Dashboard extends BaseActivity implements OnClickListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		setAdapter();
	}

	public void initPagerView(int position, View view) {

		switch (position) {
		case 0:
			Button bUserInformation;
			bUserInformation = (Button) findViewById(R.id.bUserData);
			bUserInformation.setOnClickListener(this);
			break;
		case 1:
			Button bRouteInformation;
			bRouteInformation = (Button) findViewById(R.id.bRouteData);
			bRouteInformation.setOnClickListener(this);
			break;

		}
	}

	private void setAdapter() {
		// TODO Auto-generated method stub
		FragmentAdapter adapter = new FragmentAdapter(Dashboard.this);

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(adapter);
		mPager.setCurrentItem(0);

		mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bUserData:
			i = new Intent(getApplicationContext(), UserData.class);
			startActivity(i);
			break;
		case R.id.bRouteData:
			i = new Intent(getApplicationContext(), RouteData.class);
			startActivity(i);
			break;

		}

	}

}