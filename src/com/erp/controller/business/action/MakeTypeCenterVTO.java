package com.erp.controller.business.action;

public class MakeTypeCenterVTO {
	private long id;
	private long wcId;
	private String typeName;
	private int type;
	private String unit;
	private long pareId;
	private String wcName;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getWcId() {
		return wcId;
	}
	public void setWcId(long wcId) {
		this.wcId = wcId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public long getPareId() {
		return pareId;
	}
	public void setPareId(long pareId) {
		this.pareId = pareId;
	}
	public String getWcName() {
		return wcName;
	}
	public void setWcName(String wcName) {
		this.wcName = wcName;
	}
	
	
}
