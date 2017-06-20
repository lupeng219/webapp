package com.baibao.web.p2p.service;

import java.util.Map;

/**
 * ClassName: PiggyBankService 
 * @Description: 
 * @author zhangpengxiang
 * @date 2016年4月13日
 */
public interface PiggyBankService
{	
	/**
	 * 查询用户存钱罐基本信息
	 * @param custNo
	 * @return
	 */
	public Map<String, Object> getEssentialInformation(String custNo);

	/**
	 * 查询新浪7天收益率
	 * @return
	 */
	public Map<String, Object> getYieldrate() throws Exception;
	
	/**
	 * 新浪页面查询用户信息
	 * @return
	 */
	public Map<String, Object> showMemberInfosSina(String custNo);
}
