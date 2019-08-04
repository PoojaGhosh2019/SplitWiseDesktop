package com.splitwise.splitwisesdk;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class Http {
	static HttpClient client = HttpClientBuilder.create().build();
	
	public static String sendPostRequest(String url, Map<String,String> headers, String body) {
		String responseText = "";
		HttpPost request = new HttpPost(url);
		try {
			
			for(Map.Entry<String, String> header : headers.entrySet()) {
				request.addHeader(header.getKey(),header.getValue());
			}
			
			request.setEntity(new StringEntity(body));
	
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
		
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			responseText = result.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return responseText;
	}
	
	public static String sendGetRequest(String url, Map<String,String> params) {
		String responseText = "";
		
		try {
			URIBuilder builder = new URIBuilder(url);
			for(Map.Entry<String, String> param : params.entrySet()) {
				builder.setParameter(param.getKey(),param.getValue());
			}
			HttpGet request = new HttpGet(builder.build());
			System.out.println(request.toString());
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
		
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			responseText = result.toString();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return responseText;
	}
	
}
