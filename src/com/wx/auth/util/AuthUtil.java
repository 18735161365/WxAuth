package com.wx.auth.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class AuthUtil {
	public static final String APPID = "wx325dedec026fd493";
	public static final String  APPSECRET= "971589b6b4141f3e7fdddbe66e7aa78d";
	public static JSONObject doGetJson(String url) throws ParseException, IOException{
		JSONObject jsonObject = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if(entity != null){
			String result = EntityUtils.toString(entity,"utf-8");
			jsonObject = JSONObject.fromObject(result);
		}
		httpGet.releaseConnection();
		return jsonObject;
	}
}
