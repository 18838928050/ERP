/**
 * 
 */
package com.erp.controller.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import com.erp.controller.vto.AnzhuangdannVTO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.AnzhuandanchakanBean;
import com.erp.model.vo.AzhuangdanchakanBean;
import com.erp.model.vo.fBean;
import com.erp.model.vo.mBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：fu
 * @date 2017年12月31日 下午10:28:50 一份耕耘，一份收获*****
 */
public class AnzhuangdanyilanbiaooAction extends BaseAction<AnzhuangdannVTO> {
	public String findAll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT      " + "SB.bill_code AS a,            "
				+ "SB.bill_date AS b,            " + "E.est_name AS c,              "
				+ "BB.bill_code AS d,            " + "SB.cost AS e,                 "
				+ "SB.plan_date AS f,            " + "SB.real_date AS g,            "
				+ "SB.addr AS h,                 " + "SB.setu_name_str AS i,        "
				+ "SB.mng_name AS j,             " + "SB.crea_name AS k,            "
				+ "SB.exam AS l,                 " + "SB.comp AS m                  "
				+ "FROM                          " + "	business_bill AS BB,        "
				+ "	business_bill_ext AS BBE,   " + "	establishment AS E,         "
				+ "	setu_bill AS SB             " + "WHERE                         "
				+ "	BBE.id = BB.ID              " + "AND BB.client_id = E.ID       "
				+ "AND BBE.examined = 'Y'        " + "AND BBE.enabled = 'Y'         "
				+ "AND BB.tally_set_id = 2       " + "AND SB.enab = 'Y'             "
				+ "GROUP BY                      " + "SB.bill_code                  ";
		Query query = session.createNativeQuery(sql);
		List<mBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(mBean.class)).list();
		ActionContext.getContext().put("list", list);
		return "toFindAll";

	}

	// 已审核过的进行反审核
	public String notexamined2() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String SBbillCode = model.getAnAzhuangdanchakanBean().getA();
		String sql = "update  setu_bill  set exam='N' where bill_code='" + SBbillCode + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toList";
	}

	// 未审核的进行审核
	public String examined2() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String SBbillCode = model.getAnAzhuangdanchakanBean().getA();
		String sql = "update  setu_bill  set exam='Y' where bill_code='" + SBbillCode + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toList";
	}

	// 安装单未审核，点击未审核，进入此,toChakan
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

	// 安装单已审核，点击已审核，进入此,toChakan2
	public String chakan2() {
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
		return "toChakan2";
	}

	// 对未完工的进行完工查看
	public String wangong() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sBbillCode = model.getfBean().getA();
		String sql = "SELECT                   " + " SB.bill_code AS a,                   "
				+ " SB.bill_date AS b,                   "
				+ " BB.bill_code AS c,                   "
				+ " E.est_name AS d,                     "
				+ " SB.setu_name_str AS e,               "
				+ " SB.cost AS f                         "
				+ " FROM                                 "
				+ " setu_bill AS SB ,                    "
				+ " business_bill AS BB ,                "
				+ " establishment AS E                   "
				+ " WHERE                                "
				+ " SB.bb_id = BB.ID AND                 "
				+ " BB.client_id = E.ID AND              " + " SB.bill_code = '" + sBbillCode
				+ "'     ";
		Query query = session.createNativeQuery(sql);
		List<fBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(fBean.class)).list();
		ActionContext.getContext().put("list", list);
		String compTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Date date = new Date();
		compTime = sdf.format(date);
		ActionContext.getContext().put("compTime", compTime);
		return "toWangongjsp";

	}

	// 对未完工的进行完工
	public String wangongg() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String compTime;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Date date = new Date();
		compTime = sdf.format(date);
		String SBbillCode = model.getfBean().getA();
		String sql = "update setu_bill set comp='Y',comp_time='" + compTime + "' where bill_code='"
				+ SBbillCode + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toFirstUI";
	}

	// 对未完工的进行完工
	public String fanwanggongg() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();

		String SBbillCode = model.getfBean().getA();
		String sql = "update setu_bill set comp='N',comp_time=null where bill_code='" + SBbillCode
				+ "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toFirstUI";
	}

	public String wangongbiaochakan() {

		String a = model.getfBean().getA();
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT 	SB.bill_code AS a,	SB.bill_date AS b,	E.est_name AS c,	BB.linkman AS d,	BB.phone AS e,"
				+ "	BB.bill_code AS f,	BBI.finished_content AS g,	BBI.pro_name AS h,	BBI.specification AS i,"
				+ "	BBI.make_require AS j,	BBI.amount AS k,	BB.mark AS l,	SB.setu_name_str AS m,	SB.addr AS n,	SB.cost AS o,"
				+ " SB.mng_name AS p,	SB.plan_date AS q,	SB.rema_cost AS r,	SB.need_car AS s,	SB.requ AS t,"
				+ "	SB.mark AS u,	SB.crea_name AS v,	SB.crea_time AS w,	SB.exam_name AS x,	SB.exam_time AS y,"
				+ "	MT.type_name AS z,	TS.title AS tallySet FROM 	establishment AS E,	business_bill AS BB,"
				+ "	setu_bill AS SB,	business_bill_ext AS BBE,	business_bill_item_ext AS BBIE,	business_bill_item AS BBI,"
				+ "	make_type AS MT,	tally_set AS TS WHERE	SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND SB.enab = 'Y'"
				+ " AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBI.id = BBIE.id AND BBI.bill_id = BB.id"
				+ " AND SB.bill_code = '"
				+ a
				+ "' "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id";
		String sql2 = "SELECT 	SB.bill_code AS a,	SB.bill_date AS b,	E.est_name AS c,	BB.linkman AS d,	BB.phone AS e,"
				+ "	BB.bill_code AS f,	BBI.finished_content AS g,	BBI.pro_name AS h,	BBI.specification AS i,"
				+ "	BBI.make_require AS j,	BBI.amount AS k,	BB.mark AS l,	SB.setu_name_str AS m,	SB.addr AS n,	SB.cost AS o,"
				+ " SB.mng_name AS p,	SB.plan_date AS q,	SB.rema_cost AS r,	SB.need_car AS s,	SB.requ AS t,"
				+ "	SB.mark AS u,	SB.crea_name AS v,	SB.crea_time AS w,	SB.exam_name AS x,	SB.exam_time AS y,"
				+ "	MT.type_name AS z,	TS.title AS tallySet FROM 	establishment AS E,	business_bill AS BB,"
				+ "	setu_bill AS SB,	business_bill_ext AS BBE,	business_bill_item_ext AS BBIE,	business_bill_item AS BBI,"
				+ "	make_type AS MT,	tally_set AS TS WHERE	SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND SB.enab = 'Y'"
				+ " AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBI.id = BBIE.id AND BBI.bill_id = BB.id"
				+ " AND SB.bill_code = '"
				+ a
				+ "' "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id GROUP BY SB.bill_code";

		Query query = session.createNativeQuery(sql);
		Query query2 = session.createNativeQuery(sql2);
		// 这个数组是没有groupBy的
		List<AnzhuandanchakanBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		// 这个数组是有GroupBy的，不在jsp的table里面遍历
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<AnzhuandanchakanBean> list2 = query2.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		ActionContext.getContext().put("list", list);
		ActionContext.getContext().put("list2", list2);

		return "anzhuangdanchakan";
	}

	public String tuichu() {
		return "toFirstUI";

	}

	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT 	SB.bill_code AS a,	SB.bill_date AS b,	E.est_name AS c,	BB.linkman AS d,	BB.phone AS e,"
				+ "	BB.bill_code AS f,	BBI.finished_content AS g,	BBI.pro_name AS h,	BBI.specification AS i,"
				+ "	BBI.make_require AS j,	BBI.amount AS k,	BB.mark AS l,	SB.setu_name_str AS m,	SB.addr AS n,	SB.cost AS o,"
				+ " SB.mng_name AS p,	SB.plan_date AS q,	SB.rema_cost AS r,	SB.need_car AS s,	SB.requ AS t,"
				+ "	SB.mark AS u,	SB.crea_name AS v,	SB.crea_time AS w,	SB.exam_name AS x,	SB.exam_time AS y,"
				+ "	MT.type_name AS z,	TS.title AS tallySet FROM 	establishment AS E,	business_bill AS BB,"
				+ "	setu_bill AS SB,	business_bill_ext AS BBE,	business_bill_item_ext AS BBIE,	business_bill_item AS BBI,"
				+ "	make_type AS MT,	tally_set AS TS WHERE	SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND SB.enab = 'Y'"
				+ " AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBI.id = BBIE.id AND BBI.bill_id = BB.id"
				+ " AND SB.bill_code = 'AZ(2)2017120004' "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id";
		String sql2 = "SELECT 	SB.bill_code AS a,	SB.bill_date AS b,	E.est_name AS c,	BB.linkman AS d,	BB.phone AS e,"
				+ "	BB.bill_code AS f,	BBI.finished_content AS g,	BBI.pro_name AS h,	BBI.specification AS i,"
				+ "	BBI.make_require AS j,	BBI.amount AS k,	BB.mark AS l,	SB.setu_name_str AS m,	SB.addr AS n,	SB.cost AS o,"
				+ " SB.mng_name AS p,	SB.plan_date AS q,	SB.rema_cost AS r,	SB.need_car AS s,	SB.requ AS t,"
				+ "	SB.mark AS u,	SB.crea_name AS v,	SB.crea_time AS w,	SB.exam_name AS x,	SB.exam_time AS y,"
				+ "	MT.type_name AS z,	TS.title AS tallySet FROM 	establishment AS E,	business_bill AS BB,"
				+ "	setu_bill AS SB,	business_bill_ext AS BBE,	business_bill_item_ext AS BBIE,	business_bill_item AS BBI,"
				+ "	make_type AS MT,	tally_set AS TS WHERE	SB.bb_id = BB.id AND BB.client_id = E.id AND BB.tally_set_id = 2 AND SB.enab = 'Y'"
				+ " AND BB.tally_set_id = 2 AND BBE.examined = 'Y' AND BBE.id = BB.id AND BBI.id = BBIE.id AND BBI.bill_id = BB.id"
				+ " AND BBIE.maked = 'Y'  AND SB.bill_code = 'AZ(2)2017080001' "
				+ " AND BBI.make_type_id = MT.id AND BB.tally_set_id = TS.id GROUP BY SB.bill_code";

		Query query = session.createNativeQuery(sql);
		// Query query2 = session.createNativeQuery(sql2);
		// 这个数组是没有groupBy的
		List<AnzhuandanchakanBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
		for (AnzhuandanchakanBean anzhuandanchakanBean : list) {
			System.out.println(anzhuandanchakanBean);

		}
		// // 这个数组是有GroupBy的，不在jsp的table里面遍历
		// List<AnzhuandanchakanBean> list2 = query2.unwrap(SQLQuery.class)
		// .setResultTransformer(Transformers.aliasToBean(AnzhuandanchakanBean.class)).list();
	}
}
