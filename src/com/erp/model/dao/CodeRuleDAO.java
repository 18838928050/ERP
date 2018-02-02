package com.erp.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.CodeRule;

/**
 * 编码规则
 * @author JiaQi
 *
 */
public class CodeRuleDAO extends BaseDAO<CodeRule>{
	
	/**
	 * 获取所有主数据编码规则
	 */
	public List<CodeRule> findAllCodeRuleMain(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<CodeRule> list= session.createQuery("from CodeRule where tallySetRule is null or tallySetRule = ''").list();
		session.close();
		return list;
	}
	
	/**
	 * 获取打印编号规则
	 */
	public List<CodeRule> findAllCodeRulePrint(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		List<CodeRule> list= session.createQuery("from CodeRule where tallySetRule = ?").setString(0, "INDEPENDENCE").list();
		session.close();
		return list;
	}
}
