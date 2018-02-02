/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class EstPriceVO {
	private long id;
	private long estId = 0L;
	private long proId = 0L;
	private String proName;
	private String length;
	private String width;
	private String specification;
	private String unit;
	private BigDecimal price = new BigDecimal(0);
	private String mark;
	private long makeTypeId;

	public int getSequenceCode() {
		return sequenceCode;
	}

	public void setSequenceCode(int sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	private String makeRequire;
	private String priceType = "STA";
	private String estType = "CLIENT";
	private String attachFile;
	private String proSpell;
	private int sequenceCode = 0;

	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	public String getProSpell() {
		return this.proSpell;
	}

	public void setProSpell(String proSpell) {
		this.proSpell = proSpell;
	}

	public String getAttachFile() {
		return this.attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getLength() {
		return this.length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return this.width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getPriceType() {
		return this.priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getEstType() {
		return this.estType;
	}

	public void setEstType(String estType) {
		this.estType = estType;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public long getMakeTypeId() {
		return this.makeTypeId;
	}

	public void setMakeTypeId(long makeTypeId) {
		this.makeTypeId = makeTypeId;
	}

	public String getMakeRequire() {
		return this.makeRequire;
	}

	public void setMakeRequire(String makeRequire) {
		this.makeRequire = makeRequire;
	}

	public long getEstId() {
		return this.estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "EstPriceVO [id=" + id + ", estId=" + estId + ", proId=" + proId
				+ ", proName=" + proName + ", length=" + length + ", width="
				+ width + ", specification=" + specification + ", unit=" + unit
				+ ", price=" + price + ", mark=" + mark + ", makeTypeId="
				+ makeTypeId + ", makeRequire=" + makeRequire + ", priceType="
				+ priceType + ", estType=" + estType + ", attachFile="
				+ attachFile + ", proSpell=" + proSpell + ", sequenceCode="
				+ sequenceCode + "]";
	}

}