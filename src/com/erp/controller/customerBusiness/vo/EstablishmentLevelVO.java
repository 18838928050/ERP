package com.erp.controller.customerBusiness.vo;

/**
 * 客户等级
 * @author guo
 *
 */

public class EstablishmentLevelVO{
	private long id;
	private String levelName;
	private int sequenceCode = 0;
	private String enabled = "Y";

	public String getObjectName() {
		return this.levelName;
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

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
}