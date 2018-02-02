package com.erp.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.MessageVO;

/**
 * @author： 半缘修道半缘君 @time：2017年8月30日 下午12:07:49
 **************************************************************************************************************************************
 @说明： 实现查找用户信息的DAO层
 **************************************************************************************************************************************/
public class MessageDAOw extends BaseDAOw<MessageVO> {

	// 传入：User表中的staffer_id，获得message_receiver:Mess表中的receiver_id,由于Mess表的receiver_id=User.staffer_id，从而获得Mess表中：messageID
	@SuppressWarnings("unchecked")
	List<Long> getMessageID(Long stafferID) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<Long> messgaeID = session
				.createQuery(
						"select m.messageId from MessageReceiverVO m,UserVO u where m.receiverId=u.stafferId and u.stafferId='"
								+ stafferID + "' ").list();
		session.close();
		return messgaeID;
	}

	// 获得message表中当前登陆用户的提示信息
	public List<MessageVO> getMessage(Long stafferID) {
		// 保存查找的结果信息
		List<MessageVO> messageResults = new ArrayList<MessageVO>();
		// 保存查找message表中用户提示信息需要的信息id
		List<Long> messgetID = this.getMessageID(stafferID);
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		for (int i = 0; i < messgetID.size(); i++) {
			MessageVO m = (MessageVO) session.createQuery(
					"from MessageVO where id='" + messgetID.get(i) + "' ").uniqueResult();
			messageResults.add(m);
		}
		return messageResults;
	}

	/*
	 * 
	 * @byfu
	 */

	public List<MessageVO> findAllMessageVOsAndSendDeleteIsN() {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		List<MessageVO> messageVOs = session.createQuery(
				"FROM MessageVO where senderId=51 and senderDelete='N'").list();
		session.close();
		return messageVOs;
	}

	/**
	 * @author fu 删除已发信息
	 * @param id
	 */
	public void deleteHasSendMessage(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		// id已获得
		System.out.println(id);
		session.createQuery("update MessageVO m set m.senderDelete='Y' where m.id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();
	}

	/**
	 * @author fu 获取当前id的最大值
	 * @return
	 */
	public long findMaxId() {

		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		String hql = " select id from MessageVO where id=(select max(id) from MessageVO) ";

		Object id = session.createQuery(hql).uniqueResult();
		session.getTransaction().commit();
		return (long) id;
	}

	/**
	 * @author fu
	 *         根据登陆者ID（receiver_id）和messagereceiver里面的是否删除（receiverDelete）查找接收到的未删除信息
	 *         收件箱
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MessageVO> findAllMessageVOsAndReceiverDeleteIsN() {
		Session session = HibernateUtils.getSession();
		Criteria criteria2 = session.createCriteria(MessageVO.class);
		Collection<Long> ReceiverDeleteIsY = new ArrayList<Long>();

		Query query = session
				.createQuery("select m.messageId from MessageReceiverVO  m  where m.receiverDelete='N'");
		ReceiverDeleteIsY = query.list();
		// 这里假设登录的人是杨海波
		long senderId = 51;
		criteria2.add(Restrictions.like("senderId", senderId));
		criteria2.add(Restrictions.like("senderDelete", "N"));
		criteria2.add(Restrictions.not(Restrictions.in("id", ReceiverDeleteIsY)));
		List<CooperBillVO> cooperBillVOs = criteria2.list();
		List<MessageVO> messageVOs = criteria2.list();
		session.close();
		return messageVOs;
	}

	/**
	 * @param id
	 */
	public void deleteReceiverById(long id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		// id已获得
		System.out.println(id);
		session.createQuery("update MessageVO m set m.senderDelete='Y' where m.id='" + id + "'")
				.executeUpdate();
		session.getTransaction().commit();

	}

}
