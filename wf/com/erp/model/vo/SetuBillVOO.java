/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class SetuBillVOO {
	public static final String CODE_RULE = "SETU_BILL";
	private long id;
	private long bbId = 0L;
	private String billCode;
	private String lm;
	private String phon;
	private String addr;
	private String requ;
	private String setuIdStr;
	private String setuNameStr;
	private long mngId = 0L;
	private String mngName;
	private BigDecimal cost = new BigDecimal(0);
	private BigDecimal remaCost = new BigDecimal(0);
	private Date billDate = new Date();
	private Date planDate = new Date();
	private Date realDate = new Date();
	private String examImg;
	private String compImg;
	private String mark;
	private String needCar = "N";
	private String needHigh = "N";
	private String needWeld = "N";
	private String needStee = "N";
	private long creaId = 0L;
	private String creaName;
	private Date creaTime;
	private String exam = "N";
	private long examId = 0L;
	private String examName;
	private Date examTime;
	private String comp = "N";
	private long compId = 0L;
	private String compName;
	private Date compTime;
	private String enab = "Y";
	private long disaId = 0L;
	private Date updaTime = new Date();
	private long tsId = 0L;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBbId() {
		return this.bbId;
	}

	public void setBbId(long bbId) {
		this.bbId = bbId;
	}

	public String getBillCode() {
		return this.billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getLm() {
		return this.lm;
	}

	public void setLm(String lm) {
		this.lm = lm;
	}

	public String getPhon() {
		return this.phon;
	}

	public void setPhon(String phon) {
		this.phon = phon;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRequ() {
		return this.requ;
	}

	public void setRequ(String requ) {
		this.requ = requ;
	}

	public String getSetuIdStr() {
		return this.setuIdStr;
	}

	public void setSetuIdStr(String setuIdStr) {
		this.setuIdStr = setuIdStr;
	}

	public String getSetuNameStr() {
		return this.setuNameStr;
	}

	public void setSetuNameStr(String setuNameStr) {
		this.setuNameStr = setuNameStr;
	}

	public long getMngId() {
		return this.mngId;
	}

	public void setMngId(long mngId) {
		this.mngId = mngId;
	}

	public String getMngName() {
		return this.mngName;
	}

	public void setMngName(String mngName) {
		this.mngName = mngName;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getRemaCost() {
		return this.remaCost;
	}

	public void setRemaCost(BigDecimal remaCost) {
		this.remaCost = remaCost;
	}

	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Date getPlanDate() {
		return this.planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Date getRealDate() {
		return this.realDate;
	}

	public void setRealDate(Date realDate) {
		this.realDate = realDate;
	}

	public String getExamImg() {
		return this.examImg;
	}

	public void setExamImg(String examImg) {
		this.examImg = examImg;
	}

	public String getCompImg() {
		return this.compImg;
	}

	public void setCompImg(String compImg) {
		this.compImg = compImg;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getNeedCar() {
		return this.needCar;
	}

	public void setNeedCar(String needCar) {
		this.needCar = needCar;
	}

	public String getNeedHigh() {
		return this.needHigh;
	}

	public void setNeedHigh(String needHigh) {
		this.needHigh = needHigh;
	}

	public String getNeedWeld() {
		return this.needWeld;
	}

	public void setNeedWeld(String needWeld) {
		this.needWeld = needWeld;
	}

	public String getNeedStee() {
		return this.needStee;
	}

	public void setNeedStee(String needStee) {
		this.needStee = needStee;
	}

	public long getCreaId() {
		return this.creaId;
	}

	public void setCreaId(long creaId) {
		this.creaId = creaId;
	}

	public String getCreaName() {
		return this.creaName;
	}

	public void setCreaName(String creaName) {
		this.creaName = creaName;
	}

	public Date getCreaTime() {
		return this.creaTime;
	}

	public void setCreaTime(Date creaTime) {
		this.creaTime = creaTime;
	}

	public String getExam() {
		return this.exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public long getExamId() {
		return this.examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return this.examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Date getExamTime() {
		return this.examTime;
	}

	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}

	public String getComp() {
		return this.comp;
	}

	public void setComp(String comp) {
		this.comp = comp;
	}

	public long getCompId() {
		return this.compId;
	}

	public void setCompId(long compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Date getCompTime() {
		return this.compTime;
	}

	public void setCompTime(Date compTime) {
		this.compTime = compTime;
	}

	public String getEnab() {
		return this.enab;
	}

	public void setEnab(String enab) {
		this.enab = enab;
	}

	public long getDisaId() {
		return this.disaId;
	}

	public void setDisaId(long disaId) {
		this.disaId = disaId;
	}

	public Date getUpdaTime() {
		return this.updaTime;
	}

	public void setUpdaTime(Date updaTime) {
		this.updaTime = updaTime;
	}

	public long getTsId() {
		return this.tsId;
	}

	public void setTsId(long tsId) {
		this.tsId = tsId;
	}
}