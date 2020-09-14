package com.example.demo.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.master.LoggerMapper;
import com.example.demo.model.Logger;
import com.example.demo.service.LoggerService;

@Service
public class LoggerServiceImpl implements LoggerService{
	
	@Autowired
	private LoggerMapper loggerMapper;
	
	/**
	 * @author zhangxuan
	 * @date 2020/8/2
	 * @see 日志新增
	 */
	public void add(Logger logger) {
	   loggerMapper.add(logger);
		
	}

	@Override
	public ArrayList<Logger> getLogger(Logger logger) {
		return loggerMapper.getLogger(logger);
	}



	@Override
	public ArrayList<Logger> getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCount(Logger logger) {
		// TODO Auto-generated method stub
	return loggerMapper.getCount(logger);

	}


	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return loggerMapper.deleteById(id);
	}

	@Override
	public int getLoggerAdd(Logger logger) {
		// TODO Auto-generated method stub
		return loggerMapper.getLoggerAdd(logger);
	}


	@Override
	public int loggerUpdate(Logger logger) {
		// TODO Auto-generated method stub
		return loggerMapper.loggerUpdate(logger);
	}


	@Override
	public Logger getOneLogger(String id) {
		// TODO Auto-generated method stub
		return loggerMapper.getOneLogger(id);
	}


}
