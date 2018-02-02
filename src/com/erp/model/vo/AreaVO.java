/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.util.List;

public class AreaVO{
	private long id;
	private String areaName;
	private String enabled = "Y";
	private long parentId = 0L;
	private String parentIdStr;
	private String sequCode;

	public String getSequCode() {
		return this.sequCode;
	}

	public void setSequCode(String sequCode) {
		this.sequCode = sequCode;
	}

	public String getObjectParentCodeStr() {
		return this.parentIdStr;
	}

	public String getObjectCode() {
		return String.valueOf(this.id);
	}

	public String getObjectParentCode() {
		return String.valueOf(this.parentId);
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getParentIdStr() {
		return this.parentIdStr;
	}

	public void setParentIdStr(String parentIdStr) {
		this.parentIdStr = parentIdStr;
	}

	public String getObjectName() {
		return this.areaName;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", areaName=" + areaName + ", enabled="
				+ enabled + ", parentId=" + parentId + ", parentIdStr="
				+ parentIdStr + ", sequCode=" + sequCode + "]";
	}
	
	
}