package com.erp.controller.vto;

import com.erp.model.vo.BbsArticle;

import com.erp.model.vo.BbsColumn;

/**
 * 所有公告  中间层
 * @author WangEn
 *
 */
public class BbsVTO {
	private BbsArticle bbsArticle;
	private BbsColumn bbsColumn;
	public BbsArticle getBbsArticle() {
		return bbsArticle;
	}
	public void setBbsArticle(BbsArticle bbsArticle) {
		this.bbsArticle = bbsArticle;
	}
	public BbsColumn getBbsColumn() {
		return bbsColumn;
	}
	public void setBbsColumn(BbsColumn bbsColumn) {
		this.bbsColumn = bbsColumn;
	}


}
