package com.erp.controller.basedata.mgr;

import java.util.List;

import com.erp.model.dao.MakeRequireDAO;
import com.erp.model.vo.MakeRequire;

/**
 * 制作要求
 * @author JiaQi
 *
 */
public class MakeRequireMgr {
	private MakeRequireDAO makeRequireDAO = new MakeRequireDAO();
	/**
	 * 获取全部制作要求
	 */
	public List<MakeRequire> findAll(){
		List<MakeRequire> makeRequires = null;
		try {
			makeRequires = makeRequireDAO.findAll();
		} catch (Exception e) {
			System.out.println("获取全部制作要求失败 ！");
			e.printStackTrace();
		}
		return makeRequires;
	}
	/**
	 * 通过id删除制作要求
	 * @param id
	 */
	public void delete(long id) {
		try {
			makeRequireDAO.delete(id);
		} catch (Exception e) {
			System.out.println("删除制作要求失败！");
			e.printStackTrace();
		}
	}
	/**
	 * 通过id获得
	 * @param id
	 */
	public MakeRequire findById(long id) {
		MakeRequire makeRequire = null;
		try {
			makeRequire = makeRequireDAO.getById(id);
		} catch (Exception e) {
			System.out.println("获取制作要求失败");
			e.printStackTrace();
		}
		return makeRequire;
	}
	/**
	 * 更新制作要求
	 * @param makeRequire
	 */
	public void updateMakeReqire(MakeRequire makeRequire) {
		try {
			makeRequireDAO.update(makeRequire);
		} catch (Exception e) {
			System.out.println("更新制作要求失败！");
			e.printStackTrace();
		}
	}
	/**
	 * 保存新增信息
	 * @param model
	 */
	public void saveMakeRequire(MakeRequire makeRequire) {
		try {
			makeRequireDAO.save(makeRequire);
		} catch (Exception e) {
			System.out.println("保存制作要求失败！");
			e.printStackTrace();
		}
	}
}
