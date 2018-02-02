/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.util.Date;

public class OutBill {
	public static final String CODE_RULE = "OUT_BILL";
	public static final String REQUIRER_TYPE_DEPARTMENT = "DEPARTMENT";
	public static final String REQUIRER_TYPE_CLIENT = "CLIENT";
	public static final String REQUIRER_TYPE_PROVIDER = "PROVIDER";
	public static final String REQUIRER_TYPE_STOREHOUSE = "STOREHOUSE";
	public static final String REQUIRER_TYPE_WORK_CENTER = "WORK_CENTER";
	public static final String REQUIRER_TYPE_COOPERATOR = "COOPERATOR";
	private long id;
	private String billCode;
	private Date outDate = new Date();
	private long outTypeId = 0L;
	private long storehouseId = 0L;
	private String requirerType;
	private long requirerId = 0L;
	private long managerId;
	private String managerName;
	private String businessBillCode;
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
	private Date createTime = new Date();
	private Date examineTime;

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

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public String getBillCode() {
		return this.billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getBusinessBillCode() {
		return this.businessBillCode;
	}

	public void setBusinessBillCode(String businessBillCode) {
		this.businessBillCode = businessBillCode;
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

	public long getDisableManId() {
		return this.disableManId;
	}

	public void setDisableManId(long disableManId) {
		this.disableManId = disableManId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
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

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getManagerId() {
		return this.managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Date getOutDate() {
		return this.outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public long getOutTypeId() {
		return this.outTypeId;
	}

	public void setOutTypeId(long outTypeId) {
		this.outTypeId = outTypeId;
	}

	public long getRequirerId() {
		return this.requirerId;
	}

	public void setRequirerId(long requirerId) {
		this.requirerId = requirerId;
	}

	public String getRequirerType() {
		return this.requirerType;
	}

	public void setRequirerType(String requirerType) {
		this.requirerType = requirerType;
	}

	public long getStorehouseId() {
		return this.storehouseId;
	}

	public void setStorehouseId(long storehouseId) {
		this.storehouseId = storehouseId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}