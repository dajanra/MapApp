package cl.telematica.locationexample;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import cl.telematica.locationexample.interfaces.LocationListenerHandler;
import cl.telematica.locationexample.location.ActiveLocationManagerActivity;

public class NewSearch extends ActiveLocationManagerActivity {

	public TextView citylat;
	public TextView citylong;
	public TextView gpslat;
	public TextView gpslong;
	public static ArrayList<String> phoneList = new ArrayList<>();
	public static ArrayList<String> laptopList = new ArrayList<>();
	public static ArrayList<String> desktopList = new ArrayList<>();
	public static ArrayList<String> carList = new ArrayList<>();
	public static ArrayList<String> dvdList = new ArrayList<>();
	public static ArrayList<String> consoleList = new ArrayList<>();

	public static String[] phones ={"iPhone 5s", "iPhone 6", "iPhone 6s",
		"Galaxy s5", "Galaxy s6", "Galaxy Note 3", "Galaxy Note 4", "LG g3",
		"Samsung Centura", "iPhone 4", "Droid Max"}; 

	public static String[] laptops ={"Toshiba Radius", "HP Stream", "Dell Latitude", 
		"HP Envy", "Apple Macbook Pro","Apple Macbook Air", "Lenovo g50", "HP Pavillion",
		"Dell Studio 17", "Toshiba Satellite", "Asus Zenbook", }; 

	public static String[] desktops ={"Dell Inspiron", "Dell Optiplex", "HP 280", 
		"Apple iMac", "Vostro 220", "Lenovo 7373", "Dell 380", "HP DC5800", 
		"Apple Mac Mini", "Lenovo H50", "Lenovo M70"}; 

	public static String[] cars ={"Chevy Malibu", "Dodge Neon", "Ford Mustang", 
		"Toyota Camry",	"Hyundai Accent", "Honda Civic", "Chrysler Sebring Lxi", 
		"Jeep Grand Cherokee", "Audi R8", "Ford F150", "Chevy Equinox" };  

	public static String[] consoles ={"Xbox One", "PS4", "PS3", "Xbox 360", 
		"Wii", "Gameboy 3DS", "NES", "Sega Genesis", "GameBoy Color", 
		"Playstation Vita", "PSP"}; 

	public static String[] dvds ={"Magic Mike","Saving Private Ryan", "Iron Man",
		"Hitch", "Milk", "Fight Club", "Saving Private Ryan", "Avengers", "Big Hero 6", 
		"MegaMind", "Rent"}; 

	public static int[] priceOfPhones={250, 300, 325, 350, 375, 400, 450, 475, 500, 550, 600};
	public static int[] priceOfLaptops={250, 300, 699, 350, 799, 400, 450, 475, 500, 550, 600};
	public static int[] priceOfDesktops={50, 75, 99, 100, 125, 110, 150, 200, 250, 300, 325};
	public static int[] priceOfCars={1500, 2500, 3000, 3250, 3500, 4000, 4500, 4750,  5500, 6000, 10000};
	public static int[] priceOfConsoles={80, 150, 100, 250, 300, 325, 350, 375, 400, 99, 125};
	public static int[] priceOfDvds={5, 9, 10, 12, 15, 20, 1, 3, 4, 7, 11};
	public static int i;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_search);

		gpslat = (TextView) findViewById(R.id.yourLat);
		gpslong = (TextView) findViewById(R.id.yourLong);
		gpslat.setText("" + MainActivity.yourLat);
		gpslong.setText("" + MainActivity.yourLong);

		citylat = (TextView) findViewById(R.id.cityLong);
		citylong = (TextView) findViewById(R.id.cityLat);
		citylat.setText("City Latitude: "+ MainActivity.citylatitudeText);
		citylong.setText("City Longitude: " + MainActivity.citylongitudeText);


		Random randomNumber = new Random();
		int howMany = randomNumber.nextInt(20);
		String holding, itemGps;	

		for (i=0; i <= howMany; i++){
			int itemRandNum = randomNumber.nextInt(11);//for all Item Categories
			int priceRandNum = randomNumber.nextInt(11);//Prices for all categories

			holding = phones[itemRandNum]+" $"+ priceOfPhones[priceRandNum];
			//itemGps = 
			phoneList.add(holding);
			//phoneList.add(itemGps);

			holding = laptops[itemRandNum]+" $"+ priceOfLaptops[priceRandNum]; 
			laptopList.add(holding);

			holding = desktops[itemRandNum]+" $"+ priceOfDesktops[priceRandNum]; 
			desktopList.add(holding);

			holding = cars[itemRandNum]+" $"+ priceOfCars[priceRandNum]; 
			carList.add(holding);

			holding = dvds[itemRandNum]+" $"+ priceOfDvds[priceRandNum]; 
			dvdList.add(holding);

			holding = consoles[itemRandNum]+" $"+ priceOfConsoles[priceRandNum]; 
			consoleList.add(holding);


		}

		/*System.out.println(phoneList);
		System.out.println(howMany);
		System.out.println(laptopList);
		System.out.println(desktopList);
		System.out.println(carList);
		System.out.println(dvdList);
		System.out.println(consoleList);*/
	//	latitudeText.setText("Your Latitude: " + loc.getLatitude());
		//latitudeText = (TextView) findViewById(R.id.latText);
	}


}
