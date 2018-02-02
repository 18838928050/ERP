/**
 * 
 */
package com.erp.model.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import sun.launcher.resources.launcher;

import com.erp.controller.vto.PlaceVTOw;
import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AreaVO;
import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author： 如约而至 @time：2017年9月2日 下午11:17:17
 *******************************************************************
 @说明：
 *******************************************************************/
@SuppressWarnings("deprecation")
public class PlaceDaow extends BaseDAOw<AreaVO> {

	/**
	 * @说明：查找省
	 */
	public List<AreaVO> findAllSheng() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> list = session.createQuery("from AreaVO where parentId=0")
				.list();
		AreaVO areaVO = list.get(0);
		// 这个用来返回上一级
		ActionContext.getContext().getSession().put("top", areaVO);
		return list;
	}

	/**
	 * @说明：查找市 县
	 */
	public List<AreaVO> findAllById(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> list = session.createQuery(
				"from AreaVO where parentId='" + id + "'").list();
		if (list.size() != 0) {
			AreaVO areaVO = list.get(0);
			// 这个用来返回上一级
			ActionContext.getContext().getSession().put("top", areaVO);
		}
		session.close();
		return list;
	}

	/**
	 * @说明：
	 */
	public List gerTreePlace() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List list = new ArrayList();

		Query query = session
				.createQuery("select new Map(id as sid,areaName as sname) from AreaVO where parentId=0");
		List<Map> list2 = query.list();
		for (Map map : list2) {
			list.add(map.get("sname"));// 添加省

			query = session
					.createQuery("select new Map(id as sid,areaName as sname) from AreaVO where parentId='"
							+ map.get("sid") + "'");
			list2 = query.list();
			for (Map map2 : list2) {
				list.add("　-|" + map2.get("sname"));// 添加省下面的市

				query = session
						.createQuery("select new Map(id as sid,areaName as sname) from AreaVO where parentId='"
								+ map2.get("sid") + "'");
				list2 = query.list();
				for (Map map3 : list2) {
					list.add("　　-|" + map3.get("sname"));// 添加省下面的市
				}
			}
		}
		return list;
	}

	/**
	 * @说明：得到所有的省
	 */
	public List<AreaVO> getSheng() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> a = session.createQuery("from AreaVO where parentId=0")
				.list();
		if (a.size() != 0) {
			AreaVO areaVO = a.get(0);
			// 这个用来返回上一级
			ActionContext.getContext().getSession().put("top", areaVO);

		}
		return a;
	}

	/**
	 * @说明：
	 */
	public List<AreaVO> getAllCity(Long parentId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> list = session.createQuery(
				"from AreaVO where parentId='" + parentId + "'").list();
		if (list.size() != 0) {

			AreaVO areaVO = list.get(0);
			// 这个用来返回上一级
			ActionContext.getContext().getSession().put("top", areaVO);
		}

		return list;

	}

	/**
	 * @说明：
	 */

	public AreaVO getParentIdByAreaName(String areaName) {
		String name = areaName.substring(areaName.indexOf("|") + 1);
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		AreaVO areaVO = (AreaVO) session.createQuery(
				"from AreaVO where areaName='"+name+"'").uniqueResult();
		return areaVO;
	}

	/**
	 * @说明：获得 省 条件下 sequ_code 最大值  
	 */
	public Integer getSequCode() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> a = session.createQuery("from AreaVO where parentId=0")
				.list();
		
		int[] s = new int[a.size()];
		for (int i = 1; i < s.length; i++) {
			s[i] = Integer.parseInt(a.get(i).getSequCode());
		}
		int max = s[0];
		for (int i = 1; i < s.length; i++) {
			if (s[i] > max) {
				max = s[i];
			}
		}
		
		return max;
	}

	/**
	 * @说明：  我要添加县  在查询sequ_code :  1.2.1   1.2.2  1.2.3  1.2.4  利用个数
	 */
	public Integer getSequCodeMaxByParId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<AreaVO> a = session.createQuery("from AreaVO where parentId='"+id+"'")
				.list();
		return a.size();
	}

}
