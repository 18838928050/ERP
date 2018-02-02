/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class WorkProcessVO implements SimpleObjectInterface {
	private long id;
	private String processName;
	private long workCenterId = 0L;
	private BigDecimal percent = new BigDecimal(0);
	private int sequenceCode = 0;
	private String enabled = "Y";
	private long depId = 0L;
	private String sys = "N";
	private BigDecimal price = new BigDecimal(0);

	@Override
	public String toString() {
		return "WorkProcessVO [id=" + id + ", processName=" + processName + ", workCenterId="
				+ workCenterId + ", percent=" + percent + ", sequenceCode=" + sequenceCode
				+ ", enabled=" + enabled + ", depId=" + depId + ", sys=" + sys + "]";
	}

	public String getSys() {
		return this.sys;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	public long getDepId() {
		return this.depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	@Override
	public String getObjectName() {
		return this.processName;
	}

	@Override
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProcessName() {
		return this.processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public long getWorkCenterId() {
		return this.workCenterId;
	}

	public void setWorkCenterId(long workCenterId) {
		this.workCenterId = workCenterId;
	}

	public BigDecimal getPercent() {
		return this.percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public int getSequenceCode() {
		return this.sequenceCode;
	}

	public void setSequenceCode(int sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}