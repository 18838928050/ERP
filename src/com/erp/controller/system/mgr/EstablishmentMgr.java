package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.erp.model.dao.CooperBillDAOw;
import com.erp.model.dao.CooperBillItemDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.GatherBillDAOw;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.dao.TallySetDAOw;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.FenyeMode;
import com.erp.model.vo.GatherBillVO;
import com.erp.model.vo.MakeTypeVO;

public class EstablishmentMgr {
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();
	TallySetDAOw tallySetDAO = new TallySetDAOw();
	CooperBillDAOw cooperBillDAO = new CooperBillDAOw();
	CooperBillItemDAOw cooperBillItemDAO = new CooperBillItemDAOw();
	GatherBillDAOw gatherBillDAO = new GatherBillDAOw();
	MakeTypeDAOw makeTypeDAO = new MakeTypeDAOw();
	private Date str;

	public Date getStr() {
		return str;
	}

	public void setStr(Date str) {
		this.str = str;
	}

	/**
	 * @说明：分页
	 */
	// 给当前页数和每页最大数据
	public FenyeMode fenyeService(Integer MaxNumEveryPage, Integer currentPageNum) {
		FenyeMode fenyeMode = new FenyeMode();

		// 1:每页最大数据
		fenyeMode.setMaxNumEveryPage(MaxNumEveryPage);
		// currentPageNum=currentPageNum-1;
		// 判断 如果用户没有输入页数 怎默认设置当前页数为第一页 否则按照用户输入的
		currentPageNum = (currentPageNum == null || currentPageNum == 0) ? 1 : currentPageNum;

		// 获取结果集
		Query query = establishmentDAO.getQuery();
		Integer allResultNum = query.list().size();
		// 3：设置全部结果数
		fenyeMode.setAllResultNum(allResultNum);

		Integer allPageNum = (allResultNum % MaxNumEveryPage == 0) ? allResultNum / MaxNumEveryPage
				: allResultNum / MaxNumEveryPage + 1;

		// 4:设置一共多少页
		fenyeMode.setAllPageNum(allPageNum);
		// 5：设置如果到了最后一页，那么跳回到第一页
		if (currentPageNum > allPageNum) {
			currentPageNum = allPageNum;
		}
		// 2:设置当前页
		fenyeMode.setCurrentPageNum(currentPageNum);
		// 设置每页最大数量
		query.setMaxResults(fenyeMode.getMaxNumEveryPage());
		// 设置从第几条数据开始
		query.setFirstResult((currentPageNum - 1) * MaxNumEveryPage);
		// 取得结果集
		List<EstablishmentVO> establishmentVOs = query.list();
		// 5：装在结果集
		fenyeMode.setEstList(establishmentVOs);
		return fenyeMode;
	}

	public Object getEstablishmentById(long cooperatorId, String sort, long tallyset,
			String timeLimit, String hasPay) {
		return cooperBillDAO.getCooperBillByCooperatorIdAndTimeSortTallySetifHasPay(cooperatorId,
				sort, tallyset, timeLimit, hasPay);
	}

	public Object getEstablishmentById(long id) throws Exception {
		return establishmentDAO.getById(id);
	}

	/**
	 * @说明：//由E.id=CB.cooperartor_id 得到CB
	 */
	public List<CooperBillVO> getCooperBillsByCooperatorId(long cooperatorId, String sort,
			Long tallyset, String timeLimit, String hasPay) {
		return cooperBillDAO.getCooperBillByCooperatorIdAndTimeSortTallySetifHasPay(cooperatorId,
				sort, tallyset, timeLimit, hasPay);
	}

	/**
	 * @说明：
	 */
	public List<List<CooperBillItemVO>> getCooperBillItemsByBillIds(List<CooperBillVO> cooperBillVOs) {
		// 获得cb的id的数组
		List<Long> listCBids = new ArrayList<Long>();
		for (CooperBillVO cooperBillVO : cooperBillVOs) {
			listCBids.add(cooperBillVO.getId());
		}
		List<List<CooperBillItemVO>> cooperBillItemVOs = cooperBillItemDAO
				.getCooperBillItemByBillIDs(listCBids);
		return cooperBillItemVOs;
	}

	/**
	 * @说明：
	 */
	public List<GatherBillVO> getGatherBillByCooperBillID(List<CooperBillVO> cooperBillVOs) {
		List<CooperBillVO> cooperBillVOss = cooperBillVOs;
		List<Long> listCBids = new ArrayList<Long>();
		for (CooperBillVO cooperBillVO : cooperBillVOs) {
			listCBids.add(cooperBillVO.getId());
		}
		List<GatherBillVO> gatherBillVOs = gatherBillDAO.getGatherBillByCooperBillIds(listCBids);
		return gatherBillVOs;
	}

	/**
	 * @说明：
	 */

	public List<MakeTypeVO> getMakeTypeByIds(List<List<CooperBillItemVO>> cooperbillitemvoSS) {
		List<Long> ids = new ArrayList<Long>();
		for (List<CooperBillItemVO> list : cooperbillitemvoSS) {
			for (CooperBillItemVO cooperBillItemVO : list) {
				ids.add(cooperBillItemVO.getMakeTypeId());
			}
		}
		return makeTypeDAO.getMakeTypeByIds(ids);
	}

}
