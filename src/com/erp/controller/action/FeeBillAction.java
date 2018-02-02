package com.erp.controller.action;

import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.FeeBillMgr;
import com.erp.controller.vto.FeeBillVTOw;
import com.erp.model.vo.FeeBillVO;
import com.erp.model.vo.FenyeMode;

@SuppressWarnings("serial")
public class FeeBillAction extends BaseAction<FeeBillVTOw> {
	private FeeBillMgr feeBillMgr = new FeeBillMgr();
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

	/**
	 * 这是费用类型模块
	 * 
	 * @author fu 通过tallyset=2,examined=N,enabled=Y三个条件进行筛选后的全部查询
	 * @return
	 * @throws Exception
	 */
	// 查找全部
	public String findAll() throws Exception {
		MaxNumEveryPage = (MaxNumEveryPage == null || MaxNumEveryPage.equals("")) ? 10
				: MaxNumEveryPage;
		fenyeMode = feeBillMgr.fenyeService(MaxNumEveryPage, CurrentPageNum);
		List<FeeBillVO> feeBillVOs = fenyeMode.getFeeBillList();
		model.setFeeBillVOs(feeBillVOs);
		return "toListUI";
	}

	// 审核通过
	public String ExaminedTongGuo() {

		feeBillMgr.ExaminedTongGuo(model.getFeeBillVO().getId());
		return "toFindAll";
	}

	// 查看
	public String ChaZhaoByPayBillId() {
		model.setFeeBillVO(feeBillMgr.ChaZhaoByPayBillId(model.getFeeBillVO().getId()));
		// fB.ID=FBI.billId
		model.setFeeBillItemVOs(feeBillMgr.getFeeBillItemById(model.getFeeBillVO().getId()));
		model.setDepartmentVO(feeBillMgr.getDepartmentsByDepatementId(model.getFeeBillVO()
				.getDepartmentId()));
		model.setTallySetVO(feeBillMgr.getTallySetByFeeBillId(model.getFeeBillVO().getTallySetId()));
		model.setBankAccountVO(feeBillMgr.getBankAccountByFbBankAccId(model.getFeeBillVO()
				.getBankAccountId()));
		model.setFeeTypeVOs(feeBillMgr.getFeeTypeByFeeBillitemBillIds(model.getFeeBillItemVOs()));
		return "toChaZhao";
	}
	public String toback() {
		return "toback";
		
	}
}
