package at.adme.app;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.Activity;
import android.os.Bundle;



public class Map extends Activity {
	private static final LatLng TRINITY = new LatLng(53.343,-6.254);
	
	
	//private GoogleMap map = this.getMap();
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(TRINITY, 14));
        
    }
}