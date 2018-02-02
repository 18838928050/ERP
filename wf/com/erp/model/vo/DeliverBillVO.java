/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.util.Date;

public class DeliverBillVO {
	public static final String CODE_RULE = "DELIVER_BILL";
	private long id;
	private String billCode;
	private Date deliverDate = new Date();
	private String linkman;
	private String phone;
	private String address;
	private long businessBillId = 0L;
	private long createrId = 0L;
	private String createrName;
	private long examinerId = 0L;
	private String examinerName;
	private String examined = "N";
	private String enabled = "Y";
	private long disableManId = 0L;
	private Date updateTime = new Date();
	private long tallySetId = 0L;
	private String mark;
	private String content;
	private Date createTime;
	private Date examineTime;
	private String deliComp;
	private String deliCode;
	private long payModeId = 0L;
	private String sended = "N";
	private long senderId = 0L;
	private String senderName;
	private Date sendTime;

	/**
	 * 
	 */
	public DeliverBillVO() {
		super();
	}

	/**
	 * @param id
	 * @param phone
	 */
	public DeliverBillVO(long id, String phone) {
		super();
		this.id = id;
		this.phone = phone;
	}

	/**
	 * @param id
	 * @param billCode
	 * @param deliverDate
	 * @param linkman
	 * @param phone
	 * @param address
	 * @param businessBillId
	 * @param createrId
	 * @param createrName
	 * @param examinerId
	 * @param examinerName
	 * @param examined
	 * @param enabled
	 * @param disableManId
	 * @param updateTime
	 * @param tallySetId
	 * @param mark
	 * @param content
	 * @param createTime
	 * @param examineTime
	 * @param deliComp
	 * @param deliCode
	 * @param payModeId
	 * @param sended
	 * @param senderId
	 * @param senderName
	 * @param sendTime
	 */
	public DeliverBillVO(long id, String billCode, Date deliverDate, String linkman, String phone,
			String address, long businessBillId, long createrId, String createrName,
			long examinerId, String examinerName, String examined, String enabled,
			long disableManId, Date updateTime, long tallySetId, String mark, String content,
			Date createTime, Date examineTime, String deliComp, String deliCode, long payModeId,
			String sended, long senderId, String senderName, Date sendTime) {
		super();
		this.id = id;
		this.billCode = billCode;
		this.deliverDate = deliverDate;
		this.linkman = linkman;
		this.phone = phone;
		this.address = address;
		this.businessBillId = businessBillId;
		this.createrId = createrId;
		this.createrName = createrName;
		this.examinerId = examinerId;
		this.examinerName = examinerName;
		this.examined = examined;
		this.enabled = enabled;
		this.disableManId = disableManId;
		this.updateTime = updateTime;
		this.tallySetId = tallySetId;
		this.mark = mark;
		this.content = content;
		this.createTime = createTime;
		this.examineTime = examineTime;
		this.deliComp = deliComp;
		this.deliCode = deliCode;
		this.payModeId = payModeId;
		this.sended = sended;
		this.senderId = senderId;
		this.senderName = senderName;
		this.sendTime = sendTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeliverBillVO [id=" + id + ", billCode=" + billCode + ", deliverDate="
				+ deliverDate + ", linkman=" + linkman + ", phone=" + phone + ", address="
				+ address + ", businessBillId=" + businessBillId + ", createrId=" + createrId
				+ ", createrName=" + createrName + ", examinerId=" + examinerId + ", examinerName="
				+ examinerName + ", examined=" + examined + ", enabled=" + enabled
				+ ", disableManId=" + disableManId + ", updateTime=" + updateTime + ", tallySetId="
				+ tallySetId + ", mark=" + mark + ", content=" + content + ", createTime="
				+ createTime + ", examineTime=" + examineTime + ", deliComp=" + deliComp
				+ ", deliCode=" + deliCode + ", payModeId=" + payModeId + ", sended=" + sended
				+ ", senderId=" + senderId + ", senderName=" + senderName + ", sendTime="
				+ sendTime + "]";
	}

	public long getSenderId() {
		return this.senderId;
	}

	public void setSenderId(long senderId) {
		this.senderId = senderId;
	}

	public String getSenderName() {
		return this.senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSended() {
		return this.sended;
	}

	public void setSended(String sended) {
		this.sended = sended;
	}

	public long getPayModeId() {
		return this.payModeId;
	}

	public void setPayModeId(long payModeId) {
		this.payModeId = payModeId;
	}

	public String getDeliComp() {
		return this.deliComp;
	}

	public void setDeliComp(String deliComp) {
		this.deliComp = deliComp;
	}

	public String getDeliCode() {
		return this.deliCode;
	}

	public void setDeliCode(String deliCode) {
		this.deliCode = deliCode;
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

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBillCode() {
		return this.billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
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

	public long getBusinessBillId() {
		return this.businessBillId;
	}

	public void setBusinessBillId(long businessBillId) {
		this.businessBillId = businessBillId;
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
}