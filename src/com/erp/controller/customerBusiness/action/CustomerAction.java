package com.erp.controller.customerBusiness.action;

import java.io.UnsupportedEncodingException;

import com.erp.controller.action.BaseAction;
import com.erp.controller.customerBusiness.mgr.CustomerMgr;
import com.erp.controller.customerBusiness.vto.CustomerVTO;


/**
 * 客户业务 客户 模块
 * @author guo
 *
 */

public class CustomerAction extends BaseAction<CustomerVTO>{

	private static final long serialVersionUID = 1L;
	private CustomerMgr customerMgr = new CustomerMgr();

	//	进入客户业务 客户 新客户登记 界面
	public String toAddCustomer(){
		return "toAddCustomer";
	}

	//	客户业务 客户 新客户登记 界面 提交
	public String addCustomer(){
		//		添加客户
		customerMgr.addEstablishment(getModel());
		return "addCustomer";
	}
	//	客户业务 客户 新客户登记 界面 检查客户是否存在
	public String establishmentCheck(){
		String bname = getModel().getEstablishment().getEstName(); 
		
		//get发送的中文数据乱码
		try {
			bname = new String(bname .getBytes("iso8859-1"),"utf-8");
			getModel().getEstablishment().setEstName(bname);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		customerMgr.establishmentCheck(getModel());
		return "establishmentCheck";
	}
	
	//	客户业务 客户 新客户登记 界面 选择经办人（未写，整合他人代码）
	public String stafferCheck(){
		customerMgr.findAllStaffer();
		return "srafferCheck";
	}
	
//	客户业务 客户 新客户登记 界面 选择客户类别
	public String establishmentTypeCheck(){
		customerMgr.findAllestablishmentType();
		return "establishmentTypeCheck";
	}
	
//	客户业务 客户 新客户登记 界面 选择客户等级
	public String establishmentLevelCheck(){
		customerMgr.findAllEstablishmentLevel();
		return "establishmentLevelCheck";
	}
//	客户业务 客户 新客户登记 界面 选择客户付款方式
	public String establishmentPayModeCheck(){
		customerMgr.findAllPayMode();
		return "establishmentPayModeCheck";
	}
	
//	客户业务 客户 新客户登记 界面 选择客户地区
	public String establishmentArea(){
		customerMgr.findAllArea();
		return "establishmentArea";
	}
}