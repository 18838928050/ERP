package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeTypeVO;
import com.erp.model.vo.IncomeTypeVO;

public class MoneyVTOw {
	private BankAccountVO bankAccount;
	private FeeTypeVO feeType;
	private IncomeTypeVO incomeType;
	
	//用来保存从费用类型表，收入类型表，银行账户表中获得全部数据通过model
	private List<BankAccountVO> bankAccountVOs;
	private List<FeeTypeVO> feeTypeVOs;
	private List<IncomeTypeVO> incomeTypeVOs;
	public BankAccountVO getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccountVO bankAccount) {
		this.bankAccount = bankAccount;
	}
	public FeeTypeVO getFeeType() {
		return feeType;
	}
	public void setFeeType(FeeTypeVO feeType) {
		this.feeType = feeType;
	}
	public IncomeTypeVO getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(IncomeTypeVO incomeType) {
		this.incomeType = incomeType;
	}
	public List<BankAccountVO> getBankAccountVOs() {
		return bankAccountVOs;
	}
	public void setBankAccountVOs(List<BankAccountVO> bankAccountVOs) {
		this.bankAccountVOs = bankAccountVOs;
	}
	public List<FeeTypeVO> getFeeTypeVOs() {
		return feeTypeVOs;
	}
	public void setFeeTypeVOs(List<FeeTypeVO> feeTypeVOs) {
		this.feeTypeVOs = feeTypeVOs;
	}
	public List<IncomeTypeVO> getIncomeTypeVOs() {
		return incomeTypeVOs;
	}
	public void setIncomeTypeVOs(List<IncomeTypeVO> incomeTypeVOs) {
		this.incomeTypeVOs = incomeTypeVOs;
	}
	
	
	

}
