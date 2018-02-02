package com.erp.controller.phone.vto;


import com.erp.controller.phone.vo.PhoneBookVO;

/**
 * 通讯录 逻辑处理
 * @author guo
 *
 */
public class PhoneVTO {

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//	联系人
	private PhoneBookVO phoneBook;

	public PhoneBookVO getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(PhoneBookVO phoneBook) {
		this.phoneBook = phoneBook;
	}

}