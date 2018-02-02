package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.FeeBillDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeBillVO;

public class FeiyongmingxiMgr {
	FeeBillDAOw feeBillDAO = new FeeBillDAOw();
	BankAccountDAOw bankAccountDAO = new BankAccountDAOw();

	public List<FeeBillVO> findFeeBillvosByLlimit(Long tallySet) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		return feeBillDAO.findFeeBillvosByLlimit(tallySet);
	}

	public List<BankAccountVO> setBankAccountVOS(List<FeeBillVO> feeBillVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (FeeBillVO feeBillVO : feeBillVOs) {
			ids.add(feeBillVO.getBankAccountId());

		}
		return bankAccountDAO.setsetBankAccountVOS(ids);
	}

}
