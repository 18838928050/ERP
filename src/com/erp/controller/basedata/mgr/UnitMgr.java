package com.erp.controller.basedata.mgr;

import java.util.List;
import com.erp.model.dao.UnitDAO;
import com.erp.model.vo.Unit;
/**
 * 计量单位  逻辑处理
 * @author WE
 *
 */
public class UnitMgr {
	private UnitDAO unitDAO = new UnitDAO();
	
	/**
	 * 查询unit表
	 */
	public List<Unit> findAll(){
		List<Unit> units = null;
		try {
			units = unitDAO.findAll();
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		}
		return units;
	}

	/**
	 * 根据id删除unit表中的某条记录
	 * @param id
	 */
	public void deleteUnit(long id) {
		try {
			unitDAO.delete(id);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 增加 unit表中的记录，保存到数据库中
	 * @param unit
	 */
	public void saveUnit(Unit unit) {
		try {
			unitDAO.save(unit);
		} catch (Exception e) {
			System.out.println("保存失败！");
			e.printStackTrace();
		}
	}


	/**
	 * 通过id查询获得unit表某个记录
	 * @param id
	 * @return
	 */
	public Unit getById(long id) {
		Unit unit = null;
		try {
			unit = unitDAO.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unit;
	}

	/**
	 * 更新unit表
	 * @param unit
	 */
	public void updateUnit(Unit unit) {
		try {
			unitDAO.update(unit);
		} catch (Exception e) {
			System.out.println("更新失败！");
			e.printStackTrace();
		}
		
	}
}
