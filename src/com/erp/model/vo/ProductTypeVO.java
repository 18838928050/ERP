/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;


public class ProductTypeVO implements SimpleObjectInterface, TreeObjectInterface {
	public static final String CODE_RULE = "PRODUCT_TYPE";
	private long id;
	private String typeName;
	private String typeCode;
	private long parentId = 0L;
	private String parentIdStr;
	private String nameSpell;
	private String enabled = "Y";

	@Override
	public String getObjectParentCodeStr() {
		return this.parentIdStr;
	}

	@Override
	public String getObjectCode() {
		return String.valueOf(this.id);
	}

	@Override
	public String getObjectParentCode() {
		return String.valueOf(this.parentId);
	}

	@Override
	public String getObjectName() {
		return this.typeName;
	}

	@Override
	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
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

	@Override
	public String toString() {
		return "ProductTypeVO [id=" + id + ", typeName=" + typeName + ", typeCode=" + typeCode
				+ ", parentId=" + parentId + ", parentIdStr=" + parentIdStr + ", nameSpell="
				+ nameSpell + ", enabled=" + enabled + "]";
	}
}