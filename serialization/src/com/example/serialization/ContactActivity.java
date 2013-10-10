package com.example.serialization;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		
		/*
		 * 
		 * Email Button
		 * 
		 * */
		Button email_button = (Button)findViewById(R.id.button_email);
		email_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 /* Create the Intent */
				Intent emailIntent = new Intent(Intent.ACTION_SEND,
						Uri.fromParts("mailto", "gnchyperion@live.com", null));
				/* Fill it with Data */
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
				/* Send it off to the Activity-Chooser */
				startActivity(Intent.createChooser(emailIntent, "Send mail..."));
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
		return true;
	}

}
