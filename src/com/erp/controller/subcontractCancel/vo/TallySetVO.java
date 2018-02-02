package com.erp.controller.subcontractCancel.vo;


/**
 *  账套
 * @author guo
 *
 */
public class TallySetVO {
	private long id;
	private String title;
	private String enabled = "Y";
	private String sys = "N";

	public String getSys() {
		return this.sys;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	public String getObjectName() {
		return this.title;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
}