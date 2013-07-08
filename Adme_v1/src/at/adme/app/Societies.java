package at.adme.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import at.adme.app.R;

public class Societies extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_societies);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
    //Move to the News view
    public void swapToNews(View view){
		Intent intent = new Intent(this, News.class);
		startActivity(intent);
	}
    
	//Move to the Events view
	public void swapToEvents(View view){
		Intent intent = new Intent(this, Events.class);
		startActivity(intent);
	}
	
	//Move to the Map view
	public void swapToMap(View view){
		Intent intent = new Intent(this, Map.class);
		startActivity(intent);
	}
}
