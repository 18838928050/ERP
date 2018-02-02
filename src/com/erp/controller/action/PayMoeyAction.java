/**
 * 
 */
package com.erp.controller.action;

import com.erp.controller.action.BaseAction;
import com.erp.controller.system.mgr.PayMoeyActionMgr;
import com.erp.controller.vto.PayMoeyVTOw;

/**
 @author： 如约而至    @time：2017年10月1日 下午12:35:39 
 *******************************************************************
 @说明： 账务 》》  付款单
 *******************************************************************/
public class PayMoeyAction extends BaseAction<PayMoeyVTOw>{
	PayMoeyActionMgr payMoeyActionMgr=new PayMoeyActionMgr();
	public String getMain(){
		return "main";
	}

}
