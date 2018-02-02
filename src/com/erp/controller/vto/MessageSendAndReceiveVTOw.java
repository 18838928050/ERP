/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.AccessoryVO;
import com.erp.model.vo.MessageReceiverVO;
import com.erp.model.vo.MessageVO;

/**
 * @author fu
 *******************************************************************
 @说明 内部消息
 *******************************************************************/
public class MessageSendAndReceiveVTOw {
	private MessageVO messageVO;
	private MessageReceiverVO messageReceiverVO;
	private AccessoryVO accessoryVO;
	private List<MessageVO> messageVOs;
	private List<MessageReceiverVO> messageReceiverVOs;

	public MessageReceiverVO getMessageReceiverVO() {
		return messageReceiverVO;
	}

	public void setMessageReceiverVO(MessageReceiverVO messageReceiverVO) {
		this.messageReceiverVO = messageReceiverVO;
	}

	public List<MessageReceiverVO> getMessageReceiverVOs() {
		return messageReceiverVOs;
	}

	public void setMessageReceiverVOs(List<MessageReceiverVO> messageReceiverVOs) {
		this.messageReceiverVOs = messageReceiverVOs;
	}

	public List<MessageVO> getMessageVOs() {
		return messageVOs;
	}

	public void setMessageVOs(List<MessageVO> messageVOs) {
		this.messageVOs = messageVOs;
	}

	public AccessoryVO getAccessoryVO() {
		return accessoryVO;
	}

	public void setAccessoryVO(AccessoryVO accessoryVO) {
		this.accessoryVO = accessoryVO;
	}

	public MessageVO getMessageVO() {
		return messageVO;
	}

	public void setMessageVO(MessageVO messageVO) {
		this.messageVO = messageVO;
	}

}
