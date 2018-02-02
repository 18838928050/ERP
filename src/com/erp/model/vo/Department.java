/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

public class Department {
	public static final String CODE_RULE = "DEPARTMENT";
	private long id;
	private String departmentName;
	private String departmentCode;
	private long parentId = 0L;
	private String parentIdStr;
	private String enabled = "Y";

	public String getObjectParentCodeStr() {
		return this.parentIdStr;
	}

	public String getObjectCode() {
		return String.valueOf(this.id);
	}

	public String getObjectParentCode() {
		return String.valueOf(this.parentId);
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getObjectName() {
		return this.departmentName;
	}

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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
}