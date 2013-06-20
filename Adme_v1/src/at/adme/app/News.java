package at.adme.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.*;
import at.adme.app.R;

public class News extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		
		//get the layout the view will sit in
		LinearLayout newsLayout = (LinearLayout) findViewById(R.id.newsItemView);
		
		//create the view
		RelativeLayout newsItem = new RelativeLayout(this);
		TextView text = new TextView(this);
		text.setText("Test text");
		
		newsItem.addView(text);
		newsLayout.addView(newsItem);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news, menu);
		return true;
	}

}
