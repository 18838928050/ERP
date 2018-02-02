/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CooperBillExtVO {
	private long id;
	private String examined = "N";
	private long examinerId = 0L;
	private String examinerName;
	private Date examineTime;
	private String paied = "N";
	private BigDecimal payCost = new BigDecimal(0);
	private BigDecimal paiedCost = new BigDecimal(0);
	private BigDecimal adjustCost = new BigDecimal(0);
	private String enabled = "Y";
	private long disableManId = 0L;
	private String hasPay = "N";
	private String hasAdjust = "N";
	private String hasGather = "N";
	private String gathered = "N";
	private Date smsTime;

	public Date getSmsTime() {
		return this.smsTime;
	}

	public void setSmsTime(Date smsTime) {
		this.smsTime = smsTime;
	}

	public BigDecimal getPayCost() {
		return this.payCost;
	}

	public void setPayCost(BigDecimal payCost) {
		this.payCost = payCost;
	}

	public Date getExamineTime() {
		return this.examineTime;
	}

	public void setExamineTime(Date examineTime) {
		this.examineTime = examineTime;
	}

	public String getGathered() {
		return this.gathered;
	}

	public void setGathered(String gathered) {
		this.gathered = gathered;
	}

	public BigDecimal getAdjustCost() {
		return this.adjustCost;
	}

	public void setAdjustCost(BigDecimal adjustCost) {
		this.adjustCost = adjustCost;
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

	public String getHasAdjust() {
		return this.hasAdjust;
	}

	public void setHasAdjust(String hasAdjust) {
		this.hasAdjust = hasAdjust;
	}

	public String getHasPay() {
		return this.hasPay;
	}

	public void setHasPay(String hasPay) {
		this.hasPay = hasPay;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPaied() {
		return this.paied;
	}

	public void setPaied(String paied) {
		this.paied = paied;
	}

	public BigDecimal getPaiedCost() {
		return this.paiedCost;
	}

	public void setPaiedCost(BigDecimal paiedCost) {
		this.paiedCost = paiedCost;
	}

	public String getHasGather() {
		return this.hasGather;
	}

	public void setHasGather(String hasGather) {
		this.hasGather = hasGather;
	}
}