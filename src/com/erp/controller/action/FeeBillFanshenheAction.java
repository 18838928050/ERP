package com.erp.controller.action;

import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.FeeBillFanshenheMgr;
import com.erp.controller.vto.FeeBillVTOw;
import com.erp.model.vo.FeeBillVO;
import com.erp.model.vo.FenyeMode;

public class FeeBillFanshenheAction extends BaseAction<FeeBillVTOw> {
	FeeBillFanshenheMgr fanshenheMgr = new FeeBillFanshenheMgr();
	private Integer CurrentPageNum;

	public FeeBillFanshenheMgr getFanshenheMgr() {
		return fanshenheMgr;
	}

	public void setFanshenheMgr(FeeBillFanshenheMgr fanshenheMgr) {
		this.fanshenheMgr = fanshenheMgr;
	}

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

	private Integer MaxNumEveryPage;
	FenyeMode fenyeMode = new FenyeMode();

	/**
	 * @author fu 通过tallyset=2,examined=N,enabled=Y三个条件进行筛选后的全部查询
	 * @return
	 * @throws Exception
	 */
	// 查找全部
	public String findAll() throws Exception {
		MaxNumEveryPage = (MaxNumEveryPage == null || MaxNumEveryPage.equals("")) ? 10
				: MaxNumEveryPage;
		fenyeMode = fanshenheMgr.fenyeService(MaxNumEveryPage, CurrentPageNum);
		List<FeeBillVO> feeBillVOs = fenyeMode.getFeeBillList();
		model.setFeeBillVOs(feeBillVOs);
		return "toListUI";
	}

	// 反审核
	public String ExaminedNotTongGuo() {
		fanshenheMgr.ExaminedShenHeNotTongguo(model.getFeeBillVO().getId());
		return "toFindAll";
	}

	// 查看
	public String ChaZhaoByPayBillId() {
		model.setFeeBillVO(fanshenheMgr.ChaZhaoByPayBillId(model.getFeeBillVO().getId())); // fB.ID=FBI.billId
		model.setFeeBillItemVOs(fanshenheMgr.getFeeBillItemById(model.getFeeBillVO().getId()));
		model.setDepartmentVO(fanshenheMgr.getDepartmentsByDepatementId(model.getFeeBillVO()
				.getDepartmentId()));
		model.setTallySetVO(fanshenheMgr.getTallySetByFeeBillId(model.getFeeBillVO()
				.getTallySetId()));
		model.setBankAccountVO(fanshenheMgr.getBankAccountByFbBankAccId(model.getFeeBillVO()
				.getBankAccountId()));
		model.setFeeTypeVOs(fanshenheMgr.getFeeTypeByFeeBillitemBillIds(model.getFeeBillItemVOs()));

		return "toChaZhao";
	}
	public String toback() {
		return "toback";
		
	}

}
