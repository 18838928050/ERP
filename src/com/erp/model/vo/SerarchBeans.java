/**
 * 
 */
package com.erp.model.vo;

import java.math.BigDecimal;

/**
 * @author： 如约而至 @time：2017年9月24日 上午9:37:53
 *******************************************************************
 @说明： 业务单一览表查询条件汇总
 *******************************************************************/
public class SerarchBeans {
	// 打印
	private String isPrintstr;
	// 审核
	private String isModifystr;
	// 完工
	private String isComplete;
	// 送货
	private String isDelivestr;
	// 收款
	private String isGetmonstr;
	// 结清
	private String isStopmoneystr;
	// 优惠
	private String isYouhuistr;
	// 合同
	private String isHetongstr;
	// 录入途径
	private String isLurustr;

	// 起订货金额
	private BigDecimal beginCost;
	// 末 订货金额
	private BigDecimal endCost;
	// 业务员姓名
	private String yewuyuanName;
	// 设计人姓名
	private String designName;
	// 跟单员姓名
	private String flowName;
	// 业务来源
	private String source;
	// 开单人
	private String createOrderName;
	// 送过地址
	private String address;

	// 订货起 订货日期 似乎是对应审核日期 checkDate
	// criteria.add(Restrictions.ge("checkDate",
	// Date.valueOf(se.getOrderDateStart())));
	private String orderDateStart;
	// 订货末
	private String orderDateEnd;
	// 订单号
	private String billCode;
	// 交货起
	private String deliverDateStart;
	// 交货结
	private String deliverDateEnd;
	// 完工起
	private String completeDateStart;
	// 完工结
	private String completeDateEnd;
	// 合同号
	private String contractCode;
	// 订货单位
	private String estName;
	// 联系人
	private String linkMan;
	// 电话
	private String phone;
	// 摘要
	private String mark;
	// 付款方式
	private long payModeId = 0;
	// 账套
	private long tallySetId = 0;

	public String getOrderDateStart() {
		return orderDateStart;
	}

	public void setOrderDateStart(String orderDateStart) {
		this.orderDateStart = orderDateStart;
	}

	public String getOrderDateEnd() {
		return orderDateEnd;
	}

	public void setOrderDateEnd(String orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getDeliverDateStart() {
		return deliverDateStart;
	}

	public void setDeliverDateStart(String deliverDateStart) {
		this.deliverDateStart = deliverDateStart;
	}

	public String getDeliverDateEnd() {
		return deliverDateEnd;
	}

	public void setDeliverDateEnd(String deliverDateEnd) {
		this.deliverDateEnd = deliverDateEnd;
	}

	public String getCompleteDateStart() {
		return completeDateStart;
	}

	public void setCompleteDateStart(String completeDateStart) {
		this.completeDateStart = completeDateStart;
	}

	public String getCompleteDateEnd() {
		return completeDateEnd;
	}

	public void setCompleteDateEnd(String completeDateEnd) {
		this.completeDateEnd = completeDateEnd;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getEstName() {
		return estName;
	}

	public void setEstName(String estName) {
		this.estName = estName;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public long getPayModeId() {
		return payModeId;
	}

	public void setPayModeId(long payModeId) {
		this.payModeId = payModeId;
	}

	public long getTallySetId() {
		return tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public String getIsHetongstr() {
		return isHetongstr;
	}

	public void setIsHetongstr(String isHetongstr) {
		this.isHetongstr = isHetongstr;
	}

	public String getIsLurustr() {
		return isLurustr;
	}

	public void setIsLurustr(String isLurustr) {
		this.isLurustr = isLurustr;
	}

	public BigDecimal getBeginCost() {
		return beginCost;
	}

	public void setBeginCost(BigDecimal beginCost) {
		this.beginCost = beginCost;
	}

	public BigDecimal getEndCost() {
		return endCost;
	}

	public void setEndCost(BigDecimal endCost) {
		this.endCost = endCost;
	}

	public String getYewuyuanName() {
		return yewuyuanName;
	}

	public void setYewuyuanName(String yewuyuanName) {
		this.yewuyuanName = yewuyuanName;
	}

	public String getDesignName() {
		return designName;
	}

	public void setDesignName(String designName) {
		this.designName = designName;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreateOrderName() {
		return createOrderName;
	}

	public void setCreateOrderName(String createOrderName) {
		this.createOrderName = createOrderName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsPrintstr() {
		return isPrintstr;
	}

	public void setIsPrintstr(String isPrintstr) {
		this.isPrintstr = isPrintstr;
	}

	public String getIsModifystr() {
		return isModifystr;
	}

	public void setIsModifystr(String isModifystr) {
		this.isModifystr = isModifystr;
	}

	public String getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}

	public String getIsDelivestr() {
		return isDelivestr;
	}

	public void setIsDelivestr(String isDelivestr) {
		this.isDelivestr = isDelivestr;
	}

	public String getIsGetmonstr() {
		return isGetmonstr;
	}

	public void setIsGetmonstr(String isGetmonstr) {
		this.isGetmonstr = isGetmonstr;
	}

	public String getIsStopmoneystr() {
		return isStopmoneystr;
	}

	public void setIsStopmoneystr(String isStopmoneystr) {
		this.isStopmoneystr = isStopmoneystr;
	}

	public String getIsYouhuistr() {
		return isYouhuistr;
	}

	public void setIsYouhuistr(String isYouhuistr) {
		this.isYouhuistr = isYouhuistr;
	}

}
