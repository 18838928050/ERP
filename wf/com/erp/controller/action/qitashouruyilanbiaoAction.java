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

import com.erp.controller.vto.qitashouruVTOO;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.iBean;
import com.erp.model.vo.qitashourufangshenheBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author：fu
 * @date 2017年12月21日 下午12:45:36 一份耕耘，一份收获*****
 */
public class qitashouruyilanbiaoAction extends BaseAction<qitashouruVTOO> {
	public String findAll() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "SELECT 	IC.bill_code AS a,	BA.bank_name AS b,	IC.income_date AS c,	IC.payer_name AS d,	IC.cost AS e,"
				+ "	IC.mark AS f,	IC.manager_name AS g,IC.creater_name AS h,	IC.examined AS i FROM 	income_bill AS IC,"
				+ "	bank_account AS BA WHERE IC.tally_set_id = 2 AND IC.bank_account_id = BA.ID ";
		Query query = session.createNativeQuery(sql);
		List<iBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(iBean.class)).list();
		ActionContext.getContext().put("list", list);
		return "toFindAll";
	}

	public String fanshenhechakan() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getiBean().getA();
		System.out.println(billCode + "0000000000000000000000000");
		String sqlString = "SELECT 	IB.bill_code AS a,	IB.income_date AS b,	IB.payer_name AS c,	IB.manager_name AS d,"
				+ "	D.department_name AS e,	BA.bank_name AS f,	IB.cost AS g,	IB.creater_name AS h,	IB.create_time AS hh,"
				+ "	IB.examiner_name AS i,	IB.examine_time AS ii,	T.title AS j ,IB.mark AS k FROM 	income_bill AS IB,	department AS D,"
				+ "	bank_account AS BA,	tally_set AS T WHERE 	IB.department_id = D.ID AND IB.bank_account_id = BA.ID"
				+ " AND IB.tally_set_id = T.ID AND IB.bill_code = '" + billCode + "'";
		Query query = session.createNativeQuery(sqlString);
		List<qitashourufangshenheBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(qitashourufangshenheBean.class))
				.list();
		ActionContext.getContext().put("list", list);
		return "fanshenhe";
	}

	public String shenhechakan() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getiBean().getA();
		String sqlString = "SELECT 	IB.bill_code AS a,	IB.income_date AS b,	IB.payer_name AS c,	IB.manager_name AS d,"
				+ "	D.department_name AS e,	BA.bank_name AS f,	IB.cost AS g,	IB.creater_name AS h,	IB.create_time AS hh,"
				+ "	IB.examiner_name AS i,	IB.examine_time AS ii,	T.title AS j ,IB.mark AS k FROM 	income_bill AS IB,	department AS D,"
				+ "	bank_account AS BA,	tally_set AS T WHERE 	IB.department_id = D.ID AND IB.bank_account_id = BA.ID"
				+ " AND IB.tally_set_id = T.ID AND IB.bill_code = '" + billCode + "'";
		Query query = session.createNativeQuery(sqlString);
		List<qitashourufangshenheBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(qitashourufangshenheBean.class))
				.list();
		ActionContext.getContext().put("list", list);
		return "shenhe";
	}

	public String fanshenhe() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getQitashourufangshenheBean().getA();
		String sql = "update income_bill set examined='N' where bill_code='" + billCode + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toList";

	}

	public String shenhe() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getQitashourufangshenheBean().getA();
		String sql = "update income_bill set examined='Y' where bill_code='" + billCode + "'";
		session.createSQLQuery(sql).executeUpdate();
		session.getTransaction().commit();
		return "toList";

	}

	public String qitashourudan() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String billCode = model.getiBean().getA();
		String sqlString = "SELECT 	IB.bill_code AS a,	IB.income_date AS b,	IB.payer_name AS c,	IB.manager_name AS d,"
				+ "	D.department_name AS e,	BA.bank_name AS f,	IB.cost AS g,	IB.creater_name AS h,	IB.create_time AS hh,"
				+ "	IB.examiner_name AS i,	IB.examine_time AS ii,	T.title AS j ,IB.mark AS k FROM 	income_bill AS IB,	department AS D,"
				+ "	bank_account AS BA,	tally_set AS T WHERE 	IB.department_id = D.ID AND IB.bank_account_id = BA.ID"
				+ " AND IB.tally_set_id = T.ID AND IB.bill_code = '" + billCode + "'";
		Query query = session.createNativeQuery(sqlString);
		List<qitashourufangshenheBean> list = query.unwrap(SQLQuery.class)
				.setResultTransformer(Transformers.aliasToBean(qitashourufangshenheBean.class))
				.list();
		ActionContext.getContext().put("list", list);
		// 部门list2
		String hql = "from DepartmentVO";
		List<DepartmentVO> list2 = session.createQuery(hql).list();
		ActionContext.getContext().put("list2", list2);
		// 收款账户list3
		String hql2 = "from BankAccountVO";
		List<BankAccountVO> list3 = session.createQuery(hql2).list();
		ActionContext.getContext().put("list3", list3);
		return "toXiugai";
	}

	public String tuichu() {
		return "tuichu";
	}

	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = "from BankAccountVO ";
		List<BankAccountVO> list = session.createQuery(hql).list();
		System.out.println(list);
	}
}
