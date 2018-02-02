package com.erp.controller.vto;

import java.util.List;

import com.erp.model.vo.OvBillVO;

public class ChanzhiVTO {
	private List<OvBillVO> ovBillVOs;
		private  OvBillVO ovBillVO;

		public OvBillVO getOvBillVO() {
			return ovBillVO;
		}

		public void setOvBillVO(OvBillVO ovBillVO) {
			this.ovBillVO = ovBillVO;
		}

		public List<OvBillVO> getOvBillVOs() {
			return ovBillVOs;
		}

		public void setOvBillVOs(List<OvBillVO> ovBillVOs) {
			this.ovBillVOs = ovBillVOs;
		}
		
		
}
