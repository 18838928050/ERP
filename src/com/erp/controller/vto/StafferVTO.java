package com.erp.controller.vto;
/**
 * 部门与员工中间层
 * @WangEn
 */

import com.erp.model.vo.Department;
import com.erp.model.vo.StafferVO;

public class StafferVTO {
	private Department department;
	private StafferVO stafferVo;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public StafferVO getStafferVo() {
		return stafferVo;
	}
	public void setStafferVo(StafferVO stafferVo) {
		this.stafferVo = stafferVo;
	}
		
	

}
