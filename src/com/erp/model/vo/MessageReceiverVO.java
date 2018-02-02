/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

public class MessageReceiverVO {
	private long id;
	private long messageId = 0L;
	private long receiverId = 0L;
	private String receiverName;
	private String receiverDelete = "N";
	private String receiverRead = "N";

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReceiverDelete() {
		return this.receiverDelete;
	}

	public void setReceiverDelete(String receiverDelete) {
		this.receiverDelete = receiverDelete;
	}

	public long getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public long getMessageId() {
		return this.messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getReceiverRead() {
		return this.receiverRead;
	}

	public void setReceiverRead(String receiverRead) {
		this.receiverRead = receiverRead;
	}

	@Override
	public String toString() {
		return "MessageReceiverVO [id=" + id + ", messageId=" + messageId
				+ ", receiverId=" + receiverId + ", receiverName="
				+ receiverName + ", receiverDelete=" + receiverDelete
				+ ", receiverRead=" + receiverRead + "]";
	}
	
	
}