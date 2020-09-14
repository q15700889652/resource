package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.LnMenu;
import com.example.demo.model.LnSubject;
import com.example.demo.service.LnMenuService;

@Controller
public class LnMenuController {

	@Autowired
	LnMenuService lnMenuService;

	/**
	 * @author 用户获取菜单
	 * @param usercode
	 * @return
	 */
	@GetMapping("getMenuByUsercode")
	@ResponseBody
	public HashMap<String, Object> getMenuByUsercode(String userCode) {
		System.out.println("user:" + userCode + "-->start-->getMenu");
		// 采用arrayList,有序拿去数据库数据,便于菜单和主题调整位置
		ArrayList<LnMenu> Menulist = lnMenuService.getMenuByUsercode(userCode);
		//将所有菜单的usrl带上参数
		Menulist=getNewList(Menulist);
		ArrayList<LnMenu> list = getAllSubject(Menulist);
		HashMap<String, Object> map = getMenu(Menulist, list);
		HashMap<String, Object> map4 = getEndMenuData(map);
		System.out.println("user:" + userCode + "-->end-->getMenu");
		return map4;
	}
	/**
	 * 将所有菜单的usrl带上参数
	 * @param menulist
	 * @return
	 */
	private ArrayList<LnMenu> getNewList(ArrayList<LnMenu> menulist) {
		for (LnMenu e : menulist) {
			e.setHref(e.getHref()+"?menuname="+e.getTitle());
		}
		return menulist;
	}

	/**
	 * @author 最后需要的数据组装
	 * @param map
	 * @return
	 */
	private HashMap<String, Object> getEndMenuData(HashMap<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("clearUrl", "static/api/clear.json");
		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("title", "首页");
		map2.put("icon", "fa fa-home");
		map2.put("href", "static/page/welcome-1.html?mpi=m-p-i-0");
		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("title", "LayuiMini");
		map3.put("image", "static/images/logo.png");
		map3.put("href", "");
		LinkedHashMap<String, Object> map4 = new LinkedHashMap<String, Object>();
		map4.put("clearInfo", map1);
		map4.put("homeInfo", map2);
		map4.put("logoInfo", map3);
		map4.put("menuInfo", map);
		return map4;
	}

	/**
	 * @author 取出每个主题下的菜单
	 * @param menulist
	 * @param list
	 * @return
	 */
	private HashMap<String, Object> getMenu(List<LnMenu> menulist, List<LnMenu> list) {
		List<LnSubject> subjectList = new ArrayList<LnSubject>();
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		for (LnMenu e : list) {
			LnSubject sb = new LnSubject();
			List<LnMenu> dcList = new ArrayList<LnMenu>();
			for (LnMenu m : menulist) {
				if (m.getSubjectId() == e.getSubjectId()) {
					// 这个主题下需要整理的菜单
					dcList.add(m);
				}
			}
			sb.setIcon(e.getSicon());
			sb.setSubjectid(e.getSubjectId());
			sb.setTitle(e.getSubjectName());
			sb.setChild(doMenus(dcList));
			subjectList.add(sb);
			map.put(e.getFlag(), sb);
		}
		return map;
	}

	/**
	 * @author 取出所有菜单中的主题种类
	 * @param menulist
	 * @return
	 */
	private ArrayList<LnMenu> getAllSubject(ArrayList<LnMenu> menulist) {
		return (ArrayList<LnMenu>) menulist.stream().filter(distinctByKey(o -> o.getSubjectId()))
				.collect(Collectors.toList());
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	/**
	 * @author 顶级菜单获取
	 * @param dcList
	 * @return
	 */
	private List<LnMenu> doMenus(List<LnMenu> dcList) {
		List<LnMenu> top = new ArrayList<LnMenu>();
		for (LnMenu m : dcList) {
			if (m.getSuperId() == 0) {
				top.add(m);
			}
		}
		List<LnMenu> treeList = doTree(top, dcList);
		return treeList;
	}

	/**
	 * @author 子集菜单递归查询
	 * @param top
	 * @param fllow
	 * @return
	 */
	private List<LnMenu> doTree(List<LnMenu> top, List<LnMenu> fllow) {
		for (LnMenu t : top) {
			List<LnMenu> flow = new ArrayList<LnMenu>();
			for (LnMenu f : fllow) {
				if (t.getMenuId() == f.getSuperId()) {
					flow.add(f);
				}
			}
			if (flow.size() > 0) {
				doTree(flow, fllow);
			} else {
				flow = null;
			}
			t.setChild(flow);
		}
		return top;
	}

}
