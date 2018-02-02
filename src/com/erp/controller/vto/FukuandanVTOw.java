package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.CooperBillExtVO;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PurchaseBillVO;

public class FukuandanVTOw {
	private EstablishmentVO establishmentVO;
	private BankAccountVO bankAccountVO;
	private List<EstablishmentVO> establishmentVOs;
	private List<CooperBillVO> cooperBillVOs;
	private List<BankAccountVO> bankAccountVOs;
	private List<PurchaseBillVO> purchaseBillVOs;
	private PurchaseBillVO purchaseBillVO;
	
	
	
	public PurchaseBillVO getPurchaseBillVO() {
		return purchaseBillVO;
	}

	public void setPurchaseBillVO(PurchaseBillVO purchaseBillVO) {
		this.purchaseBillVO = purchaseBillVO;
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

	public List<PurchaseBillVO> getPurchaseBillVOs() {
		return purchaseBillVOs;
	}

	public void setPurchaseBillVOs(List<PurchaseBillVO> purchaseBillVOs) {
		this.purchaseBillVOs = purchaseBillVOs;
	}

	public List<BankAccountVO> getBankAccountVOs() {
		return bankAccountVOs;
	}

	public void setBankAccountVOs(List<BankAccountVO> bankAccountVOs) {
		this.bankAccountVOs = bankAccountVOs;
	}

	private CooperBillVO cooperBillVO;
	private CooperBillItemVO cooperBillItemVO;
	private CooperBillExtVO cooperBillExtVO;

	public CooperBillExtVO getCooperBillExtVO() {
		return cooperBillExtVO;
	}

	public void setCooperBillExtVO(CooperBillExtVO cooperBillExtVO) {
		this.cooperBillExtVO = cooperBillExtVO;
	}

	public CooperBillVO getCooperBillVO() {
		return cooperBillVO;
	}

	public void setCooperBillVO(CooperBillVO cooperBillVO) {
		this.cooperBillVO = cooperBillVO;
	}

	public CooperBillItemVO getCooperBillItemVO() {
		return cooperBillItemVO;
	}

	public void setCooperBillItemVO(CooperBillItemVO cooperBillItemVO) {
		this.cooperBillItemVO = cooperBillItemVO;
	}

	public List<CooperBillVO> getCooperBillVOs() {
		return cooperBillVOs;
	}

	public void setCooperBillVOs(List<CooperBillVO> cooperBillVOs) {
		this.cooperBillVOs = cooperBillVOs;
	}

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
	}
}
