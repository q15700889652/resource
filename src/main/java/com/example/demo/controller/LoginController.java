package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
	/**
	 * 用户登陆
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("userLogin")
	public ModelAndView userLogin(HttpSession session,String userCode,String passWord,String title) {
		System.out.println(userCode+passWord);
		session.setAttribute("user", userCode);
		ModelAndView mv=new ModelAndView();
		mv.addObject("loginUserCode",userCode);
		mv.setViewName("index");
		return mv;
	}

	/**
	 * 用于拦截器拦截后跳转 采用M模板，页面在动态位置
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("login")
	public String login(HttpSession session) {
		System.out.println("跳转登陆页面");
		return "login-1";
	}

	/**
	 * 用户退出
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("loginOut")
	public String loginOut(HttpSession session) {
		session.removeAttribute("user");
		System.out.println("用户退出");
		return "login-1";
	}
}
