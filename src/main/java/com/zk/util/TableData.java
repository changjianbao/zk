package com.zk.util;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class TableData {
	public static <T> JSONObject getLayUITable(int code, String msg, int count, List<T>list) {
		JSONObject obj=new JSONObject();
		obj.put("code", code);
		obj.put("msg", msg);
		obj.put("count", count);
		obj.put("data", list);
		return obj;
	}
}
