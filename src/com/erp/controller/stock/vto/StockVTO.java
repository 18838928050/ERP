package com.erp.controller.stock.vto;

import java.util.List;

import com.erp.controller.customerBusiness.dao.EstablishmentDAO;
import com.erp.controller.customerBusiness.mgr.CustomerMgr;
import com.erp.controller.customerBusiness.vo.EstablishmentContactVO;
import com.erp.controller.customerBusiness.vo.EstablishmentVO;
import com.erp.controller.customerBusiness.vo.StafferVO;
import com.erp.controller.stock.vo.AlloBillVO;
import com.erp.controller.stock.vo.InBillVO;
import com.erp.controller.stock.vo.OutBillVO;

/**
 * 客户业务 逻辑处理
 * @author guo
 *
 */
public class StockVTO {
	
	private AlloBillVO alloBill;
	private InBillVO inBill;
	private OutBillVO outBill;
	public AlloBillVO getAlloBill() {
		return alloBill;
	}
	public void setAlloBill(AlloBillVO alloBill) {
		this.alloBill = alloBill;
	}
	public InBillVO getInBill() {
		return inBill;
	}
	public void setInBill(InBillVO inBill) {
		this.inBill = inBill;
	}
	public OutBillVO getOutBill() {
		return outBill;
	}
	public void setOutBill(OutBillVO outBill) {
		this.outBill = outBill;
	}

}