package com.erp.model.vo;

import java.util.Date;

public class SystemLog {
	private long id;
	private long createrId = 0L;
	private String createrName;
	private Date createTime = new Date();
	private String userName;
	private String depName;
	private long depId = 0L;
	private String actionCode;
	private String status;
	private String mark;
	private String ip;
	private String logType;
	private String cancelReason;
	private long relId = 0L;
	private long tallySetId = 0L;

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public long getRelId() {
		return this.relId;
	}

	public void setRelId(long relId) {
		this.relId = relId;
	}

	public String getCancelReason() {
		return this.cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getLogType() {
		return this.logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getActionCode() {
		return this.actionCode;
	}

	public String getDepName() {
		return this.depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
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

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getDepId() {
		return this.depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}
}