package com.bebapay.mobile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

public class StatisticsToday extends SherlockActivity {

	String message;
	ArrayList<String> bebaPayTexts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics_today);

		setUp();
		// readSms();
		// textAnalysis();
	}

	private void setUp() {
		// TODO Auto-generated method stub

	}

	private void readSms() {
		// TODO Auto-generated method stub
		bebaPayTexts = new ArrayList<String>();

		Cursor cursor = getContentResolver().query(
				Uri.parse("content://sms/inbox"), null, null, null, null);
		cursor.moveToFirst();

		String date = cursor.getString(cursor.getColumnIndex("date"));
		Long timestamp = Long.parseLong(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp);
		Date finaldate = calendar.getTime();
		String smsDate = finaldate.toString();

		Toast.makeText(getApplicationContext(), "smsDate: " + smsDate,
				Toast.LENGTH_LONG).show();

		do {
			message = "";
			for (int idx = 0; idx < cursor.getColumnCount(); idx++) {
				message = cursor.getColumnName(idx) + ": "
						+ cursor.getString(idx) + ": " + smsDate;
				if (message.contains("BebaPay Reciept:")) {
					bebaPayTexts.add(message);
				}
			}
		} while (cursor.moveToNext());
	}

	private void textAnalysis() {
		// TODO Auto-generated method stub
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		Toast.makeText(getApplicationContext(), "date: " + date,
				Toast.LENGTH_LONG).show();
		for (int i = 0; i < bebaPayTexts.size(); i++) {
			if (bebaPayTexts.get(i).contains(date)) {
			}
		}
	}

}
