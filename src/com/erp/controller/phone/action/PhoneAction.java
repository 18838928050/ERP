package com.erp.controller.phone.action;


import com.erp.controller.action.BaseAction;
import com.erp.controller.phone.mrg.PhoneMgr;
import com.erp.controller.phone.vto.PhoneVTO;


/**
 * 沟通	通讯录	我的通讯录 公司内部通讯录
 * @author guo
 *
 */

public class PhoneAction extends BaseAction<PhoneVTO>{

	private static final long serialVersionUID = 1L;
	private PhoneMgr phoneMgr = new PhoneMgr();
	
	//	进入沟通 通讯录	我的通讯录页面
	public String toPhoneBookList(){
		phoneMgr.findAllPhoneBook();
		return "toPhoneBookList";
	}
	
	//	进入沟通 通讯录	我的通讯录新增页面
	public String toPhoneBookNew(){
		return "toPhoneBookNew";
	}
	//	进入沟通 通讯录	我的通讯录编辑页面
	public String toPhoneBookEdit(){
		System.out.println(getModel().getId());
		phoneMgr.findByIdPhoneBook(getModel());
		return "toPhoneBookEdit";
	}
	
	//	进入沟通 通讯录	公司内部通讯录
	public String toInnerPbMain(){
		return "toInnerPbMain";
	}
	//	进入沟通 通讯录	公司内部通讯录框架左边部分
	public String toDepartmentListForInnerPb(){
//		将部门的root显示出来
		phoneMgr.rootDepartment();
		return "toDepartmentListForInnerPb";
	}
	//	进入沟通 通讯录	公司内部通讯录框架右边部分
	public String toInnerPbList(){
//		利用PhoneBook的id进行赋值传送	需要修改前台action 和删除本行代码
//		getModel().getPhoneBook().setId(1);
		phoneMgr.departmentStaffer(getModel());
		return "toInnerPbList";
	}
	
	//	保存新建的联系人
	public String savePhoneBook(){
		phoneMgr.addPhoneBook(getModel());
		return "savePhoneBook";
	}
	
	//	保存修改的联系人
	public String updatePhoneBook(){
		System.out.println(getModel().getPhoneBook().toString());
		phoneMgr.updeatPhoneBook(getModel());
		return "updatePhoneBook";
	}
	
}