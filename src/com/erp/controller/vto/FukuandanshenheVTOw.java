package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillItemVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.TallySetVO;

public class FukuandanshenheVTOw {
	private PayBillVO payBillVO;
	private List<List<PayBillVO>> paybillVOSS;
	private List<PayBillVO> payBillVOs;
	private List<EstablishmentVO> establishmentVOs;
	private List<PayBillItemVO> payBillItemVOs;
	private DepartmentVO departmentVO;
	private TallySetVO tallySetVO;
	private BankAccountVO bankAccountVO;
	private EstablishmentVO establishmentVO;

	public EstablishmentVO getEstablishmentVO() {
		return establishmentVO;
	}

	public void setEstablishmentVO(EstablishmentVO establishmentVO) {
		this.establishmentVO = establishmentVO;
	}

	public BankAccountVO getBankAccountVO() {
		return bankAccountVO;
	}

	public void setBankAccountVO(BankAccountVO bankAccountVO) {
		this.bankAccountVO = bankAccountVO;
	}

	public TallySetVO getTallySetVO() {
		return tallySetVO;
	}

	public void setTallySetVO(TallySetVO tallySetVO) {
		this.tallySetVO = tallySetVO;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public List<PayBillItemVO> getPayBillItemVOs() {
		return payBillItemVOs;
	}

	public void setPayBillItemVOs(List<PayBillItemVO> payBillItemVOs) {
		this.payBillItemVOs = payBillItemVOs;
	}

	public List<PayBillVO> getPayBillVOs() {
		return payBillVOs;

	}

	public List<EstablishmentVO> getEstablishmentVOs() {
		return establishmentVOs;
	}

	public void setEstablishmentVOs(List<EstablishmentVO> establishmentVOs) {
		this.establishmentVOs = establishmentVOs;
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

	public List<List<PayBillVO>> getPaybillVOSS() {
		return paybillVOSS;
	}

	public void setPaybillVOSS(List<List<PayBillVO>> paybillVOSS) {
		this.paybillVOSS = paybillVOSS;
	}
}
