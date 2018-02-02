package com.erp.controller.customerBusiness.vo;

/**
 * 转账方式
 * @author guo
 *
 */

public class PayModeVO {
	private long id;
	private String modeName;
	private int sequenceCode = 0;
	private String enabled = "Y";

	public String getObjectName() {
		return this.modeName;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSequenceCode() {
		return this.sequenceCode;
	}

	public void setSequenceCode(int sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	public String getModeName() {
		return this.modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}
}