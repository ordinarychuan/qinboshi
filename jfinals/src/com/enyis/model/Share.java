package com.enyis.model;

import com.enyis.model.base.BaseShare;

public class Share extends BaseShare<Share>{

	public static Share dao=new Share().dao();

	@Override
	String tableName() {
		// TODO Auto-generated method stub
		return "share";
	}

	@Override
	String primaryKey() {
		// TODO Auto-generated method stub
		return "shareId";
	}

	@Override
	boolean isAutoId() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
