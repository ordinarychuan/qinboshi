package com.enyis.service;

import java.util.List;

import com.enyis.model.Addre;

public class AddreService {

	public static List<Addre> getByuserId(String userId){
		List<Addre> list=Addre.dao.find("select * from addre where userId=?",userId);
		return list;
	}
}
