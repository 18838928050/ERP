package com.erp.controller.storehouse.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.ProductMgr;
import com.erp.controller.business.mgr.BusinessMgr;
import com.erp.controller.storehouse.mgr.InBillNewMgr;
import com.erp.controller.vto.InBillVTO;
import com.erp.model.dao.ProductDAO;
import com.erp.model.dao.ProductTypeDAO;
import com.erp.model.vo.InBillItem;
import com.erp.model.vo.Product;
import com.erp.util.IDTools;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;

/**
 * 入库单
 * @author JiaQi
 *
 */
public class InBillNewAction extends BaseAction<InBillVTO> implements ServletRequestAware{
		private HttpServletRequest request;
	    private String result;

	    public String getResult() {
	        return result;
	    }
	    public void setResult(String result) {
	        this.result = result;
	    }
	    
	    public void setServletRequest(HttpServletRequest arg0) {
	        this.request = arg0;
	    }
	
	
	private InBillNewMgr inBillNewMgr = new InBillNewMgr();
	public List<InBillItem> inBillItem = new ArrayList<InBillItem>();
	public List<InBillItem> getInBillItem() {
		return inBillItem;
	}
	public void setInBillItem(List<InBillItem> inBillItem) {
		this.inBillItem = inBillItem;
	}
	/**
	 * 跳转到入库单
	 */
	public String toInBillNew(){
		BusinessMgr businessMgr = new BusinessMgr();
		ActionContext.getContext().getValueStack().set("products", inBillNewMgr.fingAllCanUseProduct());
		ActionContext.getContext().getValueStack().set("staffers",businessMgr.findAllStafferCanUse());
		ActionContext.getContext().getValueStack().set("inTypes",inBillNewMgr.findAllInType());
		ActionContext.getContext().getValueStack().set("storehouses", inBillNewMgr.findAllStorehouse());
		return "toInBillNew";
	}
	
	/**
	 * ajax 异步请求材料
	 */
	public String InBillAjax(){
		ProductMgr productMgr = new ProductMgr();
		String name = request.getParameter("pro_code");
		System.out.println(name);
		Product p = productMgr.findByProductTypeId(name);
		if(p == null){
			result = null;
		}else{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("prodId", p.getId());
			map.put("prodCode", p.getProductCode());
			map.put("prodName", p.getProductName());
			map.put("unit", p.getUnit());
			map.put("inPric", p.getInpric());
			map.put("prodMark", p.getMark());
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
		}
		System.out.println(result);
		return "success";
	}
	
	/**
	 * 跳转到材料明细
	 */
	public String toProductMainForSelect(){
		return "toProductMainForSelect";
	}
	
	/**
	 * 获取右侧
	 */
	public String toProductTypeListForProductSelect(){
		ProductDAO productDAO = new ProductDAO();
		System.out.println(getModel().getProductIdType());
		ActionContext.getContext().getValueStack().set("products",productDAO.findByProductType(getModel().getProductIdType()));
		return "toProductTypeListForProductSelect";
	}
	
	/**
	 * 获取左侧
	 */
	public String toDepartmentListForStafferSelect(){
		ProductTypeDAO productTypeDAO = new ProductTypeDAO();
		ActionContext.getContext().getValueStack().set("productTypes",productTypeDAO.findAllCanUse());
		return "toDepartmentListForStafferSelect";
	}
	/**
	 * 保存
	 */
	public String saveInBills(){
		getModel().getInBill().setId(IDTools.GetUUID());
		getModel().getInBill().setManagerName("测试");//测试代码  待删除
		inBillNewMgr.saveInBillVTO(getModel());
		for (int i = 0; i < inBillItem.size(); i++) {
			inBillItem.get(i).setBillId(getModel().getInBill().getId());
		}
		inBillNewMgr.saveInBillItems(inBillItem);
		return toInBillNew();
	}
	
}
