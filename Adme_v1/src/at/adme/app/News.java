package at.adme.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
			RelativeLayout newsItem = new RelativeLayout(this);
			
			//create a TextView from the string
			TextView text = new TextView(this);
			text.setText(item);
			//TODO edit the view attributes
			
			//TODO add an image and signature
			
			newsItem.addView(text);
			newsLayout.addView(newsItem);
		}
		return true;
	}

}
