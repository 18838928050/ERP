/**
 * 
 */
package com.erp.controller.system.mgr;

import java.util.List;

import org.hibernate.Query;

import com.erp.model.dao.BankDAOw;
import com.erp.model.dao.BusinessBillDAOw;
import com.erp.model.dao.CooperBillDAOw;
import com.erp.model.dao.CooperBillExtDAOw;
import com.erp.model.dao.CooperBillItemDAOw;
import com.erp.model.dao.DepartmentDAOw;
import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.dao.MakeTypeDAOw;
import com.erp.model.dao.PayModeDAOw;
import com.erp.model.dao.TallySetDAOw;
import com.erp.model.vo.BankAccountVO;
import com.erp.model.vo.BusinessBillVO;
import com.erp.model.vo.CooperBillExtVO;
import com.erp.model.vo.CooperBillItemVO;
import com.erp.model.vo.CooperBillVO;
import com.erp.model.vo.DepartmentVO;
import com.erp.model.vo.EstablishmentVO;
import com.erp.model.vo.MakeTypeVO;
import com.erp.model.vo.PageVO;
import com.erp.model.vo.PayModeVO;
import com.erp.model.vo.TallySetVO;

/**
 @author： 如约而至    @time：2017年9月4日 上午10:49:51 
 *******************************************************************
 @说明： 
 *******************************************************************/
public class CooperBillActionMgr {
	private CooperBillDAOw cooperBillDAO=new CooperBillDAOw();
	private MakeTypeDAOw makeTypeDAO=new MakeTypeDAOw();
	private CooperBillItemDAOw cooperBillItemDAO=new CooperBillItemDAOw();
	private BankDAOw bankDAO=new BankDAOw();
	private PayModeDAOw payModeDAO=new PayModeDAOw();
	private TallySetDAOw tallySetDAO=new TallySetDAOw();
	private DepartmentDAOw departmentDAO =new DepartmentDAOw();
	private EstablishmentDAOw establishmentDAO=new EstablishmentDAOw();
	private CooperBillExtDAOw cooperBillExtDAO=new CooperBillExtDAOw();
	private BusinessBillDAOw businessBillDAO=new BusinessBillDAOw(); 

	/**
	 * @throws Exception 
	 * @说明：查询外协单反审核中所有信息
	 */
	public List<CooperBillVO> findAll() throws Exception {
		return cooperBillDAO.findAllByMyAdjust();
	}
	
	//装载分页
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public PageVO getPageVO(Integer maxNumEvePage,Integer curNumPage) throws Exception{
		//判断 如果用户没有输入页数 怎默认设置当前页数为第一页 否则按照用户输入的
		curNumPage=(curNumPage==null||curNumPage==0)?1:curNumPage;
		maxNumEvePage=(maxNumEvePage==null||maxNumEvePage==0)?10:maxNumEvePage;
		
		PageVO pageVO=new PageVO();
		//1手动设置当前页数
		pageVO.setCurrentPageNum(curNumPage);
		
		//2手动设置每页最大显示数
		pageVO.setMaxNumEveryPage(maxNumEvePage);
		
		//3：获得结果集
		Query query=cooperBillDAO.getAllQuery();
		
		
		//获得全部结果数
		Integer allResultNum=query.list().size();
		
		//获得所有页数
		Integer allPageNum=(allResultNum%pageVO.getMaxNumEveryPage()==0)?allResultNum/pageVO.getMaxNumEveryPage():allResultNum/pageVO.getMaxNumEveryPage()+1;
		
		//设置一共多少也
		pageVO.setAllPageNum(allPageNum);
		
		//设置从第几条开始数据
		query.setFirstResult((pageVO.getCurrentPageNum()-1)*pageVO.getMaxNumEveryPage());
		
		query.setMaxResults(pageVO.getMaxNumEveryPage());
		
		
		//获取最终结果集
		List<CooperBillVO> cooperBillVOs=query.list();
		
		//设置结果集
		pageVO.setResultlist(cooperBillVOs);
		
		return pageVO;
	}
	
	
	

	/**
	 * @说明：在cooperbill表中根据billcode获得整条数据
	 */
	public CooperBillVO getCooperBillByBillCode(String billCode) {
		return cooperBillDAO.getCooperBillByBillCode(billCode);
	}

	/**
	 * @throws Exception 
	 * @说明：cooperbill表中的department_id=maketype表中的id从而获得maketype中的type_name；根据billcode获得整条数据
	 */

	public MakeTypeVO getMakeTypeById(long departmentId) throws Exception {
		return makeTypeDAO.getById(departmentId);
	}
	

	/**
	 * @说明：项目类型：集合类型：//由前台/ERP/WebContent/WEB-INF/view/waixie/listUI.jsp查看：传来的id，查询CooperBillItem整条信息。
	 *CooperBill.id=CooperBillItem.bill_id
	 *已Test
	 * */
	
	public List<CooperBillItemVO> getCooperBillItemByCooperBillId(long billid) {
		return cooperBillItemDAO.getCooperBillItemByCooperBillId(billid);
	}
	
	

	/**
	 * @throws Exception 
	 * @说明：//由上条查出并且压入值栈的整条cooperbill记录中的bank_account_id;由CooperBill.bank_account_id=BankAccount.id 
	 */
	public BankAccountVO getBankAccountByAccountId(long bankAccountId) throws Exception {
		return bankDAO.getById(bankAccountId);
	}

	/**
	 * @throws Exception 
	 * @说明：//由上条查出并且压入值栈的整条cooperbill记录中的pay_mode_id;由CooperBill.pay_mode_id=pay_mode.id 
	 */
	public PayModeVO getPayModeByPayModeId(long payModeId) throws Exception {
		// TODO Auto-generated method stub
		return payModeDAO.getById(payModeId);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public TallySetVO getTallySetByTallSetId(long tallySetId) throws Exception {
		return tallySetDAO.getById(tallySetId);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public DepartmentVO getDepartmentNameById(long departmentId) throws Exception {
		return departmentDAO.getById(departmentId);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public EstablishmentVO getEstablishmentById(long cooperatorId) throws Exception {
		return establishmentDAO.getById(cooperatorId);
	}

	/**
	 * @throws Exception 
	 * @说明：
	 */
	public CooperBillExtVO getCooperBillExtById(long id) throws Exception {
		return cooperBillExtDAO.getById(id);
	}

	/**
	 * @param l 
	 * @说明：如果isCheckOrNo =1 表示N  , cooper_bill_ext c,cooper_bill b WHERE c.id=b.id and c.examined=N的话 ，查出是为审核的
	 */
	public void isCheckOrNo(Integer isCheckOrNo, long l) {
	    cooperBillItemDAO.isCheckOrNo(isCheckOrNo,l);
	}

	/**
	 * @说明：由BusinessBillVO中的billCode获得当前一行数据
	 */
	public BusinessBillVO getBusinessBillByBillCode(String billCode) {
		return businessBillDAO.getBusinessBillByBillCode(billCode);
	}

	/**
	 * @说明：由CooperBillItemVO中的bbCode获得当前一行记录
	 */
	public List<CooperBillItemVO> getCooperBillItemByBbCode(String bbCode) {
		return cooperBillItemDAO.getCooperBillItemByBbCode(bbCode);
	}

}
