package com.erp.model.vo;


public class ProductType  {
	public static final String CODE_RULE = "PRODUCT_TYPE";
	private long id;
	private String typeName;
	private String typeCode;
	private long parentId = 0L;
	private String parentIdStr;
	private String nameSpell;
	private String enabled = "Y";

	public String getObjectParentCodeStr() {
		return this.parentIdStr;
	}

	public String getObjectCode() {
		return String.valueOf(this.id);
	}

	public String getObjectParentCode() {
		return String.valueOf(this.parentId);
	}

	public String getObjectName() {
		return this.typeName;
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

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getParentIdStr() {
		return this.parentIdStr;
	}

	public void setParentIdStr(String parentIdStr) {
		this.parentIdStr = parentIdStr;
	}

	public String getNameSpell() {
		return this.nameSpell;
	}

	public void setNameSpell(String nameSpell) {
		this.nameSpell = nameSpell;
	}
}