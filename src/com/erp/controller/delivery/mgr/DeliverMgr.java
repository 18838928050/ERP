package com.erp.controller.delivery.mgr;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.erp.controller.customerBusiness.dao.EstablishmentDAO;
import com.erp.controller.customerBusiness.dao.PayModeDAO;
import com.erp.controller.delivery.dao.DeliverVtoDAO;
import com.erp.controller.delivery.vto.DeliverPO;
import com.erp.controller.delivery.vto.DeliverVTO;
import com.erp.controller.statistic.dao.BusinessBillDAO;
import com.erp.model.dao.BusinessBillExtDAO;
import com.erp.model.dao.BusinessBillItemDAO;
import com.erp.model.dao.DeliverBillDAO;
import com.erp.model.vo.BusinessBillItem;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.DeliverBill;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.PayMode;
import com.opensymphony.xwork2.ActionContext;



/**
 * 客户业务
 * 送货
 * @author guo
 *
 */
public class DeliverMgr {

	private BusinessBillDAO businessBillDAO = new BusinessBillDAO();
	private EstablishmentDAO establishmentDAO = new EstablishmentDAO();
	private BusinessBillExtDAO businessBillExtDAO = new BusinessBillExtDAO();
	private DeliverBillDAO deliveryBillDAO = new DeliverBillDAO();
	private BusinessBillItemDAO businessBillItemDAO = new BusinessBillItemDAO();	
	private PayModeDAO payModeDAO = new PayModeDAO();
	private DeliverVtoDAO deliverVtoDAO = new DeliverVtoDAO();
	//	查询所有的送货单
	public void findAllBusinessBillListForDeliver(){
		List<BusinessBillVO> businessBills = businessBillDAO.findBusinessBills();
		List<EstablishmentVO> establishments =null;
		try {
			establishments = establishmentDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Long, String> IdAndName = new HashMap<>();
		if(establishments != null){
			for (EstablishmentVO establishmentVO : establishments) {
				IdAndName.put(establishmentVO.getId(), establishmentVO.getEstName());
			}
		}
		if(businessBills != null && establishments != null){
			for (BusinessBillVO businessBill : businessBills) {
				//				通过id获得客户名称
				long clientId = businessBill.getClientId();
				String value = IdAndName.get(clientId);
				businessBill.setMark(value);//借用mark存订货单位
				String state = businessBillExtDAO.getBusinessBillExtDelivered(businessBill.getId());
				if(state!= null){
					if(state.equals("N")){
						//						借用SourType存放到前台是否完工
						businessBill.setSourType("未完工");
					}else{
						businessBill.setSourType("完工");
					}
				}
			}
		}
		//将信息返回页面
		ActionContext.getContext().getValueStack().set("businessBills", businessBills);
	}
	//	查询所有的送库单
	public void findAllDeliverBillListForExamine(){
		//业务单
		List<DeliverBill> deliverBills = null;
		try {
			deliverBills = deliveryBillDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取业务单的id和billCode
		List<BusinessBillVO> businessBills = businessBillDAO.findBusinessBills();
		//将信息返回页面

		ActionContext.getContext().getValueStack().set("deliverBills", deliverBills);
		ActionContext.getContext().getValueStack().set("businessBills", businessBills);
	}
	//	查询所有的送库单
	public void findAllDeliveryBillListForExamine(){

		//业务单
		List<DeliverBill> deliverBills = null;
		List<BusinessBillItem> businessBillItems = null;
		try {
			deliverBills = deliveryBillDAO.findAll();
			businessBillItems = businessBillItemDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取业务单的id和billCode
		List<BusinessBillVO> businessBills = businessBillDAO.findBusinessBills();
		//将信息返回页面
		ActionContext.getContext().getValueStack().set("deliverBills", deliverBills);
		//		ActionContext.getContext().getValueStack().set("businessBills", businessBills);
		ActionContext.getContext().getValueStack().set("businessBillItems", businessBillItems);
	}

	public void findAllDeliverBillItemSearchResult(){
		//业务单
		/*List<DeliverBill> deliverBills = null;
		List<BusinessBillItem> businessBillItems = null;
		List<PayModeVO> payModes = null;
		try {
			deliverBills = deliveryBillDAO.findAll();
			businessBillItems = businessBillItemDAO.findAll();
			payModes = payModeDAO.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取业务单的id和billCode
		List<BusinessBillVO> businessBills = businessBillDAO.findBusinessBills();
		//将信息返回页面
		ActionContext.getContext().getValueStack().set("payModes", payModes);
		ActionContext.getContext().getValueStack().set("deliverBills", deliverBills);
		ActionContext.getContext().getValueStack().set("businessBills", businessBills);
		ActionContext.getContext().getValueStack().set("businessBillItems", businessBillItems);*/

		try {
			List<Object> deliverVTOs = deliverVtoDAO.findAllDeliverVTO();
			
			List<DeliverPO> deliverVtos = new ArrayList<>();
			for(int i = 0; i < deliverVTOs.size();i++){
				DeliverPO deliver = new DeliverPO();
				Object[] object = (Object[])deliverVTOs.get(i);// 每行记录不在是一个对象 而是一个数组
				Date deliverDate =  (Date)object[0];
				String billCode =  (String)object[1];
				String content =  (String)object[2];
				String typeName =  (String)object[3];
				String finishedContent =  (String)object[4];
				String proName =  (String)object[5];
				String specification =  (String)object[6];
				String unit =  (String)object[7];
				BigDecimal amount =  (BigDecimal)object[8];
				BigDecimal unitPrice =  (BigDecimal)object[9];
				BigDecimal cost =  (BigDecimal)object[10];
				String address =  (String)object[11];
				String modeName =  (String)object[12];
				String createrName =  (String)object[13];
				String billCodeB =  (String)object[14];
				// 重新封装在一个javabean里面
				deliver.setDeliverDate(deliverDate);
				deliver.setBillCode(billCode);
				deliver.setContent(content);
				deliver.setTypeName(typeName);
				deliver.setFinishedContent(finishedContent);
				deliver.setProName(proName);
				deliver.setSpecification(specification);
				deliver.setUnit(unit);
				deliver.setAmount(amount);
				deliver.setUnitPrice(unitPrice);
				deliver.setCost(cost);
				deliver.setAddress(address);
				deliver.setModeName(modeName);
				deliver.setCreaterName(createrName);
				deliver.setBillCodeB(billCodeB);
				deliverVtos.add(deliver);
			}
			System.out.println(deliverVtos.size());
			ActionContext.getContext().getValueStack().set("deliverVTOs", deliverVtos);
			//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}