package com.erp.model.vo;

public class ClieUser {
	private long id;
	private String userName;
	private String password;
	private long clieId = 0L;
	private String pricType = "CLIE";
	private String enabled = "Y";
	private String ordeType = "UP_ZERO";

	public String getOrdeType() {
		return this.ordeType;
	}

	public void setOrdeType(String ordeType) {
		this.ordeType = ordeType;
	}

	public String getPricType() {
		return this.pricType;
	}

	public void setPricType(String pricType) {
		this.pricType = pricType;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getClieId() {
		return this.clieId;
	}

	public void setClieId(long clieId) {
		this.clieId = clieId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
}