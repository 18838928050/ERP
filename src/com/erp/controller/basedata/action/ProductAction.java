package com.erp.controller.basedata.action;

import java.util.HashMap;
import java.util.List;
import com.erp.controller.action.BaseAction;
import com.erp.controller.basedata.mgr.DepartListMgr;
import com.erp.controller.basedata.mgr.ProductMgr;
import com.erp.controller.basedata.mgr.ProductTypeMgr;
import com.erp.controller.intercepters.utils.Permission;
import com.erp.controller.vto.ProductVTO;
import com.erp.model.dao.ProductDAO;
import com.erp.model.vo.Product;
import com.erp.model.vo.ProductType;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.StafferVO;
import com.opensymphony.xwork2.ActionContext;


/**
 * 材料
 * @author WE
 *
 */

public class ProductAction extends BaseAction<ProductVTO>{
	
	private ProductMgr productListMgr = new ProductMgr();
	
	private ProductTypeMgr productTypeMgr = new ProductTypeMgr();
	

	/**
	 * 跳转材料主页面
	 */
	public String toProductMain(){
		return "toProductMain";
	}
	
	/**
	 * 跳转材料类型页面
	 */
	public String toProductTypeList(){
		ActionContext.getContext().getValueStack().set("productTypes",productTypeMgr.findAll());
//		System.out.println(productTypeMgr.findAll());
		return "toProductTypeList";
	}
	
	/**
	 * 跳转材料类型新增页面
	 */
	public String toProductTypeNew(){
		return "toProductTypeNew";
	}
	
	/**
	 * 将新增的材料类型保存到数据库中
	 * @return
	 */
	public String ProductTypeNew(){
		productTypeMgr.saveProductType(getModel().getProductType());
		return toProductTypeList();
	}
	
	
	/**
	 * 跳转材料类型编辑页面
	 */
	public String toProductTypeEdit(){
		ActionContext.getContext().getValueStack().set("productTypes", productTypeMgr.getById(getModel().getProductType().getId()));
		return "toProductEdit";
	}
	/**
	 * 编辑材料类型后，在数据库中进行更新
	 */
	public String updateProductTypeEdit(){
		productTypeMgr.updateProductType(getModel().getProductType());
		return toProductTypeList();
	}
	/**
	 * 删除product_type中的某条记录 
	 */
	public String delProductType(){
		productTypeMgr.deleteProductType(getModel().getProductType().getId());
		return toProductTypeList();
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 跳转材料页面 
	 */
	public String toProductList(){
		List<ProductVO> products = productListMgr.findByProductTypeId(getModel().getProductType().getId());
		
		
		//List<StafferVO> staffers1 = stafferListMgr.findAll();
		//System.out.println(staffers1);
//		HashMap<Long, String> productsSon = new HashMap<>();
//		for (ProductVO productVO:products) {
//		//System.out.println(stafferVO.toString());
//			productsSon.put(productVO.getId(), productVO.getProductName());
//		}
//		//productsSon.put((long)0, "");
//		for (ProductVO productVO2:products) {
//		long id = productVO2.getSuperiorId();
//		String name= staffersSon.get(id);
//		stafferVO2.setMark(name);
//		}
				
				
				
				
		 		
				ActionContext.getContext().getValueStack().set("products",products);
				//System.out.println(stafferListMgr.findByEnabled("Y").size());
//				ActionContext.getContext().getValueStack().set("stafferEnable",stafferListMgr.findByEnabled("Y",getModel().getDepartment().getId()).size());
//				ActionContext.getContext().getValueStack().set("stafferEnableN",stafferListMgr.findByEnabledN("N",getModel().getDepartment().getId()).size());
//				ActionContext.getContext().getValueStack().set("staffers",staffers1);
				ActionContext.getContext().getValueStack().set("productTypes", productTypeMgr.findAll());
				//System.out.println(staffers);		
		
//		ActionContext.getContext().getValueStack().set("products",productListMgr.findByProductTypeId(getModel().getProductTypeId()));
		return "toProductList";
	}
	
   /**
	 * 跳转材料List新增页面
	 */
	public String toProductNew(){
		return "toProductNew";
	}
  /**
    * 将新增的材料保存到数据库中
    * @return
    */
//	public String ProductNew(){
//		productListMgr.saveProduct(getModel());
//		return toProductTypeList();
//	}
	
  /**
    * 跳转材料编辑页面
	*/
//	public String toProductEdit(){
//		ActionContext.getContext().getValueStack().set("product", productListMgr.getById(getModel().getId()));
//		return "toProductEdit";
//	}
  /**
	* 编辑材料后，在数据库中进行更新
	*/
//	public String updateProductEdit(){
//		productListMgr.updateProduct(getModel());
//		return toProductNew();
//	}
	/**
	 * 删除product中的某条记录 
	 */
//	public String delProduct(){
//		productListMgr.deleteProduct(getModel().getId());
//		return toProductList();
//	}
	
	
	
	
	

}
