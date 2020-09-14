package com.example.demo.model;
 
/**  

* @author 张璇 

* @date 2020年8月3日  

*/  
public class Logger {
	private int id;       
	private String userCode; 
	private String operateUser;
	private String menuName;
	private String operateUrl;
	private String operateIp;
	private String operateDate;
	private String operateBrowser;
	private String operatingSystem;
	private int limit;
	private int page;
	private int count;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getOperateUrl() {
		return operateUrl;
	}
	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}
	public String getOperateIp() {
		return operateIp;
	}
	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateBrowser() {
		return operateBrowser;
	}
	public void setOperateBrowser(String operateBrowser) {
		this.operateBrowser = operateBrowser;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


}
