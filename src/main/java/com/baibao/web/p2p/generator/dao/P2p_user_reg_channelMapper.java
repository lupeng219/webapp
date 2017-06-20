package com.baibao.web.p2p.generator.dao;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_user_reg_channel;

public interface P2p_user_reg_channelMapper {

	public int saveRegChannel(P2p_user_reg_channel regChannel) throws BusinessException;
	
}
