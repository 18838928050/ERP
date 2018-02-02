package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.StafferVO;

public class PayBillVTOw {
	private PayBillVO payBillVO;
	private BankAccountVO bankAccountVO;
	private EstablishmentVO establishmentVO;
	private List<PayBillVO> payBillVOs;
	private List<BankAccountVO> bankAccounts;
	private List<EstablishmentVO> establishmentVOs;
	private List<StafferVO> stafferVOs;
	private List<List<EstablishmentVO>> establishmentVOSS;
	private List<List<BankAccountVO>> bankAccountListVOSS;
	private List<List<StafferVO>> stafferNameListVOSS;
	private List<List<PayBillVO>> payBillVOSS;

	public List<List<PayBillVO>> getPayBillVOSS() {
		return payBillVOSS;
	}

	public void setPayBillVOSS(List<List<PayBillVO>> payBillVOSS) {
		this.payBillVOSS = payBillVOSS;
	}

	public List<List<StafferVO>> getStafferNameListVOSS() {
		return stafferNameListVOSS;
	}

	public void setStafferNameListVOSS(List<List<StafferVO>> stafferNameListVOSS) {
		this.stafferNameListVOSS = stafferNameListVOSS;
	}

	public List<List<BankAccountVO>> getBankAccountListVOSS() {
		return bankAccountListVOSS;
	}

	public void setBankAccountListVOSS(List<List<BankAccountVO>> bankAccountListVOSS) {
		this.bankAccountListVOSS = bankAccountListVOSS;
	}

	public List<List<EstablishmentVO>> getEstablishmentVOSS() {
		return establishmentVOSS;
	}

	public void setEstablishmentVOSS(List<List<EstablishmentVO>> establishmentVOSS) {
		this.establishmentVOSS = establishmentVOSS;
	}

	public List<StafferVO> getStafferVOs() {
		return stafferVOs;
	}

	public void setStafferVOs(List<StafferVO> stafferVOs) {
		this.stafferVOs = stafferVOs;
	}

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}

	public List<BankAccountVO> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccountVO> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<PayBillVO> getPayBillVOs() {
		return payBillVOs;
	}

	public void setPayBillVOs(List<PayBillVO> payBillVOs) {
		this.payBillVOs = payBillVOs;
	}

	public PayBillVO getPayBillVO() {
		return payBillVO;
	}

	public void setPayBillVO(PayBillVO payBillVO) {
		this.payBillVO = payBillVO;
	}

	public BankAccountVO getBankAccountVO() {
		return bankAccountVO;
	}

	public void setBankAccountVO(BankAccountVO bankAccountVO) {
		this.bankAccountVO = bankAccountVO;
	}

	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}

	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}

	/**
	 * @param estsByPayBillIds
	 */

}
