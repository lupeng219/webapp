package com.baibao.web.p2p.repository.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.pay.BussStatus;
import com.baibao.pay.BussType;
import com.baibao.pay.PayLoggerService;
import com.baibao.utils.MapBuilder;
import com.baibao.web.p2p.generator.bean.P2p_public_order;
import com.baibao.web.p2p.generator.dao.P2p_public_orderMapper;
import com.baibao.web.p2p.repository.PublicOrderRepository;

@Repository
public class PublicOrderRepositoryImpl
	implements PublicOrderRepository, PayLoggerService
{
	private static Logger log =
		LoggerFactory.getLogger(PublicOrderRepositoryImpl.class);

	@Autowired
	private P2p_public_orderMapper publicOrderMapper;
	
	@Override
	public int insertPublicOrder(P2p_public_order record)
	{
		int retValue=0;
		
		try
		{
			if (record != null)
			{
				retValue= publicOrderMapper.insert(record);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
			log.error("error", e);
		}
		
		return retValue;
	}

	@Override
	public int updateByOrderFlowNo(String orderFlowNo, String ppoStatus)
	{	
		return publicOrderMapper.updateByOrderFlowNo(orderFlowNo, ppoStatus);
	}

	@Override
	public P2p_public_order selectByPrimaryKey(String orderFlowNo)
	{
		return publicOrderMapper.selectByPrimaryKey(orderFlowNo);
	}

	@Override
	@Transactional
	public void log(
		Timestamp timestamp, String tradeNo,
		BussType type, String busDesc, String channel,
		String custNo, String targetNo,
		String request, String response, BussStatus status)
	{
		try
		{
			publicOrderMapper.insert2(
				new MapBuilder<String, Object>()
					.append("ppoOrderTime", timestamp)
					.append("ppoOrderflowno", tradeNo)
					.append("ppoCustno", custNo)
					.append("ppoBussType", type.getCode())
					.append("ppoBussDesc", busDesc == null? type.getDesc(): busDesc)
					.append("ppoTargetno", targetNo)
					.append("ppoAccountchannel", channel)
					.append("ppoStatus", status.getCode())
					.append("ppoParams", request)
					.append("ppoResponse", response)
					.toMap()
				);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	@Override
	@Transactional
	public void logback(
		Timestamp timestamp, String tradeNo, String response, BussStatus status)
	{
		try
		{
			publicOrderMapper.updateByOrderFlowNo2(
				new MapBuilder<String, Object>()
					.append("ppoOrderTime", timestamp)
					.append("orderFlowNo", tradeNo)
					.append("ppoStatus", status.getCode())
					.append("ppoResponse", response)
					.toMap()
				);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public String queryLogField(String tradeNo, String fieldName) {
		return null;
	}

	@Override
	public String queryLogJon(String tradeNo) {
		return null;
	}
}
