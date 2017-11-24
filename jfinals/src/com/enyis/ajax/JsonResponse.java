package com.enyis.ajax;

public class JsonResponse {

	private Object data;
	private String url;
	private String error;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public JsonResponse(Object data,String url,String error) {
	this.data=data;
	this.url=url;
	this.error=error;
	}
}
