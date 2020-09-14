package com.example.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.second.ScorrtMapper;
import com.example.demo.model.Scorrt;
import com.example.demo.service.ScorrtService;

@Service
public class ScorrtServiceImpl implements ScorrtService {
	@Autowired(required=true)
	ScorrtMapper scorrtMapper;

	public void getParam() {
		int a = 1 / 0;
		System.out.println(a);
	}

	//@Transactional
	public Scorrt query() {
		/* int a = scorrtMapper.insert(); */
		Scorrt b = new Scorrt();
		/* if (a == 1) { */
			b = scorrtMapper.query();
		/* } */
		// 回滚
		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		return b;
	}

	@Transactional
	public int insert() {
		int a = scorrtMapper.insert();
		System.out.println(1 / 0);
		return a;
	}
}
