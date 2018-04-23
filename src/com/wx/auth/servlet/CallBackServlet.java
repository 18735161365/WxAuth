package com.wx.auth.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wx.auth.util.AuthUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CallBackServlet
 */
public class CallBackServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtil.APPID
				+ "&secret="+AuthUtil.APPSECRET
				+ "&code="+code
				+ "&grant_type=authorization_code";
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openid = jsonObject.getString("openid");
		String access_token = jsonObject.getString("access_token");
		String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
		System.out.println(userInfo);
	}
	


}
