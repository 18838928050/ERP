/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PurchaseBillItemVO;
import com.erp.model.vo.WorkCenterVO;

/**
 * @author： 如约而至 @time：2017年9月4日 下午10:31:57
 *******************************************************************
 @说明：
 *******************************************************************/
public class EstablishmentDAOw extends BaseDAOw<EstablishmentVO> {

	public Query getQuery() {

		String sql = "select * from establishment where est_code like 'T%' and status='Y'";
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(EstablishmentVO.class);

		return query;
	}

	/**
	 * @说明：获得所有外协商
	 */
	public List<EstablishmentVO> getAllWaixie() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<EstablishmentVO> sEstablishmentVOs = session.createQuery(
				"from EstablishmentVO where estCode like 'T%'").list();
		return sEstablishmentVOs;
	}

	/**
	 * @说明：
	 */
	public List<EstablishmentVO> getByIds(List<Long> ids) {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<EstablishmentVO> establishmentVOs = new ArrayList<EstablishmentVO>();
		for (Long long1 : ids) {
			establishmentVOs.add(session.get(EstablishmentVO.class, long1));
		}
		return establishmentVOs;
	}

	/**
	 * @param listEsts
	 * @return
	 */
	public List<List<EstablishmentVO>> getEstsByPayBillIds(List<Long> listReceiverIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<List<EstablishmentVO>> e = new ArrayList<List<EstablishmentVO>>();
		List<EstablishmentVO> establishmentVOs = null;
		for (long long1 : listReceiverIds) {
			establishmentVOs = session.createQuery("from EstablishmentVO where id='" + long1 + "'")
					.list();
			e.add(establishmentVOs);
		}
		return e;
	}

	public List<EstablishmentVO> getEstblishmentSS(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<EstablishmentVO> e = new ArrayList<EstablishmentVO>();
		for (long long2 : ids) {
			e.add(session.get(EstablishmentVO.class, long2));

		}
		return e;
	}

	public EstablishmentVO getEstblishment(long receiverId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(EstablishmentVO.class);
		criteria.add(Restrictions.in("id", receiverId));
		return (EstablishmentVO) criteria.uniqueResult();
	}

	public List<EstablishmentVO> getEstsByLimits(long tallySet) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(EstablishmentVO.class);
		criteria.add(Restrictions.in("tallySetId", tallySet)).add(
				Restrictions.like("estCode", "T%"));

		return criteria.list();
	}

	public Object getEstNameByEstId(long estId) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(EstablishmentVO.class);
		criteria.add(Restrictions.in("id", estId));
		return criteria.uniqueResult();
	}

	public List<EstablishmentVO> findEstsByPbIds(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		EstablishmentVO establishmentVO = new EstablishmentVO();
		List<EstablishmentVO> establishmentVOs = new ArrayList<EstablishmentVO>();
		for (long long2 : ids) {
			establishmentVO = (EstablishmentVO) session.createQuery(
					"from EstablishmentVO where id='" + long2 + "'").uniqueResult();
			establishmentVOs.add(establishmentVO);

		}
		return establishmentVOs;
	}

	public List<EstablishmentVO> findEstsByPbIdss(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<EstablishmentVO> list = new ArrayList<EstablishmentVO>();
		for (long long2 : ids) {
			list.add(session.get(EstablishmentVO.class, long2));

		}
		return list;
	}

	public List<EstablishmentVO> findEsts(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(EstablishmentVO.class);
		criteria.add(Restrictions.in("id", ids));

		return criteria.list();
	}

	public EstablishmentVO findEstByPbId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		long id2 = (long) session.createQuery(
				"select providerId from PurchaseBillVO where id='" + id + "'").uniqueResult();
		Criteria criteria = session.createCriteria(EstablishmentVO.class);
		criteria.add(Restrictions.in("id", id2));
		return (EstablishmentVO) criteria.uniqueResult();
	}

	@Test
	public void jfj() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		// SELECT bb.bill_code FROM business_bill AS bb,business_bill_ext AS bbe
		// WHERE bb.id = bbe.id AND bbe.collected = "N" AND bbe.setuped = "N"
		// AND bbe.examined ="N"
		String sqlString =

		"SELECT bb.* FROM business_bill AS bb,business_bill_ext AS bbe WHERE bb.id = bbe.id AND bbe.collected='N' AND bbe.setuped = 'N' AND bbe.examined='N'";
		SQLQuery query = session.createSQLQuery(sqlString);
		query.addEntity(BusinessBillVO.class);

		List<BusinessBillVO> billVOs = query.list();
		for (BusinessBillVO businessBillVO : billVOs) {
			System.out.println(businessBillVO);
		}
		System.out.println(query.list().size());

	}

	/**
	 * @说明：自定义条件
	 */
	public List<EstablishmentVO> getEstablishmentVOsByLimits() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(EstablishmentVO.class);
		criteria.add(Restrictions.in("tallySetId", 2l));
		criteria.add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.like("estCode", "G%"));
		return criteria.list();
	}

	/**
	 * @说明：
	 */
	public void editSaveEstablistment(EstablishmentVO e) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		// create_time 先不寫
		String hql = " UPDATE EstablishmentVO  SET  " + "est_name= '" + e.getEstName()
				+ "',est_code = '" + e.getEstCode() + "',est_type_id = '" + e.getEstTypeId()
				+ "',est_level_id = '" + "" + e.getEstLevelId() + "', phone = '" + e.getPhone()
				+ "',fax = '" + e.getFax() + "',email = '" + e.getEmail() + "',web_site = " + "'"
				+ e.getWebSite() + "',area_id = '" + e.getAreaId() + "', postcode = '"
				+ e.getPostcode() + "', address = '" + e.getAddress() + "', mark = '" + e.getMark()
				+ "'," + " manager_id = '" + e.getManagerId() + "',manager_name = '"
				+ e.getManagerName() + "', enabled = '" + e.getEnabled() + "', superior_id = '"
				+ e.getSuperiorId() + "'," + " superior_id_str = '" + e.getSuperiorIdStr()
				+ "', name_spell = '" + e.getNameSpell() + "',"
				+ "	 credit_cost = '0',bank_name1 = '" + e.getBankName1() + "', bank_acc_name1 = '"
				+ e.getBankAccName1() + "', bank_acc_code1 = '" + e.getBankAccCode1() + "',"
				+ " bank_name2 = '" + e.getBankName2() + "' ,bank_acc_code2 = '"
				+ e.getBankAccCode2() + "' , bank_acc_name2 = '" + e.getBankAccName2()
				+ "', bus_cost = '" + e.getBusCost() + "', est_type = '" + e.getEstCode()
				+ "', tally_set_id = '" + e.getTallySetId() + "'," + " creater_id = '"
				+ e.getCreaterId() + "', creater_name = '" + e.getCreaterName() + "', linkman = '"
				+ e.getLinkman() + "', linkman_phone ='" + e.getLinkmanPhone() + "', status = '"
				+ e.getStatus() + "',	 busi_pphone ='" + e.getBusiPphone() + "',	 deli_pphone = "
				+ "'" + e.getDeliPphone() + "', make_pphone = '" + e.getMakePphone()
				+ "'	WHERE id = '" + e.getId() + "'	 ";
		session.createQuery(hql).executeUpdate();
		session.getTransaction().commit();
	}

	/**
	 * @说明：
	 */
	public void stop(long id, String s) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = null;
		if (s.equals("stop")) {
			sql = "update EstablishmentVO set status ='N' where id='" + id + "'";
		} else {
			sql = "update EstablishmentVO set status ='Y' where id='" + id + "'";
		}
		session.createQuery(sql).executeUpdate();
		session.getTransaction().commit();
	}

	/**
	 * @说明：
	 */
	public void deleteByMakeEnableForN(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "update EstablishmentVO set enabled ='N' where id='" + id + "'";
		session.createQuery(sql).executeUpdate();
		session.getTransaction().commit();
	}

	/**
	 * @return
	 */
	public List<EstablishmentVO> findEstss() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(EstablishmentVO.class);
		criteria.add(Restrictions.in("status", "Y"));
		criteria.add(Restrictions.in("enabled", "Y"));
		criteria.add(Restrictions.like("estCode", "G_%"));
		return criteria.list();
	}

	/**
	 * @param id
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	//这是找PBI列表的
	public List<List<PurchaseBillItemVO>> finPBISS(long id) {
		System.out.println(id);
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		// 通过供应商的establishemt.id=PB.providerId ,找到了PurchaseBillVO 的id
		List<Long> pbIds = session.createQuery("select id from PurchaseBillVO where providerId='" + id + "'").list();
		// 现在想要根据PurchaseBillItem的id去找productid。PurchaseBillItem.bill_id=PurchaseBillVO.id
		List<List<Long>> PBIbillIds = new ArrayList<List<Long>>();
		List<Long> PBIbillId = new ArrayList<>();
		for (Long long1 : pbIds) {
			PBIbillId = session.createQuery(
					"select billId from PurchaseBillItemVO where id='" + long1 + "'").list();
			PBIbillIds.add(PBIbillId);
		}
		List<Long> pbiIds = new ArrayList<Long>();
		List<List<Long>> pbiIdss = new ArrayList<List<Long>>();
		for (List<Long> list : PBIbillIds) {
			for (Long long1 : list) {
				pbiIds = session.createQuery(
						"select id from PurchaseBillItemVO where billId='" + long1 + "'").list();
				pbiIdss.add(pbiIds);
			}
		}
		List<PurchaseBillItemVO> purchaseBillItemVOs = new ArrayList<PurchaseBillItemVO>();
		List<List<PurchaseBillItemVO>> purchaseBillItemVOss = new ArrayList<List<PurchaseBillItemVO>>();
	
		for (List<Long> long1 : pbiIdss) {
			for (Long long2 : long1) {
				purchaseBillItemVOs = session.createQuery(
						"from PurchaseBillItemVO where id='" + long2 + "'").list();
				purchaseBillItemVOss.add(purchaseBillItemVOs);
			}
		}
		return purchaseBillItemVOss;

	}

	@SuppressWarnings("unchecked")
	@Test
	public void testName() throws Exception {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		// 通过供应商的establishemt.id=PB.providerId ,找到PurchaseBillVO 的id
		String hqlj = "select id from PurchaseBillVO where providerId='" + 876 + "'";
		//这是找到的PB的id
		List<Long> pbIds = session.createQuery(hqlj).list();
		// 因为PurchaseBillItem.bill_id=PurchaseBillVO.id,所以PBI的bill_id已经找到了
		//现在想要根据PurchaseBillItem的id去找productid
		List<List<Long>> PBIidSS = new ArrayList<List<Long>>();
		//找到了pbi的id
		List<Long> billidsList = new ArrayList<>();
		for (Long long1 : pbIds) {
			billidsList = session.createQuery(
					"select id from PurchaseBillItemVO where billId='" + long1 + "'").list();
			PBIidSS.add(billidsList);
		}
		List<PurchaseBillItemVO> purchaseBillItemVOs = new ArrayList<PurchaseBillItemVO>();
		List<List<PurchaseBillItemVO>> purchaseBillItemVOss = new ArrayList<List<PurchaseBillItemVO>>();
		for (List<Long> long1 : PBIidSS) {
			for (Long long2 : long1) {
				purchaseBillItemVOs = session.createQuery(
						"from PurchaseBillItemVO where id='" + long2 + "'").list();
				purchaseBillItemVOss.add(purchaseBillItemVOs);
			}
		
		System.out.println(purchaseBillItemVOs);}
	}

	/**
	 * @param eIds
	 * @return
	 */
	public List<EstablishmentVO> getEs(List<Long> eIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<EstablishmentVO> establishmentVOs = new ArrayList<>();
		for (Long long1 : eIds) {
			establishmentVOs.add((EstablishmentVO) session.createQuery(
					"from EstablishmentVO where id='" + long1 + "'").uniqueResult());
		}
		return establishmentVOs;
	}

	/**
	 * @param establishmentVOs
	 */
	public void saves(ArrayList<EstablishmentVO> establishmentVOs) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		for (EstablishmentVO establishmentVO : establishmentVOs) {
			session.save(establishmentVO);
			System.out.println("插入到Establishment成功");
		}
		session.getTransaction().commit();
	}

	/**
	 * 找出establishment表中开头为F的最大的ESTCode值
	 * 
	 * @return
	 */
	public String findEstMaxCodeLikeF() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "select max(est_code) from establishment e where e.est_code like 'F_%' ";
		String estCode = (String) session.createSQLQuery(sql).uniqueResult();
		return estCode;
	}

	public String findEstMaxCodeLikeT() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String sql = "select max(est_code) from establishment e where e.est_code like 'T_%' ";
		String estCode = (String) session.createSQLQuery(sql).uniqueResult();
		System.out.println("max est_codej,jdaskfjskadfjslakdjflksadjf" + estCode);
		return estCode;
	}

	/**
	 * @说明：
	 */
	public List<EstablishmentVO> getEByids(List<Long> ids) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<EstablishmentVO> EstablishmentVOs = new ArrayList<EstablishmentVO>();
		/*for (Long long1 : ids) {
			EstablishmentVOs.add(session.get(EstablishmentVO.class, long1));
		}*/
		return EstablishmentVOs;
	}

}
