package com.bebapay.mobile;

import android.content.Intent;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.viewpagerindicator.CirclePageIndicator;

public abstract class BaseActivity extends SherlockFragmentActivity {

	FragmentAdapter mAdapter;
	ViewPager mPager;
	CirclePageIndicator mIndicator;
	Intent i;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.dashboard_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.mAbout:
			i = new Intent(getApplicationContext(), About.class);
			startActivity(i);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
