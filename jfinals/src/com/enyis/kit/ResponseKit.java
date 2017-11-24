package com.enyis.kit;

import com.alibaba.fastjson.JSON;
import com.enyis.ajax.JsonResponse;

public class ResponseKit {

	public static String createError(Object data){
		JsonResponse json=new JsonResponse(data, null,"0x04");
		return JSON.toJSONString(json);
	}
	public static String createSuccess(Object data,String url){
		JsonResponse json=new JsonResponse(data, url, "0");
		return JSON.toJSONString(json);
		
	}
}
