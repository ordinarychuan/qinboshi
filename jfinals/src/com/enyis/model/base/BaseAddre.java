package com.enyis.model.base;

import com.enyis.model.AbstractModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseAddre<M extends BaseAddre<M>> extends AbstractModel<M> implements IBean {

	public M setAddId(java.lang.String addId) {
		set("addId", addId);
		return (M)this;
	}

	public java.lang.String getAddId() {
		return getStr("addId");
	}

	public M setUserId(java.lang.String userId) {
		set("userId", userId);
		return (M)this;
	}

	public java.lang.String getUserId() {
		return getStr("userId");
	}

	public M setLinkman(java.lang.String linkman) {
		set("linkman", linkman);
		return (M)this;
	}

	public java.lang.String getLinkman() {
		return getStr("linkman");
	}

	public M setArea(java.lang.String area) {
		set("area", area);
		return (M)this;
	}

	public java.lang.String getArea() {
		return getStr("area");
	}
	public M setStreet(java.lang.String street) {
		set("street", street);
		return (M)this;
	}

	public java.lang.String getStreet() {
		return getStr("street");
	}
	public M setAddress(java.lang.String address) {
		set("address", address);
		return (M)this;
	}

	public java.lang.String getAddress() {
		return getStr("address");
	}

	public M setLinkphone(java.lang.String linkphone) {
		set("linkphone", linkphone);
		return (M)this;
	}

	public java.lang.String getLinkphone() {
		return getStr("linkphone");
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
