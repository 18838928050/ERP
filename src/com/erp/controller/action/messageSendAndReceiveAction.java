/**
 * 
 */
package com.erp.controller.action;

import java.io.File;
import java.util.List;

import com.erp.controller.action.BaseAction;
import com.erp.controller.mgr.MessageMgr;
import com.erp.controller.vto.MessageSendAndReceiveVTOw;
import com.erp.model.vo.MessageVO;

/**
 * 消息
 * 
 * @author fu
 *
 */
@SuppressWarnings("serial")
public class messageSendAndReceiveAction extends BaseAction<MessageSendAndReceiveVTOw> {
	private MessageMgr messageMgr = new MessageMgr();
	private long senderId = 51;

	public String left() throws Exception {
		return "left";
	}

	public String right() throws Exception {
		return "right";
	}

	public String toIndex() {
		return "toIndex";

	}

	private String username;
	private File file;

	// 提交过来的file的名字
	private String fileFileName;

	// 提交过来的file的MIME类型
	private String fileContentType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * 这里是发送信息模块，有图片上传
	 * 
	 * @author fu
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		// 注释部分打开就能用
		/*
		 * String root =
		 * ServletActionContext.getServletContext().getRealPath("/upload");
		 * InputStream is = new FileInputStream(file); OutputStream os = new
		 * FileOutputStream(new File(root, fileFileName));
		 * System.out.println("保存路径：" +
		 * ServletActionContext.getServletContext().getRealPath("/upload"));
		 * System.out.println("上传图片成功！"); byte[] buffer = new byte[500]; int
		 * length = 0; while (-1 != (length = is.read(buffer, 0,
		 * buffer.length))) { os.write(buffer); } os.close(); is.close();
		 */
		messageMgr.save(model.getMessageVO());
		return "toFaJianXiangUI";
	}

	/**
	 * 发件箱
	 * 
	 * @author fu 这里是查询发件箱模块，查询发送者没有删除的信息，send_delete是N的，就是没有被删除的
	 * @return
	 */
	public String findAllMessageVOsAndSendDeleteIsN() {
		List<MessageVO> messageVOs = messageMgr.findAllMessageVOsAndSendDeleteIsN();
		model.setMessageVOs(messageVOs);
		return "toFaJianXiang";
	}

	/*
	 * 收件箱
	 */
	public String findAllMessageVOsAndReceiverDeleteIsN() {
		List<MessageVO> messageVOs = messageMgr.findAllMessageVOsAndReceiverDeleteIsN();
		model.setMessageVOs(messageVOs);
		return "toShouJianXiang";

	}

	/*
	 * 转到写消息界面
	 */
	public String toWriteMessageUI() {
		return "toWriteMessageUI";
	}

	/**
	 * 修改数据库中的senderDelete="Y",因查找出的是等于“N"的数据
	 * 
	 * @return
	 */
	public String deleteHasSendMessageById() {
		System.out.println("model.getMessageVO().getId()........................."
				+ model.getMessageVO().getId());
		messageMgr.deleteHasSendMessageById(model.getMessageVO().getId());
		System.out.println("删除信息成功");
		return "toFaJianXiangUI";
	}

	/**
	 * @author fu
	 * @throws Exception
	 * @说明：回复（回复给发送者），通过发送者的id 这里假设发送者的id是51
	 */
	public String ReplyByWhoSenderId() throws Exception {
		return "toReplyUI";
	}

	// 跳转到reply页面
	public String Reply() throws Exception {
		System.out.println(model.getMessageVO());
		messageMgr.ReplyByWhoSenderId(model.getMessageVO());
		return "toShouJianXiangUI";
	}

	public String deleteReceiveMessageById() throws Exception {
		System.out.println(model.getMessageVO().getId() + ",,,,,,,,,,,,,,,,,,,,,,");
		messageMgr.deleteReceiverById(model.getMessageVO().getId());
		return "toShouJianXiangUI";

	}
}
