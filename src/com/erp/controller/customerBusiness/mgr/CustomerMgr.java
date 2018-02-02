package com.erp.controller.customerBusiness.mgr;

import java.util.Date;
import java.util.List;

import com.erp.controller.customerBusiness.dao.AreaDAO;
import com.erp.controller.customerBusiness.dao.EstablishmentContactDAO;
import com.erp.controller.customerBusiness.dao.EstablishmentDAO;
import com.erp.controller.customerBusiness.dao.EstablishmentLevelDAO;
import com.erp.controller.customerBusiness.dao.EstablishmentTypeDAO;
import com.erp.controller.customerBusiness.dao.PayModeDAO;
import com.erp.controller.customerBusiness.dao.StafferDAO;
import com.erp.controller.customerBusiness.vo.AreaVO;
import com.erp.controller.customerBusiness.vo.EstablishmentContactVO;
import com.erp.controller.customerBusiness.vo.EstablishmentLevelVO;
import com.erp.controller.customerBusiness.vo.EstablishmentTypeVO;
import com.erp.controller.customerBusiness.vo.PayModeVO;
import com.erp.controller.customerBusiness.vo.StafferVO;
import com.erp.controller.customerBusiness.vto.CustomerVTO;
import com.erp.controller.vto.LoginVTOw;
import com.erp.model.vo.EstablishmentVO;
import com.opensymphony.xwork2.ActionContext;


/**
 * 客户业务 逻辑处理
 * @author guo
 *
 */
public class CustomerMgr {
	private EstablishmentDAO establishmentDAO = new EstablishmentDAO();
	private EstablishmentContactDAO establishmentContactDAO = new EstablishmentContactDAO();
	private EstablishmentTypeDAO establishmentTypeDAO = new EstablishmentTypeDAO();
	private EstablishmentLevelDAO establishmentLevelDAO = new EstablishmentLevelDAO();
	private AreaDAO areaDAO = new AreaDAO();
	private PayModeDAO payModeDAO = new PayModeDAO();
	private StafferDAO stafferDAO = new StafferDAO();

	/**
	 * 添加客户
	 * @return
	 */
	public void addEstablishment(CustomerVTO customerVTO) {
		try {
			//获得用户
			LoginVTOw loginVTO=(LoginVTOw)ActionContext.getContext().getSession().get("loginVTO");
			//			打印客户
			String estcode = "F"+String.valueOf(establishmentDAO.findMaxId()+1);//通过id生成estcode
			System.out.println("estcode:"+estcode);
			customerVTO.getEstablishment().setEstCode(estcode);
			customerVTO.getEstablishment().setBusTime(new Date());//手动生成创建时间
			//名字的大写拼写
//			String firstLetter = FirstLetterUtil.getFirstLetter(customerVTO.getEstablishment().getNameSpell());
//			System.out.println("firstLetter:"+firstLetter);
			customerVTO.getEstablishment().setNameSpell("大写字母名字");
			customerVTO.getEstablishment().setCreaterName(loginVTO.getUserName());
			System.out.println("loginVTO.getUserName():"+loginVTO.getUserName());
			customerVTO.getEstablishment().setCreaterId(loginVTO.getStafferID());
			System.out.println("loginVTO.getStafferID():"+loginVTO.getStafferID());
			List<EstablishmentContactVO> establishmentContacts = customerVTO.getEstablishmentContact();
			for (EstablishmentContactVO establishmentContact : establishmentContacts) {
				establishmentContact.setSex("男");
				establishmentContact.setEstId(1);
//				保存客户下的联系人信息
				establishmentContactDAO.save(establishmentContact);
				System.out.println(establishmentContact.toString()+"----------------");
//				判断是否是主要联系人
				if(establishmentContact.getIsMain().equals("Y")){
					customerVTO.getEstablishment().setLinkman(establishmentContact.getContactName());//手动生成主要联系人的名字
					customerVTO.getEstablishment().setLinkmanPhone(establishmentContact.getMobile());//手动生成主要联系人的名字
				}
			}
//			保存客户信息
			establishmentDAO.save(customerVTO.getEstablishment());
			System.out.println(customerVTO.getEstablishment().toString()+"------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	判断客户是否存在
	public void establishmentCheck(CustomerVTO customerVTO) {
		List<EstablishmentVO> establishments = establishmentDAO.findByEstName(customerVTO.getEstablishment().getEstName());
//		将发现符合条件的客户发送到前台
		ActionContext.getContext().getValueStack().set("establishments", establishments);
	}
	
//	查询所有的员工
	public void findAllStaffer() {
//		将所有的员工都遍历出来
		List<StafferVO> staffers;
		try {
			staffers = stafferDAO.findAll();
//		将发现的员工发送到前台
			ActionContext.getContext().getValueStack().set("staffers", staffers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	查询所有客户类型 遍历到添加客户页面的选择客户类型的选项框
	public void findAllestablishmentType() {
		List<EstablishmentTypeVO> establishmentTypes;
		try {
			establishmentTypes = establishmentTypeDAO.findAll();
			ActionContext.getContext().getValueStack().set("establishmentTypes", establishmentTypes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		将发现的员工发送到前台
	}
	
//	查询所有的客户等级 遍历到添加客户页面的选择客户等级的选项框
	public void findAllEstablishmentLevel(){
		List<EstablishmentLevelVO> establishmentLevels;
		try {
			establishmentLevels = establishmentLevelDAO.findAll();
			ActionContext.getContext().getValueStack().set("establishmentLevels", establishmentLevels);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	查询所有的付款方式 遍历到添加客户页面的选择付款方式的选项框
	public void findAllPayMode(){
		List<PayModeVO> payModes;
		try {
			payModes = payModeDAO.findAll();
			ActionContext.getContext().getValueStack().set("payModes", payModes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	查询所有的付款方式 遍历到添加客户页面的选择付款方式的选项框
	public void findAllArea(){
		List<AreaVO> areas;
		try {
			areas = areaDAO.findAll();
			ActionContext.getContext().getValueStack().set("areas", areas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}