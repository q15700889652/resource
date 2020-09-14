package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.LnRole;
import com.example.demo.model.Logger;

public interface LnRoleService {

    public	ArrayList<Logger> getRole(LnRole lnrole);

	public int getRoleAdd(LnRole lnrole);

}
