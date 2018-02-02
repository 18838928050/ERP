/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PayBillItemVO {
	private long id;
	private long billId = 0L;
	private long purchaseBillId = 0L;
	private String purchaseBillCode;
	private String content;
	private Date purchaseDate;
	private BigDecimal totalCost = new BigDecimal(0);
	private BigDecimal remainCost = new BigDecimal(0);
	private BigDecimal thisCost = new BigDecimal(0);

	public long getBillId() {
		return this.billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getRemainCost() {
		return this.remainCost;
	}

	public void setRemainCost(BigDecimal remainCost) {
		this.remainCost = remainCost;
	}

	public BigDecimal getThisCost() {
		return this.thisCost;
	}

	public void setThisCost(BigDecimal thisCost) {
		this.thisCost = thisCost;
	}

	public BigDecimal getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getPurchaseBillCode() {
		return this.purchaseBillCode;
	}

	public void setPurchaseBillCode(String purchaseBillCode) {
		this.purchaseBillCode = purchaseBillCode;
	}

	public long getPurchaseBillId() {
		return this.purchaseBillId;
	}

	public void setPurchaseBillId(long purchaseBillId) {
		this.purchaseBillId = purchaseBillId;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PayBillItemVO [id=" + id + ", billId=" + billId + ", purchaseBillId="
				+ purchaseBillId + ", purchaseBillCode=" + purchaseBillCode + ", content="
				+ content + ", purchaseDate=" + purchaseDate + ", totalCost=" + totalCost
				+ ", remainCost=" + remainCost + ", thisCost=" + thisCost + "]";
	}

}