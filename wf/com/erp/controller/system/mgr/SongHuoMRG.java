/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.List;

import com.erp.model.dao.BusinessBillDAOw;
import com.erp.model.dao.BusinessBillItemDAOw;
import com.erp.model.dao.BusinessBillItemExtDAOw;
import com.erp.model.dao.DeliverBillDAOw;
import com.erp.model.dao.DepartmentDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.dao.PayModeDAOw;
import com.erp.model.dao.TallySetDAOw;
import com.erp.model.vo.BusinessBillItemExtVO;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.DeliverBillVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.PayModeVO;
import com.erp.model.vo.TallySetVO;

/**
 * @author： 如约而至 @time：2017年12月15日 上午10:04:32
 *******************************************************************
 @说明：
 *******************************************************************/
public class SongHuoMRG {
	DeliverBillDAOw deliverBillDAO = new DeliverBillDAOw();
	BusinessBillDAOw businessBillDAO = new BusinessBillDAOw();
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();
	DepartmentDAOw departmentDAO = new DepartmentDAOw();
	PayModeDAOw payModeDAO = new PayModeDAOw();
	TallySetDAOw tallySetDAO = new TallySetDAOw();
	BusinessBillItemDAOw businessBillItemDAO = new BusinessBillItemDAOw();
	MakeTypeDAOw makeTypeDAO = new MakeTypeDAOw();
	BusinessBillItemExtDAOw businessBillItemExtDAO = new BusinessBillItemExtDAOw();

	/**
	 * @说明：
	 */
	public List<DeliverBillVO> getAllDB() {
		return deliverBillDAO.getAllDeliberBills();
	}

	/**
	 * @说明：
	 */
	public List<BusinessBillVO> getAllBBByid(List<DeliverBillVO> deliverBillVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (DeliverBillVO deliverBillVO : deliverBillVOs) {
			ids.add(deliverBillVO.getBusinessBillId());

		}
		return businessBillDAO.getSonghuodanzuofeiByid(ids);
	}

	/**
	 * @说明：
	 */
	public List<EstablishmentVO> getAllEById(List<BusinessBillVO> businessBillVOs) {
		List<Long> ids = new ArrayList<Long>();
		for (BusinessBillVO dddddd : businessBillVOs) {
			ids.add(dddddd.getClientId());
		}
		return establishmentDAO.getByIds(ids);
	}

	/**
	 * @说明：
	 */
	public DeliverBillVO getOnlyDBByBillcode(String billCode) {
		return deliverBillDAO.getByBillCode(billCode);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public BusinessBillVO getBusinessById(long businessBillId) throws Exception {
		// TODO Auto-generated method stub
		return businessBillDAO.getById(businessBillId);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public EstablishmentVO getEById(long clientId) throws Exception {
		return establishmentDAO.getById(clientId);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public DepartmentVO getDById(long departmentId) throws Exception {
		// TODO Auto-generated method stub
		return departmentDAO.getById(departmentId);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public PayModeVO getPMById(long payModeId) throws Exception {
		// TODO Auto-generated method stub
		return payModeDAO.getById(payModeId);
	}

	/**
	 * @throws Exception
	 * @说明：
	 */
	public TallySetVO getTallYByid(long tallySetId) throws Exception {
		// TODO Auto-generated method stub
		return tallySetDAO.getById(tallySetId);
	}

	/**
	 * @说明：
	 */
	public List<BusinessBillItemVO> getBBIByBillId(long id) {
		return businessBillItemDAO.getBusinessBillItemByBillId(id);
	}

	/**
	 * @说明：
	 */
	public List<MakeTypeVO> getMTsById(List<BusinessBillItemVO> businessBillItemVOs) {
		List<Long> ids = new ArrayList<>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {
			ids.add(businessBillItemVO.getMakeTypeId());
		}
		return makeTypeDAO.getMakeTypeByIds(ids);
	}

	/**
	 * @说明：
	 */
	public List<BusinessBillItemExtVO> getBBIE(List<BusinessBillItemVO> businessBillItemVOs) {
		List<Long> ids = new ArrayList<>();
		for (BusinessBillItemVO businessBillItemVO : businessBillItemVOs) {
			ids.add(businessBillItemVO.getId());
		}
		return businessBillItemExtDAO.getByIds(ids);
	}

}
