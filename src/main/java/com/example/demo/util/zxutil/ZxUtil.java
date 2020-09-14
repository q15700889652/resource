package com.example.demo.util.zxutil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ZxUtil {
	public static String getSessionUserCode(HttpSession session) {	
		return session.getAttribute("user").toString();
		
	}
    public static String getRequestUrl(HttpServletRequest request) {
	return request.getRequestURL().toString();
}
    
}
