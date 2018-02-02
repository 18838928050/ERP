/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.controller.stock.vo.OutBillVO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.StorehouseVO;

/**
 @author： fu    @time：2017年12月3日 下午4:10:57 
 @说明： 一份耕耘，一份收获
 **/
public class StoreHouseDAOByfu {

	/**
	 * @说明：
	 */
	public List<StorehouseVO> getStorehourses(List<OutBillVO> outBillVOs) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
     List<Long> storeIds=new ArrayList<Long>();
		for (OutBillVO long1 : outBillVOs) {
			storeIds.add(long1.getStorehouseId());
		}
		Criteria criteria=session.createCriteria(StorehouseVO.class);
		criteria.add(Restrictions.in("id", storeIds));
		
		return criteria.list()  ;
	}

}
