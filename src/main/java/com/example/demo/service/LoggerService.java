package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.Logger;

public interface LoggerService {


	/**
	 * 日志新增
	 * @param logger
	 */
	public void add(Logger logger);

	public ArrayList<Logger> getLogger(Logger logger);

	public Object getCount(Logger logger);

	ArrayList<Logger> getLogger();

	public int deleteById(Integer id);

	public Logger getOneLogger(String id);

	public int loggerUpdate(Logger logger);

	public int getLoggerAdd(Logger logger);


}
