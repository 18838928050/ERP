/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.WaixiemingxiYilanbiaoBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author： fu @time：2018年2月2日 下午4:02:50
 * @说明： 一份耕耘，一份收获
 **/
public class WaixiemingxiyilanbiaoAction  {
	public String findAll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT     " + "CB.bill_code AS a,             "
				+ "BB.bill_code AS b,             " + "E.est_name AS c,               "
				+ "CB.cooper_date AS d,           " + "CB.linkman AS e,               "
				+ "CB.content AS f,               " + "MT.type_name AS g,             "
				+ "CBI.finished_content AS h,     " + "CBI.pro_name AS i,             "
				+ "CBI.specification AS j,        " + "CBI.make_require AS k,         "
				+ "CBI.unit AS l,                 " + "CBI.amount AS m,               "
				+ "CBI.unit_price AS n,           " + "CBI.cost AS o,                 "
				+ "BB.mark AS p,                  " + "BB.manager_name AS q,          "
				+ "BB.creater_name AS r,          " + "D.department_name AS s         "
				+ "FROM                           " + "cooper_bill AS CB ,            "
				+ "business_bill AS BB ,          " + "establishment AS E ,           "
				+ "make_type AS MT ,              " + "cooper_bill_item AS CBI ,      "
				+ "business_bill_ext AS BBE ,     " + "department AS D ,              "
				+ "cooper_bill_ext AS CBE,        " + "business_bill_item AS BBI      "
				+ "WHERE                          " + "BB.department_id = D.id AND    "
				+ "CBI.bill_id = CB.id AND        " + "CBI.make_type_id = MT.id AND   "
				+ "BB.id = BBE.id AND             " + "BB.tally_set_id = 2 AND        "
				+ "BBI.bill_id=BB.id AND          " + "BBE.examined = 'Y' AND         "
				+ "                               " + "CBE.id = CB.id AND             "
				+ "BB.client_id = E.ID AND        " + "CBI.bb_item_id=BBI.id          "
				+ "ORDER BY                       " + "a DESC                         ";
		Query query = session.createNativeQuery(sql);
		List<WaixiemingxiYilanbiaoBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(WaixiemingxiYilanbiaoBean.class))
				.list();
		ActionContext.getContext().put("list", list);
		return "toFindAll";
	}
	@Test
	public void dd() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT     " + "CB.bill_code AS a,             "
				+ "BB.bill_code AS b,             " + "E.est_name AS c,               "
				+ "CB.cooper_date AS d,           " + "CB.linkman AS e,               "
				+ "CB.content AS f,               " + "MT.type_name AS g,             "
				+ "CBI.finished_content AS h,     " + "CBI.pro_name AS i,             "
				+ "CBI.specification AS j,        " + "CBI.make_require AS k,         "
				+ "CBI.unit AS l,                 " + "CBI.amount AS m,               "
				+ "CBI.unit_price AS n,           " + "CBI.cost AS o,                 "
				+ "BB.mark AS p,                  " + "BB.manager_name AS q,          "
				+ "BB.creater_name AS r,          " + "D.department_name AS s         "
				+ "FROM                           " + "cooper_bill AS CB ,            "
				+ "business_bill AS BB ,          " + "establishment AS E ,           "
				+ "make_type AS MT ,              " + "cooper_bill_item AS CBI ,      "
				+ "business_bill_ext AS BBE ,     " + "department AS D ,              "
				+ "cooper_bill_ext AS CBE,        " + "business_bill_item AS BBI      "
				+ "WHERE                          " + "BB.department_id = D.id AND    "
				+ "CBI.bill_id = CB.id AND        " + "CBI.make_type_id = MT.id AND   "
				+ "BB.id = BBE.id AND             " + "BB.tally_set_id = 2 AND        "
				+ "BBI.bill_id=BB.id AND          " + "BBE.examined = 'Y' AND         "
				+ "                               " + "CBE.id = CB.id AND             "
				+ "BB.client_id = E.ID AND        " + "CBI.bb_item_id=BBI.id          "
				+ "ORDER BY                       " + "a DESC                         ";
		Query query = session.createNativeQuery(sql);
		List<WaixiemingxiYilanbiaoBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(WaixiemingxiYilanbiaoBean.class))
				.list();
		for (WaixiemingxiYilanbiaoBean waixiemingxiYilanbiaoBean : list) {
			System.out.println(waixiemingxiYilanbiaoBean);
		}
	}
}
