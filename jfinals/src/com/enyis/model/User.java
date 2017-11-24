package com.enyis.model;

import com.enyis.model.base.BaseUser;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User().dao();

	@Override
	String tableName() {
		return "user";
	}

	@Override
	String primaryKey() {
		return "userId";
	}

	@Override
	boolean isAutoId() {
		return false;
	}
}