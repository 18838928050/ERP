package com.erp.controller.stock.vo;


import java.math.BigDecimal;
import java.util.Date;
/**
 * 仓库进出记录
 * @author guo
 *
 */
public class InOutHistoryVO {
	private long id;
	private long stoId = 0L;
	private long proId = 0L;
	private BigDecimal amount = new BigDecimal(0);//数量
	private BigDecimal cost = new BigDecimal(0);//金额
	private BigDecimal unitPrice = new BigDecimal(0);//单价
	private Date ioTime = new Date();
	private Date billDate;//日期
	private String ioType;
	private String billType;//类型	IN_BILL入	PURC_BILL采购		OUT_BILL出	OUT调出	IN调入
	private String operType;
	private long billId = 0L;
	private long typeId = 0L;
	private long requId = 0L;
	private String requType;
	private String bbCode;
	private String billCode;//单号
	private String requName;//供需方
	private String mark;//备注
	private String logData = "N";
	private BigDecimal storAmou = new BigDecimal(0);
	private BigDecimal storCost = new BigDecimal(0);
	private BigDecimal storUp = new BigDecimal(0);

	public BigDecimal getStorAmou() {
		return this.storAmou;
	}

	public void setStorAmou(BigDecimal storAmou) {
		this.storAmou = storAmou;
	}

	public BigDecimal getStorCost() {
		return this.storCost;
	}

	public void setStorCost(BigDecimal storCost) {
		this.storCost = storCost;
	}

	public BigDecimal getStorUp() {
		return this.storUp;
	}

	public void setStorUp(BigDecimal storUp) {
		this.storUp = storUp;
	}

	public String getLogData() {
		return this.logData;
	}

	public void setLogData(String logData) {
		this.logData = logData;
	}

	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public long getRequId() {
		return this.requId;
	}

	public void setRequId(long requId) {
		this.requId = requId;
	}

	public String getRequType() {
		return this.requType;
	}

	public void setRequType(String requType) {
		this.requType = requType;
	}

	public String getBillCode() {
		return this.billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getRequName() {
		return this.requName;
	}

	public void setRequName(String requName) {
		this.requName = requName;
	}

	public String getOperType() {
		return this.operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getBbCode() {
		return this.bbCode;
	}

	public void setBbCode(String bbCode) {
		this.bbCode = bbCode;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public long getBillId() {
		return this.billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getIoTime() {
		return this.ioTime;
	}

	public void setIoTime(Date ioTime) {
		this.ioTime = ioTime;
	}

	public String getIoType() {
		return this.ioType;
	}

	public void setIoType(String ioType) {
		this.ioType = ioType;
	}

	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	public long getStoId() {
		return this.stoId;
	}

	public void setStoId(long stoId) {
		this.stoId = stoId;
	}
}