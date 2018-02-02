/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class ProductVO {
	public static final String CODE_RULE = "PRODUCT";
	private long id;
	private String productCode;
	private String productName;
	private String pnSpell;
	private String patria;
	private String unit;
	private String minorUnit;
	private String unitConvert;
	private long productTypeId = 0L;
	private String barCode;
	private BigDecimal maxLimit = new BigDecimal(0);
	private BigDecimal minLimit = new BigDecimal(0);
	private String enabled = "Y";
	private String mark;
	private BigDecimal saleCost1 = new BigDecimal(0);
	private BigDecimal saleCost2 = new BigDecimal(0);
	private BigDecimal saleCost3 = new BigDecimal(0);
	private BigDecimal saleCost4 = new BigDecimal(0);
	private String attachFile;

	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
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

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public BigDecimal getMaxLimit() {
		return this.maxLimit;
	}

	public void setMaxLimit(BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}

	public BigDecimal getMinLimit() {
		return this.minLimit;
	}

	public void setMinLimit(BigDecimal minLimit) {
		this.minLimit = minLimit;
	}

	public String getMinorUnit() {
		return this.minorUnit;
	}

	public void setMinorUnit(String minorUnit) {
		this.minorUnit = minorUnit;
	}

	public String getPatria() {
		return this.patria;
	}

	public void setPatria(String patria) {
		this.patria = patria;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getUnitConvert() {
		return this.unitConvert;
	}

	public void setUnitConvert(String unitConvert) {
		this.unitConvert = unitConvert;
	}

	public BigDecimal getSaleCost1() {
		return this.saleCost1;
	}

	public void setSaleCost1(BigDecimal saleCost1) {
		this.saleCost1 = saleCost1;
	}

	public BigDecimal getSaleCost2() {
		return this.saleCost2;
	}

	public void setSaleCost2(BigDecimal saleCost2) {
		this.saleCost2 = saleCost2;
	}

	public BigDecimal getSaleCost3() {
		return this.saleCost3;
	}

	public void setSaleCost3(BigDecimal saleCost3) {
		this.saleCost3 = saleCost3;
	}

	public BigDecimal getSaleCost4() {
		return this.saleCost4;
	}

	public void setSaleCost4(BigDecimal saleCost4) {
		this.saleCost4 = saleCost4;
	}

	public String getPnSpell() {
		return this.pnSpell;
	}

	public void setPnSpell(String pnSpell) {
		this.pnSpell = pnSpell;
	}

	public String getAttachFile() {
		return this.attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", productCode=" + productCode + ", productName="
				+ productName + ", pnSpell=" + pnSpell + ", patria=" + patria + ", unit=" + unit
				+ ", minorUnit=" + minorUnit + ", unitConvert=" + unitConvert + ", productTypeId="
				+ productTypeId + ", barCode=" + barCode + ", maxLimit=" + maxLimit + ", minLimit="
				+ minLimit + ", enabled=" + enabled + ", mark=" + mark + ", saleCost1=" + saleCost1
				+ ", saleCost2=" + saleCost2 + ", saleCost3=" + saleCost3 + ", saleCost4="
				+ saleCost4 + ", attachFile=" + attachFile + "]";
	}
	
}