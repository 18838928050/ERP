/**
 * 
 */
package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.dao.BaseDAOw;
import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.BusinessBillVO;

/**
 * @author： 如约而至 @time：2017年9月13日 下午7:10:41
 *******************************************************************
 @说明：
 *******************************************************************/
public class BusinessBillItemDAOw extends BaseDAOw<BusinessBillItemVO> {

	/**
	 * @说明：由bill_id得到BBI
	 */
	@SuppressWarnings("unchecked")
	public List<BusinessBillItemVO> getBusinessBillItemByBillId(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		return session.createQuery("from BusinessBillItemVO where billId='" + id + "'").list();
	}

	/**
	 * @说明：
	 */
	public List<BusinessBillItemVO> getBusinessBillItemByBillId(long id, String string) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		return session.createQuery(
				"from BusinessBillItemVO where billId='" + id + "' and priceType='" + string + "'")
				.list();
	}

	/**
	 * @说明：更新多个BBI
	 */
	public void updateBusinessBillItems(List<BusinessBillItemVO> all) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Integer updateNum = 0;
		for (BusinessBillItemVO b : all) {
			String hql = "update BusinessBillItemVO set makeRequire= '" + b.getMakeRequire()
					+ "',	billId='" + b.getBillId() + "',	amount='" + b.getAmount()
					+ "',unitPrice='" + b.getUnitPrice() + "',	cost='" + b.getCost()
					+ "',	makeTypeId='" + b.getMakeTypeId() + "',length='" + b.getLength()
					+ "',width='" + b.getWidth() + "',	squareNum='" + b.getSquareNum()
					+ "',	specification='" + b.getSpecification() + "',	finishedContent='"
					+ b.getFinishedContent() + "',unit='" + b.getUnit() + "',	priceType='"
					+ b.getPriceType() + "',	isCoop='" + b.getIsCoop() + "',wcId='" + b.getWcId()
					+ "',proName='" + b.getProName() + "',	lengType='" + b.getLengType()
					+ "',proId='" + b.getProId() + "',isSetu='" + b.getIsSetu() + "' where id='"
					+ b.getId() + "'";
			updateNum += session.createQuery(hql).executeUpdate();
		}
		session.getTransaction().commit();
		System.out.println("更新条数：" + updateNum);
	}

	/**
	 * @说明：
	 */
	public List<BusinessBillItemVO> getBusinessBillItemByBillIdfor(List<Long> ids) {
		for (Long long1 : ids) {
			System.out.println(long1);
		}
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BusinessBillItemVO> bb = new ArrayList<BusinessBillItemVO>();

		return bb;
	}

	/**
	 * @param bbiIds
	 * @return
	 */
	public List<BusinessBillItemVO> getbbis(List<Long> bbiIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BusinessBillItemVO> billItemVOs = new ArrayList<>();
		for (Long long1 : bbiIds) {
			billItemVOs.add((BusinessBillItemVO) session.createQuery(
					"from BusinessBillItemVO where id='" + long1 + "'").uniqueResult());
		}
		return billItemVOs;
	}

	/**
	 * @param bbIds
	 * @return
	 */
	public List<BusinessBillVO> getBbs(List<Long> bbIds) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<BusinessBillVO> billVOs = new ArrayList<>();
		for (Long long1 : bbIds) {
			billVOs.add((BusinessBillVO) session.createQuery(
					"from BusinessBillVO where id='" + long1 + "'").uniqueResult());

		}
		// TODO Auto-generated method stub
		return billVOs;
	}

}
