package com.enyis.service;

import com.enyis.model.User;

public class UserService {

	public static User UserLogin(String phone,String token) {
		String sql="select * from user where phone=? and token=?";
		return User.dao.findFirst(sql, phone,token);
	}
}
