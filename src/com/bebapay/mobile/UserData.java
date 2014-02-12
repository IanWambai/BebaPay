package com.bebapay.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;

public class UserData extends SherlockActivity implements OnClickListener {

	Button bHistory, bToday, bMonth, bAllTime;
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_data);
		setUp();
	}

	private void setUp() {
		// TODO Auto-generated method stub
		bHistory = (Button) findViewById(R.id.bUserHistory);
		bHistory.setOnClickListener(this);
		bToday = (Button) findViewById(R.id.bStatsToday);
		bToday.setOnClickListener(this);
		bMonth = (Button) findViewById(R.id.bStatsMonth);
		bMonth.setOnClickListener(this);
		bAllTime = (Button) findViewById(R.id.bStatsAllTime);
		bAllTime.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bUserHistory:
			BarGraph bar = new BarGraph();
			i = bar.getIntent(getApplicationContext());
			startActivity(i);
			break;
		case R.id.bStatsToday:
			i = new Intent(getApplicationContext(), StatisticsToday.class);
			startActivity(i);
			break;
		case R.id.bStatsMonth:
			i = new Intent(getApplicationContext(), StatisticsMonth.class);
			startActivity(i);
			break;
		case R.id.bStatsAllTime:
			i = new Intent(getApplicationContext(), StatisticsAllTime.class);
			startActivity(i);
			break;
		}
	}

}
