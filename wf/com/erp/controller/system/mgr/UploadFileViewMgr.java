/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.erp.model.dao.AccessoryDAOw;
import com.erp.model.dao.BusinessBillDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.WorkCenterDAO;
import com.erp.model.dao.WorkCenterDAOw;
import com.erp.model.vo.AccessoryVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.WorkCenter;
import com.erp.model.vo.WorkCenterVO;

/**
 @author： 如约而至    @time：2017年12月3日 下午7:01:53 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class UploadFileViewMgr {
EstablishmentDAOw establishmentDAOw=new EstablishmentDAOw();
	AccessoryDAOw accessoryDAOw=new AccessoryDAOw();
	WorkCenterDAOw workCenterDAOw=new WorkCenterDAOw();
	BusinessBillDAOw businessBillDAOw=new BusinessBillDAOw();
	/**
	 * @说明：
	 */
	public List<AccessoryVO> getAllAccessByLimit() {
		return accessoryDAOw.getAllAccessByLimit();
	}
	/**
	 * @说明：
	 */
	public List<WorkCenterVO> getAllWCByidOfExtId(List<AccessoryVO> accessoryVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (AccessoryVO accessoryVO : accessoryVOs) {
			ids.add(accessoryVO.getExtId());
		}
		return workCenterDAOw.getByIds(ids);
	}
	/**
	 * @说明：
	 */
	public List<BusinessBillVO> getBBByidOfAgaenIds(List<AccessoryVO> accessoryVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (AccessoryVO accessoryVO : accessoryVOs) {
			ids.add(accessoryVO.getAgentId());
		}
		return businessBillDAOw.getAllBBByIds(ids);
	}
	/**
	 * @说明：
	 */
	public List<EstablishmentVO> getEsByidOfClienid(List<BusinessBillVO> businessBillVOs) {
		List<Long> ids=new ArrayList<Long>();
		for (BusinessBillVO businessBillVO : businessBillVOs) {
			ids.add(businessBillVO.getClientId());
		}
		return establishmentDAOw.getEByids(ids);
	}

}
