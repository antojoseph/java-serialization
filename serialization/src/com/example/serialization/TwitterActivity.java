package com.example.serialization;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class TwitterActivity extends Activity{
	private ConfigurationBuilder    cb;
	private Twitter                 twitter;
	private TwitterFactory          tf;
	private List<twitter4j.Status> feeds;
	private ListView list_tweets;
	private TextView page_title;
	String user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_twitter);	
		
		list_tweets = (ListView)findViewById(R.id.tweets_list);
		page_title = (TextView)findViewById(R.id.twitter_activity_title);
		
		Intent i = getIntent();
		user = i.getStringExtra("user");
		
		TwitterFeeds tfeed = new TwitterFeeds();
		tfeed.execute();
		
	}
	
	private class TwitterFeeds extends AsyncTask<String, Void, String>{
		
		@Override
		protected void onPreExecute(){
			page_title.setText("Loading Tweets");
		}

		@Override
		protected String doInBackground(String... params) {
			
			cb = new ConfigurationBuilder();
		    cb.setOAuthConsumerKey("OpxulQvQRpyenFkqevqakg")
		    	.setOAuthConsumerSecret("VInBUY1nDlZ6n7VGJvbx27sg4tyQo2NJIPJlQD4UD8")
		    	.setApplicationOnlyAuthEnabled(true); 
		    tf = new TwitterFactory(cb.build());
		    twitter = tf.getInstance();

		    OAuth2Token token = null;
			try {
				token = twitter.getOAuth2Token();
			} catch (TwitterException e) {
				e.printStackTrace();
			}
		    if (token != null) {
		        Log.d("","Token Type  : " + token.getTokenType());
		        Log.d("","Access Token: " + token.getAccessToken());
		    }
		    try {
		    	if(user!=null){
		    		feeds = twitter.getUserTimeline(user);
		    	}
		    	else{
		    		feeds = twitter.getUserTimeline("twitter");
		    	}
			} catch (TwitterException e) {
				Log.d("Errrororor",e.getErrorMessage());
				feeds=null;
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String result){
			
			Log.d("ASYNCTASK","COMPLETED EVERYTHING");
			page_title.setText("Latest Tweets @" + user);
		
			
			if(feeds!=null){
				List<String> stringFeeds = new ArrayList<String>();
				for (int i = 0; i < feeds.size(); i++) {
					Log.d("STATUS",feeds.get(i).getText());
					stringFeeds.add(feeds.get(i).getText());
				}
//				ArrayAdapter<String> tweetsAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_row,stringFeeds);
				TwitterListAdapter tweetsAdapter = new TwitterListAdapter(getApplicationContext(), stringFeeds);
				list_tweets.setAdapter(tweetsAdapter);
				
			}else{
				Log.d("TASTTTT","ERRRORORORO");
			}
			
		}
		
		
	}
}