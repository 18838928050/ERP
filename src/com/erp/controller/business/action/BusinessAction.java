package com.erp.controller.business.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.ProductMgr;
import com.erp.controller.business.mgr.BusinessMgr;
import com.erp.controller.phone.dao.DepartmentDAO;
import com.erp.model.dao.BankAccountDAO;
import com.erp.model.dao.EstablishmentDAO;
import com.erp.model.dao.MakeRequireDAO;
import com.erp.model.dao.MakeTypeDAO;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.dao.ProductDAO;
import com.erp.model.dao.ProductTypeDAO;
import com.erp.model.dao.StafferDAO;
import com.erp.model.dao.WorkCenterDAO;
import com.erp.model.vo.Establishment;
import com.erp.model.vo.MakeRequire;
import com.erp.model.vo.MakeType;
import com.erp.model.vo.Product;
import com.erp.model.vo.WorkCenter;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 客户 
 * @author JiaQi
 *
 */
public class BusinessAction extends BaseAction<Establishment>{
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
	
	
	private long ProductIdType;
	public long getProductIdType() {
		return ProductIdType;
	}
	public void setProductIdType(long productIdType) {
		ProductIdType = productIdType;
	}

	private BusinessMgr businessMgr = new BusinessMgr();
	/**
	 * 跳转业务接单
	 * @return
	 */
	public String toBusinessBillSearchResult(){
		ActionContext.getContext().getValueStack().set("businesses",businessMgr.findAllCanUse());
		return "toBusinessList";
	}
	/**
	 * 选择客户 进入开单
	 */
	public String toBusinessBegian(){
		EstablishmentDAO establishmentDAO = new EstablishmentDAO();
		try {
			ActionContext.getContext().getValueStack().set("establishment",establishmentDAO.getById(getModel().getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		
		ActionContext.getContext().getValueStack().set("bankAccounts", bankAccountDAO.findAllBankAccount());
		ActionContext.getContext().getValueStack().set("makeTypes", businessMgr.findAllCanUserMakeType());
		ActionContext.getContext().getValueStack().set("payModes", businessMgr.findAllCanUsePayMode());
		ActionContext.getContext().getValueStack().set("establishments", businessMgr.findAllBusiness());
		ActionContext.getContext().getValueStack().set("departments", businessMgr.findAllDepartmentCanUse());
		ActionContext.getContext().getValueStack().set("staffers", businessMgr.findAllStafferCanUse());
		ActionContext.getContext().getValueStack().set("businesses",businessMgr.findById(getModel().getId()));
		return "toBusinessBegian";
	}
	
	/**
	 * public 
	 */
	public String toAccessoryList(){
		return "toAccessoryList";
	}
	
	public String toStafferMainForSelect(){
		return "toStafferMainForSelect";
	}
	
	/**
	 * 选择员工
	 * @return
	 */
	public String findDepartment(){
		DepartmentDAO departmentDAO = new DepartmentDAO();
		ActionContext.getContext().getValueStack().set("departments",departmentDAO.findDepartment());
		return "tofindDepartment";
	}
	
	public String findStaffer(){
		StafferDAO stafferDAO = new StafferDAO();
		ActionContext.getContext().getValueStack().set("staffers", stafferDAO.findByDepartId(getModel().getId()));
		return "findStaffer";
	}
	
	/**
	 * 跳转到maketypeforselectlist。jsp
	 */
	public String toMakeTypeList(){
		WorkCenterDAO workCenterDAO = new WorkCenterDAO();
		MakeTypeDAO makeTypeDAO = new MakeTypeDAO();
		List<MakeType> makeTypes = makeTypeDAO.findCanUse();
		int i = 0;
		List<MakeTypeCenterVTO> makeTypeCenterVTOs = new ArrayList<MakeTypeCenterVTO>();
		while(i<makeTypes.size()){
			MakeTypeCenterVTO makeTypeCenterVTO = new MakeTypeCenterVTO();
			makeTypeCenterVTO.setId(makeTypes.get(i).getId());
			makeTypeCenterVTO.setPareId(makeTypes.get(i).getParentId());
			makeTypeCenterVTO.setType(makeTypes.get(i).getType());
			makeTypeCenterVTO.setTypeName(makeTypes.get(i).getTypeName());
			makeTypeCenterVTO.setUnit(makeTypes.get(i).getUnit());
			makeTypeCenterVTO.setWcId(makeTypes.get(i).getWorkCenterId());
			try {
				if(makeTypes.get(i).getWorkCenterId() != 0){
					makeTypeCenterVTO.setWcName(workCenterDAO.getById(makeTypes.get(i).getWorkCenterId()).getWcName());
				}else{
					makeTypeCenterVTO.setWcName("");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			makeTypeCenterVTOs.add(makeTypeCenterVTO);
			i++;
		}
		
		 JSONArray jsonArray = JSONArray.fromObject(makeTypeCenterVTOs);
		 System.out.println(jsonArray.toString());
		 ActionContext.getContext().getValueStack().set("info", jsonArray.toString());
		return "toMakeTypeList";
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
		ActionContext.getContext().getValueStack().set("products",productDAO.findByProductType(ProductIdType));
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
	 * ajax 异步请求材料
	 */
	public String BusinessPriceAjax(){
		ProductMgr productMgr = new ProductMgr();
		long proId = Long.valueOf(request.getParameter("proId"));
		Product p = productMgr.findById(proId);
		if(p == null){
			result = null;
		}else{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("pric", p.getInpric());
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
		}
		System.out.println(result);
		return "success";
	}
	
	/**
	 * 跳转选择制作要求
	 */
	public String toMakeRequireListForSelect(){
		MakeRequireDAO makeRequireDAO = new MakeRequireDAO();
		try {
			ActionContext.getContext().getValueStack().set("makeRequires",makeRequireDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "toMakeRequireListForSelect";
	}
	
	/**
	 * 跳转到 选择工作中心
	 */
	public String toWorkCenterListForSelect(){
		WorkCenterDAO workCenterDAO = new WorkCenterDAO();
		ActionContext.getContext().getValueStack().set("workCenters",workCenterDAO.findAllUseWorkCenter());
		return "toWorkCenterListForSelect";
	}
}
