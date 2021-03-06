package com.enyis.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.enyis.model.AbstractModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseUser<M extends BaseUser<M>> extends AbstractModel<M> implements IBean {

	public M setUserId(java.lang.String userId) {
		set("userId", userId);
		return (M)this;
	}

	public java.lang.String getUserId() {
		return getStr("userId");
	}

	public M setToken(java.lang.String token) {
		set("token", token);
		return (M)this;
	}

	public java.lang.String getToken() {
		return getStr("token");
	}

	public M setPhone(java.lang.String phone) {
		set("phone", phone);
		return (M)this;
	}

	public java.lang.String getPhone() {
		return getStr("phone");
	}

	public M setCommission(java.lang.String commission) {
		set("commission", commission);
		return (M)this;
	}

	public java.lang.String getCommission() {
		return getStr("commission");
	}

	public M setReMoney(java.lang.String reMoney) {
		set("reMoney", reMoney);
		return (M)this;
	}

	public java.lang.String getReMoney() {
		return getStr("reMoney");
	}

	public M setCreateDate(java.util.Date createDate) {
		set("createDate", createDate);
		return (M)this;
	}

	public java.util.Date getCreateDate() {
		return get("createDate");
	}

	public M setLastUpdate(java.util.Date lastUpdate) {
		set("lastUpdate", lastUpdate);
		return (M)this;
	}

	public java.util.Date getLastUpdate() {
		return get("lastUpdate");
	}

	public M setThruDate(java.util.Date thruDate) {
		set("thruDate", thruDate);
		return (M)this;
	}

	public java.util.Date getThruDate() {
		return get("thruDate");
	}

}
