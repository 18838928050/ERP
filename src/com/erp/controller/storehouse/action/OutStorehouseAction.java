package com.erp.controller.storehouse.action;

import com.erp.controller.action.BaseAction;

import com.erp.controller.basedata.mgr.UnitMgr;
import com.erp.controller.storehouse.mgr.OutDetailMgr;
import com.erp.controller.storehouse.mgr.OutItemMgr;
import com.erp.controller.storehouse.mgr.StorehouseMgr;
import com.erp.model.vo.OutBill;
import com.opensymphony.xwork2.ActionContext;
/**
 * 出库明细一览表   controller
 * @author WangEn
 *
 */

public class OutStorehouseAction extends BaseAction<OutBill>{
	//创建逻辑处理对象
	private OutDetailMgr outDetailMgr = new OutDetailMgr();
	private StorehouseMgr storehouseMgr = new StorehouseMgr();
	private UnitMgr unitMgr = new UnitMgr();
	private OutItemMgr outItemMgr = new OutItemMgr();

	//遍历数据库
	public String toOutBillList(){
		ActionContext.getContext().getValueStack().set("storehouses", storehouseMgr.findAll());
		ActionContext.getContext().getValueStack().set("units", unitMgr.findAll());
		ActionContext.getContext().getValueStack().set("outBills", outDetailMgr.findAll());
		ActionContext.getContext().getValueStack().set("outItems", outItemMgr.findAll());
		return "toOutBillList";
		
	}

}
