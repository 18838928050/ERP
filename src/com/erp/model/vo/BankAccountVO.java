/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class BankAccountVO
		 {
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
	private Integer str=0;
	

	


	/**
	 * @return the str
	 */
	public Integer getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(Integer str) {
		this.str = str;
	}

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

	@Override
	public String toString() {
		return "BankAccountVO [id=" + id + ", accountCode=" + accountCode
				+ ", accountName=" + accountName + ", bankName=" + bankName
				+ ", tallySetId=" + tallySetId + ", currentCost=" + currentCost
				+ ", enabled=" + enabled + ", status=" + status + ", isTmp="
				+ isTmp + ", sequenceCode=" + sequenceCode + "]";
	}
}