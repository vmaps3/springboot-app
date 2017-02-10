package com.wangsong.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpClientUtil {
	private static OkHttpClient okHttpClient;
	public static String get(String url) throws IOException {
		okHttpClient = new OkHttpClient();
	    Request request = new Request.Builder().url(url).build();
	    Response response = okHttpClient.newCall(request).execute();
		return response.body().string();
	 }
	
	private static String post(String url, Map<String, String> map) throws IOException {
		Builder builder = new FormBody.Builder();
		Set<String> set=map.keySet();
		for (Iterator<String> iter =set.iterator(); iter.hasNext();) {
			  String str = (String)iter.next();
			  builder.add(str, map.get(str));
		}
		FormBody formBody=builder.build();
	    Request request = new Request.Builder()
	             .url(url)
	             .post(formBody)
	             .build();
	    Response response = okHttpClient.newCall(request).execute();
		return response.body().string();
	 }
	
	public static void main(String[] args) throws IOException {
		Map<String,String> map=new HashMap<>();
		map.put("username", "wangsong");
		map.put("password", "wangsong");
		System.out.println(post("http://127.0.0.1:8080/spring-app/login.do",map) );
		System.out.println(get("http://127.0.0.1:8080/spring-app/system/role/findRoleResourcesByRole.do?id=111") );

	}
}
