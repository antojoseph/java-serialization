package com.example.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Button createObj = (Button) findViewById(R.id.button1);
		createObj.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				createObj();
				
			}
		});
		
		Button viewSerizlizedStuff = (Button) findViewById(R.id.button2);
		viewSerizlizedStuff.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				readfromCache();
				
			}
		});
	}
		
	
public void createObj(){
	
    try
    {
       FileInputStream fileIn =  getApplicationContext().openFileInput("hello_file");
       Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
       ObjectInputStream in = new ObjectInputStream(fileIn);

       Car somecar =  (Car) in.readObject();
       
      Toast.makeText(getApplicationContext(), somecar.model, Toast.LENGTH_LONG).show();
      
      in.close();
      
    }catch(IOException i)
    {
    	Toast.makeText(getApplicationContext(),i.toString(), Toast.LENGTH_LONG).show();
    }catch(ClassNotFoundException c)
    {
    	Toast.makeText(getApplicationContext(), "Class Not Found !", Toast.LENGTH_LONG).show();
    }
	
}
	
	
	
public  void readfromCache(){
	String value = "";
	FileInputStream fis;
	try {
		fis = openFileInput("hello_file");
		byte[] input = new byte[fis.available()];
		while (fis.read(input) != -1) {
			value += new String(input);
		}

	} catch (FileNotFoundException e) {
		Toast.makeText(getApplicationContext(), "File Not Found", Toast.LENGTH_LONG).show();
	} catch (IOException e) {
		Toast.makeText(getApplicationContext(), "IO exception", Toast.LENGTH_LONG).show();
	}

	
	TextView t = (TextView) findViewById(R.id.textView1);
	t.setText(value);
	t.setMovementMethod(new ScrollingMovementMethod());
	

}

	

		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
