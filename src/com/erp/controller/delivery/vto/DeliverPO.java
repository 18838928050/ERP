package com.erp.controller.delivery.vto;

import java.math.BigDecimal;
import java.util.Date;

public class DeliverPO {
	private Date deliverDate = new Date();//交货日期
	private String billCode;//送货单号
	private String content;//摘要
	private String typeName;//项目类型
	private String finishedContent;//内容
	private String proName;//材质
	private String specification;//规格
	private String unit;//单位
	private BigDecimal amount;//数量
	private BigDecimal unitPrice;//单价
	private BigDecimal cost;//金额
	private String address;//订货单位
	private String modeName;//付款方式
	private String createrName;//业务员
	private String billCodeB;//业务单号
	public Date getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getFinishedContent() {
		return finishedContent;
	}
	public void setFinishedContent(String finishedContent) {
		this.finishedContent = finishedContent;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getModeName() {
		return modeName;
	}
	public void setModeName(String modeName) {
		this.modeName = modeName;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getBillCodeB() {
		return billCodeB;
	}
	public void setBillCodeB(String billCodeB) {
		this.billCodeB = billCodeB;
	}
	
}
