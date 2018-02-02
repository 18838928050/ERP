/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.util.Date;

public class MessageVO {
	public static final String CODE_RULE = "MESSAGE";
	private long id;
	private String title;
	private String content;
	private long senderId = 0L;
	private String senderName;
	private String senderDelete = "N";
	private String receiverName;
	private Date sendTime = new Date();
	private String hasAttach = "N";
	private long relationId = 0L;

	public long getRelationId() {
		return this.relationId;
	}

	public void setRelationId(long relationId) {
		this.relationId = relationId;
	}

	public String getHasAttach() {
		return this.hasAttach;
	}

	public void setHasAttach(String hasAttach) {
		this.hasAttach = hasAttach;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSenderDelete() {
		return this.senderDelete;
	}

	public void setSenderDelete(String senderDelete) {
		this.senderDelete = senderDelete;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Override
	public String toString() {
		return "MessageVO [id=" + id + ", title=" + title + ", content="
				+ content + ", senderId=" + senderId + ", senderName="
				+ senderName + ", senderDelete=" + senderDelete
				+ ", receiverName=" + receiverName + ", sendTime=" + sendTime
				+ ", hasAttach=" + hasAttach + ", relationId=" + relationId
				+ "]";
	}
	
	
}