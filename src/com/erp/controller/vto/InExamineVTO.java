package com.erp.controller.vto;

import com.erp.model.vo.InBill;
import com.erp.model.vo.InType;
import com.erp.model.vo.Storehouse;

/**
 * 入库审核中间层
 * @author WangEn
 *
 */
public class InExamineVTO {
	private InType inTypes;//入库类型
	private Storehouse storehouses;//仓库
	private InBill inBills;//入库单
	
	public InType getInTypes() {
		return inTypes;
	}
	public void setInTypes(InType inTypes) {
		this.inTypes = inTypes;
	}
	public Storehouse getStorehouses() {
		return storehouses;
	}
	public void setStorehouses(Storehouse storehouses) {
		this.storehouses = storehouses;
	}
	public InBill getInBills() {
		return inBills;
	}
	public void setInBills(InBill inBills) {
		this.inBills = inBills;
	}
	
	
	

}
