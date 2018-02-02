package com.erp.controller.accounts.vo;


import java.math.BigDecimal;
import java.util.Date;
/**
 * 调账单
 * @author guo
 *	一个业务有多个调帐单调账，金额为多个cost的和 但是每一个都是有正负之分adjustType
 */
public class AdjustBillVO {
	public static final String CODE_RULE = "ADJUST_BILL";
	public static final String COLLECT_ADD = "COLLECT_ADD";
	public static final String COLLECT_ABATE = "COLLECT_ABATE";
	public static final String PAY_ADD = "PAY_ADD";
	public static final String PAY_ABATE = "PAY_ABATE";
	public static final String PUR_BACK_ADD = "PUR_BACK_ADD";
	public static final String PUR_BACK_ABATE = "PUR_BACK_ABATE";
	public static final String COO_ADD = "COO_ADD";
	public static final String COO_ABATE = "COO_ABATE";
	public static final String REL_TYPE_BUSINESS_BILL = "BUSINESS_BILL";
	public static final String REL_TYPE_PURCHASE_BILL = "PURCHASE_BILL";
	public static final String REL_TYPE_COOPER_BILL = "COOPER_BILL";
	private long id;
	private String billCode;
	private Date adjustDate = new Date();
	private long clientId = 0L;
	private long managerId = 0L;
	private String managerName;
	private long departmentId = 0L;//类型
	private BigDecimal cost = new BigDecimal(0);
	private String adjustType = "COLLECT_ABATE";//PAY_ABATE	PAY_ABATE减	PAY_ADD加
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
	private String relType = "BUSINESS_BILL";//PURCHASE_BILL
	private Date createTime;
	private Date examineTime;
	private String examSms = "Y";

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

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public String getBillCode() {
		return this.billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public long getClientId() {
		return this.clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Date getAdjustDate() {
		return this.adjustDate;
	}

	public void setAdjustDate(Date adjustDate) {
		this.adjustDate = adjustDate;
	}

	public String getAdjustType() {
		return this.adjustType;
	}

	public void setAdjustType(String adjustType) {
		this.adjustType = adjustType;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public long getDisableManId() {
		return this.disableManId;
	}

	public void setDisableManId(long disableManId) {
		this.disableManId = disableManId;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRelType() {
		return this.relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}
}