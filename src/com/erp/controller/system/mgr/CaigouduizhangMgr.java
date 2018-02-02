/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.List;

import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PurchaseBillItemVO;

/**
 * @author fu
 *
 */
public class CaigouduizhangMgr {
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();

	/**
	 * @return
	 */
	public List<EstablishmentVO> findEsts() {

		return establishmentDAO.findEstss();
	}

	/**
	 * @param id
	 * @return
	 */
	public List<List<PurchaseBillItemVO>> finPBISS(long id) {
		return establishmentDAO.finPBISS(id);
	}

}
