package com.erp.controller.action;

import java.util.List;

import com.erp.controller.mgr.MessageMgr;
import com.erp.model.vo.MessageVO;

/**
 @author： 半缘修道半缘君    @time：2017年8月30日 上午10:53:55 
 **************************************************************************************************************************************
 @说明： 用户首次登陆到主页面时的开工等信息提醒
 **************************************************************************************************************************************/
@SuppressWarnings("serial")
public class MessageAction extends BaseAction<MessageVO>{
	private  MessageMgr messageMar=new MessageMgr();
	public String execute() throws Exception {
		//保存查找的所有消息结果
		/*List<MessageVO> messageVOs=messageMar.getMessage();
		//输出当前用户应该接收到的所有信息结果
		for (MessageVO messageVO : messageVOs) {
			System.out.println(messageVO);
		}*/
		return "main";
	}
}
