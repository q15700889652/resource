package com.example.demo.util.globalpropertiesConfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 * @annotation 全局参数定义
 * @date 2020/06/18
 * @author lnn
 *
 */
@ControllerAdvice
public class GlobalDataConfig {
	
	@ModelAttribute(value = "msg")
    public String message() {
        return "欢迎访问 hangge.com";
    }
 
    @ModelAttribute(value = "info")
    public Map<String, String> userinfo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "hangge");
        map.put("age", "100");
        return map;
    }

}
