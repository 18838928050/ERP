package com.erp.controller.basedata.mgr;

import java.util.List;

import com.erp.controller.vto.StafferVTO;
import com.erp.model.dao.DepartmentDAO;

import com.erp.model.vo.Department;



/**
 * 部门类型  逻辑处理
 * @author WE
 *
 */
public class DepartListMgr {
	//创建dao层对象
	private DepartmentDAO departDao = new DepartmentDAO();

	/**
	 * 查询department表
	 */
	public List<Department> findAll() {
		List<Department> departList = null;
		try {
			departList = departDao.findAll();
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		}	
		return departList;
	}

   /**
	 * 增加department表中的记录，保存到数据库中
	 * @param department
	 */
	public void saveDepartment(Department department) {
		try {
			departDao.save(department);
		} catch (Exception e) {
			System.out.println("保存失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过id查询获得department表某个记录
	 * @param id
	 * @return
	 */
	public Department getById(long id) {
		Department department = null;
		try {
			department = departDao.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}
	
	
	/**
	 * 更新department表
	 * @param department
	 */
	public void updateDepartment(Department department) {
		try {
			departDao.update(department);
		} catch (Exception e) {
			System.out.println("更新失败！");
			e.printStackTrace();
		}
		
	}

	/**
	 * 根据id删除department表中的某条记录
	 * @param id
	 */
	public void deleteDepartment(long id) {
		try {
			departDao.delete(id);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}

}
