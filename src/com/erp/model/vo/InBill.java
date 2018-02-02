/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.util.Date;

public class InBill {
	public static final String CODE_RULE = "IN_BILL";
	public static final String OFFERER_TYPE_DEPARTMENT = "DEPARTMENT";
	public static final String OFFERER_TYPE_CLIENT = "CLIENT";
	public static final String OFFERER_TYPE_PROVIDER = "PROVIDER";
	public static final String OFFERER_TYPE_STOREHOUSE = "STOREHOUSE";
	public static final String OFFERER_TYPE_WORK_CENTER = "WORK_CENTER";
	public static final String OFFERER_TYPE_COOPERATOR = "COOPERATOR";
	private long id;
	private String billCode;
	private Date inDate = new Date();
	private long inTypeId = 0L;
	private long storehouseId = 0L;
	private String offererType;
	private long offererId = 0L;
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
	private Date createTime;
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

	public Date getInDate() {
		return this.inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public long getInTypeId() {
		return this.inTypeId;
	}

	public void setInTypeId(long inTypeId) {
		this.inTypeId = inTypeId;
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

	public long getOffererId() {
		return this.offererId;
	}

	public void setOffererId(long offererId) {
		this.offererId = offererId;
	}

	public String getOffererType() {
		return this.offererType;
	}

	public void setOffererType(String offererType) {
		this.offererType = offererType;
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