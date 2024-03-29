/*
 * Oauth.java: Handles OAuth authentication
 */
package com.splitwise.splitwisesdk.auth;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/*
 * Following JAR files must be added to class path:
 * commons-codec-1.11.jar
 * httpclient-4.5.7.jar
 * httpcore-4.4.11.jar
 */

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import com.splitwise.splitwisesdk.Http;

public class OAuth {
	private String consumerKey;
	private String consumerSecret;
	private String oauth_token;
	private String oauth_token_secret;
	private String oauth_verifier;
	
	protected String requestTokenUrl;
	protected String accessTokenUrl;
	protected String authorizeUrl;
	
	private static int maxRetries = 3;
	
	public OAuth(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.oauth_token_secret = "";
	}
	
	/*
	 * getAuthoriationURL : Returns authorization url which is used to get access
	 * token
	 */
	public String getAuthorizationURL() {
		String authorizationURL = "";
		
		if(oauth_token == null) {
			// Generate Request
			OAuthRequest req = new OAuthRequest();
			req.setConsumerKey(consumerKey);
			req.setEndpoint(requestTokenUrl);
			req.setMethod("POST");
			
			hmac_sha1_sign(req);
			
			String body = req.getRequestBody();
			//System.out.println(body);
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type","application/x-www-form-urlencoded");
			
			String response = Http.sendPostRequest(req.getEndpoint(), headers, body);
			//System.out.println("Response :" + response);
			String[] rArr = response.split("&");
			HashMap<String,String> params = new HashMap<String, String>();
			//System.out.println("Response " + response);
			if(response.equalsIgnoreCase("Invalid OAuth Request")) {
				System.out.println(response);
				if(maxRetries > 0) {
					maxRetries--;
					return getAuthorizationURL();
				} else {
					System.exit(0);
				}
			} else {
				maxRetries = 3;
			}
			for(String r : rArr) {
				params.put(r.split("=")[0], r.split("=")[1]);
				//System.out.println(r.split("=")[0] + " " + r.split("=")[1]);
			}
			oauth_token = params.get("oauth_token");
			oauth_token_secret = params.get("oauth_token_secret");
			//System.out.println("Response: " + response);
		}
		authorizationURL = this.authorizeUrl + "?oauth_token=" + this.oauth_token;
		return authorizationURL;
	}
	
	public String getAccessToken() {
		String response = "";
		

			// Generate Request
			OAuthRequest req = new OAuthRequest();
			req.setConsumerKey(consumerKey);
			req.setOauthToken(oauth_token);
			req.setOauthTokenSecret(oauth_token_secret);
			req.setOauthVerifier(oauth_verifier);
			req.setEndpoint(accessTokenUrl);
			req.setMethod("POST");
			hmac_sha1_sign(req);
			
			String body = req.getRequestBody();
			//System.out.println(body);
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("Content-Type","application/x-www-form-urlencoded");
			
			response = Http.sendPostRequest(req.getEndpoint(), headers, body);
			//System.out.println("Response: " + response);
			if(response.equalsIgnoreCase("Invalid OAuth Request")) {
				System.out.println(response);
				if(maxRetries > 0) {
					maxRetries--;
					return getAccessToken();
				} else {
					System.exit(0);
				}
			} else {
				maxRetries = 3;
			}
			String[] rArr = response.split("&");
			HashMap<String,String> params = new HashMap<String, String>();
			
			for(String r : rArr) {
				params.put(r.split("=")[0], r.split("=")[1]);
				System.out.println(r.split("=")[0] + " " + r.split("=")[1]);
			}
			oauth_token = params.get("oauth_token");
			oauth_token_secret = params.get("oauth_token_secret");
		
		//response = this.authorizeUrl + "?oauth_token=" + this.oauth_token;
		return response;
	}
	
	public String request(String endpoint) {
		String response = "";
		String body_hash = "2jmj7l5rSw0yVb%2FvlWAYkK%2FYBwk%3D";
		
		OAuthRequest req = new OAuthRequest();
		req.setConsumerKey(consumerKey);
		req.setOauthToken(oauth_token);
		req.setOauthTokenSecret(oauth_token_secret);
		req.setEndpoint(endpoint);
		req.setMethod("GET");
		req.setOauthBodyHash(body_hash);
		hmac_sha1_sign(req);
		
		response = Http.sendGetRequest(req.getEndpoint() + "?" + req.getRequestBody(), new HashMap<String,String>());
		return response;
	}
	
	public void setOauthToken(String token) {
		this.oauth_token = token;
	}
	
	public String getOauthToken() {
		return this.oauth_token;
	}
	
	public void setOauthTokenSecret(String token) {
		this.oauth_token_secret = token;
	}
	
	public String getOauthTokenSecret() {
		return this.oauth_token_secret;
	}
	
	public void setOauthVerifier(String token) {
		this.oauth_verifier = token;
	}
	
	public void setRequestTokenURL(String url) {
		this.requestTokenUrl = url;
	}
	
	public void setAccessTokenURL(String url) {
		this.accessTokenUrl = url;
	}
	
	public void setAuthorizationURL(String url) {
		this.authorizeUrl = url;
	}
	
	private void hmac_sha1_sign(OAuthRequest req) {
		req.setOauthSignatureMethod(OAuthRequest.HMAC_SHA1);
		String method = req.getMethod();
		String hashedUrl = URLEncoder.encode(req.getEndpoint());
		String hashedBody = req.getRequestHash();
		String signature_base_string = method + "&" + hashedUrl + "&" + hashedBody;
		String key = consumerSecret + "&" + oauth_token_secret;
		//System.out.println(key);
		//System.out.println(signature_base_string);
		String signature = new String(
				Base64.encodeBase64(
						new HmacUtils(
								HmacAlgorithms.HMAC_SHA_1, 
								key
								).hmac(signature_base_string)
						)
				);
		req.setSignature(signature);
	}
	
}

/*
 * Normal Get Request
 * oauth_consumer_key=cCFUP5oGYVNJJAF9PlOR2qqBDcnzzEnPx5hofrh4
 * oauth_timestamp=1550436114
 * oauth_nonce=2856831
 * oauth_version=1.0
 * oauth_token=Nx9C7NRmGO4VexZ3oc04AzGIJkSwUmA3GWXyMVpl
 * oauth_body_hash=2jmj7l5rSw0yVb%2FvlWAYkK%2FYBwk%3D
 * oauth_signature_method=HMAC-SHA1
 * oauth_signature=YgKRxMCR6ODzhZ7AYTYR73lhBH8%3D
 * 
*/