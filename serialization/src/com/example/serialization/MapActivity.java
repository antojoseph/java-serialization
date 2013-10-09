package com.example.serialization;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MapActivity extends Activity {
	private GoogleMap googleMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		  try {
	            // Loading map
	            initilizeMap();
	            placeMarker();
	            moveCamera();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}
	   /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

    public void placeMarker(){
    	// latitude and longitude
    	double latitude = 17.385044;
    	double longitude = 78.486671;
    	 
    	// create marker
    	MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Your Destination ! ");
    	 
    	// adding marker
    	googleMap.addMarker(marker);
    	

    }
    
    public void moveCamera(){
    	CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(17.385044, 78.486671)).zoom(12).build();
 
    			googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
    
}
