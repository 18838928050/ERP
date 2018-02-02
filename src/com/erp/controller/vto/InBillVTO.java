package com.erp.controller.vto;
/**
 * 入库单
 * @author JiaQi
 *
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.erp.model.vo.InBill;
import com.erp.model.vo.InBillItem;

public class InBillVTO {
    private long productIdType;
	 
	public long getProductIdType() {
		return productIdType;
	}
	public void setProductIdType(long productIdType) {
		this.productIdType = productIdType;
	}
	private InBill inBill;
	private List<InBillItem> inBillItems;
	
	public List<InBillItem> getInBillItems() {
		return inBillItems;
	}
	public void setInBillItems(List<InBillItem> inBillItems) {
		this.inBillItems = inBillItems;
	}
	public InBill getInBill() {
		return inBill;
	}
	public void setInBill(InBill inBill) {
		this.inBill = inBill;
	}
}
