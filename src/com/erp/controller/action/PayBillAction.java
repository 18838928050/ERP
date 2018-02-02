package com.erp.controller.action;

import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.PayBillMgr;
import com.erp.controller.vto.PayBillVTOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.FenyeMode;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.StafferVO;

@SuppressWarnings("serial")
public class PayBillAction extends BaseAction<PayBillVTOw> {
	PayBillVTOw payBillVTO = new PayBillVTOw();
	PayBillMgr payBillMgr = new PayBillMgr();
	private Integer CurrentPageNum;
	private Integer MaxNumEveryPage;
	FenyeMode fenyeMode = new FenyeMode();

	public Integer getCurrentPageNum() {
		return CurrentPageNum;
	}

	public void setCurrentPageNum(Integer currentPageNum) {
		CurrentPageNum = currentPageNum;
	}

	public Integer getMaxNumEveryPage() {
		return MaxNumEveryPage;
	}

	public void setMaxNumEveryPage(Integer maxNumEveryPage) {
		MaxNumEveryPage = maxNumEveryPage;
	}

	public FenyeMode getFenyeMode() {
		return fenyeMode;
	}

	public void setFenyeMode(FenyeMode fenyeMode) {
		this.fenyeMode = fenyeMode;
	}

	public PayBillMgr getPayBillMgr() {
		return payBillMgr;
	}

	public void setPayBillMgr(PayBillMgr payBillMgr) {
		this.payBillMgr = payBillMgr;
	}

	public PayBillVTOw getPayBillVTO() {
		return payBillVTO;
	}

	public void setPayBillVTO(PayBillVTOw payBillVTO) {
		this.payBillVTO = payBillVTO;
	}

	public String findAll() throws Exception {
		PayBillMgr payBillMgr = new PayBillMgr();
		// 查询全部内容
		MaxNumEveryPage = (MaxNumEveryPage == null || MaxNumEveryPage.equals("")) ? 10
				: MaxNumEveryPage;
		fenyeMode = payBillMgr.fenyeService(MaxNumEveryPage, CurrentPageNum);
		List<PayBillVO> payBillVOs = fenyeMode.getPayBillVOs();

		model.setPayBillVOs(payBillVOs);
		// 查询银行账户和联系方式,paybill.bank_account_id=bankaccount.id==>bandAccountSS,由多个银行id找到银行名称和相关备注（中行（黄秀娟）），banKName,accountName
		model.setBankAccountListVOSS(payBillMgr.getBanksByPayBankAccountIds(model.getPayBillVOs()));
		List<List<BankAccountVO>> bankAccountVOSS = model.getBankAccountListVOSS();
		// (收款单位）Paybill.bank_account_id=bankacount.id==>EstablishmentVOSS，由多个收款id得到多个收款单位bankaccount.account_name和baccount.bank_name
		model.setEstablishmentVOSS(payBillMgr.getEstsByPayBillReceiverIds(model.getPayBillVOs()));
		List<List<EstablishmentVO>> EstablishmentVOSS = model.getEstablishmentVOSS();
		// 查询开单人
		model.setStafferNameListVOSS(payBillMgr.getStafferNameByCreaterIds(model.getPayBillVOs()));
		List<List<StafferVO>> sList = model.getStafferNameListVOSS();
		return "toListUI";
		// 查询是否审核
	}
}
