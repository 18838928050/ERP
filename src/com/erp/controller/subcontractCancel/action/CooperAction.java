package com.erp.controller.subcontractCancel.action;



import java.util.List;


import com.erp.controller.action.BaseAction;
import com.erp.controller.subcontractCancel.dao.CooperBillDAO;
import com.erp.controller.subcontractCancel.dao.CooperBillItemDAO;
import com.erp.controller.subcontractCancel.mgr.CooperMgr;
import com.erp.controller.subcontractCancel.vto.CooperVTO;
import com.erp.model.vo.CooperBillVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 外协 作废 模块
 * @author guo
 *
 */

public class CooperAction extends BaseAction<CooperVTO>{

	private static final long serialVersionUID = 1L;
	
	private CooperMgr cooperMgr = new CooperMgr();
	
	
	/**
	 * JiaQi  跳转到 要外协的业务单
	 * @return
	 */
	public String toBusinessBillListForCooper(){
		CooperBillDAO coopperBillDAO = new CooperBillDAO();
		List<CooperBillVO> coopers = null;
		try {
			coopers = coopperBillDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ActionContext.getContext().getValueStack().set("coopers", coopers);
		
		return "toBusinessBillListForCooper";
	}
	
	/**
	 * JiaQi
	 * 跳转到明细
	 */
	public String toCooperBillItem(){
		CooperBillItemDAO cooperBillItemDAO = new CooperBillItemDAO();
		
		ActionContext.getContext().getValueStack().set("cooperBillItems", cooperBillItemDAO.findByCopperBillId(getModel().getId()));
		
		return "toCooperBillItem";
	}
	
	/**
	 * JiaQi
	 * @return
	 */
	

//	进入外协单作废页面
	public String toCooperBillListForCancel(){
		return "toCooperBillListForCancel";
	}
//	外协单作废页面查询
	public String cooperBillListForCancel(){
		System.out.println(getModel().getSelect().toString());
		cooperMgr.selectCooperBill(getModel());
		return "cooperBillListForCancel";
	}
//	外协单单个作废
	public String cooperBillCancel(){
		
		return "cooperBillCancel";
	}
	
//	进入收货单作废页面
	public String toGatherBillListForCancel(){
		return "toGatherBillListForCancel";
	}
//	收货单作废页面查询
	public String gatherBillListForCancel(){
		System.out.println(getModel().getSelect().toString());
		cooperMgr.selectGatherBill(getModel());
		return "gatherBillListForCancel";
	}
//	收货单作废
	public String gatherBillCancel(){
		
		return "gatherBillCancel";
	}
//	外协单改价格页面
	public String cooperBillListForEditPrice(){
		cooperMgr.getCooperBill();
		return "cooperBillListForEditPrice";
	}
//	外协价格页面
	public String estPriceList(){
		return "estPriceList";
	}
}