package com.enyis.service;

import java.util.List;

import com.enyis.model.Addre;
import com.jfinal.plugin.activerecord.Db;

public class AddreService {

	public static List<Addre> getByuserId(String userId){
		List<Addre> list=Addre.dao.find("select * from addre where userId=?",userId);
		return list;
	}
	public static boolean updateDefau(String userId,String addId) {
		Addre isde=Addre.dao.findFirst("select * from addre where isDefault=?",Addre.isDefault);
		if(isde!=null) {
			isde.setIsDefault("0").update();
		}
		return Addre.dao.findById(addId).setIsDefault(Addre.isDefault).update();	
	}
}
