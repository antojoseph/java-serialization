package com.example.cachmeh;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static final String DEBUG_TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		enableHttpCaching();
		getdatafromInternet task = new getdatafromInternet();
		task.execute();
	}
	
	private void enableHttpCaching()
    {
		final long httpCacheSize = 10 * 1024 * 1024; // 10 MiB
		final File httpCacheDir = new File(getCacheDir(), "http");
		try {
			com.integralblue.httpresponsecache.HttpResponseCache.install(httpCacheDir, httpCacheSize);
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), e.toString(),Toast.LENGTH_LONG).show();
		}
    }
	
	

	public class getdatafromInternet extends AsyncTask<Void, Void, String> {

		String responseData;

		@Override
		protected String doInBackground(Void... params) {

			URL blogFeedUrl;
			try {
				blogFeedUrl = new URL(
						"http://blog.teamtreehouse.com/api/get_recent_summary/?count=20");
				HttpURLConnection connection = (HttpURLConnection) blogFeedUrl
						.openConnection();
				connection.connect();

				InputStream inputStream = connection.getInputStream();
				Reader reader = new InputStreamReader(inputStream);
				int contentLength = connection.getContentLength();
				char[] charArray = new char[contentLength];
				reader.read(charArray);
				responseData = new String(charArray);
			} catch (MalformedURLException e) {
				Log.v(DEBUG_TAG, e.toString());
			} catch (IOException e) {
				Log.v(DEBUG_TAG, e.toString());
			}
			return responseData;

		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
		}

	}
}
