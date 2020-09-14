package com.example.demo.model;

/**
 * @author 角色实体
 *
 */

public class LnRole {
 
	private int roleid;
	private String rolename;
	private Integer status;
	private String remarsk;
	private String createtime;
	private String createName;
	private String createcode;
//	private int createcode;
	
	public int getRoleid() {
		return roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarsk() {
		return remarsk;
	}

	public void setRemarsk(String remarsk) {
		this.remarsk = remarsk;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getCreatecode() {
		return createcode;
	}

	public void setCreatecode(String createcode) {
		this.createcode = createcode;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}


}
