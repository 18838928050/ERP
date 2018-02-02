/**
 * 
 */
package com.erp.controller.action;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import com.erp.controller.action.BaseAction;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AreaVO;
import com.opensymphony.xwork2.ActionContext;


/**
 @author： 如约而至    @time：2017年9月6日 下午10:50:04 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class TestAraa extends BaseAction<AreaVO>{
	
	@SuppressWarnings("deprecation")
	@Test
	public void testNameSQL() throws Exception {
		Session session=HibernateUtils.getSession();
		//session.beginTransaction();
		SQLQuery query= session.createSQLQuery("drop table allo_bill");
		session.beginTransaction().commit();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testName2() throws Exception {
		List list=new ArrayList();
		list.add(1,"1");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	@Resource
	public void testName22() throws Exception {
		ActionContext.getContext().getValueStack().set("aa", "dfa");
	}
	
	
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Test
	public void testName() throws Exception {
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
				list.add("  -|"+map2.get("sname"));//添加省下面的市
				
				query= session.createQuery("select new Map(id as sid,areaName as sname) from AreaVO where parentId='"+map2.get("sid")+"'");
				list2=query.list();
				for (Map map3 : list2) {
					list.add("      -|"+map3.get("sname"));//添加省下面的市
				}
			}
		}
		ServletActionContext.getContext().getValueStack().set("a", "s");
			for (Object object : list) {
			System.err.println(object);
		}
	}
}
