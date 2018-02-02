/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;




import org.junit.Test;

import com.erp.controller.vto.PlaceVTOw;
import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AreaVO;

/**
 @author： 如约而至    @time：2017年9月2日 下午11:17:17 
 *******************************************************************
 @说明： 
 *******************************************************************/
@SuppressWarnings("deprecation")
public class CopyOfPlaceDaow extends BaseDAOw<AreaVO>{

	/**
	 * @说明：查找省
	 */
	public List<AreaVO> findAllSheng() {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> list=session.createQuery("from AreaVO where parentId=0").list();
		session.close();
		return list;
	}

	/**
	 * @说明：查找市  县
	 */
	public List<AreaVO> findAllById(long id) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> list=session.createQuery("from AreaVO where parentId='"+id+"'").list();
		session.close();
		return list;
	}

	/**
	 * @说明：
	 */
	
	public List<AreaVO> getAllById(long parentId) {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> areaVOs=session.createQuery("from AreaVO where parentId='"+parentId+"'").list();
		session.close();
		return areaVOs;
	}

	/**
	 * @说明：
	 */
	public List gerTreePlace() throws Exception {
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List list=new ArrayList();
		
		Query query=session.createQuery("select new Map(id as sid,areaName as sname) from AreaVO where parentId=0");
		List<Map> list2=query.list();
		for (Map map : list2) {
			list.add(map.get("sname"));//添加省
			
			query= session.createQuery("select new Map(id as sid,areaName as sname) from AreaVO where parentId='"+map.get("sid")+"'");
			list2=query.list();
			for (Map map2 : list2) {
				list.add("-|"+map2.get("sname"));//添加省下面的市
				
				query= session.createQuery("select new Map(id as sid,areaName as sname) from AreaVO where parentId='"+map2.get("sid")+"'");
				list2=query.list();
				for (Map map3 : list2) {
					list.add("　-|"+map3.get("sname"));//添加省下面的市
				}
			}
		}
			/*for (Object object : list) {
			System.err.println(object);
		}*/
			return list;
	}


}
