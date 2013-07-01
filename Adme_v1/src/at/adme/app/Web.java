package at.adme.app;

import java.io.IOException;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.BasicResponseHandler;

import android.net.http.*;

public class Web {
	public static String getHerokuPosts(){
		//Instantiate client
		AndroidHttpClient client = AndroidHttpClient.newInstance("AdMe");
		
		//make the post request to get the login token
		HttpGet postRequest = new HttpGet("http://httpbin.org");
		System.out.println(postRequest.getURI());
		//postRequest.addHeader("email", "test@test.com");
		//postRequest.addHeader("password", "testing123");
		
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String response = "fail";
		try {
			response = client.execute(postRequest, responseHandler);
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String result = response.toString();
		
		return result;
		/*
		
			
		HttpGet request = new HttpGet("http://tomtesting.herokuapp.com");
		
		HttpResponse response = null;
		try{
			response = client.execute(request);
		}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
}
