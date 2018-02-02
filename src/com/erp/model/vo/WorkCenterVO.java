/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

public class WorkCenterVO {
	private long id;
	private String wcCode;
	private String wcName;
	private String mark;
	private long storehouseId = 0L;
	private String enabled = "Y";
	private String sys = "N";

	public String getSys() {
		return sys;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	@Override
	public String toString() {
		return "WorkCenterVO [id=" + id + ", wcCode=" + wcCode + ", wcName=" + wcName + ", mark="
				+ mark + ", storehouseId=" + storehouseId + ", enabled=" + enabled + ", sys=" + sys
				+ "]";
	}

	public String getObjectName() {
		return this.wcName;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public long getStorehouseId() {
		return this.storehouseId;
	}

	public void setStorehouseId(long storehouseId) {
		this.storehouseId = storehouseId;
	}

	public String getWcCode() {
		return this.wcCode;
	}

	public void setWcCode(String wcCode) {
		this.wcCode = wcCode;
	}

	public String getWcName() {
		return this.wcName;
	}

	public void setWcName(String wcName) {
		this.wcName = wcName;
	}
}