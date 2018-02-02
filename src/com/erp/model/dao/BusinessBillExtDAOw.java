/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillExtVO;

/**
 @author： 如约而至    @time：2017年9月12日 下午10:53:26 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class BusinessBillExtDAOw extends BaseDAOw<BusinessBillExtVO>{

	/**
	 * @说明：
	 */
	public List<BusinessBillExtVO> getByIds(List<Long> ids) {
		Session session=HibernateUtils.getSession();
		 session.beginTransaction();
		 List<BusinessBillExtVO> businessBillExtVOs=new ArrayList<BusinessBillExtVO>();
		 for (Long long1 : ids) {
			 businessBillExtVOs.add(session.get(BusinessBillExtVO.class, long1));
		 }
		return businessBillExtVOs;
	}

}
