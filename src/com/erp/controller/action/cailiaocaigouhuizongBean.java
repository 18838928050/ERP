/**
 * 
 */
package com.erp.controller.action;

import java.math.BigDecimal;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DecimalDV;

/**
 @author： 如约而至    @time：2017年11月26日 下午1:06:32 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class cailiaocaigouhuizongBean {
	private String productCode;
	private String productName;
	private String unit;
	private BigDecimal amount;
	private BigDecimal unitPrice;
	private BigDecimal cost;
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String toString() {
		return "cailiaocaigouhuizongBean [productCode=" + productCode
				+ ", productName=" + productName + ", unit=" + unit
				+ ", amount=" + amount + ", unitPrice=" + unitPrice + ", cost="
				+ cost + "]";
	}

}