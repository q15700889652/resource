package com.example.demo.util.globalpropertiesConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  *  测试.yml中数据是否set到实体类
 * @author Administrator
 *
 */
@RestController
public class YmlController {

	@Autowired
	Book book;

	@GetMapping("/book")
	public Book book() {
		return book;
	}

}
