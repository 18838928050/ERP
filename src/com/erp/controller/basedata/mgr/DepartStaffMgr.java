package com.erp.controller.basedata.mgr;

import java.util.List;
import com.erp.model.dao.StafferDAO;
import com.erp.model.vo.StafferVO;
import com.erp.model.vo.UserVO;

/**
 * 部门与员工 逻辑处理
 * @author WE
 *
 */
public class DepartStaffMgr {
	//创建dao层对象
	private StafferDAO stafferDao = new StafferDAO();
	
	/**
	 * 通过id 停用员工
	 * @param id
	 */
	public void setAbled(long id,String abled) {
		try{
			StafferVO stafferVo = new StafferVO();
			stafferVo = stafferDao.getById(id);
			stafferVo.setEnabled(abled);
			stafferDao.update(stafferVo);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("设置员工状态失败！");
		}
	}
	
	
	/**
	 * 更新员工信息
	 */
	public void save(StafferVO stafferVo){
		try {
			stafferDao.save(stafferVo);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("保存失败！");
		}
	}
	
	/**
	 * 通过 员工姓名查找员工
	 */
//	public StafferVO findByUserNameToVO1(String userName){
//		return stafferDao.findByUserName(userName);
//	}
	
	/**
	 * 通过id删除员工
	 */
	public void delById(Long id){
		try {
			stafferDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("用户删除错误！"+id);
		}
	}

	/**
	 * 获取员工列表
	 */
	public List<StafferVO> findAll(){
		try{
			return stafferDao.findAll();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("获取员工列表错误！");
			return null;
		}
	}

}
