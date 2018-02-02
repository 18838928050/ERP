package com.erp.controller.subcontractCancel.vto;


import com.erp.controller.subcontractCancel.vo.CooperBillVO;
import com.erp.controller.subcontractCancel.vo.GatherBillVO;
import com.erp.controller.subcontractCancel.vo.SelectVO;

/**
 * 外协	作废  	逻辑处理
 * @author guo
 *
 */
public class CooperVTO {
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	//	外协单
	private CooperBillVO cooperBill ;
//	收货单
	private GatherBillVO gatherBill;
//	搜索条件	
	private SelectVO select;
	
	public CooperBillVO getCooperBill() {
		return cooperBill;
	}
	public void setCooperBill(CooperBillVO cooperBill) {
		this.cooperBill = cooperBill;
	}
	public GatherBillVO getGatherBill() {
		return gatherBill;
	}
	public void setGatherBill(GatherBillVO gatherBill) {
		this.gatherBill = gatherBill;
	}
	public SelectVO getSelect() {
		return select;
	}
	public void setSelect(SelectVO select) {
		this.select = select;
	}
	
}