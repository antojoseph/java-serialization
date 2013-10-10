package com.example.serialization;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/* *
		 * *
		 * Contact Button
		 * *
		 * */
		ImageButton contact_button = (ImageButton)findViewById(R.id.button_contact);
		contact_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),ContactActivity.class);
				startActivity(i);
			}
		});
		
		ImageButton twitter_button = (ImageButton)findViewById(R.id.button_twitter);
		twitter_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),TwitterActivity.class);
				String user = "rahules32";
				i.putExtra("user", user);
				startActivity(i);
			}
		});
		
		
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
