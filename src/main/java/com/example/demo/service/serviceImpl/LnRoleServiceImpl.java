package com.example.demo.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.master.LnRoleMapper;
import com.example.demo.model.LnRole;
import com.example.demo.model.Logger;
import com.example.demo.service.LnRoleService;
@Service
public class LnRoleServiceImpl implements LnRoleService{

	@Autowired
	LnRoleMapper lnrolemapper;
	
	@Override
	public ArrayList<Logger> getRole(LnRole lnrole) {
		return lnrolemapper.getRole(lnrole);
	}

	@Override
	public int getRoleAdd(LnRole lnrole) {
		// TODO Auto-generated method stub
		return lnrolemapper.getRoleAdd(lnrole);
	}

}
