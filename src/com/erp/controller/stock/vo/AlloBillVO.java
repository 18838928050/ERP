/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.controller.stock.vo;

import java.util.Date;
/**
 * 调拨单
 * @author guo
 *
 */
public class AlloBillVO {
	public static final String CODE_RULE = "ALLO_BILL";
	private long id;//
	private String billCode;//单号
	private Date alloDate = new Date();//调拨日期
	private long managerId = 0L;//
	private String managerName;//经办人
	private long fromStoId = 0L;//
	private long toStoId = 0L;//
	private String description;//摘要
	private String mark;//
	private long createrId = 0L;//
	private String createrName;//
	private Date createTime = new Date();//
	private Date examineTime;//
	private String examined = "N";//是否审核
	private long examinerId = 0L;//
	private String examinerName;//
	private String enabled = "Y";//是否启用
	private long disableManId = 0L;//
	private Date updateTime = new Date();//
	private long tallySetId = 0L;//归属类型

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

	public Date getAlloDate() {
		return this.alloDate;
	}

	public void setAlloDate(Date alloDate) {
		this.alloDate = alloDate;
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

	public long getFromStoId() {
		return this.fromStoId;
	}

	public void setFromStoId(long fromStoId) {
		this.fromStoId = fromStoId;
	}

	public long getToStoId() {
		return this.toStoId;
	}

	public void setToStoId(long toStoId) {
		this.toStoId = toStoId;
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
}