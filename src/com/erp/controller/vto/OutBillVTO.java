package com.erp.controller.vto;
/**
 * 出库单
 * @author JiaQi
 *
 */

import java.util.List;

import com.erp.model.vo.OutBill;
import com.erp.model.vo.OutBillItem;

public class OutBillVTO {
	private OutBill outBill;
	private List<OutBillItem> outBillItems;
	public OutBill getOutBill() {
		return outBill;
	}
	public void setOutBill(OutBill outBill) {
		this.outBill = outBill;
	}
	public List<OutBillItem> getOutBillItems() {
		return outBillItems;
	}
	public void setOutBillItems(List<OutBillItem> outBillItems) {
		this.outBillItems = outBillItems;
	}
	
	
}
