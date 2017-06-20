package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_system_params;

public interface P2p_system_paramsMapper {
	/**
	 * 查询系统配置参数
	 * @param result
	 * @return
	 * @throws BusinessException
	 */
	public P2p_system_params queryParamsBynames(String name) throws BusinessException;
}
