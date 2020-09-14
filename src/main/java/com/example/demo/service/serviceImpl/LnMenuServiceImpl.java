package com.example.demo.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.master.LnMenuMapper;
import com.example.demo.model.LnMenu;
import com.example.demo.service.LnMenuService;
@Service
public class LnMenuServiceImpl implements LnMenuService{
	@Autowired
	LnMenuMapper lnMenuMapper;
	public ArrayList<LnMenu> getMenuByUsercode(String usercode) {
		return lnMenuMapper.getMenuByUsercode(usercode);
	}

}
