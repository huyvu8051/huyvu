package com.huyvu.dto;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

public class OnRegistrationCompleteEvent extends ApplicationEvent {
	private String appUrl;
	private Locale locale;
	private UserDTO user;

	public OnRegistrationCompleteEvent(UserDTO user, Locale locale, String appUrl) {
		super(user);
		this.appUrl = appUrl;
		this.locale = locale;
		this.user = user;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
