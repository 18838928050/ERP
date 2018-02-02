package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.FeiyongdanyilanMgr;
import com.erp.controller.vto.FeiyongdanyilanActionVTOw;

public class feiyongdanyidanTableAction extends BaseAction<FeiyongdanyilanActionVTOw> {
	FeiyongdanyilanMgr feiyongdanyilanMgr = new FeiyongdanyilanMgr();

	public String listUI() {
		model.setFeeBillVOs(feiyongdanyilanMgr.getFeeBillBosByLimits());
		model.setBankAccountVOs(feiyongdanyilanMgr.getBankAccountsByFeebillBankAccouIds(model
				.getFeeBillVOs()));
		return "listui";
	}
}
