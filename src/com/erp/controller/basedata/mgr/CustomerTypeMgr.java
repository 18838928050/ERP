package com.erp.controller.basedata.mgr;

import java.util.List;

import com.erp.model.dao.CustomerTypeDAO;
import com.erp.model.vo.EstablishmentLevel;
import com.erp.model.vo.EstablishmentType;

/**
 * 单位类别  逻辑处理
 * @author WE
 *
 */
public class CustomerTypeMgr {
	//创建逻辑处理对象
	private CustomerTypeDAO customerTypeDao = new CustomerTypeDAO();
	
	/**
	 * 查询establishment_type表
	 * @return
	 */
	public List<EstablishmentType> findAll() {
		//创建查询结果对象
		List<EstablishmentType> customTypes = null;
		
		try {
			customTypes = customerTypeDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("查询失败！");
			e.printStackTrace();
		}
		return customTypes;
	}

	/**
	 * 根据id删除establishment_type表中的某条记录
	 * @param id
	 */
	public void deleteType(long id) {
		try {
			customerTypeDao.delete(id);
		} catch (Exception e) {
			System.out.println("删除失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 增加 establishment_type表中的记录，保存到数据库中
	 * @param establishmentType
	 */
	public void saveCustomerType(EstablishmentType establishmentType) {
		try {
			customerTypeDao.save(establishmentType);
		} catch (Exception e) {
			System.out.println("保存失败！");
			e.printStackTrace();
		}
	}

	/**
	 * 通过id查询获得establishment_type表某个记录
	 * @param id
	 * @return
	 */
	public EstablishmentType getById(long id) {
		EstablishmentType establishmentType = null;
		try {
			establishmentType = customerTypeDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return establishmentType;
	}

	/**
	 * 更新establishment_level表
	 * @param unit
	 */
	public void updateCustomerType(EstablishmentType establishmentType) {
		try {
			customerTypeDao.update(establishmentType);
		} catch (Exception e) {
			System.out.println("更新失败！");
			e.printStackTrace();
		}
		
	}

}
