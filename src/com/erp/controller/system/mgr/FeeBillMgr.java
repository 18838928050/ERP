package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.DepartmentDAOw;
import com.erp.model.dao.FeeBillDAOw;
import com.erp.model.dao.FeeBillItemDAOw;
import com.erp.model.dao.FeeTypeDAOw;
import com.erp.model.dao.TallySetDAOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.FeeBillItemVO;
import com.erp.model.vo.FeeBillVO;
import com.erp.model.vo.FeeTypeVO;
import com.erp.model.vo.FenyeMode;
import com.erp.model.vo.TallySetVO;

public class FeeBillMgr {
	FeeBillDAOw feeBillDAO = new FeeBillDAOw();
	FeeBillItemDAOw feeBillItemDAO = new FeeBillItemDAOw();
	FeeTypeDAOw feeTypeDAO = new FeeTypeDAOw();
	TallySetDAOw tallySetDAO = new TallySetDAOw();
	BankAccountDAOw bankAccountDAO = new BankAccountDAOw();
	DepartmentDAOw departmentDAO = new DepartmentDAOw();

	public void ExaminedTongGuo(long id) {
		feeBillDAO.ExaminedTongGuo(id);

	}

	public FeeBillVO ChaZhaoByPayBillId(long id) {
		return feeBillDAO.ChaZhaoByPayBillId(id);

	}

	public List<FeeBillItemVO> getFeeBillItemById(long id) {
		return feeBillItemDAO.getFeeBillItemById(id);
	}

	public TallySetVO getTallySetByFeeBillId(long id) {
		return tallySetDAO.getTallySetByFeeBillId(id);
	}

	public BankAccountVO getBankAccountByFbBankAccId(long id) {
		return bankAccountDAO.getBankAccountByFbBankAccId(id);
	}

	public DepartmentVO getDepartmentsByDepatementId(long id) {
		return departmentDAO.getDepartmentsByDepatementId(id);
	}

	public List<FeeTypeVO> getFeeTypeByFeeBillitemBillIds(List<FeeBillItemVO> feeBillItemVOs) {
		List<Long> ids = new ArrayList<Long>();

		for (FeeBillItemVO feeBillItemVO : feeBillItemVOs) {
			ids.add(feeBillItemVO.getFtId());
		}

		return feeTypeDAO.getFeeTypeByFeeBillitemBillIds(ids);
	}

	/**
	 * @param maxNumEveryPage
	 * @param currentPageNum
	 * @return
	 */
	public FenyeMode fenyeService(Integer maxNumEveryPage, Integer currentPageNum) {
		FenyeMode fenyeMode = new FenyeMode();
		fenyeMode.setMaxNumEveryPage(maxNumEveryPage);
		currentPageNum = (currentPageNum == null || currentPageNum == 0) ? 1 : currentPageNum;
		Query query = feeBillDAO.findAllByTEN();
		// List<FeeBillVO> feeBillList = query.list();
		Integer allResultNum = query.list().size();
		// 3：设置全部结果数

		fenyeMode.setAllResultNum(allResultNum);

		Integer allPageNum = (allResultNum % maxNumEveryPage == 0) ? allResultNum / maxNumEveryPage
				: allResultNum / maxNumEveryPage + 1;

		// 4:设置一共多少页
		fenyeMode.setAllPageNum(allPageNum);
		// 5：设置如果到了最后一页，那么跳回到第一页
		if (currentPageNum > allPageNum) {
			currentPageNum = allPageNum;
		}
		// 再设置一次当前页currentPageNum
		fenyeMode.setCurrentPageNum(currentPageNum);
		// 设置每页最大数量
		query.setMaxResults(fenyeMode.getMaxNumEveryPage());
		// 设置从第几条数据开始
		query.setFirstResult((currentPageNum - 1) * maxNumEveryPage);
		// 取得结果集
		List<FeeBillVO> feeBillList = query.list();
		// 5：装在结果集
		fenyeMode.setFeeBillList(feeBillList);
		return fenyeMode;
	}
}
