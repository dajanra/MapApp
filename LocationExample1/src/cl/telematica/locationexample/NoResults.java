package cl.telematica.locationexample;

import java.util.Random;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.Fragment;

public class NoResults extends Activity {
	private final LatLng LOCATION_ONE = new LatLng(34.0500, -118.2500);
	private LatLng RANDOM_LOCATION;
	private double randomLat, minLat, maxLat, randomLng, minLng, maxLng;
	
	Random randomDouble  = new Random();
	
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_no_results);
		Button b = (Button)findViewById(R.id.btnGPS);
		String selectedLocation = getIntent().getExtras().getString("key");
		
		minLat = MainActivity.citylatitudeText - 0.02;
		maxLat = MainActivity.citylatitudeText + 0.02;
		minLng = MainActivity.citylongitudeText - 0.02;
		maxLng = MainActivity.citylongitudeText + 0.02;
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(NoResults.this, MainActivity.class));
				
			};
		});
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		map.addMarker(new MarkerOptions().position(LOCATION_ONE).title("SEXY LOCATION NUMBER ONE"));
		
		for(int i=1; i<10; i++){
			randomLat = minLat + (maxLat - minLat) * randomDouble.nextDouble();
			randomLng = minLng + (maxLng - minLng)* randomDouble.nextDouble();
			RANDOM_LOCATION = new LatLng(randomLat, randomLng);
			map.addMarker(new MarkerOptions().position(RANDOM_LOCATION).title(selectedLocation));
		}
		

		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_ONE, 9);
		map.animateCamera(update);
	}
}


