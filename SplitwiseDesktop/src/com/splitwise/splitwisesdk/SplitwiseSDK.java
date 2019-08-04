package com.splitwise.splitwisesdk;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import com.splitwise.splitwisesdk.auth.OAuth;
import com.splitwise.splitwisesdk.responses.*;

public class SplitwiseSDK {
	private static SplitwiseSDK instance = null;
	// Register your app at https://secure.splitwise.com/apps/new and get API
	// Key
	private String consumerKey = "cCFUP5oGYVNJJAF9PlOR2qqBDcnzzEnPx5hofrh4";
	private String consumerSecret = "uwGfeBgdVlx2vAz4HwT3sPQgZ3Ib4PcYeZXyFiE2";
	private String accessToken = "";
	
	private OAuth oauth;
	
	// API URLS
	final private String SPLITWISE_BASE_URL = "https://secure.splitwise.com/";
	final private String SPLITWISE_VERSION  = "v3.0";

	//URLs to make the request
	final private String REQUEST_TOKEN_URL   = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_request_token";
	final private String ACCESS_TOKEN_URL    = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_access_token";
	final private String AUTHORIZE_URL       = SPLITWISE_BASE_URL+"authorize";
	
	// Harsh
	final private String GET_CURRENT_USER_URL= SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_current_user";
	final private String GET_USER_URL        = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_user";
	final private String GET_FRIENDS_URL     = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_friends";
	final private String GET_GROUPS_URL      = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_groups";
	final private String GET_GROUP_URL       = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_group";
	
	// Abhimanyu
	final private String GET_CURRENCY_URL    = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_currencies";
	final private String GET_CATEGORY_URL    = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_categories";
	final private String GET_EXPENSES_URL    = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_expenses";
	final private String GET_EXPENSE_URL     = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/get_expense";
	
	
	final private String CREATE_EXPENSE_URL  = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/create_expense";
	final private String CREATE_GROUP_URL    = SPLITWISE_BASE_URL+"api/"+SPLITWISE_VERSION+"/create_group";
	
	private SplitwiseSDK() {
		oauth = new OAuth(consumerKey,consumerSecret);
		oauth.setRequestTokenURL(this.REQUEST_TOKEN_URL);
		oauth.setAuthorizationURL(this.AUTHORIZE_URL);
		oauth.setAccessTokenURL(this.ACCESS_TOKEN_URL);
	}
	
	public static SplitwiseSDK getInstance() {
		if(instance == null) {
			instance = new SplitwiseSDK();
		}
		return instance;
	}

	public String getAuthorizationURL() {
		return oauth.getAuthorizationURL();
	}
	
	public String getAccessToken() {
		return oauth.getAccessToken();
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public void setOauthToken(String token) {
		oauth.setOauthToken(token);
	}
	
	public void setOauthTokenSecret(String token) {
		oauth.setOauthTokenSecret(token);
	}
	
	public String getOauthToken() {
		return oauth.getOauthToken();
	}
	
	public String getOauthTokenSecret() {
		return oauth.getOauthTokenSecret();
	}
	
	public void setOauthVerifier(String token) {
		oauth.setOauthVerifier(token);
	}
	
	public User getCurrentUser() {
		String response = "";
		response = oauth.request(GET_CURRENT_USER_URL);
		
		return new User(response);
	}
	
	public static void main(String args[]) {
		SplitwiseSDK sdk = SplitwiseSDK.getInstance();
		// Step 1: Execute and set oauth_token, oauth_token_secret from output.Get authorization url
		//System.out.println("Set oauth_token and oauth_token_secret in program");
		//System.out.println("Go to url: " + sdk.getAuthorizationURL());
		// Comment above lines
		
		// Step 2: Uncomment below, On the browser, after clicking on authorize copy oauth_verifier and paste it below
		/** /
		String oauth_token = "t8l1ophvezhxV2KAOC3aRFb36rOIDl2OGhe1h16N";
		String oauth_token_secret = "YeHkvmzc8t57Ftq4n2s8gd8fZMahBEUQIIzgcsMW";
		String oauth_verifier = "SQmyHFE4ScI2a0WvrQpA";
		
		sdk.setOauthToken(oauth_token);
		sdk.setOauthTokenSecret(oauth_token_secret);
		sdk.setOauthVerifier(oauth_verifier);
		System.out.println(sdk.getAccessToken());
		/**/
		// Copy oauth_token and oauth_token_secret from output and paste it below. Comment above lines
		
		//Step 3: Set access token and access token secret
		/**/
		String oauth_access_token = "DuRUarYgjBpOpjDDIyV7Oj1NQVpiDp0WL9Yc6CAg";
		String oauth_access_token_secret = "AcagAm8Xcizwbp5wWoCkFL5Ns0SaxNWDmi1yh7O3";
		sdk.setOauthToken(oauth_access_token);
		sdk.setOauthTokenSecret(oauth_access_token_secret);
		
		System.out.println(sdk.getCurrentUser());
		/**/
	}

}
