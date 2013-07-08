package at.adme.app;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;
import android.net.http.*;

public class Web {
	public static String[] getHerokuPosts(){
		//get the authentication token
		String token = getAuthToken();
		
		//Instantiate client
		AndroidHttpClient client = AndroidHttpClient.newInstance("AdMe");
		
		//TEST
		//HttpGet postRequest = new HttpGet("http://httpbin.org/get");
		
		//create the uri for the posts
		String url = "http://tomtesting.herokuapp.com/posts.json?auth_token="+token;
		
		//make the post request to get the login token
		HttpGet postRequest = new HttpGet(url);
		//DEBUG
		System.out.println(postRequest.getURI());
		
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
		String value = response.toString();
		
		//parse the result
		JSONArray arr = null;
		String text = null;
		JSONObject obj = null;
		String[] result = null;
		try {
			arr = (JSONArray) new JSONTokener(value).nextValue();
			result = new String[arr.length()];
			for(int i = 0; i < arr.length(); i++){
				obj = arr.getJSONObject(i);
				result[i] = obj.getString("content");
				System.out.println(result[i]);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String posts = token;
		return result;
	}
	
	//gets an auth token from the heroku server and returns it as a string
	public static String getAuthToken(){
		//generate the json
		JSONObject content = new JSONObject();
		try {
			content.put("email", "test@test.com");
			content.put("password", "testing123");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//make string entity for json object
		StringEntity se = null;
		try {
			se = new StringEntity(content.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Instantiate client
		AndroidHttpClient client = AndroidHttpClient.newInstance("AdMe");
		
		//make the post request to get the login token
		HttpPost postRequest = new HttpPost("http://tomtesting.herokuapp.com/api/v1/tokens.json");
		
		//add the string entity
		postRequest.setEntity(se);
		
		//Declare the json
		postRequest.addHeader("Content-Type", "application/json");
		
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
		
		//parse the result
		JSONObject obj = null;
		String token = null; 
		try {
			obj = (JSONObject) new JSONTokener(result).nextValue();
			token = obj.getString("token");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return token;
	}
}
