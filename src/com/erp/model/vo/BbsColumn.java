package com.erp.model.vo;

import java.util.Date;

public class BbsColumn {
	private long id;
	private String columnName;
	private String mark;
	private int sequenceCode = 0;
	private long lastTopicId = 0L;
	private String lastTopicTitle;
	private long lastTopicAuthorId = 0L;
	private String lastTopicAuthorName;
	private Date lastTopicTime;

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLastTopicId() {
		return this.lastTopicId;
	}

	public void setLastTopicId(long lastTopicId) {
		this.lastTopicId = lastTopicId;
	}

	public Date getLastTopicTime() {
		return this.lastTopicTime;
	}

	public void setLastTopicTime(Date lastTopicTime) {
		this.lastTopicTime = lastTopicTime;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getSequenceCode() {
		return this.sequenceCode;
	}

	public void setSequenceCode(int sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	public String getLastTopicAuthorName() {
		return this.lastTopicAuthorName;
	}

	public void setLastTopicAuthorName(String lastTopicAuthorName) {
		this.lastTopicAuthorName = lastTopicAuthorName;
	}

	public String getLastTopicTitle() {
		return this.lastTopicTitle;
	}

	public void setLastTopicTitle(String lastTopicTitle) {
		this.lastTopicTitle = lastTopicTitle;
	}

	public long getLastTopicAuthorId() {
		return this.lastTopicAuthorId;
	}

	public void setLastTopicAuthorId(long lastTopicAuthorId) {
		this.lastTopicAuthorId = lastTopicAuthorId;
	}
}