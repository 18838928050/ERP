package com.erp.controller.stock.action;

import java.io.UnsupportedEncodingException;

import com.erp.controller.action.BaseAction;
import com.erp.controller.customerBusiness.mgr.CustomerMgr;
import com.erp.controller.customerBusiness.vo.EstablishmentVO;
import com.erp.controller.customerBusiness.vto.CustomerVTO;
import com.erp.controller.stock.mgr.StockMgr;
import com.erp.controller.stock.vto.StockVTO;

import antlr.collections.List;

/**
 * 库存 作废 模块
 * @author guo
 */

public class StockAction extends BaseAction<StockVTO>{
	private StockMgr stockMgr=new StockMgr();
	private static final long serialVersionUID = 1L;
	
	//	进入库存 作废 调拨单作废列表界面
	public String toAlloBillListForCancel(){
		stockMgr.findAllAlloBill();
		return "toAlloBillListForCancel";
	}
	//	进入库存 作废 入库单作废界面
	public String toInBillListForCancel(){
		stockMgr.findAllInBill();
		return "toInBillListForCancel";
	}
	//	进入库存 作废 出库单作废列表界面
	public String toOutBillListForCancel(){
		stockMgr.findAllOutBill();
		return "toOutBillListForCancel";
	}

	//	库存 作废  具体调拨单作废界面
	public String toAlloBillCancel(){
		return "toAlloBillCancel";
	}
	//	库存 作废  具体入库单作废界面
	public String toInBillCancel(){
		return "toInBillCancel";
	}
	//	库存 作废  具体出库单作废界面
	public String toOutBillCancel(){
		return "toOutBillCancel";
	}
	
	//	库存 作废  调拨单作废界面按钮
	public String alloBillCancel(){
		stockMgr.updateAlloBill(getModel().getAlloBill());
		return "alloBillCancel";
	}
	//	库存 作废  入库单作废界面按钮
	public String inBillCancel(){
		stockMgr.updateInBill(getModel().getInBill());
		return "inBillCancel";
	}
	//	库存 作废  出库单作废界面按钮
	public String outBillCancel(){
		stockMgr.updateOutBill(getModel().getOutBill());
		return "inBillCancel";
	}
	
	//	库存 库存  库存查询界面
	public String toStockSearch(){
		stockMgr.findAllProduct();
		return "toStockSearch";
	}
//	库存 库存	收发存明细表界面 
	public String  toInOutList(){
		stockMgr.findAllInOutHistory();
		return "toInOutList";
	}
//	库存 库存  收发存汇总表界面 
	public String toInOutCount(){
		return "toInOutCount";
	}
}