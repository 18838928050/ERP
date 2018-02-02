package com.erp.controller.basedata.mgr;

import java.util.List;

import com.erp.model.dao.MakeTypeDAO;
import com.erp.model.dao.WorkCenterDAO;
import com.erp.model.vo.MakeType;
import com.erp.model.vo.WorkCenter;

/**
 * 项目类型 逻辑控制
 * @author JiaQi
 *
 */
public class MakeTypeMgr{
	private MakeTypeDAO makeTypeDAO = new MakeTypeDAO();
	/**
	 * 获取全部 项目
	 */
	public List<MakeType> findAll(){
		List<MakeType> makeTypes = null;
		try {
			makeTypes =  makeTypeDAO.findAll();
		} catch (Exception e) {
			System.out.println("获取项目类型信息失败！");
			e.printStackTrace();
		}
		return makeTypes;
	}
	/**
	 * 通过上级ID获取全部 项目类型
	 */
	public List<MakeType> findByParentId(long Id) {
		return makeTypeDAO.findfindByParentId(Id);
	}
	
	/**
	 * 获取全部工作中心
	 * @return
	 */
	public List<WorkCenter> getAllWorkCenter() {
		List<WorkCenter> workCenters = null;
		try {
			workCenters = new WorkCenterDAO().findAll();
		} catch (Exception e) {
			System.out.println("获取全部工作中心错误！");
			e.printStackTrace();
		}
		return workCenters;
	}
	
	/**
	 * 获取全部可用工作中心
	 * @return
	 */
	public List<WorkCenter> getAllUseWorkCenter() {
		List<WorkCenter> workCenters = null;
		try {
			workCenters = new WorkCenterDAO().findAllUseWorkCenter();
		} catch (Exception e) {
			System.out.println("获取工作中心错误！");
			e.printStackTrace();
		}
		return workCenters;
	}
	
	/**
	 * 通过id删除项目类型
	 */
	public void delMakeType(Long id){
		try {
			makeTypeDAO.delete(id);
		} catch (Exception e) {
			System.out.println("删除项目类型错误！");
			e.printStackTrace();
		}
	}
	/**
	 * 通过id查询项目类型
	 */
	public MakeType findById(long id) {
		MakeType makeType = null;
		try {
			makeType = makeTypeDAO.getById(id);
		} catch (Exception e) {
			System.out.println("获取项目类型失败！");
			e.printStackTrace();
		}
		return makeType;
	}
	
	/**
	 * 更新 项目类型
	 */
	public void update(MakeType makeType){
		try {
			makeTypeDAO.update(makeType);
		} catch (Exception e) {
			System.out.println("更新项目类型失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存项目
	 * @param makeType
	 */
	public void save(MakeType makeType) {
		try {
			makeTypeDAO.save(makeType);
		} catch (Exception e) {
			System.out.println("保存项目类型失败！");
			e.printStackTrace();
		}
	}
}
