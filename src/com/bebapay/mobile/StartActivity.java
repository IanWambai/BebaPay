package com.bebapay.mobile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;

public class StartActivity extends SherlockActivity implements OnClickListener {

	Button bBebaPayLogo;
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.start_activity);
		getSupportActionBar().hide();
		setUp();
	}

	private void setUp() {
		// TODO Auto-generated method stub

		bBebaPayLogo = (Button) findViewById(R.id.bBebaPayLogo);
		bBebaPayLogo.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bBebaPayLogo:
			i = new Intent(getApplicationContext(), Dashboard.class);
			startActivity(i);
			break;

		}

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("Leave?");
		alertDialog.setMessage("Are you sure you want to leave?");
		alertDialog.setIcon(17301552);
		alertDialog.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						Process.killProcess(Process.myPid());
					}
				});
		alertDialog.setNegativeButton("No",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						paramAnonymousDialogInterface.dismiss();
					}
				});
		alertDialog.show();
	}

}
