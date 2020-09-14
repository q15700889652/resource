package com.example.demo.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.LnRole;
import com.example.demo.service.LnRoleService;

@Controller
public class LnRoleController {
	
	@Autowired
	LnRoleService lnroleservice;
	
	/**
	 * 初始化
	 * @param session
	 * @return
	 */
	@GetMapping("role")
	public String role(HttpSession session) {

		System.out.println("跳转日志页面");

		return "role/role";
	}
	
	/**
	 * 前台页面信息展示功能
	 * @param lnrole
	 * @return
	 */
	@PostMapping("/role/query")
	@ResponseBody
	public HashMap<String,Object> getRole(@ModelAttribute LnRole lnrole) {
		
		HashMap<String,Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", "");
		map.put("data",lnroleservice.getRole(lnrole));	
		return map;
		
	}
	
	/**
	 * 增加信息页面跳转
	 * @return
	 */
	@GetMapping("/roleAdd")
	public ModelAndView roleadd(HttpSession session) {
		System.out.println("11111111111111111");
		Object userCode =session.getAttribute("user");
		ModelAndView mv=new ModelAndView();
		mv.addObject("userCode",userCode);
		mv.setViewName("role/add");
		return mv;
		
	}

	/**
	 * 增加角色信息页面
	 * @param lnrole
	 * @return
	 */
	@PostMapping("/LnRole/add")
	@ResponseBody
	public HashMap<String, Object> getRoleAdd(LnRole lnrole) {
			System.out.println("22222222222222");
			boolean flag=false;
			HashMap<String, Object> map=new HashMap<>();
			if(lnroleservice.getRoleAdd(lnrole)==1) {
				flag=true;
			}
			map.put("flag", flag);
			return map;
		} 
	
}
