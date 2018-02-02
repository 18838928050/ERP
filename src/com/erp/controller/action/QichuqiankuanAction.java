/**
 * 
 */
package com.erp.controller.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.erp.model.dao.EstablishmentDAOw;
import com.erp.model.vo.BusinessBillItemVO;
import com.erp.model.vo.EstablishmentVO;

/**
 * @author： 如约而至 @time：2017年11月13日 上午9:02:01
 *******************************************************************
 @说明：
 *******************************************************************/
public class QichuqiankuanAction {
	private File wmc;
	private String wmcContentType;
	private String wmcFileName;
	EstablishmentDAOw establishmentDAO = new EstablishmentDAOw();

	public String DaoRu() {
		return "DaoRu";
	}

	public String test() throws BiffException, IOException, ParseException {
		File destFile = new File(ServletActionContext.getServletContext().getRealPath("/upload")
				+ "/" + wmcFileName);
		System.out.println("destFile:" + destFile);
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println("path" + path);
		FileUtils.copyFile(wmc, destFile);
		up(destFile);
		return null;
	}

	public void up(File file) throws BiffException, IOException, ParseException {
		// 创建输入流，读取Excel
		InputStream is = new FileInputStream(file);
		// jxl提供的Workbook类
		Workbook wb = Workbook.getWorkbook(is);
		// Excel的页签数量//最下面的 Sheet1
		int sheet_size = wb.getNumberOfSheets();
		ArrayList<EstablishmentVO> establishmentVOs = new ArrayList<EstablishmentVO>();
		ArrayList<BusinessBillItemVO> billItemVOs = new ArrayList<>();
		for (int index = 0; index < sheet_size; index++) {
			// 每个页签创建一个Sheet对象
			Sheet sheet = wb.getSheet(index);

			// sheet.getRows()返回该页的总行数
			for (int i = 1; i < sheet.getRows(); i++) {
				// sheet.getColumns()返回该页的总列数
				EstablishmentVO establishmentVO = new EstablishmentVO();
				BusinessBillItemVO billItemVO = new BusinessBillItemVO();
				for (int j = 0; j < sheet.getColumns(); j++) {
					// String ce = sheet.getCell(j, i).getContents();
					// System.out.println(ce);
					// 把得到的欠款金额string类型转换成BigDecimal类型
					BigDecimal qiankuan = new BigDecimal(sheet.getCell(1, i).getContents());
					establishmentVO.setEstName(sheet.getCell(0, i).getContents());
					// 找出establishment表中开头为F的最大的ESTCode值,截取后面的数字部分转换成int类型加一，再转换成string放进数据库
					String estCodeString = establishmentDAO.findEstMaxCodeLikeF();
					String shuzibufen = estCodeString.substring(estCodeString.length() - 4,
							estCodeString.length());
					int a = Integer.parseInt(shuzibufen) + 1;
					// bString是最后要插入到数据库的ESTCode
					String bString = ("F0" + a);
					establishmentVO.setBusCost(qiankuan);
					establishmentVO.setEstCode(bString);
					establishmentVO.setEstTypeId(0);
					establishmentVO.setEstLevelId(0);
					establishmentVO.setEstType("CLIENT");
					establishmentVO.setEstTypeId(1);
					// 这里是登录者的id和Name，此处先假设
					establishmentVO.setManagerName("杨海波");
					establishmentVO.setManagerId(51);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date = formatter.parse(sheet.getCell(2, i).getContents());
					establishmentVO.setBusTime(date);
					billItemVO.setUnitPrice(qiankuan);
					billItemVO.setCost(qiankuan);
					billItemVO.setFinishedContent(sheet.getCell(4, i).getContents());

				}
				establishmentVOs.add(establishmentVO);
				billItemVOs.add(billItemVO);
			}
		}
		for (EstablishmentVO establishmentVO : establishmentVOs) {
			System.out.println(establishmentVO);
		}
		for (BusinessBillItemVO businessBillItemVO : billItemVOs) {
			System.out.println(businessBillItemVO);
		}
		establishmentDAO.saves(establishmentVOs);
	}

	/**
	 * @return the wmc
	 */
	public File getWmc() {
		return wmc;
	}

	/**
	 * @param wmc
	 *            the wmc to set
	 */
	public void setWmc(File wmc) {
		this.wmc = wmc;
	}

	/**
	 * @return the wmcContentType
	 */
	public String getWmcContentType() {
		return wmcContentType;
	}

	/**
	 * @param wmcContentType
	 *            the wmcContentType to set
	 */
	public void setWmcContentType(String wmcContentType) {
		this.wmcContentType = wmcContentType;
	}

	/**
	 * @return the wmcFileName
	 */
	public String getWmcFileName() {
		return wmcFileName;
	}

	/**
	 * @param wmcFileName
	 *            the wmcFileName to set
	 */
	public void setWmcFileName(String wmcFileName) {
		this.wmcFileName = wmcFileName;
	}
}
