package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.model.Scorrt;
import com.example.demo.service.LnScorrtService;

@Controller
public class LnScorrtController {
	
	@Autowired
	LnScorrtService lnScorrtService;

	/**
	 * 跳转菜单页面
	 * @return
	 */
	@GetMapping("getScorrt")
	public String scorrt() {
		return "scorrt/menu";
		
	}
	
	
	@GetMapping("getScorrtDate")
	@ResponseBody
	public HashMap<String,Object> getScorrtDate() {
		HashMap<String,Object> map=new HashMap<>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", "");
		map.put("data",lnScorrtService.getScortByUsercode("00000000"));	
		return map;		
	}
	
	
	
	@ResponseBody
	public HashMap<String,Object> getScorrtByUsercode(String userCode) {
//	ArrayList<Scorrt> Scorrt=lnScorrtService.getScorrtByUsercode(userCode);
	
	return null;
		
	}

	/**
	 * 顶级权限获取
	 * @param dcList
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<Scorrt> doMenus(List<Scorrt> dcList) {
		List<Scorrt> top = new ArrayList<Scorrt>();
		for (Scorrt m : dcList) {
			if (m.getIsMenu() == 0) {
				top.add(m);
			}
		}
		List<Scorrt> treeList = doTree(top, dcList);
		return treeList;
	}

	/**
	 * 子集权限获取
	 * @param top
	 * @param fllow
	 * @return
	 */
	private List<Scorrt> doTree(List<Scorrt> top,List<Scorrt> fllow){
		for(Scorrt t:top) {
			List<Scorrt> flow=new ArrayList<Scorrt>();
			for(Scorrt f:fllow) {
				if(t.getAuthorityId()==f.getParentId()) {
					flow.add(f);
				}
			}
			if(flow.size()>0) {
				doTree(flow,fllow);
			}
			else {
				flow=null;
			}
			t.setChild(flow);
		}
		
		return top;
		
	}
}
