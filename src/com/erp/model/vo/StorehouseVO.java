package com.erp.model.vo;


public class StorehouseVO {
	private long id;
	private String stoName;
	private String stoCode;
	private int sequenceCode = 0;
	private String enabled = "Y";
	private long tallySetId = 0L;

	public String getObjectName() {
		return this.stoName;
	}

	public long getTallySetId() {
		return this.tallySetId;
	}

	public void setTallySetId(long tallySetId) {
		this.tallySetId = tallySetId;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSequenceCode() {
		return this.sequenceCode;
	}

	public void setSequenceCode(int sequenceCode) {
		this.sequenceCode = sequenceCode;
	}

	public String getStoCode() {
		return this.stoCode;
	}

	public void setStoCode(String stoCode) {
		this.stoCode = stoCode;
	}

	public String getStoName() {
		return this.stoName;
	}

	public void setStoName(String stoName) {
		this.stoName = stoName;
	}

	@Override
	public String toString() {
		return "StorehouseVO [id=" + id + ", stoName=" + stoName + ", stoCode=" + stoCode
				+ ", sequenceCode=" + sequenceCode + ", enabled=" + enabled + ", tallySetId="
				+ tallySetId + "]";
	}
	
}