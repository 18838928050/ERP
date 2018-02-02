/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.erp.model.vo;

import java.math.BigDecimal;

public class EnterpriseInfoVO {
	private long id;
	private String image;
	private String slogan;
	private String linkman;
	private String phone;
	private String fax;
	private String address;
	private String postcode;
	private String bankName;
	private String bankAccount;
	private int loginLimit = 0;
	private int lockHour = 0;
	private int pageSize = 20;
	private String printFoot;
	private String busiAutoExamine = "N";
	private String bbPriceType;
	private int uploadPort = 1500;
	private String dbBackupFolder;
	private String shortName;
	private String smsCode;
	private String smsPwd;
	private String smsKey;
	private String dbAb = "N";
	private int dbAbHour = 0;
	private int dbAbMinute = 0;
	private String lastDbAb;
	private String doPrint = "PRINT";
	private String printWidth = "FIXED";
	private String bbPrintImage = "N";
	private String mbPrintImage = "N";
	private String setuPrintImage = "N";
	private String busiCooComp = "Y";
	private String selectContact = "ALL";
	private String workCenter = "N";
	private String smsClientType;
	private String dbAdel = "N";
	private String loginImage;
	private int msgInterval = 1;

	private BigDecimal busiOv = new BigDecimal(0);
	private BigDecimal makeOv = new BigDecimal(0);
	private BigDecimal receOv = new BigDecimal(0);
	private BigDecimal follOv = new BigDecimal(0);
	private BigDecimal comDesi = new BigDecimal(0);
	private BigDecimal cliDesi = new BigDecimal(0);
	private BigDecimal setuOv = new BigDecimal(0);

	private String busiModi = "Y";
	private String coopModi = "Y";
	private int earlDataDays = 30;
	private String baseTs = "Y";
	private String bankTs = "Y";
	private String storTs = "Y";
	private String busiLengType = "MAX";
	private String busiComp = "ALL";
	private String busiUplo = "UNEXA";
	private String deskType = "MSG";
	private String deliAutoComp = "N";
	private String bankPr = "N";
	private String lengType = "M";
	private String areaType = "M";
	private String busiProd = "INPUT";

	private String busiBc = "Y";
	private String deliBc = "Y";
	private String makeBc = "Y";
	private String setuBc = "Y";

	private String busiMng = "EST_MNG";
	private String busiFoll = "EST_MNG";
	private String busiDesi = "CREA";
	private String outBusi = "CURR";
	private String feeBusi = "CURR";

	private String purcStoc = "Y";
	private String busiClos = "HAND_CD";
	private String qq;

	public String getBusiClos() {
		return this.busiClos;
	}

