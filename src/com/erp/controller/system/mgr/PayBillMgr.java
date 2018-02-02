package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;

import com.erp.controller.vto.PayBillVTOw;
import com.erp.model.dao.BankAccountDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.PayBillDaow;
import com.erp.model.dao.StafferDAOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.FenyeMode;
import com.erp.model.vo.PayBillVO;
import com.erp.model.vo.StafferVO;

public class PayBillMgr {
	PayBillDaow payBillDao = new PayBillDaow();
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();
	BankAccountDAOw bankAccountDAO = new BankAccountDAOw();
	StafferDAOw stafferDAO = new StafferDAOw();
	private PayBillVTOw payBillVTO = new PayBillVTOw();

	public PayBillVTOw getPayBillVTO() {
		return payBillVTO;
	}

	public void setPayBillVTO(PayBillVTOw payBillVTO) {
		this.payBillVTO = payBillVTO;
	}

	public List<PayBillVO> findAll() throws Exception {
		FenyeMode fenyeMode = new FenyeMode();
		int currentPageNum;
		Integer MaxNumEveryPage;

		List<PayBillVO> payBillVOs = payBillDao.findAll();

		for (PayBillVO payBillVO : payBillVOs) {
			if (payBillVO.getExamined().equals("Y")) {
				payBillVO.setExamined("已审核");
			} else {
				payBillVO.setExamined("未审核");
			}

			if (payBillVO.getPayType().equals("COOPER")) {
				payBillVO.setPayType("外协");

			} else {
				payBillVO.setPayType("采购");
			}

		}
		return payBillVOs;
	}

	public List<BankAccountVO> findBankAccountAndAccountName() {

		return payBillDao.findBankAccountAndAccountName();

	}

	/**
	 * @return
	 * 
	 */
	public List<EstablishmentVO> findEst() {
		return payBillDao.findEst();

	}

	/**
	 * @return
	 */
	public List<StafferVO> findCreater() {
		return payBillDao.findCreater();
	}

	public List<List<EstablishmentVO>> getEstsByPayBillReceiverIds(List<PayBillVO> payBillVOs) {
		// 获得establishment的id数组
		List<Long> listReceiverIds = new ArrayList<Long>();
		for (PayBillVO payBillVO : payBillVOs) {
			listReceiverIds.add(payBillVO.getReceiverId());
		}
		List<List<EstablishmentVO>> establishmeLists = establishmentDAO
				.getEstsByPayBillIds(listReceiverIds);
		return establishmeLists;
	}

	/**
	 * @param payBillVOs
	 * @return
	 */
	public List<List<BankAccountVO>> getBanksByPayBankAccountIds(List<PayBillVO> payBillVOs) {
		List<Long> listBankIds = new ArrayList<Long>();
		for (PayBillVO payBillVO : payBillVOs) {
			listBankIds.add(payBillVO.getBankAccountId());
		}
		List<List<BankAccountVO>> bankaccountVOS = bankAccountDAO
				.getBanksByPayBankAccountIds(listBankIds);
		return bankaccountVOS;
	}

	/**
	 * @param payBillVOs
	 * @return
	 */
	public List<List<StafferVO>> getStafferNameByCreaterIds(List<PayBillVO> payBillVOs) {
		List<Long> listStafferIds = new ArrayList<Long>();
		for (PayBillVO payBillVO : payBillVOs) {
			listStafferIds.add(payBillVO.getCreaterId());
		}
		List<List<StafferVO>> stafferVOS = stafferDAO.getStafferNameByCreaterIds(listStafferIds);
		return stafferVOS;
	}

	public List<List<PayBillVO>> getExaminedByNOrY(List<PayBillVO> payBillVOs) {
		List<String> examined = new ArrayList<String>();
		for (PayBillVO payBillVO : payBillVOs) {
			if (payBillVO.getExamined() == "Y") {
				payBillVO.setExamined("已审核");

			} else {
				payBillVO.setExamined("未审核");
			}

		}
		return null;
	}

	/**
	 * @param maxNumEveryPage
	 * @param currentPageNum
	 * @return
	 * @throws Exception
	 */
	public FenyeMode fenyeService(Integer maxNumEveryPage, Integer currentPageNum) throws Exception {
		FenyeMode fenyeMode = new FenyeMode();
		fenyeMode.setMaxNumEveryPage(maxNumEveryPage);
		currentPageNum = (currentPageNum == null || currentPageNum == 0) ? 1 : currentPageNum;
		Query query = payBillDao.findAAll();
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
		List<PayBillVO> payBillVOs = query.list();
		// 5：装在结果集
		fenyeMode.setPayBillVOs(payBillVOs);
		return fenyeMode;
	}
}
