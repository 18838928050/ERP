package com.erp.model.vo;

import java.util.Date;

public class BbsArticle {
	private long id;
	private long columnId;
	private String title;
	private String content;
	private long parentId = 0L;
	private int viewCount = 0;
	private int replyCount = 0;
	private long createrId;
	private String createrName;
	private Date createTime = new Date();
	private long replierId;
	private String replierName;
	private Date lastTime;
	private String enabled = "Y";
	private String hasAttach = "N";

	public long getColumnId() {
		return this.columnId;
	}

	public void setColumnId(long columnId) {
		this.columnId = columnId;
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

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return this.parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getReplierId() {
		return this.replierId;
	}

	public void setReplierId(long replierId) {
		this.replierId = replierId;
	}

	public String getReplierName() {
		return this.replierName;
	}

	public void setReplierName(String replierName) {
		this.replierName = replierName;
	}

	public int getReplyCount() {
		return this.replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getHasAttach() {
		return this.hasAttach;
	}

	public void setHasAttach(String hasAttach) {
		this.hasAttach = hasAttach;
	}
}