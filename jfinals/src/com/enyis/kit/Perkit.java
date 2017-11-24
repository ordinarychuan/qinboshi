package com.enyis.kit;

import com.enyis.model.User;

public class Perkit {

	private User user;

	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public Perkit(User user) {
		this.user = user;
	}

	
}
