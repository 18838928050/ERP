/**
 * 
 */
package com.erp.controller.action;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.erp.controller.vto.YewuduizhangVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.YewudanzuofeiBean;
import com.erp.model.vo.gBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：fu
 * @date 2018年1月6日 下午3:46:24 一份耕耘，一份收获*****
 */
public class YewudanzuofeiAction extends BaseAction<YewuduizhangVTO> {
	public String findAll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT    " + "BB.bill_code AS a,            "
				+ "BB.order_date AS b,           " + "E.est_name AS c,              "
				+ "BB.content AS d,              " + "BB.deliver_date AS e,         "
				+ "BB.manager_name AS f,         " + "BBE.examined AS g             "
				+ "FROM                          " + "business_bill AS BB ,         "
				+ "business_bill_ext AS BBE ,    " + "establishment AS E            "
				+ "WHERE                         " + "BBE.id = BB.ID AND            "
				+ "BB.client_id = E.ID AND       " + "BBE.enabled = 'Y' AND         "
				+ "BB.tally_set_id = 2        ";
		Query query = session.createNativeQuery(sql);
		List<gBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(gBean.class)).list();
		ActionContext.getContext().put("list", list);
		return "tofindAll";

	}

	public String zuofei() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getBusinessBill().getBillCode();
		String sql1 = "select id from business_bill  where bill_code='" + billCode + "'";
		BigInteger id = (BigInteger) session.createSQLQuery(sql1).uniqueResult();
		System.out.println(id);
		String sql = "update business_bill_ext  set enabled='N' where  id='" + id + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toFirstUI";
	}

	public String chakan() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getBusinessBill().getBillCode();
		String sql1 = "SELECT                 " + "BB.bill_code AS a,                       "
				+ "BB.order_date AS b,                      "
				+ "E.est_name AS c,                         "
				+ "E.linkman AS d,                          "
				+ "E.linkman_phone AS e,                    "
				+ "MT.type_name AS f,                       "
				+ "BBI.finished_content AS g,               "
				+ "BBI.pro_name AS h,                       "
				+ "BBI.specification AS i,                  "
				+ "BBI.make_require AS j,                   "
				+ "BBI.amount AS k,                         "
				+ "BBI.square_num AS l,                     "
				+ "BBI.unit_price AS m,                     "
				+ "BBI.cost AS n,                           "
				+ "BBI.is_cooper AS o,                      "
				+ "BBI.is_setu AS p,                        "
				+ "BB.introducer_name AS q,                 "
				+ "BB.setup_require AS r,                   "
				+ "D.department_name AS s,                  "
				+ "BB.lading_require AS t,                  "
				+ "BB.manager_name AS u,                    "
				+ "BB.deliver_date AS v,                    "
				+ "BB.designer_name_str AS w,               "
				+ "BB.address AS x,                         "
				+ "BB.imprest AS y,                         "
				+ "PM.mode_name AS z,                       "
				+ "BB.content AS aa,                        "
				+ "BB.mark AS cc,                           "
				+ "BB.check_date AS dd,                     "
				+ "BB.creater_name AS ee,                   "
				+ "BB.create_time AS ff,                    "
				+ "BBE.examiner_name AS gg,                 "
				+ "BBE.examine_time AS hh,                  "
				+ "T.title AS ii                            "
				+ "FROM                                     "
				+ "establishment AS E ,                     "
				+ "business_bill AS BB ,                    "
				+ "business_bill_item AS BBI ,              "
				+ "department AS D ,                        "
				+ "pay_mode AS PM ,                         "
				+ "business_bill_ext AS BBE ,               "
				+ "tally_set AS T ,                         "
				+ "make_type AS MT                          "
				+ "WHERE                                    "
				+ "BB.client_id = E.id AND                  "
				+ "BBE.id = BB.id AND                       "
				+ "BB.department_id = D.id AND              "
				+ "BBI.bill_id = BB.id AND                  "
				+ "BB.pay_mode_id = PM.id AND               "
				+ "BB.tally_set_id = T.id AND               " + "BB.bill_code = '" + billCode
				+ "' AND      " + "BBI.make_type_id = MT.ID                 ";
		Query query = session.createNativeQuery(sql1);
		List<YewudanzuofeiBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(YewudanzuofeiBean.class)).list();
		ActionContext.getContext().put("list", list);
		// 这是放列表之外的数据，只要一条，所以就把billCode groupBY了
		String sql2 = "SELECT                 " + "BB.bill_code AS a,                       "
				+ "BB.order_date AS b,                      "
				+ "E.est_name AS c,                         "
				+ "E.linkman AS d,                          "
				+ "E.linkman_phone AS e,                    "
				+ "MT.type_name AS f,                       "
				+ "BBI.finished_content AS g,               "
				+ "BBI.pro_name AS h,                       "
				+ "BBI.specification AS i,                  "
				+ "BBI.make_require AS j,                   "
				+ "BBI.amount AS k,                         "
				+ "BBI.square_num AS l,                     "
				+ "BBI.unit_price AS m,                     "
				+ "BBI.cost AS n,                           "
				+ "BBI.is_cooper AS o,                      "
				+ "BBI.is_setu AS p,                        "
				+ "BB.introducer_name AS q,                 "
				+ "BB.setup_require AS r,                   "
				+ "D.department_name AS s,                  "
				+ "BB.lading_require AS t,                  "
				+ "BB.manager_name AS u,                    "
				+ "BB.deliver_date AS v,                    "
				+ "BB.designer_name_str AS w,               "
				+ "BB.address AS x,                         "
				+ "BB.imprest AS y,                         "
				+ "PM.mode_name AS z,                       "
				+ "BB.content AS aa,                        "
				+ "BB.mark AS cc,                           "
				+ "BB.check_date AS dd,                     "
				+ "BB.creater_name AS ee,                   "
				+ "BB.create_time AS ff,                    "
				+ "BBE.examiner_name AS gg,                 "
				+ "BBE.examine_time AS hh,                  "
				+ "T.title AS ii                            "
				+ "FROM                                     "
				+ "establishment AS E ,                     "
				+ "business_bill AS BB ,                    "
				+ "business_bill_item AS BBI ,              "
				+ "department AS D ,                        "
				+ "pay_mode AS PM ,                         "
				+ "business_bill_ext AS BBE ,               "
				+ "tally_set AS T ,                         "
				+ "make_type AS MT                          "
				+ "WHERE                                    "
				+ "BB.client_id = E.id AND                  "
				+ "BBE.id = BB.id AND                       "
				+ "BB.department_id = D.id AND              "
				+ "BBI.bill_id = BB.id AND                  "
				+ "BB.pay_mode_id = PM.id AND               "
				+ "BB.tally_set_id = T.id AND               " + "BB.bill_code = '" + billCode
				+ "' AND      " + "BBI.make_type_id = MT.ID     GROUP BY BB.bill_code             ";
		Query query2 = session.createNativeQuery(sql2);
		// list2只有一条数据
		List<YewudanzuofeiBean> list2 = query2.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(YewudanzuofeiBean.class)).list();
		ActionContext.getContext().put("list2", list2);
		return "toChakan";

	}

	public String tuichu() {
		return "tuichu";

	}
}
