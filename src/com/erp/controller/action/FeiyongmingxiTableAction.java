package com.erp.controller.action;

import com.erp.controller.system.mgr.FeiyongmingxiMgr;
import com.erp.controller.vto.FeiyongmingxiVTOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.FeeBillVO;

public class FeiyongmingxiTableAction extends BaseAction<FeiyongmingxiVTOw> {
	FeiyongmingxiMgr feiyongmingxiMgr = new FeiyongmingxiMgr();

	public String findAll() {
		Long tallySet = 2l;
		model.setFeeBillVOs(feiyongmingxiMgr.findFeeBillvosByLlimit(tallySet));

		model.setBankAccountVOs(feiyongmingxiMgr.setBankAccountVOS(model.getFeeBillVOs()));
		for (FeeBillVO iterable_element : model.getFeeBillVOs()) {
			System.out.println(iterable_element);

		}
		for (BankAccountVO iterable_element : model.getBankAccountVOs()) {
			System.out.println(iterable_element);

		}
		return "tolistUI";

	}
}
