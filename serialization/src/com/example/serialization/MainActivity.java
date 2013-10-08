package com.example.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i = new Intent(getApplicationContext(),SecondActivity.class);
				startActivity(i);
				
			}
		});
		
		
		
		Car mycar = new Car("Petrol", "Saztro", 1989);
		

		File myDir = new File(Constants.ROOTDIR + Constants.DIRNAME);    
	    myDir.mkdirs();
	    File file = new File (myDir, Constants.FILENAME);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(mycar);
			os.close();
			fos.close();
		} catch (FileNotFoundException e) {
			Toast.makeText(getApplicationContext(), "File Not Found !", Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "IO exception !", Toast.LENGTH_LONG).show();
		}
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
