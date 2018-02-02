package com.erp.controller.mgr;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.erp.controller.vto.LoginVTOw;
import com.erp.controller.vto.MessageSendAndReceiveVTOw;
import com.erp.model.dao.AccessoryDAOw;
import com.erp.model.dao.MessageDAO;
import com.erp.model.dao.MessageDAOw;
import com.erp.model.vo.MessageVO;

/**
 @author： 半缘修道半缘君    @time：2017年8月30日 上午11:50:38 
 **************************************************************************************************************************************
 @说明： Mgr：处理具体的业务
 **************************************************************************************************************************************/
public class MessageMgr {
	private MessageDAOw messageDAO = new MessageDAOw();
	private MessageSendAndReceiveVTOw messageSendAndReceiveVTO = new MessageSendAndReceiveVTOw();
	private AccessoryDAOw accessoryDAO = new AccessoryDAOw();

	public AccessoryDAOw getAccessoryDAO() {
		return accessoryDAO;
	}

	public void setAccessoryDAO(AccessoryDAOw accessoryDAO) {
		this.accessoryDAO = accessoryDAO;
	}

	public MessageDAOw getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAOw messageDAO) {
		this.messageDAO = messageDAO;
	}

	public MessageSendAndReceiveVTOw getMessageSendAndReceiveVTO() {
		return messageSendAndReceiveVTO;
	}

	public void setMessageSendAndReceiveVTO(MessageSendAndReceiveVTOw messageSendAndReceiveVTO) {
		this.messageSendAndReceiveVTO = messageSendAndReceiveVTO;
	}

	// 获得当前登录用户在user表中以编辑者身份拥有的id即：staffer_id
	public Long getStafferID() {
		LoginVTOw loginVTO = (LoginVTOw) ServletActionContext.getRequest().getAttribute("loginVTO");
		return loginVTO.getStafferID();
	}

	// @说明：获得message表中当前登陆用户的提示信息
	public List<MessageVO> getMessage() {
		return messageDAO.getMessage(getStafferID());
	}

	public List<MessageVO> findAllMessageVOsAndSendDeleteIsN;

	public List<MessageVO> getFindAllMessageVOsAndSendDeleteIsN() {
		return findAllMessageVOsAndSendDeleteIsN;
	}

	public void setFindAllMessageVOsAndSendDeleteIsN(
			List<MessageVO> findAllMessageVOsAndSendDeleteIsN) {
		this.findAllMessageVOsAndSendDeleteIsN = findAllMessageVOsAndSendDeleteIsN;
	}

	/**
	 * @author fu 获取发送消息的即刻时间方法
	 * @return
	 */
	public Date getNowDate() {
		Calendar Cld = Calendar.getInstance();

		int YY = Cld.get(Calendar.YEAR);
		int MM = Cld.get(Calendar.MONTH) + 1;
		int DD = Cld.get(Calendar.DATE);
		int HH = Cld.get(Calendar.HOUR_OF_DAY);
		int mm = Cld.get(Calendar.MINUTE);
		int SS = Cld.get(Calendar.SECOND);
		int MI = Cld.get(Calendar.MILLISECOND);
		// String curTime = YY + MM + DD + HH + mm + SS + MI;

		Calendar cal = Calendar.getInstance();
		java.util.Date date = cal.getTime();
		System.out.println(date);
		return date;
	}

	// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
	public void save(MessageVO messageVO1) throws Exception {
		// 找最大ID值，在message表里面
		messageVO1.setTitle(messageVO1.getTitle());// 。。。。。。。。。。
		messageVO1.setContent(messageVO1.getContent());// 。。。。。。。。
		// 获取登录者的名字和ID（这里先假设）
		// TODO
		messageVO1.setSenderId(51);
		messageVO1.setSenderName("杨海波");
		// sendDate来自于上方家假设值
		messageVO1.setSendTime(getNowDate());// 。。。。。。。。。。。。。。
		messageVO1.setReceiverName("杨海波");
		messageVO1.setSenderDelete("N");// 。。。。。。。。。。
		messageVO1.setHasAttach("N");// 。。。。。。。。。。
		messageVO1.setRelationId(0);// 。。。。。。。。。。
		messageDAO.save(messageVO1);
	}

	public List<MessageVO> findAllMessageVOsAndSendDeleteIsN() {
		return messageDAO.findAllMessageVOsAndSendDeleteIsN();
	}

	public void deleteHasSendMessageById(long id) {
		messageDAO.deleteHasSendMessage(id);
	}

	/*
	 * 
	 * 收件箱
	 */
	public List<MessageVO> findAllMessageVOsAndReceiverDeleteIsN() {
		return messageDAO.findAllMessageVOsAndReceiverDeleteIsN();
	}

	@Test
	public void test() {
		messageDAO.findAllMessageVOsAndReceiverDeleteIsN();
		for (MessageVO messageVO : findAllMessageVOsAndSendDeleteIsN) {
			System.out.println(messageVO);

		}
	}

	public void ReplyByWhoSenderId(MessageVO messageVO) throws Exception {
		MessageVO messageVO1 = new MessageVO();
		messageVO1.setTitle(messageVO.getTitle());// 。。。。。。。。。。
		messageVO1.setContent(messageVO.getContent());// 。。。。。。。。
		// 获取登录者的名字和ID（这里先假设）
		// TODO
		messageVO1.setSenderId(51);
		messageVO1.setSenderName("杨海波");
		// sendDate来自于上方家假设值
		messageVO1.setSendTime(getNowDate());// 。。。。。。。。。。。。。。
		messageVO1.setReceiverName("杨海波");
		messageVO1.setSenderDelete("N");// 。。。。。。。。。。
		messageVO1.setHasAttach("N");// 。。。。。。。。。。
		messageVO1.setRelationId(0);// 。。。。。。。。。。
		messageDAO.save(messageVO1);
	}

	/**
	 * @param id
	 * @throws Exception
	 */
	public void deleteReceiverById(long id) throws Exception {
		messageDAO.deleteReceiverById(id);
	}
}
