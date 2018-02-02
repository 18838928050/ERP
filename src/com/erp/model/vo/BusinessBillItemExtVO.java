/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class BusinessBillItemExtVO {
	private long id;
	private BigDecimal deliAmou = new BigDecimal(0);
	private BigDecimal setuAmou = new BigDecimal(0);
	private String coopComp = "N";
	private BigDecimal coopAmou = new BigDecimal(0);
	private String wcComp = "N";
	private String operName;
	private long operId = 0L;
	private Date operTime;
	private String maked = "N";
	private String makerName;
	private long makerId = 0L;
	private Date makeTime;
	private String compStr;
	private String urgentFlag = "N";
	private long proId = 0L;
	private String proFlag = "N";
	private String lastPrinter;
	private int printNum = 0;
	private Date printTime;

	@Override
	public String toString() {
		return "BusinessBillItemExtVO [id=" + id + ", deliAmou=" + deliAmou + ", setuAmou="
				+ setuAmou + ", coopComp=" + coopComp + ", coopAmou=" + coopAmou + ", wcComp="
				+ wcComp + ", operName=" + operName + ", operId=" + operId + ", operTime="
				+ operTime + ", maked=" + maked + ", makerName=" + makerName + ", makerId="
				+ makerId + ", makeTime=" + makeTime + ", compStr=" + compStr + ", urgentFlag="
				+ urgentFlag + ", proId=" + proId + ", proFlag=" + proFlag + ", lastPrinter="
				+ lastPrinter + ", printNum=" + printNum + ", printTime=" + printTime + "]";
	}

	public BigDecimal getSetuAmou() {
		return this.setuAmou;
	}

	public void setSetuAmou(BigDecimal setuAmou) {
		this.setuAmou = setuAmou;
	}

	public Date getPrintTime() {
		return this.printTime;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
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

	public BigDecimal getDeliAmou() {
		return this.deliAmou;
	}

	public void setDeliAmou(BigDecimal deliAmou) {
		this.deliAmou = deliAmou;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoopComp() {
		return this.coopComp;
	}

	public void setCoopComp(String coopComp) {
		this.coopComp = coopComp;
	}

	public BigDecimal getCoopAmou() {
		return this.coopAmou;
	}

	public void setCoopAmou(BigDecimal coopAmou) {
		this.coopAmou = coopAmou;
	}

	public String getWcComp() {
		return this.wcComp;
	}

	public void setWcComp(String wcComp) {
		this.wcComp = wcComp;
	}

	public String getOperName() {
		return this.operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public long getOperId() {
		return this.operId;
	}

	public void setOperId(long operId) {
		this.operId = operId;
	}

	public Date getOperTime() {
		return this.operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public String getMaked() {
		return this.maked;
	}

	public void setMaked(String maked) {
		this.maked = maked;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public long getMakerId() {
		return this.makerId;
	}

	public void setMakerId(long makerId) {
		this.makerId = makerId;
	}

	public Date getMakeTime() {
		return this.makeTime;
	}

	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}

	public String getCompStr() {
		return this.compStr;
	}

	public void setCompStr(String compStr) {
		this.compStr = compStr;
	}

	public String getUrgentFlag() {
		return this.urgentFlag;
	}

	public void setUrgentFlag(String urgentFlag) {
		this.urgentFlag = urgentFlag;
	}

	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	public String getProFlag() {
		return this.proFlag;
	}

	public void setProFlag(String proFlag) {
		this.proFlag = proFlag;
	}
}