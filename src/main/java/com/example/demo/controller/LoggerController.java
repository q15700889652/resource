package com.example.demo.controller;

import java.util.HashMap;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Logger;
import com.example.demo.service.LoggerService;

/**
 * @author 张璇
 * @date 2020年8月3日 日志表现层
 */

@Controller
public class LoggerController {

	@Autowired
	private LoggerService loggerservice;

	/**
	 * 初始化
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("logger")
	public String Logger(HttpSession session) {
		System.out.println("跳转角色管理页面");

		return "logger/logger";
	}

	/**
	 * 收集日志
	 * 
	 * @return
	 */
	@PostMapping("/getLogger")
	@ResponseBody
	public HashMap<String, Object> getLogger(@ModelAttribute Logger logger) {
		logger.setPage((logger.getPage() - 1) * logger.getLimit());
		HashMap<String, Object> hash = new HashMap<>();
		hash.put("code", 0);
		hash.put("msg", "");
		hash.put("count", loggerservice.getCount(logger));
		hash.put("data", loggerservice.getLogger(logger));
		return hash;
	}

	// @RequestMapping(value="/deleteById")
	@PostMapping("deleteById")
	@ResponseBody
	public HashMap<String, Object> deleteById(@RequestParam("id") Integer id) {
		boolean flag = false;
		HashMap<String, Object> map = new HashMap<>();
		if (loggerservice.deleteById(id) == 1) {
			flag = true;
		}
		map.put("flag", flag);

		return map;
	}

	/**
	 * 查询单条数据，返回页面 定义一个页面+定义一批数据
	 */
	@GetMapping("/modify")

	public ModelAndView modify(String id) {
		Logger logger = loggerservice.getOneLogger(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("logger", logger);
		mv.setViewName("logger/edit");
		return mv;
	}

	/**
	 * 修改日志信息
	 */
	@PostMapping("/loggerUpdate")
	@ResponseBody
	public HashMap<String, Object> loggerUpdate(Logger logger) {
		boolean flag = false;
		HashMap<String, Object> map = new HashMap<>();
		if (loggerservice.loggerUpdate(logger) == 1) {
			flag = true;
		}
		map.put("flag", flag);
		return map;
	}

	/**
	 * 增加日志跳转页面
	 */
	@GetMapping("/loggerAdd")
	public String loggerAdd() {
		return "logger/add";
	}

	/**
	 * 日志增加
	 * 
	 * @return
	 */
	@PostMapping("/logger/add")
	@ResponseBody
	public HashMap<String, Object> getLoggerAdd(Logger logger) {
		boolean flag = false;
		HashMap<String, Object> map = new HashMap<>();
		if (loggerservice.getLoggerAdd(logger) == 1) {
			flag = true;
		}
		map.put("flag", flag);
		return map;
	}
}