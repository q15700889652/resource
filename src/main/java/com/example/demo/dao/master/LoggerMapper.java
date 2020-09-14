package com.example.demo.dao.master;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Logger;
import com.example.demo.model.SelectData;

@Mapper
public interface LoggerMapper {

	public void add(Logger logger);


	public ArrayList<Logger> getLogger(Logger logger);


	public Object getCount(Logger logger);


	public int deleteById(Integer id);


	public Logger getOneLogger(String id);


	public int getLoggerAdd(Logger logger);


	public int loggerUpdate(Logger logger);


	public List<SelectData> getSelectData(String columnCode,String columnName,String table);



}
