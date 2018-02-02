package com.erp.controller.phone.mrg;

import java.util.List;

import com.erp.controller.customerBusiness.dao.StafferDAO;
import com.erp.controller.customerBusiness.vo.StafferVO;
import com.erp.controller.phone.dao.DepartmentDAO;
import com.erp.controller.phone.dao.PhoneBookDAO;
import com.erp.controller.phone.vo.PhoneBookVO;
import com.erp.controller.phone.vto.PhoneVTO;
import com.erp.controller.vto.LoginVTOw;
import com.erp.model.vo.DepartmentVO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 客户业务 逻辑处理
 * @author guo
 *
 */
public class PhoneMgr {
	
	private PhoneBookDAO phoneBookDAO = new PhoneBookDAO();
	private DepartmentDAO departmentDAO = new DepartmentDAO();
	private StafferDAO stafferDAO = new StafferDAO();

//	查询登录用户下的所有的联系人
	public void findAllPhoneBook() {
		//获得用户
		LoginVTOw loginVTO=(LoginVTOw)ActionContext.getContext().getSession().get("loginVTO");
		//			打印客户
//		将所有的联系人都遍历出来
		List<PhoneBookVO> phoneBooks;
		System.out.println(loginVTO.getStafferID()+"----------------------");
		try {
			phoneBooks = phoneBookDAO.findByStafferId(loginVTO.getStafferID());
//		将发现的联系人发送到前台
			ActionContext.getContext().getValueStack().set("phoneBooks", phoneBooks);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//添加联系人
	public void addPhoneBook(PhoneVTO phoneVTO){
		try {
			PhoneBookVO phoneBook = phoneVTO.getPhoneBook();
			LoginVTOw loginVTO=(LoginVTOw)ActionContext.getContext().getSession().get("loginVTO");
			phoneBook.setStafferId(loginVTO.getStafferID());
//				保存客户下的联系人信息
			phoneBookDAO.save(phoneBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//删除联系人
	public void delectPhoneBook(PhoneVTO phoneVTO){
		try {
			PhoneBookVO phoneBook = phoneVTO.getPhoneBook();
//				保存客户下的联系人信息
			phoneBookDAO.delete(phoneBook.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//更新联系人
	public void updeatPhoneBook(PhoneVTO phoneVTO){
		try {
			PhoneBookVO phoneBook = phoneVTO.getPhoneBook();
			LoginVTOw loginVTO=(LoginVTOw)ActionContext.getContext().getSession().get("loginVTO");
			phoneBook.setStafferId(loginVTO.getStafferID());
//				保存客户下的联系人信息
			phoneBookDAO.update(phoneBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//根据id查找联系人
	public void findByIdPhoneBook(PhoneVTO phoneVTO){
		try {
//				保存客户下的联系人信息
			PhoneBookVO phoneBook = phoneBookDAO.getById(phoneVTO.getId());
			ActionContext.getContext().getValueStack().set("phoneBook", phoneBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询部门列表
	public void rootDepartment(){
		try {
			List<DepartmentVO> departments = departmentDAO.findDepartment();
			for(int i = 0; i < departments.size();i++){
				System.out.println(departments.get(i).getDepartmentName());
			}
			ActionContext.getContext().getValueStack().set("departments", departments);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询部门列表下的联系人
	public void departmentStaffer(PhoneVTO phoneVTO){
		try {
//			List<StafferVO> staffers = stafferDAO.findByDepartId(phoneVTO.getPhoneBook().getId());
			long i=1;
			List<StafferVO> staffers = stafferDAO.findByDepartId(i);
			ActionContext.getContext().getValueStack().set("staffers", staffers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}