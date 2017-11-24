package com.enyis.model.base;

import com.enyis.model.AbstractModel;
import com.jfinal.plugin.activerecord.IBean;

public abstract class BaseShare<M extends BaseShare<M>> extends AbstractModel<M> implements IBean  {

	public M setShareId(java.lang.String shareId) {
		set("shareId", shareId);
		return (M)this;
	}

	public java.lang.String getShareId() {
		return getStr("shareId");
	}

	public M setUserId(java.lang.String userId) {
		set("userId", userId);
		return (M)this;
	}

	public java.lang.String getUserId() {
		return getStr("userId");
	}
	public M setByuserId(java.lang.String byuserId) {
		set("byuserId", byuserId);
		return (M)this;
	}

	public java.lang.String getByuserId() {
		return getStr("byuserId");
	}
	public M setCreateDate(java.util.Date createDate) {
		set("createDate", createDate);
		return (M)this;
	}

	public java.util.Date getCreateDate() {
		return get("createDate");
	}

	public M setThruDate(java.util.Date thruDate) {
		set("thruDate", thruDate);
		return (M)this;
	}

	public java.util.Date getThruDate() {
		return get("thruDate");
	}

	public M setLastUpdate(java.util.Date lastUpdate) {
		set("lastUpdate", lastUpdate);
		return (M)this;
	}

	public java.util.Date getLastUpdate() {
		return get("lastUpdate");
	}
	
}
