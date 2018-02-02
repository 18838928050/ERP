package com.erp.controller.storehouse.mgr;

import java.util.List;

import com.erp.model.dao.EstablishmentDAO;
import com.erp.model.vo.Establishment;
import com.erp.model.vo.InBill;

/**
 * 客户信息   查询
 * @author WE
 *
 */
public class EstablishmentMgr {
	private EstablishmentDAO establishmentDao = new EstablishmentDAO();
	
	//查询供方 单位
	public List<Establishment> findAll() {
		//创建查询结果对象
		List<Establishment> establishments=null;
		try {
			establishments = establishmentDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return establishments;
	}
	

}
