/**
 * 
 */
package com.erp.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;




import org.junit.Test;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.IncomeTypeVO;

/**
 @author： 如约而至    @time：2017年8月31日 下午10:17:46 
 *******************************************************************
 @说明： 
 *******************************************************************/
@SuppressWarnings("unchecked")
public class IncomeTypeDAOw extends BaseDAOw<IncomeTypeVO>{

	/*
	

	*//**
	 * @说明：查询所有银行账户 并对结果按照sequenceCode进行升序
	 */
	
	public  List<IncomeTypeVO> findAllOderyBySequenceCode() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		return session.createQuery("from IncomeTypeVO order by sequenceCode asc").list();
	}

	/**
	 * @说明：
	 */
	public  int getIncomeTypeSequenceCodeMax() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		Object i= session.createQuery("select Max(sequenceCode) from  IncomeTypeVO").uniqueResult();
		System.out.println(i+".......");
		return (int) i;
	}




	
	
	
	

}
