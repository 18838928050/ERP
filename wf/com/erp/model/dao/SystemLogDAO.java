/**
 * 
 */
package com.erp.model.dao;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.SystemLog;

/**
 @author： 如约而至    @time：2017年12月3日 下午2:10:40 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class SystemLogDAO extends BaseDAO<SystemLog>{

	/**
	 * @说明：
	 */
	public SystemLog getByStaid(long staffedid) {
		Session session=HibernateUtils.getSession();
		return (SystemLog) session.createQuery("from SystemLog as st where st.createrId="+staffedid+" and st.actionCode='LOGIN' order by st.createTime desc").setFirstResult(0).setMaxResults(1).uniqueResult();
	}
	


}
