/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class FeeBillItemVO {
	private long id;
	private long billId = 0L;
	private long ftId = 0L;
	private BigDecimal cost = new BigDecimal(0);
	private String mark;
	private long bbId;
	private String bbCode;

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

	public long getFtId() {
		return this.ftId;
	}

	public void setFtId(long ftId) {
		this.ftId = ftId;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public long getBbId() {
		return this.bbId;
	}

	public void setBbId(long bbId) {
		this.bbId = bbId;
	}

	public String getBbCode() {
		return this.bbCode;
	}

	public void setBbCode(String bbCode) {
		this.bbCode = bbCode;
	}

	@Override
	public String toString() {
		return "FeeBillItemVO [id=" + id + ", billId=" + billId + ", ftId=" + ftId + ", cost="
				+ cost + ", mark=" + mark + ", bbId=" + bbId + ", bbCode=" + bbCode + "]";
	}

}