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
import com.erp.controller.storehouse.mgr.OutBillNewMgr;
import com.erp.controller.vto.OutBillVTO;
import com.erp.model.vo.OutBillItem;
import com.erp.model.vo.Product;
import com.erp.util.IDTools;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;

/**
 * 出库单
 * @author JiaQi
 *
 */
public class OutBillNewAction extends BaseAction<OutBillVTO> implements ServletRequestAware{
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
	
	
	
	private OutBillNewMgr outBillNewMgr = new OutBillNewMgr();
	private List<OutBillItem> outBillItems = new ArrayList<>();
	public List<OutBillItem> getOutBillItems() {
		return outBillItems;
	}

	public void setOutBillItems(List<OutBillItem> outBillItems) {
		this.outBillItems = outBillItems;
	}

	/**
	 * 跳转出库单界面
	 */
	public String toOutBillNew(){
		BusinessMgr businessMgr = new BusinessMgr();
		ActionContext.getContext().getValueStack().set("products", outBillNewMgr.fingAllCanUseProduct());
		ActionContext.getContext().getValueStack().set("staffers",businessMgr.findAllStafferCanUse());
		ActionContext.getContext().getValueStack().set("storehouses",outBillNewMgr.findAllStorehouse());
		return "toOutBillNew";
	}
	
	/**
	 * 保存出库单
	 */
	public String saveOutBill(){
		getModel().getOutBill().setId(IDTools.GetUUID());
		getModel().getOutBill().setManagerName("测试");//测试代码  待删除
		outBillNewMgr.saveOutBillVTO(getModel());
		for (int i = 0; i < outBillItems.size(); i++) {
			outBillItems.get(i).setBillId(getModel().getOutBill().getId());
		}
		outBillNewMgr.saveOutBillItems(outBillItems);
		return toOutBillNew();
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
}
