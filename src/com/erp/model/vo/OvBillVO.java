/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class OvBillVO {
	public static final String CODE_RULE = "OV_BILL";
	private long id;
	private String billCode;
	private long stafferId = 0L;
	private String stafferName;
	private long depId = 0L;
	private String outType = "VIR";
	private Date outDate = new Date();
	private BigDecimal cost;
	private String description;
	private String mark;
	private String examined = "N";
	private long examinerId = 0L;
	private String examinerName;
	private long createrId = 0L;
	private String createrName;
	private String enabled = "Y";
	private long disableManId = 0L;
	private Date updateTime = new Date();
	private long tallySetId = 0L;
	private Date createTime;
	private Date examineTime;

	
	@Override
	public String toString() {
		return "OvBillVO [id=" + id + ", billCode=" + billCode + ", stafferId=" + stafferId + ", stafferName="
				+ stafferName + ", depId=" + depId + ", outType=" + outType + ", outDate=" + outDate + ", cost=" + cost
				+ ", description=" + description + ", mark=" + mark + ", examined=" + examined + ", examinerId="
				+ examinerId + ", examinerName=" + examinerName + ", createrId=" + createrId + ", createrName="
				+ createrName + ", enabled=" + enabled + ", disableManId=" + disableManId + ", updateTime=" + updateTime
				+ ", tallySetId=" + tallySetId + ", createTime=" + createTime + ", examineTime=" + examineTime + "]";
	}

	public String getStafferName() {
		return this.stafferName;
	}

	public void setStafferName(String stafferName) {
		this.stafferName = stafferName;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBillCode() {
		return this.billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public long getStafferId() {
		return this.stafferId;
	}

	public void setStafferId(long stafferId) {
		this.stafferId = stafferId;
	}

	public long getDepId() {
		return this.depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public String getOutType() {
		return this.outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public Date getOutDate() {
		return this.outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getExamined() {
		return this.examined;
	}

	public void setExamined(String examined) {
		this.examined = examined;
	}

	public long getExaminerId() {
		return this.examinerId;
	}

	public void setExaminerId(long examinerId) {
		this.examinerId = examinerId;
	}

	public String getExaminerName() {
		return this.examinerName;
	}

	public void setExaminerName(String examinerName) {
		this.examinerName = examinerName;
	}

	public long getCreaterId() {
		return this.createrId;
	}

	public void setCreaterId(long createrId) {
		this.createrId = createrId;
	}

	public String getCreaterName() {
		return this.createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public long getDisableManId() {
		return this.disableManId;
	}

	public void setDisableManId(long disableManId) {
		this.disableManId = disableManId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExamineTime() {
		return this.examineTime;
	}

	public void setExamineTime(Date examineTime) {
		this.examineTime = examineTime;
	}
}