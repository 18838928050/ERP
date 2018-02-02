/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class MakeType {
	private long id;
	private String typeName;//项目类型
	private long parentId = 0L;
	private String parentIdStr;
	private String tnSpell;
	private long workCenterId = 0L;
	private String enabled = "Y";
	private String unit;
	private int type = 1;
	private String sequCode;
	private String autoStoc = "N";
	private BigDecimal lossRate = new BigDecimal(0);

	public String getAutoStoc() {
		return this.autoStoc;
	}

	public void setAutoStoc(String autoStoc) {
		this.autoStoc = autoStoc;
	}

	public BigDecimal getLossRate() {
		return this.lossRate;
	}

	public void setLossRate(BigDecimal lossRate) {
		this.lossRate = lossRate;
	}

	public String getSequCode() {
		return this.sequCode;
	}

	public void setSequCode(String sequCode) {
		this.sequCode = sequCode;
	}

	public String getObjectParentCodeStr() {
		return this.parentIdStr;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getTnSpell() {
		return this.tnSpell;
	}

	public void setTnSpell(String tnSpell) {
		this.tnSpell = tnSpell;
	}

	public String getObjectName() {
		return this.typeName;
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

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public long getWorkCenterId() {
		return this.workCenterId;
	}

	public void setWorkCenterId(long workCenterId) {
		this.workCenterId = workCenterId;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String toString() {
		return "MakeType [id=" + id + ", typeName=" + typeName + ", parentId=" + parentId + ", parentIdStr="
				+ parentIdStr + ", tnSpell=" + tnSpell + ", workCenterId=" + workCenterId + ", enabled=" + enabled
				+ ", unit=" + unit + ", type=" + type + ", sequCode=" + sequCode + ", autoStoc=" + autoStoc
				+ ", lossRate=" + lossRate + "]";
	}
	
}