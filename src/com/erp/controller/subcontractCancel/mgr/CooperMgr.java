package com.erp.controller.subcontractCancel.mgr;


import java.util.List;

import com.erp.controller.subcontractCancel.dao.CooperBillDAO;
import com.erp.controller.subcontractCancel.dao.GatherBillDAO;
import com.erp.controller.subcontractCancel.vto.CooperVTO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.GatherBillVO;
import com.opensymphony.xwork2.ActionContext;


/**
 * 外协 逻辑处理
 * @author guo
 *
 */
public class CooperMgr {
	//	外协单dao
	CooperBillDAO coopperBillDAO = new CooperBillDAO();
	GatherBillDAO gatherBillDAO = new GatherBillDAO();

	//	查询外协单
	public void selectCooperBill(CooperVTO cooperVTO) {
		List<CooperBillVO> cooperBills = coopperBillDAO.findByWhere(cooperVTO.getSelect());
//		将发现符合条件的客户发送到前台
		ActionContext.getContext().getValueStack().set("cooperBills", cooperBills);
	}
//根据id删除外协单
	public void delectCooperBill(CooperVTO cooperVTO) {
		try {
			coopperBillDAO.delete(cooperVTO.getCooperBill().getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//	查询收货单
	public void selectGatherBill(CooperVTO cooperVTO) {
//		根据收货单号查询数据
		List<GatherBillVO> gatherBills = gatherBillDAO.findByBillCode("G(1)2016120001");
//		将发现符合条件的客户发送到前台
		ActionContext.getContext().getValueStack().set("gatherBills", gatherBills);
	}
	//	查询外协单
	public void getCooperBill() {
//		根据收货单号查询数据
		List<CooperBillVO> cooperBills = null;
		try {
			cooperBills = coopperBillDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ActionContext.getContext().getValueStack().set("cooperBills", cooperBills);
	}
	
}