package com.erp.controller.vto;

import com.erp.model.vo.OutBill;
import com.erp.model.vo.OutBillItem;
import com.erp.model.vo.Storehouse;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.Unit;

/**
 * 出库单明细一览表中间层
 * @author WangEn
 *
 */
public class OutItemListVTO {
	private OutBill  outBills;//出库单
	private OutBillItem outBillItems;//出库明细单
	private ProductVO product;
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	private Storehouse storeHouses;//仓库
	public OutBill getOutBills() {
		return outBills;
	}
	public void setOutBills(OutBill outBills) {
		this.outBills = outBills;
	}
	public OutBillItem getOutBillItems() {
		return outBillItems;
	}
	public void setOutBillItems(OutBillItem outBillItems) {
		this.outBillItems = outBillItems;
	}
	public Storehouse getStoreHouses() {
		return storeHouses;
	}
	public void setStoreHouses(Storehouse storeHouses) {
		this.storeHouses = storeHouses;
	}
	
	
	
	


}
