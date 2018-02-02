package com.erp.controller.make.mgr;

import java.util.List;

import com.erp.controller.make.dao.WorkProcessDao;
import com.erp.model.vo.WorkProcessVO;

/**
 * 产量统计表    中间层
 * @author WE
 *
 */
public class WorkProcessMgr {
	private WorkProcessDao workProcessDao = new WorkProcessDao();
	
	/**
	 * 查询work_process表
	 * 
	 */
	public List<WorkProcessVO> findAll() {
		//创建查询结果对象
		List<WorkProcessVO> workProcesss=null;
		try {
			workProcesss = workProcessDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workProcesss;
	} 

}
