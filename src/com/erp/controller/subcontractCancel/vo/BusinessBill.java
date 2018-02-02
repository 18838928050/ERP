package com.erp.controller.subcontractCancel.vo;

import java.math.BigDecimal;
import java.util.Date;

public class BusinessBill {
	public static final String CODE_RULE = "BUSINESS_BILL";
	private long id;
	private String billCode;
	private long clientId = 0L;
	private String linkman;
	private String phone;
	private String address;
	private Date orderDate = new Date();
	private Date deliverDate = new Date();
	private Date checkDate = new Date();
	private String content;
	private BigDecimal amount = new BigDecimal(0);
	private BigDecimal cost = new BigDecimal(0);
	private BigDecimal square = new BigDecimal(0);
	private BigDecimal lengM = new BigDecimal(0);
	private BigDecimal lengCm = new BigDecimal(0);
	private long bankAccountId = 0L;
	private long payModeId = 0L;
	private BigDecimal imprest = new BigDecimal(0);
	private BigDecimal favCost = new BigDecimal(0);
	private long managerId = 0L;
	private String managerName;
	private long departmentId = 0L;
	private String setupRequire;
	private String ladingRequire;
	private String mark;
	private String contractCode;
	private long tallySetId = 0L;
	private long introducerId = 0L;
	private String introducerName;
	private String designType = "SELF";
	private String designerIdStr;
	private String designerNameStr;
	private String followerIdStr;
	private String followerNameStr;
	private long createrId = 0L;
	private String createrName;
	private Date createTime = new Date();
	private Date updateTime = new Date();
	private long modifierId = 0L;
	private String modifierName;
	private Date modifyTime;
	private String sourType = "INNER";

	public String getSourType() {
		return this.sourType;
	}

	public void setSourType(String sourType) {
		this.sourType = sourType;
	}

	public BigDecimal getLengM() {
		return this.lengM;
	}

	public void setLengM(BigDecimal lengM) {
		this.lengM = lengM;
	}

	public BigDecimal getLengCm() {
		return this.lengCm;
	}

	public void setLengCm(BigDecimal lengCm) {
		this.lengCm = lengCm;
	}

	public String getFollowerIdStr() {
		return this.followerIdStr;
	}

	public void setFollowerIdStr(String followerIdStr) {
		this.followerIdStr = followerIdStr;
	}

	public String getFollowerNameStr() {
		return this.followerNameStr;
	}

	public void setFollowerNameStr(String followerNameStr) {
		this.followerNameStr = followerNameStr;
	}

	public long getIntroducerId() {
		return this.introducerId;
	}

	public void setIntroducerId(long introducerId) {
		this.introducerId = introducerId;
	}

	public String getIntroducerName() {
		return this.introducerName;
	}

	public void setIntroducerName(String introducerName) {
		this.introducerName = introducerName;
	}

	public String getDesignType() {
		return this.designType;
	}

	public void setDesignType(String designType) {
		this.designType = designType;
	}

	public String getDesignerIdStr() {
		return this.designerIdStr;
	}

	public void setDesignerIdStr(String designerIdStr) {
		this.designerIdStr = designerIdStr;
	}

	public String getDesignerNameStr() {
		return this.designerNameStr;
	}

	public void setDesignerNameStr(String designerNameStr) {
		this.designerNameStr = designerNameStr;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getModifierId() {
		return this.modifierId;
	}

	public void setModifierId(long modifierId) {
		this.modifierId = modifierId;
	}

	public String getModifierName() {
		return this.modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public long getClientId() {
		return this.clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getDeliverDate() {
		return this.deliverDate;
	}

	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getImprest() {
		return this.imprest;
	}

	public void setImprest(BigDecimal imprest) {
		this.imprest = imprest;
	}

	public String getLadingRequire() {
		return this.ladingRequire;
	}

	public void setLadingRequire(String ladingRequire) {
		this.ladingRequire = ladingRequire;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
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

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSetupRequire() {
		return this.setupRequire;
	}

	public void setSetupRequire(String setupRequire) {
		this.setupRequire = setupRequire;
	}

	public BigDecimal getFavCost() {
		return this.favCost;
	}

	public void setFavCost(BigDecimal favCost) {
		this.favCost = favCost;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public BigDecimal getSquare() {
		return this.square;
	}

	public void setSquare(BigDecimal square) {
		this.square = square;
	}

	public String getContractCode() {
		return this.contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public long getPayModeId() {
		return this.payModeId;
	}

	public void setPayModeId(long payModeId) {
		this.payModeId = payModeId;
	}
}