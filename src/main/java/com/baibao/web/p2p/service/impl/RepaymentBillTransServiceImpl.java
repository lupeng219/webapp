package com.baibao.web.p2p.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.web.p2p.repository.RepaymentBillRepository;
import com.baibao.web.p2p.service.RepaymentBillTransService;
@Service("repaymentBillTransService")
public class RepaymentBillTransServiceImpl implements RepaymentBillTransService {
	
	@Autowired
	private RepaymentBillRepository  repaymentBillRepository;
	
	/*@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public int addRepaymentBillTrans(P2p_repayment_bill_trans repaymentBillTtrans) throws RuntimeException{
		return repaymentRepository.insert(repaymentBillTtrans);
	}

	@Override
	@Transactional(rollbackFor = RuntimeException.class)
	public int updateRepaymentBillTranSatus(String prtRepaybillno) throws RuntimeException{
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			repaymentRepository.updatePrtRepaystatus(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}*/

}
