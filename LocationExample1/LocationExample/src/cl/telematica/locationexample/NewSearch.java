package cl.telematica.locationexample;

import android.os.Bundle;
import android.widget.TextView;
import cl.telematica.locationexample.location.ActiveLocationManagerActivity;

public class NewSearch extends ActiveLocationManagerActivity {
	
	public TextView citylat;
	public TextView citylong;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_search);
		citylat = (TextView) findViewById(R.id.textView4);
		citylong = (TextView) findViewById(R.id.textView5);
		citylat.setText(""+ MainActivity.citylatitudText);
		citylong.setText("" + MainActivity.citylatitudText);
		
	}

}
