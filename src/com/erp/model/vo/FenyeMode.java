package com.erp.model.vo;

import java.util.List;

public class FenyeMode {

	// 存放数值
	private Integer currentPageNum;// 当前页数
	private Integer allPageNum;// 一共多少页数
	private Integer maxNumEveryPage;// 每页最大条数
	private Integer allResultNum;// 一共多少条数

	/* 选择外协商 */
	private List<EstablishmentVO> estList;
	/* 价格手册 */
	private List<EstPriceVO> estPriceList;
	// 账务
	private List<BankAccountVO> bankAccountList;
	// 费用类型
	private List<FeeBillVO> feeBillList;
	private List<PayBillVO> payBillVOs;

	public List<PayBillVO> getPayBillVOs() {
		return payBillVOs;
	}

	public void setPayBillVOs(List<PayBillVO> payBillVOs) {
		this.payBillVOs = payBillVOs;
	}

	public List<FeeBillVO> getFeeBillList() {
		return feeBillList;
	}

	public void setFeeBillList(List<FeeBillVO> feeBillList) {
		this.feeBillList = feeBillList;
	}

	public List<BankAccountVO> getBankAccountList() {
		return bankAccountList;
	}

	public void setBankAccountList(List<BankAccountVO> bankAccountList) {
		this.bankAccountList = bankAccountList;
	}

	public List<EstPriceVO> getEstPriceList() {
		return estPriceList;
	}

	public void setEstPriceList(List<EstPriceVO> estPriceList) {
		this.estPriceList = estPriceList;
	}

	public List<EstablishmentVO> getEstList() {
		return estList;
	}

	public void setEstList(List<EstablishmentVO> estList) {
		this.estList = estList;
	}

	public Integer getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public Integer getAllPageNum() {
		return allPageNum;
	}

	public void setAllPageNum(Integer allPageNum) {
		this.allPageNum = allPageNum;
	}

	public Integer getMaxNumEveryPage() {
		return maxNumEveryPage;
	}

	public void setMaxNumEveryPage(Integer maxNumEveryPage) {
		this.maxNumEveryPage = maxNumEveryPage;
	}

	public Integer getAllResultNum() {
		return allResultNum;
	}

	public void setAllResultNum(Integer allResultNum) {
		this.allResultNum = allResultNum;
	}

	@Override
	public String toString() {
		return "FenyeMode [estList=" + estList + ", estPriceList=" + estPriceList
				+ ", currentPageNum=" + currentPageNum + ", allPageNum=" + allPageNum
				+ ", maxNumEveryPage=" + maxNumEveryPage + ", allResultNum=" + allResultNum + "]";
	}

}
