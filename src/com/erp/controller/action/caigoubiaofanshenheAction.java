package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.CaigoubiaofanshenheMgr;
import com.erp.controller.vto.PurchaseBillVTOw;

public class caigoubiaofanshenheAction extends BaseAction<PurchaseBillVTOw> {
	CaigoubiaofanshenheMgr caigoubiaofanshenheMgr = new CaigoubiaofanshenheMgr();
	public String shenhebutongguo() {
		caigoubiaofanshenheMgr.shenhebutongguo(model.getPurchaseBillVO().getId());
		return "toFindAll";
	}
	
	public String chakan() {
		model.setPurchaseBillVO(caigoubiaofanshenheMgr.findPbByPbId(model.getPurchaseBillVO().getId()));
		model.setEstablishmentVO(caigoubiaofanshenheMgr.findEstByPbId(model.getPurchaseBillVO().getId()));
		model.setStorehouseVO(caigoubiaofanshenheMgr.getStoreHouseByPbId(model.getPurchaseBillVO().getId()));
		model.setProductVOs(caigoubiaofanshenheMgr.findProductByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillItemVOs(caigoubiaofanshenheMgr.findPBIS(model.getPurchaseBillVO().getId()));
		model.setTallySetVO(caigoubiaofanshenheMgr.findTallySetByPbId(model.getPurchaseBillVO().getId()));
		model.setBankAccountVO(caigoubiaofanshenheMgr.findBankByPbId(model.getPurchaseBillVO().getId()));
		model.setPurchaseBillExtVO(caigoubiaofanshenheMgr.findPbeByPbId(model.getPurchaseBillVO().getId()));
		return "toChakan";
	}
	public String tuichu() {
		return "tuichu";
	}
}
