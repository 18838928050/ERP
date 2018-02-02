 package com.erp.controller.subcontractCancel.vo;


import java.math.BigDecimal;
import java.util.Date;
/**
 * 外协单
 * @author guo
 *
 */
public class CooperBillVO {
	public static final String CODE_RULE = "COOPER_BILL";
	private long id;
	private String billCode;//外协单号
	private Date cooperDate = new Date();//外协日期
	private Date gatherDate = new Date();//收货日期
	private long cooperatorId = 0L;//外协单位	客户表（合作伙伴）
	private String linkman;
	private String phone;
	private String address;
	private String content;//摘要
	private BigDecimal imprest = new BigDecimal(0);
	private BigDecimal favCost = new BigDecimal(0);
	private BigDecimal cost = new BigDecimal(0);//外协金额
	private BigDecimal amount = new BigDecimal(0);
	private BigDecimal square = new BigDecimal(0);
	private BigDecimal lengM = new BigDecimal(0);
	private BigDecimal lengCm = new BigDecimal(0);
	private long bankAccountId = 0L;
	private long payModeId = 0L;
	private long departmentId = 0L;//部门
	private long managerId = 0L;
	private String managerName;//业务员
	private String gatherRequire;
	private String setupRequire;
	private String mark;
	private long tallySetId = 0L;//账套
	private long createrId = 0L;
	private String createrName;
	private long modifierId = 0L;
	private String modifierName;
	private Date modifyTime;
	private Date createTime = new Date();
	private Date updateTime = new Date();

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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCooperatorId() {
		return this.cooperatorId;
	}

	public void setCooperatorId(long cooperatorId) {
		this.cooperatorId = cooperatorId;
	}

	public Date getCooperDate() {
		return this.cooperDate;
	}

	public void setCooperDate(Date cooperDate) {
		this.cooperDate = cooperDate;
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

	public BigDecimal getFavCost() {
		return this.favCost;
	}

	public void setFavCost(BigDecimal favCost) {
		this.favCost = favCost;
	}

	public Date getGatherDate() {
		return this.gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public String getGatherRequire() {
		return this.gatherRequire;
	}

	public void setGatherRequire(String gatherRequire) {
		this.gatherRequire = gatherRequire;
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

	public long getPayModeId() {
		return this.payModeId;
	}

	public void setPayModeId(long payModeId) {
		this.payModeId = payModeId;
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

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getSquare() {
		return this.square;
	}

	public void setSquare(BigDecimal square) {
		this.square = square;
	}
}