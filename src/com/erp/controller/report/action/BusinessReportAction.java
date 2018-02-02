package com.erp.controller.report.action;

import java.math.BigDecimal;
import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.finance.mgr.InComeBillMgr;
import com.erp.controller.finance.mgr.InComeTypeMgr;
import com.erp.model.vo.IncomeBill;
import com.opensymphony.xwork2.ActionContext;

/**
 * 营业 统计
 * @author JiaQi
 *
 */
public class BusinessReportAction extends BaseAction<IncomeBill>{
	/**
	 * 跳转到营业销售日报界面
	 */
	public String toBusinessDateCount(){
		InComeBillMgr inComeBillMgr = new InComeBillMgr();
		List<IncomeBill> incomeBills= inComeBillMgr.findAllCanUse("","");
		ActionContext.getContext().getValueStack().set("inComeBillNum", incomeBills.size());
		int i = 0;
		BigDecimal cost = new BigDecimal(0);//合同金额
		while (i < incomeBills.size()) {
			cost = cost.add(incomeBills.get(i).getCost());
			i++;
		}
		ActionContext.getContext().getValueStack().set("cost", cost);
		return "toBusinessDateCount";
	}
}
