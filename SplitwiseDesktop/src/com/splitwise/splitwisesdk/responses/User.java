package com.splitwise.splitwisesdk.responses;

import java.util.Map;

public class User {
	private String jsonText;
	
	public long id;
	public String first_name;
	public String last_name;
	public Map<String,String> picture;
	public String email;
	public String registration_status;
	public String force_refresh_at;
	public String locale;
	public String country_code;
	public String date_format;
	public String default_currency;
	public long default_group_id;
	public String notification_read;
	public int notification_count;
	public NotificationSetting notification;
	
	public User(String jsonText) {
		this.jsonText = jsonText;
		parseJSON();
	}
	
	private void parseJSON() {
		// Logic to parse JSON
		//
	}
	
	public String toString() {
		return jsonText;
	}
	
	private static class NotificationSetting {
		public boolean added_as_friend;
		public boolean added_to_group;
		public boolean expense_added;
		public boolean expense_updated;
		public boolean bills;
		public boolean payments;
		public boolean monthly_summary;
		public boolean announcements;
	}
}
