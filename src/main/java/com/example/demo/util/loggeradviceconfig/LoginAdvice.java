package com.example.demo.util.loggeradviceconfig;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.master.LoggerMapper;
import com.example.demo.model.Logger;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

public class LoginAdvice<userAgent> {

//	@Autowired
//	private LoggerService loggerService;
	@Autowired
	private LoggerMapper loggerMapper;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	/**
	 * 并不是拦截器，只是代理。当访问impl的时候，就会进行代理。所以查询条数访问一次后台代理一次，进行数据查询又进入一次代理。收集2次。需要优化
	 * 并且当跳转页面它是不进入serviceimpl，所以没有拦截
	 */
	public void add() {
		Object usercode = session.getAttribute("user");// 用户编码
		Object menuname = request.getParameter("menuname");// 菜单名
		Object url = request.getRequestURL();// 操作
		String ip = request.getRemoteAddr();// 地址
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 时间
		Date date = new Date();
		String odate = sdf.format(date);
		String agent = request.getHeader("User-Agent");
		UserAgent userAgent = UserAgent.parseUserAgentString(agent);// 解析agent字符串
		Browser browser = userAgent.getBrowser();// 获取浏览器对象
		OperatingSystem operatingSystem = userAgent.getOperatingSystem();// 获取操作系统对象
		Logger logger = new Logger();// 创建日志对象
		// Object user = request.getSession().getAttribute("user");
		// 获取参数
		logger.setId(1);
		logger.setUserCode(usercode == null ? "" : usercode.toString());
		logger.setMenuName(menuname == null ? "" : menuname.toString());
		logger.setOperateUrl(url.toString());
		logger.setOperateIp(ip.toString());
		logger.setOperateDate(odate.toString());
		logger.setOperateBrowser(browser.toString());
		logger.setOperatingSystem(operatingSystem.toString());
		loggerMapper.add(logger);
		System.out.println("准备向数据库添加日志");
	}
}
