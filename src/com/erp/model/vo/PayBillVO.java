package com.erp.model.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PayBillVO {
	public static final String CODE_RULE = "PAY_BILL";
	public static final String PAY_TYPE_PURCHASE = "PURCHASE";
	public static final String PAY_TYPE_COOPER = "COOPER";
	private long id;
	private String billCode;
	private Date payDate = new Date();
	private long receiverId = 0L;
	private long managerId = 0L;
	private String managerName;
	private long departmentId = 0L;
	private long payModeId = 0L;
	private long bankAccountId = 0L;
	private BigDecimal cost = new BigDecimal(0);
	private String description;
	private String mark;
	private long createrId = 0L;
	private String createrName;
	private String examined = "N";
	private long examinerId = 0L;
	private String examinerName;
	private String enabled = "Y";
	private long disableManId = 0L;
	private Date updateTime = new Date();
	private long tallySetId = 0L;
	private String payType;
	private Date createTime;
	private Date examineTime;
	private String examSms = "Y";
	private String attachFile;

	public String getAttachFile() {
		return this.attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getExamSms() {
		return this.examSms;
	}

	public void setExamSms(String examSms) {
		this.examSms = examSms;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getExamineTime() {
		return this.examineTime;
	}

	public void setExamineTime(Date examineTime) {
		this.examineTime = examineTime;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
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

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public long getCreaterId() {
		return this.createrId;
	}

	public void setCreaterId(long createrId) {
		this.createrId = createrId;
	}

	public String getCreaterName() {
		return this.createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getDisableManId() {
		return this.disableManId;
	}

	public void setDisableManId(long disableManId) {
		this.disableManId = disableManId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getExamined() {
		return this.examined;
	}

	public void setExamined(String examined) {
		this.examined = examined;
	}

	public long getExaminerId() {
		return this.examinerId;
	}

	public void setExaminerId(long examinerId) {
		this.examinerId = examinerId;
	}

	public String getExaminerName() {
		return this.examinerName;
	}

	public void setExaminerName(String examinerName) {
		this.examinerName = examinerName;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getManagerId() {
		return this.managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
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

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public long getPayModeId() {
		return this.payModeId;
	}

	public void setPayModeId(long payModeId) {
		this.payModeId = payModeId;
	}

	public long getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PayBillVO [id=" + id + ", billCode=" + billCode + ", payDate=" + payDate
				+ ", receiverId=" + receiverId + ", managerId=" + managerId + ", managerName="
				+ managerName + ", departmentId=" + departmentId + ", payModeId=" + payModeId
				+ ", bankAccountId=" + bankAccountId + ", cost=" + cost + ", description="
				+ description + ", mark=" + mark + ", createrId=" + createrId + ", createrName="
				+ createrName + ", examined=" + examined + ", examinerId=" + examinerId
				+ ", examinerName=" + examinerName + ", enabled=" + enabled + ", disableManId="
				+ disableManId + ", updateTime=" + updateTime + ", tallySetId=" + tallySetId
				+ ", payType=" + payType + ", createTime=" + createTime + ", examineTime="
				+ examineTime + ", examSms=" + examSms + ", attachFile=" + attachFile + "]";
	}

}