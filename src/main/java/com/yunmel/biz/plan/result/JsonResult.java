package com.yunmel.biz.plan.result;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {
	private static final int success = 10000;
	private static final int error = 10001;
	
	public static Map<String,Object> toSuccess(String tips, Object obj){
		return genMap(success, tips, obj);
	}
	
	public static Map<String,Object> toError(String tips, Object obj){
		return genMap(error, tips, obj);
	}
	
	private static Map<String, Object> genMap(int code, String tips, Object obj){
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("tips", tips);
		map.put("datas", obj);
		return map;
	}
}
