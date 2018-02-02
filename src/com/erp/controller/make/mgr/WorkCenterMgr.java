package com.erp.controller.make.mgr;

import java.util.List;

import com.erp.controller.make.dao.WorkCenterDao;
import com.erp.model.vo.WorkCenter;
/**
 * 
 * @author WE
 *
 */
public class WorkCenterMgr {
	private WorkCenterDao workCenterDao = new WorkCenterDao();
	/**
	 * 查询work_center表
	 * @return
	 */
	public List<WorkCenter> findAll(){
		List<WorkCenter> workCenters = null;
		try {
			workCenters = workCenterDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return workCenters;
		
	}
	

}
