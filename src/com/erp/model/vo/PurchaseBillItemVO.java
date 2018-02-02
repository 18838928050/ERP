/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class PurchaseBillItemVO {
	private long id;
	private long billId = 0L;
	private long productId = 0L;
	private BigDecimal amount = new BigDecimal(0);
	private BigDecimal unitPrice = new BigDecimal(0);
	private BigDecimal cost = new BigDecimal(0);
	private BigDecimal outUnitPrice = new BigDecimal(0);
	private BigDecimal outCost = new BigDecimal(0);
	private String mark;

	public BigDecimal getOutUnitPrice() {
		return this.outUnitPrice;
	}

	public void setOutUnitPrice(BigDecimal outUnitPrice) {
		this.outUnitPrice = outUnitPrice;
	}

	public BigDecimal getOutCost() {
		return this.outCost;
	}

	public void setOutCost(BigDecimal outCost) {
		this.outCost = outCost;
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

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "PurchaseBillItemVO [id=" + id + ", billId=" + billId + ", productId=" + productId
				+ ", amount=" + amount + ", unitPrice=" + unitPrice + ", cost=" + cost
				+ ", outUnitPrice=" + outUnitPrice + ", outCost=" + outCost + ", mark=" + mark
				+ "]";
	}
	
}