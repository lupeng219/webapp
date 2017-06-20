package com.baibao.web.p2p.repository.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;
import com.baibao.web.p2p.generator.dao.P2p_users_redenvelopeMapper;
import com.baibao.web.p2p.repository.UsersRedenvelopeRepository;

@Repository("usersRedenvelopeRepository")
public class UsersRedenvelopeRepositoryImpl implements UsersRedenvelopeRepository {

	private static Logger log = LoggerFactory.getLogger(UsersRedenvelopeRepositoryImpl.class); 
	@Autowired
	private P2p_users_redenvelopeMapper p2p_users_redenvelopeMapper;
	
	@Override
	public List<Map<String, Object>> queryRedenvelopeBycustNo(String custNo,
			String status) throws BusinessException {
		return p2p_users_redenvelopeMapper.queryRedenvelopeBycustNo(custNo, status);
	}

	@Override
	public void updateRedenvelopeMature() {
		//查询未使用、小于当前时间红包
		List<P2p_users_redenvelope> redenvelopeList  = p2p_users_redenvelopeMapper.queryRedenvelopeNotused(); 
		if(redenvelopeList.size()>0){
			//更新过期红包状态
			int count = p2p_users_redenvelopeMapper.updateRedenvelopeMature(redenvelopeList);
			log.info(new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").format(new Date())+"更新过期红包"+redenvelopeList.size()+"个，更新成功" + count);
		}else{
			log.info(new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").format(new Date())+"There is no need to update the red envelope");
		}
		
	}
	
	@Override
	public int getRedenvelopeLotteryDrawNo(String lotteryDrawNo) {
		return p2p_users_redenvelopeMapper.getRedenvelopeLotteryDrawNo(lotteryDrawNo);
	}

	@Override
	public int saveRedenvelope(Map<String, Object> parameter)
			throws BusinessException {
		return p2p_users_redenvelopeMapper.saveRedenvelope(parameter);
	}

}