	public void setBusiClos(String busiClos) {
		this.busiClos = busiClos;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getSetuBc() {
		return this.setuBc;
	}

	public void setSetuBc(String setuBc) {
		this.setuBc = setuBc;
	}

	public String getSetuPrintImage() {
		return this.setuPrintImage;
	}

	public void setSetuPrintImage(String setuPrintImage) {
		this.setuPrintImage = setuPrintImage;
	}

	public String getAreaType() {
		return this.areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public BigDecimal getSetuOv() {
		return this.setuOv;
	}

	public void setSetuOv(BigDecimal setuOv) {
		this.setuOv = setuOv;
	}

	public String getPurcStoc() {
		return this.purcStoc;
	}

	public void setPurcStoc(String purcStoc) {
		this.purcStoc = purcStoc;
	}

	public String getCoopModi() {
		return this.coopModi;
	}

	public void setCoopModi(String coopModi) {
		this.coopModi = coopModi;
	}

	public String getBusiMng() {
		return this.busiMng;
	}

	public void setBusiMng(String busiMng) {
		this.busiMng = busiMng;
	}

	public String getBusiFoll() {
		return this.busiFoll;
	}

	public void setBusiFoll(String busiFoll) {
		this.busiFoll = busiFoll;
	}

	public String getBusiDesi() {
		return this.busiDesi;
	}

	public void setBusiDesi(String busiDesi) {
		this.busiDesi = busiDesi;
	}

	public String getOutBusi() {
		return this.outBusi;
	}

	public void setOutBusi(String outBusi) {
		this.outBusi = outBusi;
	}

	public String getFeeBusi() {
		return this.feeBusi;
	}

	public void setFeeBusi(String feeBusi) {
		this.feeBusi = feeBusi;
	}

	public String getBusiBc() {
		return this.busiBc;
	}

	public void setBusiBc(String busiBc) {
		this.busiBc = busiBc;
	}

	public String getDeliBc() {
		return this.deliBc;
	}

	public void setDeliBc(String deliBc) {
		this.deliBc = deliBc;
	}

	public String getMakeBc() {
		return this.makeBc;
	}

	public void setMakeBc(String makeBc) {
		this.makeBc = makeBc;
	}

	public String getBusiProd() {
		return this.busiProd;
	}

	public void setBusiProd(String busiProd) {
		this.busiProd = busiProd;
	}

	public String getLengType() {
		return this.lengType;
	}

	public void setLengType(String lengType) {
		this.lengType = lengType;
	}

	public String getBankPr() {
		return this.bankPr;
	}

	public void setBankPr(String bankPr) {
		this.bankPr = bankPr;
	}

	public String getDeliAutoComp() {
		return this.deliAutoComp;
	}

	public void setDeliAutoComp(String deliAutoComp) {
		this.deliAutoComp = deliAutoComp;
	}

	public String getDeskType() {
		return this.deskType;
	}

	public void setDeskType(String deskType) {
		this.deskType = deskType;
	}

	public String getBusiUplo() {
		return this.busiUplo;
	}

	public void setBusiUplo(String busiUplo) {
		this.busiUplo = busiUplo;
	}

	public String getBusiComp() {
		return this.busiComp;
	}

	public void setBusiComp(String busiComp) {
		this.busiComp = busiComp;
	}

	public String getBusiLengType() {
		return this.busiLengType;
	}

	public void setBusiLengType(String busiLengType) {
		this.busiLengType = busiLengType;
	}

	public int getEarlDataDays() {
		return this.earlDataDays;
	}

	public void setEarlDataDays(int earlDataDays) {
		this.earlDataDays = earlDataDays;
	}

	public String getBankTs() {
		return this.bankTs;
	}

	public void setBankTs(String bankTs) {
		this.bankTs = bankTs;
	}

	public String getStorTs() {
		return this.storTs;
	}

	public void setStorTs(String storTs) {
		this.storTs = storTs;
	}

	public String getBusiModi() {
		return this.busiModi;
	}

	public void setBusiModi(String busiModi) {
		this.busiModi = busiModi;
	}

	public BigDecimal getComDesi() {
		return this.comDesi;
	}

	public void setComDesi(BigDecimal comDesi) {
		this.comDesi = comDesi;
	}

	public BigDecimal getCliDesi() {
		return this.cliDesi;
	}

	public void setCliDesi(BigDecimal cliDesi) {
		this.cliDesi = cliDesi;
	}

	public BigDecimal getBusiOv() {
		return this.busiOv;
	}

	public void setBusiOv(BigDecimal busiOv) {
		this.busiOv = busiOv;
	}

	public BigDecimal getMakeOv() {
		return this.makeOv;
	}

	public void setMakeOv(BigDecimal makeOv) {
		this.makeOv = makeOv;
	}

	public BigDecimal getReceOv() {
		return this.receOv;
	}

	public void setReceOv(BigDecimal receOv) {
		this.receOv = receOv;
	}

	public BigDecimal getFollOv() {
		return this.follOv;
	}

	public void setFollOv(BigDecimal follOv) {
		this.follOv = follOv;
	}

	public String getLoginImage() {
		return this.loginImage;
	}

	public void setLoginImage(String loginImage) {
		this.loginImage = loginImage;
	}

	public String getDbAdel() {
		return this.dbAdel;
	}

	public void setDbAdel(String dbAdel) {
		this.dbAdel = dbAdel;
	}

	public String getSmsClientType() {
		return this.smsClientType;
	}

	public void setSmsClientType(String smsClientType) {
		this.smsClientType = smsClientType;
	}

	public String getWorkCenter() {
		return this.workCenter;
	}

	public void setWorkCenter(String workCenter) {
		this.workCenter = workCenter;
	}

	public String getSelectContact() {
		return this.selectContact;
	}

	public void setSelectContact(String selectContact) {
		this.selectContact = selectContact;
	}

	public String getBbPrintImage() {
		return this.bbPrintImage;
	}

	public void setBbPrintImage(String bbPrintImage) {
		this.bbPrintImage = bbPrintImage;
	}

	public String getMbPrintImage() {
		return this.mbPrintImage;
	}

	public void setMbPrintImage(String mbPrintImage) {
		this.mbPrintImage = mbPrintImage;
	}

	public String getPrintWidth() {
		return this.printWidth;
	}

	public void setPrintWidth(String printWidth) {
		this.printWidth = printWidth;
	}

	public String getDoPrint() {
		return this.doPrint;
	}

	public void setDoPrint(String doPrint) {
		this.doPrint = doPrint;
	}

	public String getDbAb() {
		return this.dbAb;
	}

	public void setDbAb(String dbAb) {
		this.dbAb = dbAb;
	}

	public int getDbAbHour() {
		return this.dbAbHour;
	}

	public void setDbAbHour(int dbAbHour) {
		this.dbAbHour = dbAbHour;
	}

	public int getDbAbMinute() {
		return this.dbAbMinute;
	}

	public void setDbAbMinute(int dbAbMinute) {
		this.dbAbMinute = dbAbMinute;
	}

	public String getLastDbAb() {
		return this.lastDbAb;
	}

	public void setLastDbAb(String lastDbAb) {
		this.lastDbAb = lastDbAb;
	}

	public String getSmsKey() {
		return this.smsKey;
	}

	public void setSmsKey(String smsKey) {
		this.smsKey = smsKey;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getSmsCode() {
		return this.smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getSmsPwd() {
		return this.smsPwd;
	}

	public void setSmsPwd(String smsPwd) {
		this.smsPwd = smsPwd;
	}

	public String getDbBackupFolder() {
		return this.dbBackupFolder;
	}

	public void setDbBackupFolder(String dbBackupFolder) {
		this.dbBackupFolder = dbBackupFolder;
	}

	public int getUploadPort() {
		return this.uploadPort;
	}

	public void setUploadPort(int uploadPort) {
		this.uploadPort = uploadPort;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public int getLockHour() {
		return this.lockHour;
	}

	public void setLockHour(int lockHour) {
		this.lockHour = lockHour;
	}

	public int getLoginLimit() {
		return this.loginLimit;
	}

	public void setLoginLimit(int loginLimit) {
		this.loginLimit = loginLimit;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPrintFoot() {
		return this.printFoot;
	}

	public void setPrintFoot(String printFoot) {
		this.printFoot = printFoot;
	}

	public String getBusiAutoExamine() {
		return this.busiAutoExamine;
	}

	public void setBusiAutoExamine(String busiAutoExamine) {
		this.busiAutoExamine = busiAutoExamine;
	}

	public String getBbPriceType() {
		return this.bbPriceType;
	}

	public void setBbPriceType(String bbPriceType) {
		this.bbPriceType = bbPriceType;
	}

	public String getBusiCooComp() {
		return this.busiCooComp;
	}

	public void setBusiCooComp(String busiCooComp) {
		this.busiCooComp = busiCooComp;
	}

	public String getBaseTs() {
		return this.baseTs;
	}

	public void setBaseTs(String baseTs) {
		this.baseTs = baseTs;
	}

	public int getMsgInterval() {
		return this.msgInterval;
	}

	public void setMsgInterval(int msgInterval) {
		this.msgInterval = msgInterval;
	}
}