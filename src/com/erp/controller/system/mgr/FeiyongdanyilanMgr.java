package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.FeeBillDAOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeBillVO;

public class FeiyongdanyilanMgr {
	FeeBillDAOw feeBillDAO = new FeeBillDAOw();
	BankAccountDAOw bankAccountDAO = new BankAccountDAOw();

	public List<FeeBillVO> getFeeBillBosByLimits() {
		return feeBillDAO.getFeeBillBosByLimits();
	}

	public List<BankAccountVO> getBankAccountsByFeebillBankAccouIds(List<FeeBillVO> feeBillVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (FeeBillVO feeBillVO : feeBillVOs) {
			ids.add(feeBillVO.getBankAccountId());
		}

		return bankAccountDAO.getBankAccountsByFeebillBankAccouIds(ids);
	}
}
