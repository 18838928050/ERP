package com.erp.controller.basedata.mgr;

import java.util.List;

import com.erp.model.dao.StafferDAO;
import com.erp.model.vo.ProductVO;
import com.erp.model.vo.StafferVO;

/**
 * 员工列表  逻辑处理
 * @author WE
 *
 */
public class StafferListMgr {
	//创建dao层对象
	private StafferDAO stafferDao = new StafferDAO();
	
	/**
	 * 查询staffer表 全部数据
	 */
	public List<StafferVO> findAll() {
		List<StafferVO> staffers = null;
		try {
			staffers = stafferDao.findAll();
		} catch (Exception e) {
			System.out.println("查询失败！");
			e.printStackTrace();
		}	
		return staffers;
	}
	
	
	/**
	 * 查询staffer表  对应部门的数据
	 */
	public List<StafferVO> findByDepartId(long id) {
		List<StafferVO> staffers = null;
		try {
			staffers = stafferDao.findByDepartId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staffers;
	}
	
	/**
	 * 查询staffer表  对应员工的状态
	 */
	public List<StafferVO> findByEnabled(String enabled,long id) {
		List<StafferVO> staffersEnable = null;
		try {
			staffersEnable = stafferDao.findByEnabled("Y",id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staffersEnable;
	}
	
	public List<StafferVO> findByEnabledN(String enabled,long id) {
		List<StafferVO> staffersEnableN = null;
		try {
			staffersEnableN = stafferDao.findByEnabled("N",id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staffersEnableN;
	}

	
	   /**
		 * 增加 staffer表中的记录，保存到数据库中
		 * @param product
		 */
		public void saveStaffer(StafferVO staffer) {
			try {
				stafferDao.save(staffer);
			} catch (Exception e) {
				System.out.println("保存失败！");
				e.printStackTrace();
			}
		}


		/**
		 * 通过id查询获得staffer表某个记录
		 * @param id
		 * @return
		 */
		public StafferVO getById(long id) {
			StafferVO staffer = null;
			try {
				staffer = stafferDao.getById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return staffer;
		}
		
		/**
		 * 更新staffer表
		 * @param staffer
		 */
		public void updateStaffer(StafferVO staffer) {
			try {
				stafferDao.update(staffer);
			} catch (Exception e) {
				System.out.println("更新失败！");
				e.printStackTrace();
			}
			
		}


		/**
		 * 根据id删除staffer表中的某条记录
		 * @param id
		 */
		public void deleteStaffer(long id) {
			try {
				stafferDao.delete(id);
			} catch (Exception e) {
				System.out.println("删除失败！");
				e.printStackTrace();
			}
		}

}
