package com.erp.controller.finance.mgr;

import java.util.List;


import com.erp.model.dao.DepartmentDAO;
import com.erp.model.vo.Department;


/**
 * 
 * @author WangEn
 *
 */
public class DepartmentMgr {
	DepartmentDAO departmentDao = new DepartmentDAO();
	/**
	 * 查询department表
	 * @return
	 */
	public List<Department> findAll() {
		//创建查询结果对象
		List<Department> departs=null;
		try {
			departs = departmentDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departs;
	}

}
