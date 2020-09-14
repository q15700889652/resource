package com.example.demo.util.globalExceptionConfig;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
/**
 * 继承:移除父类本身带有的错误
 * @author Administrator
 *
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes{
	@SuppressWarnings("deprecation")
	public Map<String, Object> getErrorAttributes(WebRequest webRequest,boolean includeStackTrace){
		Map<String, Object> errorAttributes=super.getErrorAttributes(webRequest, includeStackTrace);
		errorAttributes.remove("error");
		return errorAttributes;
	}
} 
