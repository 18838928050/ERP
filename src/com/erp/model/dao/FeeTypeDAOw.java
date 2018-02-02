/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.FeeTypeVO;

/**
 * @author： 如约而至 @time：2017年8月31日 下午10:17:46
 *******************************************************************
 @说明：
 *******************************************************************/
@SuppressWarnings("unchecked")
public class FeeTypeDAOw extends BaseDAOw<FeeTypeVO> {

	/**
	 * @throws Exception
	 * @说明：删除
	 */
	/*
	 * public void deleteBankAccountById(long id) throws Exception { delete(id);
	 * }
	 *//**
	 * @说明：查询所有银行账户 并对结果按照sequenceCode进行升序
	 */

	public List<FeeTypeVO> findAllOderyBySequenceCode() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		return session.createQuery("from FeeTypeVO order by sequenceCode asc").list();
	}

	/**
	 * @说明：
	 */
	public int getFeeTypeSequenceCodeMax() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Object i = session.createQuery("select Max(sequenceCode) from  FeeTypeVO").uniqueResult();
		System.out.println(i + ".......");
		return (int) i;
	}

	public FeeTypeVO getFeeTypeByFeeBillitemBillId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "select ftId from FeeBillItemVO where billId='" + id + "'";
		long id2 = (long) session.createQuery(hql).uniqueResult();
		Criteria criteria = session.createCriteria(FeeTypeVO.class);
		criteria.add(Restrictions.in("id", id2));
		return (FeeTypeVO) criteria.uniqueResult();
	}

	public List<FeeTypeVO> getFeeTypeByFeeBillitemBillIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<FeeTypeVO> feeTypeVOs = new ArrayList<FeeTypeVO>();
		for (Long long1 : ids) {
			feeTypeVOs.add(session.get(FeeTypeVO.class, long1));
		}
		return feeTypeVOs;
	}

}
