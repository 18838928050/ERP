package com.erp.controller.communicate.mgr;

import java.util.List;


import com.erp.model.dao.BbsArticleDAO;
import com.erp.model.vo.BbsArticle;


/**
 * 
 * 所有公告 右
 * @author WangEn
 *
 */
public class BbsArticleListMgr {
	//创建dao层对象
		private BbsArticleDAO bbsAricleDao = new BbsArticleDAO();
		
		/**
		 * 查询BbsArticle表 全部数据
		 */
		public List<BbsArticle> findAll() {
			List<BbsArticle> bbsArticle = null;
			try {
				bbsArticle = bbsAricleDao.findAll();
			} catch (Exception e) {
				System.out.println("查询失败！");
				e.printStackTrace();
			}	
			return bbsArticle;
		}
		
		
		/**
		 * 查询bbsArticle表  对应部门的数据
		 */
		public List<BbsArticle> findByColumnId(long id) {
			List<BbsArticle> bbsArticle = null;
			try {
				bbsArticle = bbsAricleDao.findByBbsColumnId(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bbsArticle;
		}

		
		   /**
			 * 增加 bbsArticle表中的记录，保存到数据库中
			 * @param product
			 */
			public void saveBbsArticle(BbsArticle bbsArticle) {
				try {
					bbsAricleDao.save(bbsArticle);
				} catch (Exception e) {
					System.out.println("保存失败！");
					e.printStackTrace();
				}
			}


			/**
			 * 通过id查询获得bbsArticle表某个记录
			 * @param id
			 * @return
			 */
			public BbsArticle getById(long id) {
				BbsArticle bbsArticle = null;
				try {
					bbsArticle = bbsAricleDao.getById(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return bbsArticle;
			}
			
			/**
			 * 更新BbsArticle表
			 * @param bbsArticle
			 */
			public void updateBbsArticle(BbsArticle bbsArticle) {
				try {
					bbsAricleDao.update(bbsArticle);
				} catch (Exception e) {
					System.out.println("更新失败！");
					e.printStackTrace();
				}
				
			}


			/**
			 * 根据id删除bbsArticle表中的某条记录
			 * @param id
			 */
			public void deleteBbsArticle(long id) {
				try {
					bbsAricleDao.delete(id);
				} catch (Exception e) {
					System.out.println("删除失败！");
					e.printStackTrace();
				}
			}

}
