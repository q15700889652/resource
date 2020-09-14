package com.example.demo.dao.second;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Scorrt;


@Mapper
public interface ScorrtMapper {
	public Scorrt query();

	public int insert();

	public ArrayList<Scorrt> getScorrtByUsercode();
}
