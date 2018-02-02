package com.erp.controller.system.mgr;

import java.util.ArrayList;
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
import com.erp.controller.vto.WaixieshangdengjiVTO;
import com.erp.model.dao.CooperBillDAOw;
import com.erp.model.dao.CooperBillItemDAOw;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.opensymphony.xwork2.ActionContext;

public class WaixieshangdengMGR {
	private EstablishmentDAO establishmentDAO = new EstablishmentDAO();
	private EstablishmentContactDAO establishmentContactDAO = new EstablishmentContactDAO();
	private EstablishmentTypeDAO establishmentTypeDAO = new EstablishmentTypeDAO();
	private EstablishmentLevelDAO establishmentLevelDAO = new EstablishmentLevelDAO();
	private AreaDAO areaDAO = new AreaDAO();
	private PayModeDAO payModeDAO = new PayModeDAO();
	private StafferDAO stafferDAO = new StafferDAO();
	private CooperBillDAOw cooperBillDAOw=new CooperBillDAOw();
	private CooperBillItemDAOw cooperBillItemDAOw=new CooperBillItemDAOw();
	private MakeTypeDAOw makeTypeDAOw=new MakeTypeDAOw();
	//
	public List<EstablishmentVO> getAllEs() {
		return establishmentDAO.getAllEsByT();
	}
	
	
	/**
	 * 添加客户
	 * @return
	 */
	public void addEstablishment(WaixieshangdengjiVTO waixieshangdengjiVTO) {
		try {
			//获得用户
			LoginVTOw loginVTO=(LoginVTOw)ActionContext.getContext().getSession().get("loginVTO");
			//			打印客户
			String estcode = "T"+String.valueOf(establishmentDAO.findMaxId()+1);//通过id生成estcode
			System.out.println("estcode:"+estcode);
			waixieshangdengjiVTO.getEstablishment().setEstCode(estcode);
			waixieshangdengjiVTO.getEstablishment().setBusTime(new Date());//手动生成创建时间
			//名字的大写拼写
//			String firstLetter = FirstLetterUtil.getFirstLetter(customerVTO.getEstablishment().getNameSpell());
//			System.out.println("firstLetter:"+firstLetter);
			waixieshangdengjiVTO.getEstablishment().setNameSpell("大写字母名字");
			waixieshangdengjiVTO.getEstablishment().setCreaterName(loginVTO.getUserName());
			System.out.println("loginVTO.getUserName():"+loginVTO.getUserName());
			waixieshangdengjiVTO.getEstablishment().setCreaterId(loginVTO.getStafferID());
			System.out.println("loginVTO.getStafferID():"+loginVTO.getStafferID());
			List<EstablishmentContactVO> establishmentContacts = waixieshangdengjiVTO.getEstablishmentContact();
			for (EstablishmentContactVO establishmentContact : establishmentContacts) {
				establishmentContact.setSex("男");
				establishmentContact.setEstId(1);
//				保存客户下的联系人信息
				establishmentContactDAO.save(establishmentContact);
				System.out.println(establishmentContact.toString()+"----------------");
//				判断是否是主要联系人
				if(establishmentContact.getIsMain().equals("Y")){
					waixieshangdengjiVTO.getEstablishment().setLinkman(establishmentContact.getContactName());//手动生成主要联系人的名字
					waixieshangdengjiVTO.getEstablishment().setLinkmanPhone(establishmentContact.getMobile());//手动生成主要联系人的名字
				}
			}
			
//			保存客户信息
			establishmentDAO.save(waixieshangdengjiVTO.getEstablishment());
			System.out.println(waixieshangdengjiVTO.getEstablishment().toString()+"------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<CooperBillVO> getCB(long id) {
		return cooperBillDAOw.getCooperBillByCooperatorId(id);
	}


	public List<List<CooperBillItemVO>> getCBI(List<CooperBillVO> cooperBillVOs) {
		List<Long> ids=new ArrayList<>();
		for (CooperBillVO cooperBillVO : cooperBillVOs) {
			ids.add(cooperBillVO.getId());
		}
		return cooperBillItemDAOw.getCooperBillItemByBillIDs(ids);
	}


	public List<MakeTypeVO> getMak(List<List<CooperBillItemVO>> getcList) {
		List<Long> ids=new ArrayList<>();
		for (List<CooperBillItemVO> list : getcList) {
			for (CooperBillItemVO cooperBillItemVO : list) {
				ids.add(cooperBillItemVO.getMakeTypeId());
			}
		}
		
		return makeTypeDAOw.getMakeTypeByIds(ids);
	}


	public void start(long id) {
		establishmentDAO.start(id);
		
	}


	public void stop(long id) {
		establishmentDAO.stop(id);		
	}


	public void delete(long id) throws Exception {
		establishmentDAO.delete(id);		
		
	}


	public EstablishmentVO getEById(long id) throws Exception {
		return establishmentDAO.getById(id);
	}

	

}
