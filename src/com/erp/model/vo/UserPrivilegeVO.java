package com.erp.model.vo;

public class UserPrivilegeVO {
	private long id;
	private long userId = 0L;
	private String privilegeCode;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrivilegeCode() {
		return this.privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}