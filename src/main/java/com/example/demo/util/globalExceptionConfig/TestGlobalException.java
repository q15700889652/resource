package com.example.demo.util.globalExceptionConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TestGlobalException {
	@GetMapping("/hello")
	public String hello() throws Exception {
		 throw new Exception("发生错误");
	}
}
