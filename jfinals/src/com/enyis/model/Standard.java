package com.enyis.model;

import com.enyis.model.base.BaseStandard;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Standard extends BaseStandard<Standard> {
	public static final Standard dao = new Standard().dao();

	@Override
	String tableName() {
		// TODO Auto-generated method stub
		return "standard";
	}

	@Override
	String primaryKey() {
		// TODO Auto-generated method stub
		return "stId";
	}

	@Override
	boolean isAutoId() {
		// TODO Auto-generated method stub
		return false;
	}
}
