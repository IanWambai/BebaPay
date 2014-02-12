package com.bebapay.mobile;

import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class RouteDisplay extends SherlockActivity {

	TextView tvRoute;
	String route;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.route_display);
		getData();
		setUp();
	}

	private void getData() {
		// TODO Auto-generated method stub
		Bundle b = getIntent().getExtras();
		route = b.getString("route");
	}

	private void setUp() {
		// TODO Auto-generated method stub
		tvRoute = (TextView) findViewById(R.id.tvRoute);
		tvRoute.setText(route);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
