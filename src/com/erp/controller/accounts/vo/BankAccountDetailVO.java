/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.controller.accounts.vo;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 银行入账细节
 * @author guo
 *
 */
public class BankAccountDetailVO {
	private long id;
	private Date costDate;
	private long bankAccountId;
	private BigDecimal cost;
	private BigDecimal baCost;
	private String costType;
	private String billCode;
	private Date billDate;
	private String billType;
	private String extBillType;
	private String rcType;
	private String managerName;
	private String mark;//付款单位
	private long tallySetId;
	private long billId;
	private String financeType;
	private String operType;
	private String logData = "N";

	public String getLogData() {
		return this.logData;
	}

	public void setLogData(String logData) {
		this.logData = logData;
	}

	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public BigDecimal getBaCost() {
		return this.baCost;
	}

	public void setBaCost(BigDecimal baCost) {
		this.baCost = baCost;
	}

	public String getOperType() {
		return this.operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String getFinanceType() {
		return this.financeType;
	}

	public void setFinanceType(String financeType) {
		this.financeType = financeType;
	}

	public long getBankAccountId() {
		return this.bankAccountId;
	}

	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getBillCode() {
		return this.billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getCostDate() {
		return this.costDate;
	}

	public void setCostDate(Date costDate) {
		this.costDate = costDate;
	}

	public String getCostType() {
		return this.costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getRcType() {
		return this.rcType;
	}

	public void setRcType(String rcType) {
		this.rcType = rcType;
	}

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public long getBillId() {
		return this.billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public String getExtBillType() {
		return this.extBillType;
	}

	public void setExtBillType(String extBillType) {
		this.extBillType = extBillType;
	}
}