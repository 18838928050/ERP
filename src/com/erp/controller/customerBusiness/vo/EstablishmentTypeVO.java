package com.erp.controller.customerBusiness.vo;

/**
 * 客户类型
 * @author guo
 *
 */
public class EstablishmentTypeVO   {
	private long id;
	private String typeName;//客户类型名
	private int sequenceCode = 0;//标识
	private String enabled = "Y";//启用

	public String getObjectName() {
		return this.typeName;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public int getSequenceCode() {
		return this.sequenceCode;
	}

	public void setSequenceCode(int sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}