package com.erp.controller.basedata.mgr;

import java.util.List;

import com.erp.model.dao.AccessoryMarkDAO;
import com.erp.model.vo.AccessoryMark;

/**
 * 文件说明
 * @author JiaQi
 *
 */
public class AccessoryMarkMgr {
	private AccessoryMarkDAO accessoryMarkDAO = new AccessoryMarkDAO();
	
	/**
	 * 获取全部
	 * @return
	 */
	public List<AccessoryMark> findAll() {
		List<AccessoryMark> accessoryMarks = null;
		try {
			accessoryMarks = accessoryMarkDAO.findAll();
		} catch (Exception e) {
			System.out.println("获取全部文件说明失败！");
			e.printStackTrace();
		}
		return accessoryMarks;
	}

	/**
	 * 通过id删除 文件说明
	 * @param id
	 */
	public void deleteAccessory(long id) {
		try {
			accessoryMarkDAO.delete(id);
		} catch (Exception e) {
			System.out.println("删除文件说明失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过id获取对象
	 * @param id
	 * @return
	 */
	public AccessoryMark findById(long id) {
		try {
			return accessoryMarkDAO.getById(id);
		} catch (Exception e) {
			System.out.println("获取文件说明失败！");
			e.printStackTrace();
		}
		return null;
	}

	public void updateAccessoryMark(AccessoryMark accessoryMark) {
		try {
			accessoryMarkDAO.update(accessoryMark);
		} catch (Exception e) {
			System.out.println("更新文件说明失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存文件类型
	 * @param model
	 */
	public void saveAccessoryMark(AccessoryMark accessoryMark) {
		try {
			accessoryMarkDAO.save(accessoryMark);
		} catch (Exception e) {
			System.out.println("保存文件说明失败！");
			e.printStackTrace();
		}
	}

}
