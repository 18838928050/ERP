package com.erp.controller.subcontractCancel.vo;


import java.util.Date;
/**
 * 收货单	同cooperBill属性
 * @author guo
 *
 */
public class GatherBillVO {
	public static final String CODE_RULE = "GATHER_BILL";
	private long id;
	private String billCode;//外协单号
	private Date gatherDate = new Date();//收货日期
	private long cooperBillId = 0L;//外协单位
	private long createrId = 0L;
	private String createrName;//业务人
	private long examinerId = 0L;
	private String examinerName;//开单人
	private String examined = "N";
	private String enabled = "Y";//是否作废
	private long disableManId = 0L;
	private Date updateTime = new Date();
	private long tallySetId = 0L;
	private String mark;
	private String content;
	private Date createTime;
	private Date examineTime;
	private String linkman;
	private String phone;

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getBillCode() {
		return this.billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public long getCooperBillId() {
		return this.cooperBillId;
	}

	public void setCooperBillId(long cooperBillId) {
		this.cooperBillId = cooperBillId;
	}

	public Date getGatherDate() {
		return this.gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
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

	public String getExamined() {
		return this.examined;
	}

	public void setExamined(String examined) {
		this.examined = examined;
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

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}