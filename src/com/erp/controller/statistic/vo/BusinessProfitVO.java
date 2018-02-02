package com.erp.controller.statistic.vo;


import java.math.BigDecimal;

//账单表 金额
public class BusinessProfitVO {
	private long id;
	private String bbCode;
	private BigDecimal materialCost = new BigDecimal(0);
	private BigDecimal cooperCost = new BigDecimal(0);
	private BigDecimal feeCost = new BigDecimal(0);
	private BigDecimal profitCost = new BigDecimal(0);//业务单  欠款

	public String getBbCode() {
		return this.bbCode;
	}

	public void setBbCode(String bbCode) {
		this.bbCode = bbCode;
	}

	public BigDecimal getCooperCost() {
		return this.cooperCost;
	}

	public void setCooperCost(BigDecimal cooperCost) {
		this.cooperCost = cooperCost;
	}

	public BigDecimal getFeeCost() {
		return this.feeCost;
	}

	public void setFeeCost(BigDecimal feeCost) {
		this.feeCost = feeCost;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getMaterialCost() {
		return this.materialCost;
	}

	public void setMaterialCost(BigDecimal materialCost) {
		this.materialCost = materialCost;
	}

	public BigDecimal getProfitCost() {
		return this.profitCost;
	}

	public void setProfitCost(BigDecimal profitCost) {
		this.profitCost = profitCost;
	}
}