/**
 * 
 */
package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.AnzhuandanfanwangongBean;
import com.erp.model.vo.AnzhuandanwangongBean;
import com.erp.model.vo.AnzhuangBean;
import com.erp.model.vo.AzhuangdanchakanBean;
import com.erp.model.vo.ChakanyewudanBean;
import com.erp.model.vo.SetuBillVOO;
import com.erp.model.vo.anzhuangdanzuofeiBean;
import com.erp.model.vo.fBean;

/**
 * @author： fu @time：2017年12月6日 下午2:08:05
 * @说明： 一份耕耘，一份收获
 **/
public class AnzhuangdannVTO {
	private fBean fBean;
	private AzhuangdanchakanBean anAzhuangdanchakanBean;
	private AnzhuandanwangongBean anzhuandanwangongBean;
	private SetuBillVOO setuBillVOO;
	private AnzhuandanfanwangongBean anzhuandanfanwangongBean;
	private ChakanyewudanBean chakanyewudanBean;
	private anzhuangdanzuofeiBean anzhuangdanzuofeiBean;
	private AnzhuangBean anzhuangBean;
	private List<AnzhuangBean> anzhuangBeans;

	public fBean getfBean() {
		return fBean;
	}

	public void setfBean(fBean fBean) {
		this.fBean = fBean;
	}

	public AzhuangdanchakanBean getAnAzhuangdanchakanBean() {
		return anAzhuangdanchakanBean;
	}

	public void setAnAzhuangdanchakanBean(AzhuangdanchakanBean anAzhuangdanchakanBean) {
		this.anAzhuangdanchakanBean = anAzhuangdanchakanBean;
	}

	public List<AnzhuangBean> getAnzhuangBeans() {
		return anzhuangBeans;
	}

	public void setAnzhuangBeans(List<AnzhuangBean> anzhuangBeans) {
		this.anzhuangBeans = anzhuangBeans;
	}

	public AnzhuangBean getAnzhuangBean() {
		return anzhuangBean;
	}

	public void setAnzhuangBean(AnzhuangBean anzhuangBean) {
		this.anzhuangBean = anzhuangBean;
	}

	public anzhuangdanzuofeiBean getAnzhuangdanzuofeiBean() {
		return anzhuangdanzuofeiBean;
	}

	public void setAnzhuangdanzuofeiBean(anzhuangdanzuofeiBean anzhuangdanzuofeiBean) {
		this.anzhuangdanzuofeiBean = anzhuangdanzuofeiBean;
	}

	public ChakanyewudanBean getChakanyewudanBean() {
		return chakanyewudanBean;
	}

	public void setChakanyewudanBean(ChakanyewudanBean chakanyewudanBean) {
		this.chakanyewudanBean = chakanyewudanBean;
	}

	public AnzhuandanfanwangongBean getAnzhuandanfanwangongBean() {
		return anzhuandanfanwangongBean;
	}

	public void setAnzhuandanfanwangongBean(AnzhuandanfanwangongBean anzhuandanfanwangongBean) {
		this.anzhuandanfanwangongBean = anzhuandanfanwangongBean;
	}

	public SetuBillVOO getSetuBillVOO() {
		return setuBillVOO;
	}

	public void setSetuBillVOO(SetuBillVOO setuBillVOO) {
		this.setuBillVOO = setuBillVOO;
	}

	public AnzhuandanwangongBean getAnzhuandanwangongBean() {
		return anzhuandanwangongBean;
	}

	public void setAnzhuandanwangongBean(AnzhuandanwangongBean anzhuandanwangongBean) {
		this.anzhuandanwangongBean = anzhuandanwangongBean;
	}
}
