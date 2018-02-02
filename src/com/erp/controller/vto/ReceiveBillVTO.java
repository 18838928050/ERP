package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.ReceiveBill;
import com.erp.model.vo.ReceiveBillItem;

/**
 * 入账单 VTO
 * @author JiaQi
 *
 */


public class ReceiveBillVTO {
	private ReceiveBill receiveBill;
	private List<ReceiveBillItem> receiveBillItems;
	
	public ReceiveBill getReceiveBill() {
		return receiveBill;
	}
	public void setReceiveBill(ReceiveBill receiveBill) {
		this.receiveBill = receiveBill;
	}
	public List<ReceiveBillItem> getReceiveBillItems() {
		return receiveBillItems;
	}
	public void setReceiveBillItems(List<ReceiveBillItem> receiveBillItems) {
		this.receiveBillItems = receiveBillItems;
	}
}
