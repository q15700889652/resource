package com.example.demo.model;

import java.util.List;

public class LnSubject {
	private int subjectid;
	private String title;
	private String icon;
	private List<LnMenu> child;
	
	
	public List<LnMenu> getChild() {
		return child;
	}

	public void setChild(List<LnMenu> child) {
		this.child = child;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public LnSubject() {
		// TODO Auto-generated constructor stub
	}
}
