package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeBillVO;

public class FeiyongdanyilanActionVTOw {
	private List<FeeBillVO> feeBillVOs;
	private List<BankAccountVO> bankAccountVOs;

	public List<FeeBillVO> getFeeBillVOs() {
		return feeBillVOs;
	}

	public void setFeeBillVOs(List<FeeBillVO> feeBillVOs) {
		this.feeBillVOs = feeBillVOs;
	}

	public List<BankAccountVO> getBankAccountVOs() {
		return bankAccountVOs;
	}

	public void setBankAccountVOs(List<BankAccountVO> bankAccountVOs) {
		this.bankAccountVOs = bankAccountVOs;
	}

}
