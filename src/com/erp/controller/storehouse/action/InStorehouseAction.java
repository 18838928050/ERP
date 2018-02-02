package com.erp.controller.storehouse.action;

import java.util.HashMap;

import com.erp.controller.action.BaseAction;
import com.erp.controller.storehouse.mgr.EstablishmentMgr;
import com.erp.controller.storehouse.mgr.InDetailMgr;
import com.erp.controller.storehouse.mgr.InTypeMgr;
import com.erp.controller.storehouse.mgr.StorehouseMgr;
import com.erp.model.vo.Establishment;
import com.erp.model.vo.InBill;
import com.erp.model.vo.StafferVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 入库单一览表   controller 
 * @author WangEn
 *
 */
public class InStorehouseAction extends BaseAction<InBill>{
	//创建逻辑处理对象
	private InDetailMgr inDetailMgr = new InDetailMgr();
	private StorehouseMgr storehouseMgr = new StorehouseMgr();
	private InTypeMgr inTypeMgr = new InTypeMgr();
	private EstablishmentMgr establishmentMgr = new EstablishmentMgr();
	//遍历数据库
	public String toInBillResult(){
		
		ActionContext.getContext().getValueStack().set("inTypes", inTypeMgr.findAll());
		ActionContext.getContext().getValueStack().set("storehouses", storehouseMgr.findAll());
		ActionContext.getContext().getValueStack().set("inBills", inDetailMgr.findAll());
		ActionContext.getContext().getValueStack().set("establishments", establishmentMgr.findAll());
		HashMap<Long, String> establishmnetsSon = new HashMap<>();
		for (Establishment establishment:establishmentMgr.findAll()) {
			//System.out.println(stafferVO.toString());
			establishmnetsSon.put(establishment.getId(), establishment.getEstName());
		}
		establishmnetsSon.put((long)0, "");
		System.out.println(establishmentMgr.findAll());
		return "toInBillResult";
		
	}
	
	//跳转入库单一览表编辑页面
	public String toInBillEdit(){
		return "toInBillEdit";
	}
	
	//跳转入库单一览表编辑页面
	public String tohadExamine(){
		return "tohadExamine";
	}
	

}
