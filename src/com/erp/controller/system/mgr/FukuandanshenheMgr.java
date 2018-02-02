package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.DepartmentDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.PayBillDaow;
import com.erp.model.dao.PayBillItemDAOw;
import com.erp.model.dao.TallySetDAOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayBillItemVO;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.TallySetVO;

public class FukuandanshenheMgr {
	PayBillDaow payBillDao = new PayBillDaow();
	PayBillItemDAOw payBillItemDAO = new PayBillItemDAOw();
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();
	DepartmentDAOw departmentDAO = new DepartmentDAOw();
	TallySetDAOw tallySetDAO = new TallySetDAOw();
	BankAccountDAOw bankAccountDAO = new BankAccountDAOw();

	public static List<PayBillVO> findAllByTEN(Long tallyset) {
		// TODO Auto-generated method stub
		return PayBillDaow.findAllByTEN(tallyset);
	}

	public List<EstablishmentVO> getEstblishmentSS(List<PayBillVO> payBillVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (PayBillVO payBillVO : payBillVOs) {
			ids.add(payBillVO.getReceiverId());
		}
		return establishmentDAO.getEstblishmentSS(ids);
	}

	public void ExaminedTongGuo(long id) {
		payBillDao.ExaminedTongGuo(id);
	}

	public PayBillVO ChaZhaoByPayBillId(long id) {
		// TODO Auto-generated method stub
		return payBillDao.ChaZhaoByPayBillId(id);
	}

	public List<PayBillItemVO> getPayBillItemById(long id) {
		// TODO Auto-generated method stub
		return payBillItemDAO.getPayBillItemById(id);
	}

	public DepartmentVO getDepartmentsByDepatementId(long departmentId) {
		// TODO Auto-generated method stub
		return departmentDAO.getDepartmentsByDepatementId(departmentId);
	}

	public TallySetVO getTallySetByPayBillId(long tallySetId) {
		// TODO Auto-generated method stub
		return tallySetDAO.getTallySetByFeeBillId(tallySetId);
	}

	public BankAccountVO getBankAccountByFbBankAccId(long bankAccountId) {
		// TODO Auto-generated method stub
		return bankAccountDAO.getBankAccountByFbBankAccId(bankAccountId);
	}

	public Object getPayTypeByPayBillitemBillIds(List<PayBillItemVO> payBillItemVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (PayBillItemVO payBillItemVO : payBillItemVOs) {
			ids.add(payBillItemVO.getPurchaseBillId());
		}
		return payBillDao.getPayTypeByFeeBillitemBillIds(ids);
	}

	public EstablishmentVO getEstblishment(long receiverId) {

		return establishmentDAO.getEstblishment(receiverId);
	}

}
