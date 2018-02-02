package com.erp.controller.delivery.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.customerBusiness.vto.CustomerVTO;
import com.erp.controller.delivery.mgr.DeliverMgr;

/**
 * 客户业务
 * 送货
 * 	送货	审核	反审核	送货一览表	送货明细一览表
 * 安装
 * 	安装	审核	反审核	安装一览表
 * @author guo
 *
 */
public class DeliverAction extends BaseAction<CustomerVTO>{
	private DeliverMgr deliveryMgr = new DeliverMgr();
	
//	送货	进入送货页面
	public String toBusinessBillListForDeliver(){
		deliveryMgr.findAllBusinessBillListForDeliver();
		return "toBusinessBillListForDeliver";
	}
//	送货	进入审核页面
	public String toDeliverBillListForExamine(){
		deliveryMgr.findAllDeliverBillListForExamine();
		return "toDeliverBillListForExamine";
	}
//	送货	进入反审核页面
	public String toDeliverBillListForUnExamine(){
		deliveryMgr.findAllDeliverBillListForExamine();
		return "toDeliverBillListForUnExamine";
	}
//	送货	进入送货单一览表页面
	public String toDeliverBillSearchResult(){
		deliveryMgr.findAllDeliveryBillListForExamine();
		return "toDeliverBillSearchResult";
	}
//	送货	进入送货单明细一览表页面
	public String toDeliverBillItemSearchResult(){
		deliveryMgr.findAllDeliverBillItemSearchResult();
		return "toDeliverBillItemSearchResult";
	}
	
}
