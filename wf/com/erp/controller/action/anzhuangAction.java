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

import com.erp.controller.vto.AnzhuangdannVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AnzhuandanchakanBean;
import com.erp.model.vo.AnzhuangBean;
import com.erp.model.vo.Bean2;
import com.erp.model.vo.ChakanyewudanBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：fu
 * @date 2017年12月17日 下午8:10:39 一份耕耘，一份收获*****
 */
public class anzhuangAction extends BaseAction<AnzhuangdannVTO> {
	public String findAll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT BB.bill_code AS a,	BB.order_date AS b,	E.est_name AS c,BB.content AS d,BB.setup_require AS e, BB.deliver_date AS f ,"
				+ " BBE.completed AS g"
				+ " FROM business_bill AS BB,"
				+ "	business_bill_ext AS BBE,	business_bill_item AS BBI,	establishment AS E  WHERE BB.tally_set_id = 2 "
				+ " AND BBE.enabled = 'Y' AND BBE.examined = 'Y' AND BBE.setuped = 'N' AND BBE.has_setu = 'N' AND BBE.id = BB.id"
				+ " AND BBI.is_setu = 'Y' AND BBI.bill_id = BB.id AND BBE.closed = 'N' AND BB.client_id = E.id GROUP BY"
				+ "	BB.bill_code ORDER BY BB.order_date ASC";
		Query query = session.createNativeQuery(sql);
		List<AnzhuangBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuangBean.class)).list();
		ActionContext.getContext().put("list", list);
		return "toFindAll";
	}

	public String chakan() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getChakanyewudanBean().getA();
		// 第一三四个table
		String sql = "SELECT BB.bill_code AS a,	BB.order_date AS b,	E.est_name AS c,	EL.level_name AS d,	BB.linkman AS e,"
				+ "	BB.phone AS f,	BB.contract_code AS g,	D.department_name AS q,	BB.setup_require AS r,	BB.content AS s,"
				+ "	BB.manager_name AS t,	BB.lading_require AS u,	BB.mark AS v,	BB.designer_name_str AS w,	BB.deliver_date AS x,"
				+ "	BB.creater_name AS y,	BB.create_time AS z,	BBE.examiner_name AS aa,	BBE.examine_time AS bb,	BB.modifier_name AS cc,"
				+ "	BB.modify_time AS dd,	T.title AS tally FROM 	business_bill AS BB,	business_bill_ext AS BBE,"
				+ "	business_bill_item AS BBI,	establishment AS E,	establishment_level AS EL,	make_type AS MT,"
				+ "	tally_set AS T,	business_bill_item_ext AS BBIE,	work_center AS WC,	department AS D WHERE	BB.department_id = D.id "
				+ " AND BB.id = BBE.id AND BBI.bill_id = BB.id AND BBIE.id = BBI.id AND BB.client_id = E.id AND BBI.make_type_id = MT.id"
				+ " AND BB.tally_set_id = T.id AND BBI.wc_id = WC.id AND BB.bill_code = '"
				+ billCode + " '" + " AND E.est_level_id = EL.ID GROUP BY BB.bill_code";
		Query query = session.createNativeQuery(sql);
		List<ChakanyewudanBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(ChakanyewudanBean.class)).list();
		ActionContext.getContext().put("list", list);
		// 第二个table,查询业务单中间部分
		String sql2 = "SELECT MT.type_name AS h,BBI.finished_content AS i,BBI.pro_name AS j,BBI.specification AS k,BBI.make_require AS l,"
				+ " BBI.amount AS m,BBI.is_cooper AS n,WC.wc_name AS o,BBIE.coop_comp AS p,BBIE.wc_comp AS pp FROM "
				+ " business_bill AS BB ,business_bill_ext AS BBE ,business_bill_item AS BBI ,establishment AS E ,establishment_level AS EL ,"
				+ " make_type AS MT ,tally_set AS T ,business_bill_item_ext AS BBIE ,work_center AS WC ,department AS D"
				+ " WHERE BB.department_id = D.id AND BB.id = BBE.id AND BBI.bill_id = BB.id AND BBIE.id = BBI.id AND "
				+ " BB.client_id = E.id AND BBI.make_type_id = MT.id AND BB.tally_set_id = T.id AND BBI.wc_id = WC.id AND"
				+ " BB.bill_code = '" + billCode + "' AND E.est_level_id = EL.ID ";
		Query query2 = session.createNativeQuery(sql2);
		List<Bean2> list2 = query2.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(Bean2.class)).list();
		ActionContext.getContext().put("list2", list2);
		return "toChakan";
	}

	public String tuichu() {
		return "tuichu";
	}

	public String kaianzhuangdan() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getChakanyewudanBean().getA();
		String sql = "SELECT             " + " 	SB.bill_code AS a,    "
				+ " 	SB.bill_date AS b,                   "
				+ " 	E.est_name AS c,                     "
				+ " 	BB.linkman AS d,                     "
				+ " 	BB.phone AS e,                       "
				+ " 	BB.bill_code AS f,                   "
				+ " 	BBI.finished_content AS g,           "
				+ " 	BBI.pro_name AS h,                   "
				+ " 	BBI.specification AS i,              "
				+ " 	BBI.make_require AS j,               "
				+ " 	BBI.amount AS k,                     "
				+ " 	BB.mark AS l,                        "
				+ " 	SB.setu_name_str AS m,               "
				+ " 	SB.addr AS n,                        "
				+ " 	SB.cost AS o,                        "
				+ " 	SB.mng_name AS p,                    "
				+ " 	SB.plan_date AS q,                   "
				+ " 	SB.rema_cost AS r,                   "
				+ " 	SB.need_car AS s,                    "
				+ " 	SB.requ AS t,                        "
				+ " 	SB.mark AS u,                        "
				+ " 	SB.crea_name AS v,                   "
				+ " 	SB.crea_time AS w,                   "
				+ " 	SB.exam_name AS x,                   "
				+ " 	SB.exam_time AS y,                   "
				+ " 	MT.type_name AS z,                   "
				+ " 	TS.title AS tallySet                 "
				+ " FROM                                  "
				+ " 	establishment AS E,                  "
				+ " 	business_bill AS BB,                 "
				+ " 	setu_bill AS SB,                     "
				+ " 	business_bill_ext AS BBE,            "
				+ " 	business_bill_item_ext AS BBIE,      "
				+ " 	business_bill_item AS BBI,           "
				+ " 	make_type AS MT,                     "
				+ " 	tally_set AS TS                      "
				+ " WHERE                                 "
				+ " 	SB.bb_id = BB.id                     "
				+ " AND BB.client_id = E.id               "
				+ " AND BB.tally_set_id = 2               "
				+ " AND BB.tally_set_id = 2               "
				+ " AND BBE.id = BB.id                    "
				+ " AND BBI.id = BBIE.id                  "
				+ " AND BBI.bill_id = BB.id               "
				+ " AND SB.bill_code ='AZ(2)2017120004'   "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id";
		String sql2 = "SELECT             " + " 	SB.bill_code AS a,    "
				+ " 	SB.bill_date AS b,                   "
				+ " 	E.est_name AS c,                     "
				+ " 	BB.linkman AS d,                     "
				+ " 	BB.phone AS e,                       "
				+ " 	BB.bill_code AS f,                   "
				+ " 	BBI.finished_content AS g,           "
				+ " 	BBI.pro_name AS h,                   "
				+ " 	BBI.specification AS i,              "
				+ " 	BBI.make_require AS j,               "
				+ " 	BBI.amount AS k,                     "
				+ " 	BB.mark AS l,                        "
				+ " 	SB.setu_name_str AS m,               "
				+ " 	SB.addr AS n,                        "
				+ " 	SB.cost AS o,                        "
				+ " 	SB.mng_name AS p,                    "
				+ " 	SB.plan_date AS q,                   "
				+ " 	SB.rema_cost AS r,                   "
				+ " 	SB.need_car AS s,                    "
				+ " 	SB.requ AS t,                        "
				+ " 	SB.mark AS u,                        "
				+ " 	SB.crea_name AS v,                   "
				+ " 	SB.crea_time AS w,                   "
				+ " 	SB.exam_name AS x,                   "
				+ " 	SB.exam_time AS y,                   "
				+ " 	MT.type_name AS z,                   "
				+ " 	TS.title AS tallySet                 "
				+ " FROM                                  "
				+ " 	establishment AS E,                  "
				+ " 	business_bill AS BB,                 "
				+ " 	setu_bill AS SB,                     "
				+ " 	business_bill_ext AS BBE,            "
				+ " 	business_bill_item_ext AS BBIE,      "
				+ " 	business_bill_item AS BBI,           "
				+ " 	make_type AS MT,                     "
				+ " 	tally_set AS TS                      "
				+ " WHERE                                 "
				+ " 	SB.bb_id = BB.id                     "
				+ " AND BB.client_id = E.id               "
				+ " AND BB.tally_set_id = 2               "
				+ " AND BB.tally_set_id = 2               "
				+ " AND BBE.id = BB.id                    "
				+ " AND BBI.id = BBIE.id                  "
				+ " AND BBI.bill_id = BB.id               "
				+ " AND SB.bill_code ='AZ(2)2017120004'   "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id GROUP BY SB.bill_code";
		Query query = session.createNativeQuery(sql);
		Query query2 = session.createNativeQuery(sql2);
		// 这个数组是没有groupBy的
		List<AnzhuandanchakanBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		// 这个数组是有GroupBy的，不在jsp的table里面遍历
		List<AnzhuandanchakanBean> list2 = query2.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		ActionContext.getContext().put("list", list);
		ActionContext.getContext().put("list2", list2);
		return "toKaianzhuangdan";
	}

	@Test
	public void tt() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT             " + " 	SB.bill_code AS a,    "
				+ " 	SB.bill_date AS b,                   "
				+ " 	E.est_name AS c,                     "
				+ " 	BB.linkman AS d,                     "
				+ " 	BB.phone AS e,                       "
				+ " 	BB.bill_code AS f,                   "
				+ " 	BBI.finished_content AS g,           "
				+ " 	BBI.pro_name AS h,                   "
				+ " 	BBI.specification AS i,              "
				+ " 	BBI.make_require AS j,               "
				+ " 	BBI.amount AS k,                     "
				+ " 	BB.mark AS l,                        "
				+ " 	SB.setu_name_str AS m,               "
				+ " 	SB.addr AS n,                        "
				+ " 	SB.cost AS o,                        "
				+ " 	SB.mng_name AS p,                    "
				+ " 	SB.plan_date AS q,                   "
				+ " 	SB.rema_cost AS r,                   "
				+ " 	SB.need_car AS s,                    "
				+ " 	SB.requ AS t,                        "
				+ " 	SB.mark AS u,                        "
				+ " 	SB.crea_name AS v,                   "
				+ " 	SB.crea_time AS w,                   "
				+ " 	SB.exam_name AS x,                   "
				+ " 	SB.exam_time AS y,                   "
				+ " 	MT.type_name AS z,                   "
				+ " 	TS.title AS tallySet                 "
				+ " FROM                                  "
				+ " 	establishment AS E,                  "
				+ " 	business_bill AS BB,                 "
				+ " 	setu_bill AS SB,                     "
				+ " 	business_bill_ext AS BBE,            "
				+ " 	business_bill_item_ext AS BBIE,      "
				+ " 	business_bill_item AS BBI,           "
				+ " 	make_type AS MT,                     "
				+ " 	tally_set AS TS                      "
				+ " WHERE                                 "
				+ " 	SB.bb_id = BB.id                     "
				+ " AND BB.client_id = E.id               "
				+ " AND BB.tally_set_id = 2               "
				+ " AND BB.tally_set_id = 2               "
				+ " AND BBE.id = BB.id                    "
				+ " AND BBI.id = BBIE.id                  "
				+ " AND BBI.bill_id = BB.id               "
				+ " AND SB.bill_code ='AZ(2)2017120004'   "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id";
		Query query = session.createNativeQuery(sql);
		// 这个数组是没有groupBy的
		List<AnzhuandanchakanBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		for (AnzhuandanchakanBean anzhuandanchakanBean : list) {
			System.out.println(anzhuandanchakanBean);

		}
	}
}
