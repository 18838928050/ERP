package com.erp.controller.subcontractCancel.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用于查询的条件属性封装
 * 
 * 使用地点
 * 1:外协单作废
 * 2:收货单作废
 * @author guo
 *
 */
/**
 * @author guo
 *
 */
public class SelectVO {
	private String beginDate ;//开始时间
	private String endDate ;//结束时间
	private String cooperatorId ;//外协单位 对用客户表
	private String managerName ;//业务员
	private String billCode ;//外协单号
	private String departmentId ;//部门
	private String beginCost;//外协金额
	private String endCost;//外协金额
	private String enabled ;//审核状态未找到
	private String tallySetId ;//账套
	
	
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCooperatorId() {
		return cooperatorId;
	}
	public void setCooperatorId(String cooperatorId) {
		this.cooperatorId = cooperatorId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getBeginCost() {
		return beginCost;
	}
	public void setBeginCost(String beginCost) {
		this.beginCost = beginCost;
	}
	public String getEndCost() {
		return endCost;
	}
	public void setEndCost(String endCost) {
		this.endCost = endCost;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getTallySetId() {
		return tallySetId;
	}
	public void setTallySetId(String tallySetId) {
		this.tallySetId = tallySetId;
	}
	@Override
	public String toString() {
		return "SelectVO [beginDate=" + beginDate + ", endDate=" + endDate + ", cooperatorId=" + cooperatorId
				+ ", managerName=" + managerName + ", billCode=" + billCode + ", departmentId=" + departmentId
				+ ", beginCost=" + beginCost + ", endCost=" + endCost + ", enabled=" + enabled + ", tallySetId="
				+ tallySetId + "]";
	}
}
