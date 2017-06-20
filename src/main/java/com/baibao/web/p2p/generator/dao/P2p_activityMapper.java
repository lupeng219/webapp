package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

public interface P2p_activityMapper {

	/**
	 * 更新活动代收流水
	 * @param context
	 * @param judgment
	 * @return
	 */
	public int updateActiveB2cTransAid(Map<String, Object> map);
	
	/**
	 * 查询活动代收成功列表 （跑批请求代付使用）
	 * @return
	 */
	List<Map<String, Object>> selectActiveTransByStatus();
	    
    /**
     * 查询代收流水状态为处理中的数据（跑批使用）
     */
    List<Map<String, Object>> selectActiveTransAidByProcessing();
   
    /**
     * 查询代付流水状态为处理中的数据（跑批使用）
     */
    List<Map<String, Object>> selectActiveTransByProcessing();

	
	/**
	 * 更新活动代付流水
	 * @param context
	 * @param judgment
	 * @return
	 */
	public int updateActiveB2cTrans(Map<String, Object> map);


}
