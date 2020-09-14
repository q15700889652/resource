package com.example.demo.util.globalExceptionConfig;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
/**
 * 异常跳转全局定义错误页面
 * @author Administrator
 *
 */
@Component
public class MyErrorViewResolver implements ErrorViewResolver{
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		ModelAndView mv=new ModelAndView("errorPage");
		mv.addObject("custommsg","出错啦");
		mv.addAllObjects(model);
		return mv;
	}

}
