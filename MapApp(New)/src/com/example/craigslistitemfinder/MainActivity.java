package com.example.craigslistitemfinder;

import cl.telematica.locationexample.interfaces.LocationListenerHandler;
import cl.telematica.locationexample.location.ActiveLocationManagerActivity;

import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActiveLocationManagerActivity {

	public static String locationSet, yourLat, yourLong;
	public static TextView latitudeText, longitudeText;
	public static double gps_lat, gps_long;
	private Handler handler;
	private Runnable delayRunnable;
	public static double citylongitudeText, citylatitudeText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		
		Button useCurrentGPSBtn = (Button)findViewById(R.id.btnGPSSearch);
		Button useSelectedCityBtn = (Button)findViewById(R.id.btnSetCity);

		final Spinner spinner = (Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());

		useCurrentGPSBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Context context = getApplicationContext();
				citylatitudeText = 1000;
				citylongitudeText = 1000;
				CharSequence text = "GPS not yet retrieved, please click again";
				int duration = Toast.LENGTH_LONG;
				Toast toast = Toast.makeText(context, text, duration);
				//handler = new Handler();
				
				
				if(yourLat == null){
					toast.show();
				}else{
					Intent i = (new Intent(MainActivity.this, NewSearch.class));
					startActivity(i); 
				}
			}

		});
		

		useSelectedCityBtn.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View v) {
				// gives a GPS point for the center of the city chosen and assigns
				//it to the strings "citylatitudeText" and "citylongitudeText"
				locationSet = String.valueOf(spinner.getSelectedItem());
				if( locationSet.equals("Washington D.C.") )
				{ citylatitudeText = 38.9047;
				citylongitudeText = -77.0164;
				}
				else if (locationSet.equals("Mansfield, PA"))
				{citylatitudeText = 41.8061;
				citylongitudeText = -77.0756;			
				}
				else if (locationSet.equals( "New York, NY"))
				{citylatitudeText = 40.7127;
				citylongitudeText = -74.0059;			
				}
				else if (locationSet.equals( "Juneau, AL"))
				{citylatitudeText = 58.3000;
				citylongitudeText = -134.4167;			
				}
				else if (locationSet.equals("Phoenix, AZ"))
				{citylatitudeText = 33.4500;
				citylongitudeText = -112.0667;			
				}
				else if (locationSet.equals("Tucson, AZ"))
				{citylatitudeText = 32.2217;
				citylongitudeText = -110.9264;			
				}
				else if (locationSet.equals( "Sacramento, CA"))
				{citylatitudeText = 38.5556;
				citylongitudeText = -121.4689;			
				}
				else if (locationSet.equals("San Diego, CA"))
				{citylatitudeText = 32.7150;
				citylongitudeText = -117.1625;			
				}
				else if (locationSet.equals("Los Angeles, CA"))
				{citylatitudeText = 34.0500;
				citylongitudeText = -118.2500;			
				}
				else if (locationSet.equals("Denver, CO"))
				{citylatitudeText = 39.7392;
				citylongitudeText = -104.9903;			
				}
				else if (locationSet.equals("Jacksonville, FL"))
				{citylatitudeText = 30.3369;
				citylongitudeText = -81.6614;			
				}
				else if (locationSet.equals("Orlando, FL"))
				{citylatitudeText = 28.4158;
				citylongitudeText = -81.2989;			
				}
				else if (locationSet.equals("Atlanta, GA"))
				{citylatitudeText = 33.7550;
				citylongitudeText = -84.3900;			
				}
				else if (locationSet.equals("Boise, ID"))
				{citylatitudeText = 43.6167;
				citylongitudeText = -116.2000;			
				}
				else if (locationSet.equals("Chicago, IL"))
				{citylatitudeText = 41.8369;
				citylongitudeText = -87.6847;			
				}
				else if (locationSet.equals("Indianapolis, IN"))
				{citylatitudeText = 39.7910;
				citylongitudeText = -86.1480;			
				}
				else if (locationSet.equals("Des Moines, IA"))
				{citylatitudeText = 41.5908;
				citylongitudeText = -93.6208;			
				}
				else if (locationSet.equals("Kansas City, KS"))
				{citylatitudeText = 39.1067;
				citylongitudeText = -94.6764;			
				}
				else if (locationSet.equals("Louisville, KY"))
				{citylatitudeText = 38.2500;
				citylongitudeText = -85.7667;			
				}
				else if (locationSet.equals("New Orleans, LA"))
				{citylatitudeText = 29.9500;
				citylongitudeText = -90.0667;			
				}
				else if (locationSet.equals("Portland, ME"))
				{citylatitudeText = 43.6667;
				citylongitudeText = -70.2667;			
				}
				else if (locationSet.equals("Baltimore, MD"))
				{citylatitudeText = 39.2833;
				citylongitudeText = -76.6167;			
				}
				else if (locationSet.equals("Boston, MA"))
				{citylatitudeText = 42.3601;
				citylongitudeText = -71.0589;			
				}
				else if (locationSet.equals("Detroit, MI"))
				{citylatitudeText = 42.3314;
				citylongitudeText = -83.0458;			
				}
				else if (locationSet.equals("Minneapolis, MN"))
				{citylatitudeText = 44.9778;
				citylongitudeText = -93.2650;			
				}
				else if (locationSet.equals("Seattle, WA"))
				{citylatitudeText = 47.6097;
				citylongitudeText = -122.3331;			
				}
				else
				{citylatitudeText = 39.9500;
				citylongitudeText = -75.1667;			
				}				
				
				
				Context context = getApplicationContext();
				CharSequence text = "Your current GPS not yet retrieved, please click again";
				int duration = Toast.LENGTH_LONG;

				Toast toast = Toast.makeText(context, text, duration);
				
				if(yourLat == null){
					toast.show();
				}else{
					Intent i = (new Intent(MainActivity.this, NewSearch.class));
					startActivity(i); 
				}
				
			};				
		});
		//Determines the current GPS location of the device running the app.
		latitudeText = (TextView) findViewById(R.id.latText);
		longitudeText = (TextView) findViewById(R.id.longText);
		

		listener = new LocationListenerHandler() {
			@Override
			public void OnLocationReceived(Location loc) {
				latitudeText.setText(""+ loc.getLatitude());
				longitudeText.setText("" + loc.getLongitude());
				yourLat = latitudeText.getText().toString();
				yourLong = longitudeText.getText().toString();
				
			}
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
