package com.baibao.web.p2p.service;

import java.util.List;
import java.util.Map;

/**
 * 统计业务实现接口
 * @author yangyang
 *
 */
public interface StatisticalService
{
	public void saveVisitorsInfo(
		String ip, String accessResource,
		String accessFrom, String user_agent,
		String custNo, String data);
	
	public void updateIpInfo(String ip);

	public List<Map<String, Object>> selectIpForDeal();
}
