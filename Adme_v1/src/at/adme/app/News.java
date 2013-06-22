package at.adme.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import at.adme.app.R;

public class News extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		
		loadNewsItems();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news, menu);
		return true;
	}
	
	//Swap to the Societies Activity
	public void swapToSocieties(View view){
		Intent intent = new Intent(this, Societies.class);
		startActivity(intent);
	}
	
	private boolean loadNewsItems(){
		//get the layout to put the news items in
		LinearLayout newsLayout = (LinearLayout) findViewById(R.id.newsItemView);
		
		//load the resources object
		Resources res = getResources();
		
		//get the array of news items
		String[] news_items = res.getStringArray(R.array.news_items);
		
		//create a view for each news item and add it to the layout
		for(String item:news_items){
			//create the layout
			LinearLayout newsItem = new LinearLayout(this);
			newsItem.setOrientation(1);
			
			//add an ImageView
			ImageView image = new ImageView(this);
			image.setImageResource(R.drawable.ic_launcher);
			newsItem.addView(image);
			
			//create a TextView from the string
			TextView text = new TextView(this);
			text.setText(item);
			newsItem.addView(text);
			
			//add a signature TextView
			TextView signature = new TextView(this);
			text.setText("signature");
			//Typeface tf = ;
			//text.setTypeface(tf);
			newsItem.addView(signature);
			
			//TODO edit the view attributes
			
			//TODO add an image and signature
			
			newsLayout.addView(newsItem);
		}
		return true;
	}
	
	public void swapToMap(View view){
		Intent intent = new Intent(this, Map.class);
		startActivity(intent);
	}

}
