package com.erp.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.erp.model.utils.HibernateUtils;
import com.erp.model.vo.MessageVO;

/**
 @author： 半缘修道半缘君    @time：2017年8月30日 下午12:07:49 
 **************************************************************************************************************************************
 @说明： 实现查找用户信息的DAO层
 **************************************************************************************************************************************/
public class MessageDAO extends BaseDAO<MessageVO>{


	//传入：User表中的staffer_id，获得message_receiver:Mess表中的receiver_id,由于Mess表的receiver_id=User.staffer_id，从而获得Mess表中：messageID
	 @SuppressWarnings("unchecked")
	List<Long> getMessageID (Long stafferID){
		 Session session=HibernateUtils.getSession();
		 session.beginTransaction();
		 List<Long> messgaeID= (List<Long>)session.createQuery("select m.messageId from MessageReceiverVO m,UserVO u where m.receiverId=u.stafferId and u.stafferId='"+stafferID+"' ").list();
		 session.close();
		return messgaeID;
	}
	
	
	//获得message表中当前登陆用户的提示信息
	public List<MessageVO> getMessage(Long stafferID) {
		//保存查找的结果信息
		List<MessageVO> messageResults=new ArrayList<MessageVO>();
		//保存查找message表中用户提示信息需要的信息id
		List<Long> messgetID=this.getMessageID(stafferID);
		 Session session=HibernateUtils.getSession();
		 session.beginTransaction();
		 for (int i = 0; i < messgetID.size(); i++) {
			   MessageVO m= (MessageVO) session.createQuery("from MessageVO where id='"+messgetID.get(i)+"' ").uniqueResult();
			   messageResults.add(m);
		}
		 session.close();
		return messageResults;
	}
}
