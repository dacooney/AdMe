package at.adme.app;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.Activity;
import android.os.Bundle;



public class Map extends Activity {
	private static final LatLng SU = new LatLng(53.344648,-6.258908);
	private static final LatLng DISABILITIES = new LatLng(53.343283,-6.257089);
	private static final LatLng CAS = new LatLng(53.341777,-6.253029);
	private static final LatLng HEALTH = new LatLng(53.34459,-6.253522);
	private static final LatLng CAMPSUPER = new LatLng(53.343267,-6.257395);
	private static final LatLng TREASURER = new LatLng(53.344478,-6.261317);
	private static final LatLng ISSSERV = new LatLng(53.34488,-6.255389);
	private static final LatLng ADM_RECS = new LatLng(53.344393,-6.258905);
	//private static final LatLng TRINITY = new LatLng(53.343,-6.254);
	private GoogleMap mMap = null;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(TRINITY, 14));
        this.mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        placeCollegeMarkers();
        
    }
    
    // Place markers for college services
    private void placeCollegeMarkers(){
    	this.mMap.addMarker(new MarkerOptions()
    		.position(ADM_RECS)
    		.title("Admissions and Student Records"));
    	this.mMap.addMarker(new MarkerOptions()
    		.position(ISSSERV)
    		.title("ISS Services"));
    	this.mMap.addMarker(new MarkerOptions()
        	.position(TREASURER)
        	.title("Treasurer's Office (Fees)"));
    	this.mMap.addMarker(new MarkerOptions()
        	.position(CAMPSUPER)
        	.title("Campus Superintendent (Lockers)"));
    	this.mMap.addMarker(new MarkerOptions()
        	.position(HEALTH)
        	.title("College Health Centre"));
    	this.mMap.addMarker(new MarkerOptions()
        	.position(CAS)
        	.title("Careers Advisory Service"));
    	this.mMap.addMarker(new MarkerOptions()
        	.position(DISABILITIES)
        	.title("Disabilities Services"));
    	this.mMap.addMarker(new MarkerOptions()
        	.position(SU)
        	.title("Students Union"));
    }
}