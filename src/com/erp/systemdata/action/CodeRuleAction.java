package com.erp.systemdata.action;

import com.erp.controller.action.BaseAction;
import com.erp.model.dao.CodeRuleDAO;
import com.erp.model.vo.CodeRule;
import com.opensymphony.xwork2.ActionContext;

/**
 * 编码规则
 * @author JiaQi
 *
 */
public class CodeRuleAction extends BaseAction<CodeRule>{
	private CodeRuleDAO codeRuleDAO = new CodeRuleDAO();
	/**
	 * 跳转到主数据编码规则
	 */
	public String toCodeRuleMain(){
		ActionContext.getContext().getValueStack().set("codeRoles", codeRuleDAO.findAllCodeRuleMain());
		System.out.println(getModel().getId());
		ActionContext.getContext().getValueStack().set("id", getModel().getId());
		return "toCodeRuleMain";
	}
	/**
	 * 跳转到主数据打印规则
	 */
	public String toCodeRulePrint(){
		ActionContext.getContext().getValueStack().set("codeRoles", codeRuleDAO.findAllCodeRulePrint());
		return "toCodeRuleMain";
	}
	
	/**
	 * 获取右侧详细信息
	 */
	public String findCodeRuleById(){
		try {
			ActionContext.getContext().getValueStack().set("codeRule", codeRuleDAO.getById(getModel().getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toCodeRuleDesc";
	}
	
	/**
	 * 获取主数据编码规则列表
	 */
	public String findCodeRuleList(){
		if(getModel().getId() == 1){
			ActionContext.getContext().getValueStack().set("codeRule",codeRuleDAO.findAllCodeRuleMain());
		}else if(getModel().getId() == 2){
			ActionContext.getContext().getValueStack().set("codeRule",codeRuleDAO.findAllCodeRulePrint());
		}
		return "findCodeRuleList";
	}
	
	/**
	 * 保存
	 */
	public String updateCodeRule(){
		
		CodeRule codeRule = null;
		try {
			codeRule = codeRuleDAO.getById(getModel().getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		codeRule.setGenerateRule(getModel().getGenerateRule());
		codeRule.setPrefix(getModel().getPrefix());
		codeRule.setSeparator(getModel().getSeparator());
		codeRule.setNumberLength(getModel().getNumberLength());
		codeRule.setPrintFoot(getModel().getPrintFoot());
		codeRule.setTallySetRule(getModel().getTallySetRule());
		try {
			codeRuleDAO.update(codeRule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ActionContext.getContext().getValueStack().set("id", codeRule.getId());
		return findCodeRuleById();
	}
}
