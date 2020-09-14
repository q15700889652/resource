package com.example.demo.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.second.ScorrtMapper;
import com.example.demo.model.Scorrt;
import com.example.demo.service.LnScorrtService;

@Service
public class lnScorrtServiceImpl implements LnScorrtService{
	
	@Autowired
	ScorrtMapper scorrtMapper;

	@Override
	public ArrayList<Scorrt> getScortByUsercode(String userCode) {
		// TODO Auto-generated method stub
		return scorrtMapper.getScorrtByUsercode();
	}

}
