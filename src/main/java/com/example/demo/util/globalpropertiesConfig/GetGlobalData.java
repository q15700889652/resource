package com.example.demo.util.globalpropertiesConfig;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetGlobalData {
	/**
	 * @annotation ControllerAdvice全局参数定义获取
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("scorrt1")
	@ResponseBody
	public String scorrt1(Model model) {
		Map<String, Object> map = model.asMap();
		String msg = map.get("msg").toString();
		Map<String, String> info = (Map<String, String>) map.get("info");
		String result = "msg：" + msg + "<br>" + "info：" + info;
		return result;
	}
}
