package at.adme.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.*;
import com.facebook.*;
import com.facebook.model.*;

public class FBLoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fblogin);
		
		Session.openActiveSession(this, true, new Session.StatusCallback() {
			
			@Override
			public void call(Session session, SessionState state, Exception exception) {
				if(session.isOpened()){
					// make request to the /me API
					Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

					// callback after Graph API response with user object
					@Override
					public void onCompleted(GraphUser user, Response response) {
						if (user != null) {
							TextView welcome = (TextView) findViewById(R.id.welcome);
							welcome.setText("Hello " + user.getName() + "!");
							}
					}
					});
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fblogin, menu);
		return true;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}

}
