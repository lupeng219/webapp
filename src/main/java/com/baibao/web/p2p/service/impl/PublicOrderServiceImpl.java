package com.baibao.web.p2p.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.pay.BussStatus;
import com.baibao.pay.BussType;
import com.baibao.pay.PayLoggerService;
import com.baibao.web.p2p.generator.bean.P2p_public_order;
import com.baibao.web.p2p.repository.PublicOrderRepository;
import com.baibao.web.p2p.service.PublicOrderService;

@Service("publicOrderService")
public class PublicOrderServiceImpl
	implements PublicOrderService
{
	@Autowired
	private PublicOrderRepository  publicOrderRepository;
	
	@Override
	public int insertPublicOrder(P2p_public_order record) {
		
		return publicOrderRepository.insertPublicOrder(record);
	}

	@Override
	public int updateByOrderFlowNo(String orderFlowNo, String ppoStatus) {
		
		return publicOrderRepository.updateByOrderFlowNo(orderFlowNo, ppoStatus);
	}

	@Override
	public P2p_public_order selectByPrimaryKey(String orderFlowNo) {
		
		return publicOrderRepository.selectByPrimaryKey(orderFlowNo);
	}
}
