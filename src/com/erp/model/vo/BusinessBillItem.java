/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class BusinessBillItem {
	public static final String PRICE_TYPE_AMOUNT = "AMOUNT";
	public static final String PRICE_TYPE_LENGTH = "LENGTH";
	public static final String PRICE_TYPE_AREA = "AREA";
	private long id;
	private long billId = 0L;
	private String makeRequire;
	private BigDecimal amount = new BigDecimal(0);//数量
	private BigDecimal unitPrice = new BigDecimal(0);//单价
	private BigDecimal cost = new BigDecimal(0);
	private long makeTypeId = 0L;
	private BigDecimal length = new BigDecimal(0);
	private BigDecimal width = new BigDecimal(0);
	private BigDecimal squareNum = new BigDecimal(0);
	private long proId = 0L;
	private String proName;//材质
	private String specification;//规格
	private String finishedContent;//内容
	private String unit;//单位
	private String priceType;
	private long wcId = 0L;
	private String isCoop = "N";
	private String lengType = "M";
	private String isSetu = "N";

	public String getIsSetu() {
		return this.isSetu;
	}

	public void setIsSetu(String isSetu) {
		this.isSetu = isSetu;
	}

	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	public String getLengType() {
		return this.lengType;
	}

	public void setLengType(String lengType) {
		this.lengType = lengType;
	}

	public String getIsCoop() {
		return this.isCoop;
	}

	public void setIsCoop(String isCoop) {
		this.isCoop = isCoop;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
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

	public String getMakeRequire() {
		return this.makeRequire;
	}

	public void setMakeRequire(String makeRequire) {
		this.makeRequire = makeRequire;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public long getMakeTypeId() {
		return this.makeTypeId;
	}

	public void setMakeTypeId(long makeTypeId) {
		this.makeTypeId = makeTypeId;
	}

	public BigDecimal getSquareNum() {
		return this.squareNum;
	}

	public void setSquareNum(BigDecimal squareNum) {
		this.squareNum = squareNum;
	}

	public String getPriceType() {
		return this.priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public BigDecimal getWidth() {
		return this.width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public String getFinishedContent() {
		return this.finishedContent;
	}

	public void setFinishedContent(String finishedContent) {
		this.finishedContent = finishedContent;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public long getWcId() {
		return this.wcId;
	}

	public void setWcId(long wcId) {
		this.wcId = wcId;
	}

	public String toString() {
		return "BusinessBillItem [id=" + id + ", billId=" + billId + ", makeRequire=" + makeRequire + ", amount="
				+ amount + ", unitPrice=" + unitPrice + ", cost=" + cost + ", makeTypeId=" + makeTypeId + ", length="
				+ length + ", width=" + width + ", squareNum=" + squareNum + ", proId=" + proId + ", proName=" + proName
				+ ", specification=" + specification + ", finishedContent=" + finishedContent + ", unit=" + unit
				+ ", priceType=" + priceType + ", wcId=" + wcId + ", isCoop=" + isCoop + ", lengType=" + lengType
				+ ", isSetu=" + isSetu + "]";
	}
	
}