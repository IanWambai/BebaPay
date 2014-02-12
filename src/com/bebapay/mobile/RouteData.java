package com.bebapay.mobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockActivity;

public class RouteData extends SherlockActivity {

	EditText etFrom, etTo;
	Button bSearch;
	String from, to, route;
	AsyncTask<String, Void, String> searchTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.route_data);
		setUp();
	}

	private void setUp() {
		// TODO Auto-generated method stub
		etFrom = (EditText) findViewById(R.id.etRouteFrom);
		etTo = (EditText) findViewById(R.id.etRouteTo);
		bSearch = (Button) findViewById(R.id.bRouteSearch);
		bSearch.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				from = etFrom.getText().toString();
				to = etTo.getText().toString();

				Boolean search = false;

				if (from.length() < 2) {
					etFrom.setError("Please enter a proper location name");
					search = false;
				} else {
					etFrom.setError(null);
					search = true;
				}
				if (to.length() < 2) {
					etTo.setError("Please enter a proper destination name");
					search = false;
				} else {
					etTo.setError(null);
					search = true;
				}

				if (search == true) {
					searchTask = new SearchRoute().execute();
				}

			}
		});
	}

	private class SearchRoute extends AsyncTask<String, Void, String> {
		ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			pDialog = new ProgressDialog(RouteData.this);
			pDialog.setMessage("Searching...");
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			
			try {
				synchronized (pDialog) {
					pDialog.wait(3000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			route = "You'll have to fly there";
			Intent i = new Intent(getApplicationContext(), RouteDisplay.class);
			Bundle b = new Bundle();
			b.putString("route", route);
			i.putExtras(b);
			startActivity(i);
			return null;
		}

		protected void onPostExecute(String params) {
			super.onPostExecute(params);

			pDialog.dismiss();

		}
	}

}
