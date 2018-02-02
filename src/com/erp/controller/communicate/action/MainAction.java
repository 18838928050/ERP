package com.erp.controller.communicate.action;

import java.util.List;
import com.erp.controller.action.BaseAction;
import com.erp.controller.communicate.mgr.BbsArticleListMgr;
import com.erp.controller.communicate.mgr.BbsColumnListMgr;
import com.erp.model.vo.BbsArticle;
import com.erp.controller.vto.BbsVTO;
import com.opensymphony.xwork2.ActionContext;

/**
 * 所有公告  action
 * @author WangEn
 *
 */
public class MainAction extends BaseAction<BbsVTO>{
	//创建逻辑处理对象
	private BbsArticleListMgr bbsArticleMgr = new BbsArticleListMgr();
	private BbsColumnListMgr bbsColumnMgr = new BbsColumnListMgr();
	
	/**
	 * 跳转主页面
	 */
	public String toMain(){
		return "toMain";
	}
	
	/**
	 * 跳转TopicList页面
	 * @return
	 */
	public String toBbsTopicList(){
		List<BbsArticle> bbsArticle = bbsArticleMgr.findAll();
		ActionContext.getContext().getValueStack().set("bbsArticle",bbsArticle);
//		List<BbsArticle> bbsArticle = bbsArticleMgr.findById(getModel().getBbsArticle().getColumnId());
//		ActionContext.getContext().getValueStack().set("bbsArticleList",bbsArticleMgr.findById(getModel().getBbsArticle().getColumnId()));
//		System.out.println(bbsArticle);
		return "toBbsTopicList";
	}
	
	/**
	 * 跳转bbs列表页面
	 */
	public String toBbsColumnList(){
		ActionContext.getContext().getValueStack().set("bbsColumnList",bbsColumnMgr.findAll());
		return "toBbsColumnList";
	}
	
	/**
	 * 跳转新增bbsColumn页面
	 */
	public String toBbsColumnNew(){
		return "toBbsColumnNew";
	}
	/**
	  * 将新增的bbsColumn保存到数据库中
	  * @return
	  */
	public String BbsColumnNew(){
		bbsColumnMgr.saveBbsColumn(getModel().getBbsColumn());
		return toBbsColumnList();
		}
	
	/**
	 * 跳转编辑bbsColumn页面
	 */
	public String tobbsColumnEdit(){
		ActionContext.getContext().getValueStack().set("bbsColumnList", bbsColumnMgr.getById(getModel().getBbsColumn().getId()));
		return "tobbsColumnEdit";
	}
	/**
	  * 编辑部门信息后，在数据库中进行更新
	  */
		public String updateBbsColumn(){
			bbsColumnMgr.updateBbsColumn(getModel().getBbsColumn());
			return toBbsColumnList();
		}
		/**
		 * 删除bbsColumn中的某条记录 
		 */
		public String delDepartment(){
			bbsColumnMgr.deleteBbsColumn(getModel().getBbsColumn().getId());
			return toBbsColumnList();
		}
	
	
	/**
	 * 跳转bbsArticle列表页面
	 */
	public String toBbsArticleList(){
		List<BbsArticle> bbsArticles = bbsArticleMgr.findByColumnId(getModel().getBbsColumn().getId());
		ActionContext.getContext().getValueStack().set("bbsArticles",bbsArticles);
		ActionContext.getContext().getValueStack().set("bbsColumnList",bbsColumnMgr.findAll());
//		System.out.println(staffers);
		return "toBbsArticleList";
	}
	
	/**
	 * 跳转新增bbsArticle页面
	 */
	public String toBbsArticleNew(){
		return "toBbsArticleNew";
	}
	 /**
	   * 将新增的bbsArticle保存到数据库中
	   * @return
	   */
		public String ArticleNew(){
			bbsArticleMgr.saveBbsArticle(getModel().getBbsArticle());
			return toBbsArticleList();
		}
	
	/**
	 * 跳转编辑bbsArticle页面
	 */
	public String toEdit(){
		return "toBbsArticleEdit";
	}
	/**
	  * 编辑员工后，在数据库中进行更新
	  */
	public String updateBbsArticle(){
		bbsArticleMgr.updateBbsArticle(getModel().getBbsArticle());
		return toBbsArticleList();
	}
	
	/**
	 * 删除bbsArticle中的某条记录 
	 */
	public String delBbsArticle(){
		bbsArticleMgr.deleteBbsArticle(getModel().getBbsArticle().getId());
		return toBbsArticleList();
	}
	

}
