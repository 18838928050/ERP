/**
 * 
 */
package com.erp.model.vo;

public class AModel {

	private String waixiename;
	private String monry;
	private String date;
	private String marg;
	private String ta;

	public String getWaixiename() {
		return waixiename;
	}

	public void setWaixiename(String waixiename) {
		this.waixiename = waixiename;
	}

	public String getMonry() {
		return monry;
	}

	public void setMonry(String monry) {
		this.monry = monry;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMarg() {
		return marg;
	}

	public void setMarg(String marg) {
		this.marg = marg;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	@Override
	public String toString() {
		return "AModel [waixiename=" + waixiename + ", monry=" + monry + ", date=" + date
				+ ", marg=" + marg + ", ta=" + ta + "]";
	}

}
