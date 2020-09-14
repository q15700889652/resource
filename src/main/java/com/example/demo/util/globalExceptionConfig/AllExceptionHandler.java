package com.example.demo.util.globalExceptionConfig;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @annotation 全局异常获取，跳转错误页面
 * @date 2020/06/18
 * @author lnn
 *
 */
//@ControllerAdvice
public class AllExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";

	//@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

}
