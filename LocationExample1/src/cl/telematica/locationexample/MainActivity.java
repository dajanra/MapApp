package cl.telematica.locationexample;

import cl.telematica.locationexample.interfaces.LocationListenerHandler;
import cl.telematica.locationexample.location.ActiveLocationManagerActivity;


import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActiveLocationManagerActivity {
	
	public static String citylatitudText;
	public static String citylongitudText;
	public static TextView latitudText;
	public static TextView longitudText;
	public String locationSet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		Button b = (Button)findViewById(R.id.btnTestNoResults);
		Button c = (Button)findViewById(R.id.btnGPSSearch);
		Button d = (Button)findViewById(R.id.btnSetCity);
		Spinner spinner = (Spinner)findViewById(R.id.spinner1);
		final String locationSet = spinner.getSelectedItem().toString();
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, NoResults.class));
			};
		});
		c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//if ()
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, NewSearch.class));
			};
		});
		
		d.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if( locationSet == "Washington D.C.")
				{ citylatitudText = "38.9047 N";
				citylongitudText = "77.0164 W";
				}
				else if (locationSet == "Mansfield, PA")
				{citylatitudText = "41.8061 N";
				citylongitudText = "77.0756 W";			
				}
				else if (locationSet == "New York, NY")
				{citylatitudText = "40.7127� N";
				citylongitudText = "74.0059� W";			
				}
				else if (locationSet == "Juneau, AL")
				{citylatitudText = "58.3000� N";
				citylongitudText = "134.4167� W";			
				}
				else if (locationSet == "Phoenix, AZ")
				{citylatitudText = "33.4500� N";
				citylongitudText = "112.0667� W";			
				}
				else if (locationSet == "Tucson, AZ")
				{citylatitudText = "32.2217� N";
				citylongitudText = "110.9264� W";			
				}
				else if (locationSet == "Sacramento, CA")
				{citylatitudText = "38.5556� N";
				citylongitudText = "121.4689� W";			
				}
				else if (locationSet == "San Diego, CA")
				{citylatitudText = "32.7150� N";
				citylongitudText = "117.1625� W";			
				}
				else if (locationSet == "Los Angeles, CA")
				{citylatitudText = "34.0500� N";
				citylongitudText = "118.2500� W";			
				}
				else if (locationSet == "Denver, CO")
				{citylatitudText = "39.7392� N";
				citylongitudText = "104.9903� W";			
				}
				else if (locationSet == "Jacksonville, FL")
				{citylatitudText = "30.3369� N";
				citylongitudText = "81.6614� W";			
				}
				else if (locationSet == "Orlando, FL")
				{citylatitudText = "28.4158� N";
				citylongitudText = "81.2989� W";			
				}
				else if (locationSet == "Atlanta, GA")
				{citylatitudText = "33.7550� N";
				citylongitudText = "84.3900� W";			
				}
				else if (locationSet == "Boise, ID")
				{citylatitudText = "43.6167� N";
				citylongitudText = "116.2000� W";			
				}
				else if (locationSet == "Chicago, IL")
				{citylatitudText = "41.8369� N";
				citylongitudText = "87.6847� W";			
				}
				else if (locationSet == "Indianapolis, IN")
				{citylatitudText = "39.7910� N";
				citylongitudText = "86.1480� W";			
				}
				else if (locationSet == "Des Moines, IA")
				{citylatitudText = "41.5908� N";
				citylongitudText = "93.6208� W";			
				}
				else if (locationSet == "Kansas City, KS")
				{citylatitudText = "39.1067� N";
				citylongitudText = "94.6764� W";			
				}
				else if (locationSet == "Louisville, KY")
				{citylatitudText = "38.2500� N";
				citylongitudText = "85.7667� W";			
				}
				else if (locationSet == "New Orleans, LA")
				{citylatitudText = "29.9500� N";
				citylongitudText = "90.0667� W";			
				}
				else if (locationSet == "Portland, ME")
				{citylatitudText = "43.6667� N";
				citylongitudText = "70.2667� W";			
				}
				else if (locationSet == "Baltimore, MD")
				{citylatitudText = "39.2833� N";
				citylongitudText = "76.6167� W";			
				}
				else if (locationSet == "Boston, MA")
				{citylatitudText = "42.3601� N";
				citylongitudText = "71.0589� W";			
				}
				else if (locationSet == "Detroit, MI")
				{citylatitudText = "42.3314� N";
				citylongitudText = "83.0458� W";			
				}
				else if (locationSet == "Minneapolis, MN")
				{citylatitudText = "44.9778� N";
				citylongitudText = "93.2650� W";			
				}
				else if (locationSet == "Seattle, WA")
				{citylatitudText = "47.6097� N";
				citylongitudText = "122.3331� W";			
				}
				else
				{citylatitudText = "39.9500� N";
				citylongitudText = "75.1667� W";			
				}				
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, NewSearch.class));
			};
		});
		latitudText = (TextView) findViewById(R.id.textView4);
		longitudText = (TextView) findViewById(R.id.textView5);
		
		listener = new LocationListenerHandler() {
			@Override
			public void OnLocationReceived(Location loc) {
				latitudText.setText("" + loc.getLatitude());
				longitudText.setText("" + loc.getLongitude());
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
