package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.WodefeiyongdanMgr;
import com.erp.controller.vto.WodefeiyongdanVTOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeBillVO;

public class WodefeiyongdanAction extends BaseAction<WodefeiyongdanVTOw> {
	WodefeiyongdanMgr wodefeiyongdanMgr = new WodefeiyongdanMgr();

	public String listUI() {
		String createrName = "邵丽萍";
		long tallySetId = 2l;

		model.setFeeBillVOs(wodefeiyongdanMgr.getFeeBillVOSbylimit(createrName, tallySetId));
		model.setBankAccountVOs(wodefeiyongdanMgr.getBankAccountVOSbyFeeBillBankAccountIds(model
				.getFeeBillVOs()));

		for (FeeBillVO feeBillVO : model.getFeeBillVOs()) {
			System.out.println(feeBillVO);

		}
		for (BankAccountVO bankAccountVO : model.getBankAccountVOs()) {
			System.out.println(bankAccountVO);

		}
		return "toListUI";

	}

}
