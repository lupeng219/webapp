package com.baibao.web.p2p.repository;

import java.util.List;

import com.baibao.web.p2p.generator.bean.P2p_system_params;
/**
 * 配置参数
 * @author hs
 *
 * @date 2017年2月8日
 */
public interface SystemParamsRepository {
	public P2p_system_params getSystemByname(String name) ;
}
