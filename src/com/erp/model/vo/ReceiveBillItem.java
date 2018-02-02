/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ReceiveBillItem {
	private long id;
	private long billId = 0L;
	private long businessBillId = 0L;
	private String businessBillCode;
	private String linkman;
	private String content;
	private Date orderDate;
	private BigDecimal totalCost = new BigDecimal(0);
	private BigDecimal remainCost = new BigDecimal(0);
	private BigDecimal thisCost = new BigDecimal(0);

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public long getBillId() {
		return this.billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public String getBusinessBillCode() {
		return this.businessBillCode;
	}

	public void setBusinessBillCode(String businessBillCode) {
		this.businessBillCode = businessBillCode;
	}

	public long getBusinessBillId() {
		return this.businessBillId;
	}

	public void setBusinessBillId(long businessBillId) {
		this.businessBillId = businessBillId;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}