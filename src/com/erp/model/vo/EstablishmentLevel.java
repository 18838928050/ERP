package com.erp.model.vo;


public class EstablishmentLevel{
	private long id;
	private String levelName;
	private int sequenceCode = 0;
	private String enabled = "Y";

	public String getObjectName() {
		return this.levelName;
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

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	@Override
	public String toString() {
		return "EstablishmentLevel [id=" + id + ", levelName=" + levelName + ", sequenceCode=" + sequenceCode
				+ ", enabled=" + enabled + "]";
	}
	
	
}