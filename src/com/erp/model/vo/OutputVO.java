/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class OutputVO {
	private long id;
	private long bbItemId = 0L;
	private long processId = 0L;
	private BigDecimal percent = new BigDecimal(0);
	private Date makeDate = new Date();
	private String mark;
	private long makerId = 0L;
	private String makerName;
	private long createrId = 0L;
	private String createrName;
	private Date createTime = new Date();
	private BigDecimal amount = new BigDecimal(0);

	public long getProcessId() {
		return this.processId;
	}

	@Override
	public String toString() {
		return "OutputVO [id=" + id + ", bbItemId=" + bbItemId + ", processId=" + processId
				+ ", percent=" + percent + ", makeDate=" + makeDate + ", mark=" + mark
				+ ", makerId=" + makerId + ", makerName=" + makerName + ", createrId=" + createrId
				+ ", createrName=" + createrName + ", createTime=" + createTime + "]";
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public BigDecimal getPercent() {
		return this.percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public long getBbItemId() {
		return this.bbItemId;
	}

	public void setBbItemId(long bbItemId) {
		this.bbItemId = bbItemId;
	}

	public long getCreaterId() {
		return this.createrId;
	}

	public void setCreaterId(long createrId) {
		this.createrId = createrId;
	}

	public String getCreaterName() {
		return this.createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getMakeDate() {
		return this.makeDate;
	}

	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	public long getMakerId() {
		return this.makerId;
	}

	public void setMakerId(long makerId) {
		this.makerId = makerId;
	}

	public String getMakerName() {
		return this.makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
}