package com.javacodegeeks.android.androidsmsexample;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button button;
	EditText editPhoneNum;
	EditText editSMS;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button = (Button) findViewById(R.id.button);
		editPhoneNum = (EditText) findViewById(R.id.editPhoneNum);
		editSMS = (EditText) findViewById(R.id.editSMS);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String phoneNo = editPhoneNum.getText().toString();
				String sms = editSMS.getText().toString();

				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(phoneNo, null, sms, null, null);
					Toast.makeText(getApplicationContext(), "SMS Sent!",
							Toast.LENGTH_LONG).show();
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"SMS faild, please try again later!",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}

			}
		});
	}
}