package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ScorrtService;


@SpringBootTest
class Demo1ApplicationTests {
	@Autowired
	private ScorrtService scorrtService;
	@Test
	void contextLoads() {
		scorrtService.query();
	}

}
