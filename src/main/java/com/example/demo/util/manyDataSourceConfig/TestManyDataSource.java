package com.example.demo.util.manyDataSourceConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Scorrt;
import com.example.demo.service.ScorrtService;

@Controller
public class TestManyDataSource {
	@Autowired
	private ScorrtService scorrtService;
	
	@GetMapping("testSecondDataSource")
	@ResponseBody
	public Scorrt query() {
		return scorrtService.query();
	}
}
