package com.enyis.model;

import com.enyis.model.base.BaseQin_Order;

public class Qin_Order extends BaseQin_Order<Qin_Order>{

	public static Qin_Order dao=new Qin_Order().dao();

	@Override
	String tableName() {
		return "qin_order";
	}

	@Override
	String primaryKey() {
		return "oId";
	}

	@Override
	boolean isAutoId() {
		return false;
	}
	
}
