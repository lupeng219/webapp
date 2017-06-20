package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_loan_record;
import com.baibao.web.p2p.generator.bean.P2p_loan_recordExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface P2p_loan_recordMapper {
    int countByExample(P2p_loan_recordExample example);

    int deleteByExample(P2p_loan_recordExample example);

    int deleteByPrimaryKey(Long ptfId);

    int insert(P2p_loan_record record);

    int insertSelective(P2p_loan_record record);

    List<P2p_loan_record> selectByExample(P2p_loan_recordExample example);

    P2p_loan_record selectByPrimaryKey(Long ptfId);

    int updateByExampleSelective(@Param("record") P2p_loan_record record, @Param("example") P2p_loan_recordExample example);

    int updateByExample(@Param("record") P2p_loan_record record, @Param("example") P2p_loan_recordExample example);

    int updateByPrimaryKeySelective(P2p_loan_record record);

    int updateByPrimaryKey(P2p_loan_record record);
    
    P2p_loan_record getLoanRecordByFlowNo(@Param("flowNo")String flowNo);
    
    int updateloanRecord(Map<String, Object>map);
    /**
     * 查询可疑的流水
     * @return
     */
    List<Map<String, Object>> querySuspiciousPaymentFlow();
    
    /**
     * 更新结标代付的记录
     * @param paramMap
     * @return
     */
	public int updateSuspiciousPaymentFlow(Map<String, Object> paramMap);
	
	/**
	 * 修改产品的最终状态
	 * @param paramMap
	 * @return
	 */
	public int updateLoanProductStatus(Map<String, Object> paramMap);
}