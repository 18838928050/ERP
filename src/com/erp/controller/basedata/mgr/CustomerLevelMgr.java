package com.erp.controller.basedata.mgr;

import java.util.List;

import com.erp.model.dao.CustomerLevelDAO;
import com.erp.model.vo.EstablishmentLevel;


/**
 * 客户等级 逻辑处理
 * @author WE
 *
 */
public class CustomerLevelMgr {
	private CustomerLevelDAO customerLevelDao = new CustomerLevelDAO();
	
	/**
	 * 查询establishment_level表
	 * @return
	 */
	public List<EstablishmentLevel> findAll() {
		//创建查询结果对象
		List<EstablishmentLevel> customLevels =null;
		try {
			customLevels = customerLevelDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customLevels;
	}

	/**
	 * 根据id删除establishment_level表中的某条记录
	 * @param id
	 */
	public void deletelevel(long id) {
		try {
			customerLevelDao.delete(id);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 增加 establishment_level表中的记录，保存到数据库中
	 * @param establishmentLevel
	 */
	public void saveCustomerLevel(EstablishmentLevel establishmentLevel) {
		try {
			customerLevelDao.save(establishmentLevel);
		} catch (Exception e) {
			System.out.println("保存失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 通过id查询获得establishment_level表某个记录
	 * @param id
	 * @return
	 */
	public EstablishmentLevel getById(long id) {
		EstablishmentLevel establishmentLevel = null;
		try {
			establishmentLevel = customerLevelDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return establishmentLevel;
	}

	/**
	 * 更新establishment_level表
	 * @param unit
	 */
	public void updateCustomerLevel(EstablishmentLevel establishmentLevel) {
		try {
			customerLevelDao.update(establishmentLevel);
		} catch (Exception e) {
			System.out.println("更新失败！");
			e.printStackTrace();
		}
		
	}

}
