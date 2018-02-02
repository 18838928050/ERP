package com.erp.controller.accounts.vo;

/**
 * 其它收入单
 */
import java.math.BigDecimal;
import java.util.Date;

public class IncomeBillVO {
	public static final String CODE_RULE = "INCOME_BILL";
	private long id;
	private String billCode;//单号
	private Date incomeDate = new Date();//日期
	private long departmentId = 0L;
	private long payModeId = 0L;//付款方式
	
	private long bankAccountId = 0L;
	private BigDecimal cost = new BigDecimal(0);
	private long incomeTypeId = 0L;
	private long managerId;
	private String managerName;//经办人
	private String mark;//摘要
	private String examined = "N";//状态
	private long examinerId = 0L;
	private String examinerName;
	private long createrId = 0L;
	private String createrName;
	private String enabled = "Y";//激活
	private long disableManId = 0L;
	private Date updateTime = new Date();
	private long tallySetId = 0L;//账套
	private Date createTime;
	private Date examineTime;
	private String payerName;//付款单位
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

	public String getPayerName() {
		return this.payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
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

	public Date getIncomeDate() {
		return this.incomeDate;
	}

	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}

	public long getIncomeTypeId() {
		return this.incomeTypeId;
	}

	public void setIncomeTypeId(long incomeTypeId) {
		this.incomeTypeId = incomeTypeId;
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

	public long getPayModeId() {
		return this.payModeId;
	}

	public void setPayModeId(long payModeId) {
		this.payModeId = payModeId;
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
}