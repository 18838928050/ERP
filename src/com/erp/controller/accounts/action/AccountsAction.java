package com.erp.controller.accounts.action;


import com.erp.controller.accounts.mgr.AccountsMgr;
import com.erp.controller.accounts.vto.AccountsVTO;
import com.erp.controller.action.BaseAction;

/**
 * 账务	作废	
 * @author guo
 */

public class AccountsAction extends BaseAction<AccountsVTO>{

	private static final long serialVersionUID = 1L;
	AccountsMgr accountsMgr = new AccountsMgr();
	
//	进入收款单作废页面
	public String toReceiveBillListForCancel(){
		accountsMgr.toReceiveBills();
		return "toReceiveBillListForCancel";
	}
//	带搜索条件
	public String toSelectReceiveBillListForCancel(){
		accountsMgr.selectReceiveBill(getModel());
		return "toSelectReceiveBillListForCancel";
	}
//	进入作废收款单单页面  模态框没有见页面
	public String toDisabledReceiveBill(){
//		accountsMgr.toEnabledReceiveBill(getModel());
		return "toDisabledReceiveBill";
	}
//	作废单个收款单
	public String disabledReceiveBill(){
		accountsMgr.enabledReceiveBill(getModel());
		return "disabledReceiveBill";
	}
//	进入收款单详情页
	public String toReceiveBill(){
		accountsMgr.getReceiveBill(getModel());
		return "toReceiveBill";
	}
	
	
	
//	进入其它收入单页面
	public String toIncomeBillListForCancel(){
		accountsMgr.toIncomeBills();
		return "toIncomeBillListForCancel";
	}
//	进入其它收入单页面搜索带条件
	public String toSelectIncomeBillListForCancel(){
		accountsMgr.toEnabledIncomeBill(getModel());
		return "toSelectInncomeBillListForCancel";
	}
//	进入其它收入单页面  模态框没有见页面
	public String toDisabledIncomeBill(){
		accountsMgr.toEnabledIncomeBill(getModel());
		return "toDisabledIncomeBill";
	}
//	作废单个其它收入单
	public String disabledIncomeBill(){
		accountsMgr.enabledIncomeBill(getModel());
		return "disabledReceiveBill";
	}
	public String toIncomeBill(){
		accountsMgr.toIncomeBill(getModel());
		return "toIncomeBill";
	}
	
	
	
//	进入付款单作废页面
	public String toPayBillListForCancel(){
		accountsMgr.toPaycomeBills();
		return "toPayBillListForCancel";
	}
	
//	带搜索条件
	public String toSelectPayBillListForCancel(){
		accountsMgr.selectPayBill(getModel());
		return "toSelectPayBillListForCancel";
	}
//	进入其它付款单页面  模态框没有见页面
	public String toDisabledPayBill(){
		accountsMgr.toEnabledPayBill(getModel());
		return "toDisabledPayBill";
	}
//	作废单个付款收入单
	public String disabledPayBill(){
		accountsMgr.enabledPayBill(getModel());
		return "disabledPayBill";
	}
	public String toPayBill(){
		accountsMgr.toPayBill(getModel());
		return "toPayBill";
	}
	
	
	
	
//	进入费用单作废页面
	public String toFeeBillListForCancel(){
		accountsMgr.toFeeBills();
		return "toFeeBillListForCancel";
	}
//	带搜索条件
	public String toSelectFeeBillListForCancel(){
		accountsMgr.selectFeeBill(getModel());
		return "toSelectFeeBillListForCancel";
	}
//	进入其它费用单页面  模态框没有见页面
	public String toDisabledFeeBill(){
		accountsMgr.toEnabledFeeBill(getModel());
		return "toDisabledFeeBill";
	}
//	作废单个费用单
	public String disabledFeeBill(){
		accountsMgr.enabledFeeBill(getModel());
		return "disabledFeeBill";
	}
	public String toFeeBill(){
		accountsMgr.toFeeBill(getModel());
		return "toFeeBill";
	}
	
	
//	进入调账单作废页面
	public String toAdjustBillListForCancel(){
		accountsMgr.toAdjustBills();
		return "toAdjustBillListForCancel";
	}
//	带搜索条件
	public String toSelectAdjustBillListForCancel(){
		accountsMgr.selectAdjustBill(getModel());
		return "toSelectAdjustBillListForCancel";
	}
//	进入其它调账单页面  模态框没有见页面
	public String toDisabledAdjustBill(){
		return "toDisabledAdjustBill";
	}
//	作废单个调账单
	public String disabledAdjustBill(){
		accountsMgr.enabledAdjustBill(getModel());
		return "disabledAdjustBill";
	}
//	
	public String toAdjustBill(){
//		accountsMgr.toAdjustBill();
		return "toAdjustBill";
	}
	
	
//	进入转账取款单作废页面
	public String toTransferBillListForCancel(){
		accountsMgr.toTransferBills();
		return "toTransferBillListForCancel";
	}
//	带搜索条件
	public String toSelectTransferBillListForCancel(){
		accountsMgr.selectTransferBill(getModel());
		return "toSelectTransferBillListForCancel";
	}
//	进入其它转账取款页面  模态框没有见页面
	public String toDisabledTransferBill(){
		accountsMgr.toEnabledTransferBill(getModel());
		return "toDisabledTransferBill";
	}
//	作废单个转账取款disabledTransferBill
	public String disabledTransferBill(){
		accountsMgr.enabledTransferBill(getModel());
		return "disabledTransferBill";
	}
	public String toTransferBill(){
		accountsMgr.toTransferBill(getModel());
		return "toTransferBill";
	}
	
	
//	进入资金借入单作废页面
	public String toInLoanBillListForCancel(){
		accountsMgr.toInLoanBills();
		return "toInLoanBillListForCancel";
	}
//	带搜索条件
	public String toSelectInLoanBillListForCancel(){
		accountsMgr.selectInLoanBill(getModel());
		return "toSelectInLoanBillListForCancel";
	}
//	进入其它转账取款页面  模态框没有见页面
	public String toDisabledInLoanBill(){
		accountsMgr.toEnabledInLoanBill(getModel());
		return "toDisabledInLoanBill";
	}
//	作废单个转账取款
	public String disabledInLoanBill(){
		accountsMgr.enabledInLoanBill(getModel());
		return "disabledInLoanBill";
	}
	public String toInLoanBill(){
		accountsMgr.toInLoanBill(getModel());
		return "toInLoanBill";
	}
	
	
	
//	进入资金借出单作废页面
	public String toLoanBillOutListForCancel(){
		accountsMgr.toOutLoanBills();
		return "toLoanBillOutListForCancel";
	}
//	带搜索条件
	public String toSelectOutLoanBillListForCancel(){
		accountsMgr.selectOutLoanBill(getModel());
		return "toSelectOutLoanBillListForCancel";
	}
//	进入其它转账取款页面  模态框没有见页面
	public String toDisabledOutLoanBill(){
		accountsMgr.toEnabledOutLoanBill(getModel());
		return "toDisabledOutLoanBill";
	}
//	作废单个转账取款
	public String disabledOutLoanBill(){
		accountsMgr.enabledOutLoanBill(getModel());
		return "disabledOutLoanBill";
	}
	public String toOutLoanBill(){
		accountsMgr.toOutLoanBill(getModel());
		return "toOutLoanBill";
	}
}