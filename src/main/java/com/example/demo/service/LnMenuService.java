package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.LnMenu;

public interface LnMenuService {

	ArrayList<LnMenu> getMenuByUsercode(String usercode);

}
