/**
 * 
 */
package com.erp.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillItemExtVO;

/**
 * @author： 如约而至 @time：2017年10月9日 下午4:00:32
 *******************************************************************
 @说明：
 *******************************************************************/
public class BusinessBillItemExtDAO extends BaseDAO<BusinessBillItemExtVO> {

	/**
	 * @说明：
	 */
	public List<BusinessBillItemExtVO> getByIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		List<BusinessBillItemExtVO> bs = new ArrayList<>();
		BusinessBillItemExtVO b;
		for (Long long1 : ids) {
			b = new BusinessBillItemExtVO();
			b.setDeliAmou((BigDecimal) session.createQuery(
					"select s.deliAmou from BusinessBillItemExtVO as s where s.id=" + long1 + "")
					.uniqueResult());
			bs.add(b);
		}
		return bs;
	}

}
