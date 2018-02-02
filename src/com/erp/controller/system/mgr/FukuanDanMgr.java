package com.erp.controller.system.mgr;

import java.util.List;

import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.CooperBillDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.PurchaseDAOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PurchaseBillVO;

public class FukuanDanMgr {
EstablishmentDAOw establishmentDAO=new EstablishmentDAOw();
CooperBillDAOw cooperBillDAO=new CooperBillDAOw();
BankAccountDAOw bankAccountDAO=new BankAccountDAOw();
PurchaseDAOw purchaseDAO=new PurchaseDAOw();
	public List<EstablishmentVO> getEstsByLimits(long tallySet) {
		
		return establishmentDAO.getEstsByLimits(tallySet);
	}
	public List<CooperBillVO> getCooperBillsByLimits(Long bankAccountId, long EstablishmentId, long tallySet) {
		return cooperBillDAO.getCooperBillsByLimits(bankAccountId,EstablishmentId,tallySet);
	}
	public List<BankAccountVO> getBankAccounts() throws Exception {
		return bankAccountDAO.findAll();
	}
	public List<PurchaseBillVO> getPurchaseBillVOsByLimits(long prividerId, long tallyset) {
		return purchaseDAO.getPurchaseBillVOsByLimits(prividerId,tallyset);
	}
	public void saveCooperBillVOs(List<CooperBillVO> cooperBillVOs) {
			cooperBillDAO.saveCooperBillVOs(cooperBillVOs);
	}
	public Object getEstNameByEstId(long estId) {
		return establishmentDAO.getEstNameByEstId(estId);
	}

}
