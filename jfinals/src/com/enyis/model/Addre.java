package com.enyis.model;

import com.enyis.model.base.BaseAddre;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Addre extends BaseAddre<Addre> {
	public static final Addre dao = new Addre().dao();
	public static final String isDefault="1";
	@Override
	String tableName() {
		// TODO Auto-generated method stub
		return "addre";
	}

	@Override
	String primaryKey() {
		// TODO Auto-generated method stub
		return "addId";
	}

	@Override
	boolean isAutoId() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
