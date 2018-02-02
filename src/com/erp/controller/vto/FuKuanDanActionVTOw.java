package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillVO;

public class FuKuanDanActionVTOw {
	private List<PayBillVO> payBillVOs;
	private List<EstablishmentVO> establishmentVOs;
	private List<BankAccountVO> bankAccountVOs;

	public List<PayBillVO> getPayBillVOs() {
		return payBillVOs;
	}

	public void setPayBillVOs(List<PayBillVO> payBillVOs) {
		this.payBillVOs = payBillVOs;
	}

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}

	public List<BankAccountVO> getBankAccountVOs() {
		return bankAccountVOs;
	}

	public void setBankAccountVOs(List<BankAccountVO> bankAccountVOs) {
		this.bankAccountVOs = bankAccountVOs;
	}

}
