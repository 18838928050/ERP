package com.erp.controller.storehouse.mgr;

import java.util.List;
import com.erp.model.dao.InBillDAO;
import com.erp.model.dao.StorehouseDAO;
import com.erp.model.vo.InBill;
import com.erp.model.vo.Storehouse;

/**
 * 逻辑处理  仓库
 * @author WangEn
 *
 */
public class StorehouseMgr {
	//创建数据库查询对象
	private StorehouseDAO storehouseDao = new StorehouseDAO();
	/**
	 * 查询storehouse表
	 * @return
	 */
	public List<Storehouse> findAll() {
		//创建查询结果对象
		List<Storehouse> storehouses=null;
		try {
			storehouses = storehouseDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storehouses;
	}

}
