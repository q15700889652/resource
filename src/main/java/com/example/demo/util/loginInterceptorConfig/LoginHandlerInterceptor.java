package com.example.demo.util.loginInterceptorConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器，登录检查
 * @author lining
 * @date 2020/08/03
 */
@Component 
public class LoginHandlerInterceptor implements HandlerInterceptor {
    // 目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        // 如果获取的request的session中的loginUser参数为空（未登录），就返回登录页，否则放行访问
        System.out.println("拦截用户，session判断。当前用户:"+user);
        if (user == null) {
        	response.sendRedirect("/ln/login");
            return false;
        } else {
            // 已登录，放行
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
   
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}