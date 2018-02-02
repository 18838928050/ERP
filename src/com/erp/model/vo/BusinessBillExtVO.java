/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class BusinessBillExtVO {
	private long id;
	private String examined = "N";
	private long examinerId = 0L;
	private String examinerName;
	private Date examineTime;
	private String completed = "N";
	private Date completeTime;
	private String closed = "N";
	private Date closeTime;
	private String closerName;
	private long closerId = 0L;
	private String makerName;
	private String collected = "N";
	private String maked = "N";
	private String delivered = "N";
	private String setuped = "N";
	private BigDecimal collectedCost = new BigDecimal(0);
	private BigDecimal receiveCost = new BigDecimal(0);
	private BigDecimal adjustCost = new BigDecimal(0);
	private String enabled = "Y";
	private long disableManId = 0L;
	private String lastPrinter;
	private int printNum = 0;
	private String hasReceive = "N";
	private String hasAdjust = "N";
	private String hasDeliver = "N";
	private String hasSetu = "N";
	private String examSms = "N";
	private String makeSms = "N";
	private Date receTime;

	public String getSetuped() {
		return this.setuped;
	}

	public void setSetuped(String setuped) {
		this.setuped = setuped;
	}

	public String getHasSetu() {
		return this.hasSetu;
	}

	public void setHasSetu(String hasSetu) {
		this.hasSetu = hasSetu;
	}

	public Date getReceTime() {
		return this.receTime;
	}

	public void setReceTime(Date receTime) {
		this.receTime = receTime;
	}

	public Date getCompleteTime() {
		return this.completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public BigDecimal getReceiveCost() {
		return this.receiveCost;
	}

	public void setReceiveCost(BigDecimal receiveCost) {
		this.receiveCost = receiveCost;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getExamineTime() {
		return this.examineTime;
	}

	public void setExamineTime(Date examineTime) {
		this.examineTime = examineTime;
	}

	public String getCompleted() {
		return this.completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getClosed() {
		return this.closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public Date getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getCloserName() {
		return this.closerName;
	}

	public void setCloserName(String closerName) {
		this.closerName = closerName;
	}

	public long getCloserId() {
		return this.closerId;
	}

	public void setCloserId(long closerId) {
		this.closerId = closerId;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getCollected() {
		return this.collected;
	}

	public void setCollected(String collected) {
		this.collected = collected;
	}

	public String getMaked() {
		return this.maked;
	}

	public void setMaked(String maked) {
		this.maked = maked;
	}

	public String getDelivered() {
		return this.delivered;
	}

	public void setDelivered(String delivered) {
		this.delivered = delivered;
	}

	public BigDecimal getCollectedCost() {
		return this.collectedCost;
	}

	public void setCollectedCost(BigDecimal collectedCost) {
		this.collectedCost = collectedCost;
	}

	public BigDecimal getAdjustCost() {
		return this.adjustCost;
	}

	public void setAdjustCost(BigDecimal adjustCost) {
		this.adjustCost = adjustCost;
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

	public String getLastPrinter() {
		return this.lastPrinter;
	}

	public void setLastPrinter(String lastPrinter) {
		this.lastPrinter = lastPrinter;
	}

	public int getPrintNum() {
		return this.printNum;
	}

	public void setPrintNum(int printNum) {
		this.printNum = printNum;
	}

	public String getHasReceive() {
		return this.hasReceive;
	}

	public void setHasReceive(String hasReceive) {
		this.hasReceive = hasReceive;
	}

	public String getHasAdjust() {
		return this.hasAdjust;
	}

	public void setHasAdjust(String hasAdjust) {
		this.hasAdjust = hasAdjust;
	}

	public String getHasDeliver() {
		return this.hasDeliver;
	}

	public void setHasDeliver(String hasDeliver) {
		this.hasDeliver = hasDeliver;
	}

	public String getExamSms() {
		return this.examSms;
	}

	public void setExamSms(String examSms) {
		this.examSms = examSms;
	}
	
	

	@Override
	public String toString() {
		return "BusinessBillExtVO [id=" + id + ", examined=" + examined
				+ ", examinerId=" + examinerId + ", examinerName="
				+ examinerName + ", examineTime=" + examineTime
				+ ", completed=" + completed + ", completeTime=" + completeTime
				+ ", closed=" + closed + ", closeTime=" + closeTime
				+ ", closerName=" + closerName + ", closerId=" + closerId
				+ ", makerName=" + makerName + ", collected=" + collected
				+ ", maked=" + maked + ", delivered=" + delivered
				+ ", setuped=" + setuped + ", collectedCost=" + collectedCost
				+ ", receiveCost=" + receiveCost + ", adjustCost=" + adjustCost
				+ ", enabled=" + enabled + ", disableManId=" + disableManId
				+ ", lastPrinter=" + lastPrinter + ", printNum=" + printNum
				+ ", hasReceive=" + hasReceive + ", hasAdjust=" + hasAdjust
				+ ", hasDeliver=" + hasDeliver + ", hasSetu=" + hasSetu
				+ ", examSms=" + examSms + ", makeSms=" + makeSms
				+ ", receTime=" + receTime + "]";
	}

	public String getMakeSms() {
		return this.makeSms;
	}

	public void setMakeSms(String makeSms) {
		this.makeSms = makeSms;
	}
}