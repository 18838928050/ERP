package com.erp.controller.communicate.mgr;

import java.util.List;


import com.erp.model.dao.BbsColumnDAO;
import com.erp.model.vo.BbsColumn;

/**
 * 所有公告  左
 * @author WangEn
 *
 */
public class BbsColumnListMgr {
	    //创建dao层对象
		private BbsColumnDAO bbsColumnDao = new BbsColumnDAO();

		/**
		 * 查询bbsColumn表
		 */
		public List<BbsColumn> findAll() {
			List<BbsColumn> bbsColumnList = null;
			try {
				bbsColumnList = bbsColumnDao.findAll();
			} catch (Exception e) {
				System.out.println("查询失败！");
				e.printStackTrace();
			}	
			return bbsColumnList;
		}

	   /**
		 * 增加bbsColumn表中的记录，保存到数据库中
		 * @param bbsColumn
		 */
		public void saveBbsColumn(BbsColumn bbsColumn) {
			try {
				bbsColumnDao.save(bbsColumn);
			} catch (Exception e) {
				System.out.println("保存失败！");
				e.printStackTrace();
			}
		}
		
		/**
		 * 通过id查询获得bbsColumn表某个记录
		 * @param id
		 * @return
		 */
		public BbsColumn getById(long id) {
			BbsColumn bbsColumn = null;
			try {
				bbsColumn = bbsColumnDao.getById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bbsColumn;
		}
		
		
		/**
		 * 更新bbsColumn表
		 * @param bbsColumn
		 */
		public void updateBbsColumn(BbsColumn bbsColumn) {
			try {
				bbsColumnDao.update(bbsColumn);
			} catch (Exception e) {
				System.out.println("更新失败！");
				e.printStackTrace();
			}
			
		}

		/**
		 * 根据id删除bbscolumn表中的某条记录
		 * @param id
		 */
		public void deleteBbsColumn(long id) {
			try {
				bbsColumnDao.delete(id);
			} catch (Exception e) {
				System.out.println("删除失败！");
				e.printStackTrace();
			}
		}

}
