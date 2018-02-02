/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.util.Date;

public class AccessoryVO {
	private long id;
	private String agentType;
	private long agentId = 0L;
	private String fileName;
	private String sourceName;
	private String mark;
	private Date createTime = new Date();
	private long createrId = 0L;
	private String createrName;
	private String tmpCode;
	private String customPath;
	private long extId = 0L;
	private String accType;

	public String getCustomPath() {
		return this.customPath;
	}

	public void setCustomPath(String customPath) {
		this.customPath = customPath;
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

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public long getAgentId() {
		return this.agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public String getAgentType() {
		return this.agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getTmpCode() {
		return this.tmpCode;
	}

	public void setTmpCode(String tmpCode) {
		this.tmpCode = tmpCode;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getAccType() {
		return this.accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public long getExtId() {
		return this.extId;
	}

	public void setExtId(long extId) {
		this.extId = extId;
	}
}