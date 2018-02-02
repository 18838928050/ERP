package com.erp.controller.communicate.mgr;

import java.util.List;

import com.erp.model.dao.EstablishmentCommunicateDAO;
import com.erp.model.vo.Establishment;
import com.erp.model.vo.EstablishmentCommunicate;

/**
 * 我的日程
 * @author JiaQi
 *
 */
public class MyCommunicateMgr {
	private EstablishmentCommunicateDAO establishmentCommunicateDAO = new EstablishmentCommunicateDAO();
	/**
	 * 获取全部
	 */
	public List<EstablishmentCommunicate> findAll(){
		List<EstablishmentCommunicate> establishmentCommunicates = null;
		try {
			establishmentCommunicates = establishmentCommunicateDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return establishmentCommunicates;
	}
	/**
	 * 保存
	 */
	public void save(EstablishmentCommunicate entity) {
		try {
			establishmentCommunicateDAO.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
