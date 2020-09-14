package com.example.demo.dao.master;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.LnMenu;

@Mapper
public interface LnMenuMapper {
	/**
	 * 菜单查询
	 * @param usercode
	 * @return
	 */
	ArrayList<LnMenu> getMenuByUsercode(String usercode);

}
