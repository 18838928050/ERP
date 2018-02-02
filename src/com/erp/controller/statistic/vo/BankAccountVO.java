package com.erp.controller.statistic.vo;

import java.math.BigDecimal;
/**
 * 银行账户
 * @author guo
 *
 */
public class BankAccountVO {
	private long id;
	private String accountCode;
	private String accountName;
	private String bankName;
	private long tallySetId = 0L;
	private BigDecimal currentCost = new BigDecimal(0);
	private String enabled = "Y";
	private String status = "Y";
	private String isTmp = "Y";
	private int sequenceCode = 0;

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSequenceCode() {
		return this.sequenceCode;
	}

	public void setSequenceCode(int sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	public String getIsTmp() {
		return this.isTmp;
	}

	public void setIsTmp(String isTmp) {
		this.isTmp = isTmp;
	}

	public String getObjectName() {
		return this.bankName;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getCurrentCost() {
		return this.currentCost;
	}

	public void setCurrentCost(BigDecimal currentCost) {
		this.currentCost = currentCost;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public String getAccountCode() {
		return this.accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
}