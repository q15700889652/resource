package com.example.demo.dao.master;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.LnRole;
import com.example.demo.model.Logger;

@Mapper
public interface LnRoleMapper {

	public ArrayList<Logger> getRole(LnRole lnrole);

	public int getRoleAdd(LnRole lnrole);
}
