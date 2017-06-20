package com.baibao.web.p2p.service;

import java.util.List;

import com.baibao.web.p2p.generator.bean.P2p_mobile_app;

/**
 * @author lupeng
 * @date: 2016年1月27日下午4:20:11
 */
public interface MobileAppService {
	public P2p_mobile_app findAll();

	public int saveMobileApp(P2p_mobile_app app);

	public int updateMobileApp(P2p_mobile_app app);
}
