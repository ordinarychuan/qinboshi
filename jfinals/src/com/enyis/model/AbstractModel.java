package com.enyis.model;

import java.util.UUID;

import com.jfinal.plugin.activerecord.Model;

public abstract class AbstractModel<T extends AbstractModel<T>> extends Model<T>{
	
	abstract String tableName();
	abstract String primaryKey();
	abstract boolean isAutoId();
	@Override
	public boolean save() {
		boolean boo=isAutoId();
		if(!boo) {
			this.set(primaryKey(), UUID.randomUUID().toString());
		}
		return super.save();
	}
}
