/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.util.Date;

public class EstablishmentCommunicate {
	public static final String COMM_TYPE_LOG = "LOG";
	public static final String COMM_TYPE_PLAN = "PLAN";
	private long id;
	private long estId = 0L;
	private Date communicateTime = new Date();
	private String title;
	private String content;
	private long createrId;
	private String createrName;
	private Date createTime = new Date();
	private String commType = "LOG";
	private String forAll = "N";
	private String smsRemind = "N";
	private Date smsRemindDate;
	private String sendSms = "N";
	private String completed = "N";
	private String completeMark;
	private Date completeDate;
	private long parentId = 0L;
	private String attachFile;

	public String getCompleteMark() {
		return this.completeMark;
	}

	public void setCompleteMark(String completeMark) {
		this.completeMark = completeMark;
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getAttachFile() {
		return this.attachFile;
	}

	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	public String getSendSms() {
		return this.sendSms;
	}

	public void setSendSms(String sendSms) {
		this.sendSms = sendSms;
	}

	public String getCommType() {
		return this.commType;
	}

	public void setCommType(String commType) {
		this.commType = commType;
	}

	public String getCompleted() {
		return this.completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public Date getCompleteDate() {
		return this.completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public String getForAll() {
		return this.forAll;
	}

	public void setForAll(String forAll) {
		this.forAll = forAll;
	}

	public String getSmsRemind() {
		return this.smsRemind;
	}

	public void setSmsRemind(String smsRemind) {
		this.smsRemind = smsRemind;
	}

	public Date getSmsRemindDate() {
		return this.smsRemindDate;
	}

	public void setSmsRemindDate(Date smsRemindDate) {
		this.smsRemindDate = smsRemindDate;
	}

	public long getEstId() {
		return this.estId;
	}

	public void setEstId(long estId) {
		this.estId = estId;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCommunicateTime() {
		return this.communicateTime;
	}

	public void setCommunicateTime(Date communicateTime) {
		this.communicateTime = communicateTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}