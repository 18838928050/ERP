/**
 * 
 */
package com.erp.controller.action;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.erp.controller.vto.AnzhuangdannVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AnzhuangBean;
import com.erp.model.vo.AzhuangdanchakanBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：fu
 * @date 2017年12月24日 下午2:41:27 一份耕耘，一份收获*****
 */

// 安装单反审核
public class anzhuagndanfanshenheAction extends BaseAction<AnzhuangdannVTO> {

	public String findAll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT SB.bill_code AS a,	SB.bill_date AS b,	E.est_name AS c,	BB.bill_code AS d,	BB.content AS e,	SB.setu_name_str AS f,"
				+ " 	SB.crea_name AS g FROM 	setu_bill AS SB,	establishment AS E,	business_bill AS BB,	business_bill_ext AS BBE "
				+ " WHERE 	BBE.id = BB.ID AND BBE.examined = 'Y' AND BBE.enabled = 'Y' AND BB.tally_set_id = 2 AND SB.bb_id = BB.ID"
				+ " AND BB.client_id = E.ID AND SB.enab = 'Y' AND SB.exam = 'Y'";
		Query query = session.createNativeQuery(sql);
		List<AnzhuangBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuangBean.class)).list();
		ActionContext.getContext().put("list", list);
		return "toFindAll";
	}

	public String notexamined() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String SBbillCode = model.getAnzhuangBean().getA();
		String sql = "update  setu_bill  set exam='N' where bill_code='" + SBbillCode + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toList";
	}

	public String notexamined2() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String SBbillCode = model.getAnAzhuangdanchakanBean().getA();
		String sql = "update  setu_bill  set exam='N' where bill_code='" + SBbillCode + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toList";
	}

	public String chakan() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String SBbillCode = model.getAnAzhuangdanchakanBean().getA();

		String sqll = "SELECT              " + " 	SB.bill_code AS a,   "
				+ " 	SB.plan_date AS b,               " + " 	E.est_name AS c,                 "
				+ " 	BB.linkman AS d,                 " + " 	BB.address AS e,                 "
				+ " 	BB.bill_code AS f,               " + " 	MT.type_name AS g,               "
				+ " 	BBI.finished_content AS h,       " + " 	BBI.pro_name AS i,               "
				+ " 	BBI.specification AS j,          " + " 	BBI.make_require AS k,           "
				+ " 	BBI.amount AS l,                 " + " 	SB.mark AS n,                    "
				+ " 	SB.setu_name_str AS o,           " + " 	SB.addr as p,                    "
				+ " 	SB.cost AS q,                    " + " 	SB.mng_name AS r,                "
				+ " 	SB.rema_cost AS t,               " + " 	SB.need_car AS u,                "
				+ " 	SB.need_high AS uu,              " + " 	SB.need_weld AS uuu,             "
				+ " 	SB.crea_name AS w,               " + " 	SB.crea_time AS x,               "
				+ " 	SB.exam_name AS y,               " + " 	SB.exam_time AS z,               "
				+ " 	TS.title AS tallySet             " + " FROM                                 "
				+ " 	business_bill AS BB,             " + " 	setu_bill AS SB,                 "
				+ " 	establishment AS E,              " + " 	business_bill_item AS BBI,       "
				+ " 	make_type AS MT,                 " + " 	tally_set AS TS,                 "
				+ " 	business_bill_ext AS BBE         " + " WHERE                                "
				+ " 	SB.bb_id = BB.id                 " + " AND BB.client_id = E.id              "
				+ " AND BBI.bill_id = BB.id              "
				+ " AND BBI.make_type_id = MT.id         "
				+ " AND BB.tally_set_id = TS.id          "
				+ " AND BBE.examined = 'Y'               "
				+ " AND BBE.enabled = 'Y'                "
				+ " AND BB.tally_set_id = 2              " + " AND SB.bill_code = '" + SBbillCode
				+ "' " + " AND BB.id = BBE.id                   " + " AND BBI.is_setu = 'Y'";
		String sql2 = "SELECT              " + " 	SB.bill_code AS a,               "
				+ " 	SB.plan_date AS b,               " + " 	E.est_name AS c,                 "
				+ " 	BB.linkman AS d,                 " + " 	BB.address AS e,                 "
				+ " 	BB.bill_code AS f,               " + " 	MT.type_name AS g,               "
				+ " 	BBI.finished_content AS h,       " + " 	BBI.pro_name AS i,               "
				+ " 	BBI.specification AS j,          " + " 	BBI.make_require AS k,           "
				+ " 	BBI.amount AS l,                 " + " 	SB.mark AS n,                    "
				+ " 	SB.setu_name_str AS o,           " + " 	SB.addr as p,                    "
				+ " 	SB.cost AS q,                    " + " 	SB.mng_name AS r,                "
				+ " 	SB.rema_cost AS t,               " + " 	SB.need_car AS u,                "
				+ " 	SB.need_high AS uu,              " + " 	SB.need_weld AS uuu,             "
				+ " 	SB.crea_name AS w,               " + " 	SB.crea_time AS x,               "
				+ " 	SB.exam_name AS y,               " + " 	SB.exam_time AS z,               "
				+ " 	TS.title AS tallySet             " + " FROM                                 "
				+ " 	business_bill AS BB,             " + " 	setu_bill AS SB,                 "
				+ " 	establishment AS E,              " + " 	business_bill_item AS BBI,       "
				+ " 	make_type AS MT,                 " + " 	tally_set AS TS,                 "
				+ " 	business_bill_ext AS BBE         " + " WHERE                                "
				+ " 	SB.bb_id = BB.id                 " + " AND BB.client_id = E.id              "
				+ " AND BBI.bill_id = BB.id              "
				+ " AND BBI.make_type_id = MT.id         "
				+ " AND BB.tally_set_id = TS.id          "
				+ " AND BBE.examined = 'Y'               "
				+ " AND BBE.enabled = 'Y'                "
				+ " AND BB.tally_set_id = 2              " + " AND SB.bill_code = '" + SBbillCode
				+ "' " + " AND BB.id = BBE.id                   "
				+ " AND BBI.is_setu = 'Y' GROUP BY SB.bill_code";
		Query query = session.createNativeQuery(sqll);
		List<AzhuangdanchakanBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AzhuangdanchakanBean.class)).list();
		Query query2 = session.createNativeQuery(sql2);
		List<AzhuangdanchakanBean> list2 = query2.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AzhuangdanchakanBean.class)).list();
		ActionContext.getContext().put("list", list);
		ActionContext.getContext().put("list2", list2);
		return "toChakan";
	}

	public String tuichu() {
		return "toFirstUI";
	}
}
