package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeBillVO;

public class FeiyongmingxiVTOw {
	private FeeBillVO feeBillVO;
	private BankAccountVO bankAccountVO;
	List<FeeBillVO> feeBillVOs;
	List<BankAccountVO> bankAccountVOs;

	public FeeBillVO getFeeBillVO() {
		return feeBillVO;
	}

	public void setFeeBillVO(FeeBillVO feeBillVO) {
		this.feeBillVO = feeBillVO;
	}

	public BankAccountVO getBankAccountVO() {
		return bankAccountVO;
	}

	public void setBankAccountVO(BankAccountVO bankAccountVO) {
		this.bankAccountVO = bankAccountVO;
	}

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
