package com.erp.controller.statistic.action;


import com.erp.controller.accounts.vto.AccountsVTO;
import com.erp.controller.action.BaseAction;
import com.erp.controller.statistic.mgr.StatisticMgr;

/**
 * 账务	作废	
 * @author guo
 */
public class StatisticAction extends BaseAction<AccountsVTO>{

	private static final long serialVersionUID = 1L;
	private StatisticMgr statisticMgr = new StatisticMgr();

	//进入客户应收款
	public String toReceivableList(){
		statisticMgr.findAllEstablishment();
		return "toReceivableList";
	}
	//进入业务单应收款
	public String toBusinessBillListForReceive(){
		statisticMgr.findAllBusinessBill();
		return "toBusinessBillListForReceive";
	}

	//进入应收汇总表
	public String toReceivableCount(){
		statisticMgr.findYearBusinessBill();
		return "toReceivableCount";
	}

	//进入应收款账龄分布表
	public String toReceivableAgeList(){
		statisticMgr.findMonthProfitCost();
		return "toReceivableAgeList";
	}
	//进入采购付款一览表	采购单和付款单 	PurchaseBillVO	PayBillVO
	public String toPurPayCostList(){
		statisticMgr.findPurPayCostList();
		return "toPurPayCostList";
	}
	//进入外协付款一览表	
	public String toCooPayCostList(){
		statisticMgr.findCooPayCostList();
		return "toCooPayCostList";
	}



}