package at.adme.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Events extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.events, menu);
		return true;
	}

	//Move to the Map view
	public void swapToMap(View view){
		Intent intent = new Intent(this, Map.class);
		startActivity(intent);
	}
	
	//Move to the Societies view
	public void swapToSocieties(View view){
		Intent intent = new Intent(this, Societies.class);
		startActivity(intent);
	}
	
	//Move to the News view
	public void swapToNews(View view){
		Intent intent = new Intent(this, News.class);
		startActivity(intent);
	}
}
