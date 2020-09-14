package com.example.demo.model;

import java.util.List;

/**
 * @author 菜单实体
 * @author Administrator
 *
 */
public class LnMenu {
	private int menuId;
	private String title;
	private String href;
	private String icon;
	private String target;
	private String createName;
	private int superId;
	private int subjectId;
	private int status;
	private String subjectName;
	private String sicon;
	private String flag;
	private List<LnMenu> child;
	private String rolename;
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSicon() {
		return sicon;
	}

	public void setSicon(String sicon) {
		this.sicon = sicon;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<LnMenu> getChild() {
		return child;
	}

	public void setChild(List<LnMenu> child) {
		this.child = child;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}


	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public int getSuperId() {
		return superId;
	}

	public void setSuperId(int superId) {
		this.superId = superId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public LnMenu() {
		// TODO Auto-generated constructor stub
	}

}
