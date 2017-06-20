package com.baibao.web.p2p.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.core.exception.BusinessException;
import com.baibao.utils.Utils;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_picture;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;
import com.baibao.web.p2p.generator.dao.P2p_loan_productMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_product_aidMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_product_pictureMapper;
import com.baibao.web.p2p.generator.dao.P2p_tender_recordMapper;
import com.baibao.web.p2p.repository.LoanProductAidRepository;

@Repository
public class LoanProductAidRepositoryImpl implements LoanProductAidRepository {

	@Autowired
	private P2p_loan_product_aidMapper loanProductAidMapper;
	@Autowired
	private P2p_loan_productMapper loanProductMapper;
	@Autowired
	private P2p_tender_recordMapper tenderRecordMapper;
	@Autowired
	private P2p_loan_product_pictureMapper loanProductPictureMapper; 
	
	@Override
	public List<P2p_loan_product_aid> queryTenderRecordByCust(Map<String, Object> params) {
		return loanProductAidMapper.queryTenderRecordByCust(params);
	}

	@Override
	public Integer getCustTenderRecordTotal(Map<String, Object> params) {
		return loanProductAidMapper.getCustTenderRecordTotal(params);
	}

	@Override
	public List<P2p_loan_product_aid> queryProductAid(Map<String, Object> params) {
		return loanProductAidMapper.queryPorductAid(params);
	}

	@Override
	public P2p_loan_product_aid queryByProductNo(String productNo) {
		return loanProductAidMapper.queryByProductNo(productNo);
	}

	@Override
	public List<Map<String, Object>> findLoanProductAidPage(
			Map<String, Object> params) {
		return loanProductAidMapper.findLoanProductAidPage(params);
	}

	@Override
	public int findLoanProductAidTotal(Map<String, Object> params) {
		return loanProductAidMapper.findLoanProductAidTotal(params);
	}

	@Override
	public List<P2p_tender_record> queryTenderRecordByPorductNo(Map<String, Object> params) {
		return tenderRecordMapper.queryTenderRecordByPorductNo(params);
	}

	@Override
	public Integer selectTotalByPorductNo(Map<String, Object> params) {
		return tenderRecordMapper.selectTotalByPorductNo(params);
	}

	@Override
	public List<P2p_loan_product_aid> findLoanProductAidListPage(Map<String, Object> params)
	{
		params.put("now", Utils.now());

		return loanProductAidMapper.findLoanProductAidListPage(params);
	}
	
	@Override
	public int getLoanProductAidListTotal(Map<String, Object> params)
	{
		params.put("now", Utils.now());

		return loanProductAidMapper.getLoanProductAidListTotal(params);
	}
	
	@Override
	public List<P2p_loan_product_aid> findLoanProductAidCreditTransListPage(Map<String, Object> params)
	{
		params.put("now", Utils.now());

		return loanProductAidMapper.findLoanProductAidCreditTransListPage(params);
	}
	
	@Override
	public int getLoanProductAidCreditTransListTotal(Map<String, Object> params)
	{
		params.put("now", Utils.now());

		return loanProductAidMapper.getLoanProductAidCreditTransListTotal(params);
	}

	@Override
	public List<P2p_loan_product_aid> findActiveProductAidList() {
		return loanProductAidMapper.findActiveProductAidList();
	}

	@Override
	public Map<String, Object> queryPorductAidActiveApp() {
		return loanProductAidMapper.queryPorductAidActiveApp();
	}

	@Override
	public Map<String, Object> queryPorductAidApp() {
		return loanProductAidMapper.queryPorductAidApp();
	}

	@Override
	public List<P2p_loan_product_picture> selectByproductNo(
			Map<String, Object> map) {
		return loanProductPictureMapper.selectByproductNo(map);
	}

	@Override
	public List<Map<String, Object>> tenderRecordByCustNo(
			Map<String, Object> map) {
		return tenderRecordMapper.tenderRecordByCustNo(map);
	}

	@Override
	public int tenderRecordByCustNoCount(Map<String, Object> map) {
		return tenderRecordMapper.tenderRecordByCustNoCount(map);
	}

	@Override
	public List<P2p_loan_product_aid> queryProductAidBydybz(Map<String, Object> map)
	{
		map.put("now", Utils.now());


		return loanProductAidMapper.queryProductAidBydybz(map);
	}

	@Override
	public List<P2p_loan_product_aid> queryAssetsPackProductAid(Map<String, Object> map)
	{
		map.put("now", Utils.now());

		return loanProductAidMapper.queryAssetsPackProductAid(map);
	}
	
	@Override
	public List<P2p_loan_product_aid> queryTermDaysProductAid(Map<String, Object> map)
	{
		map.put("now", Utils.now());

		return loanProductAidMapper.queryTermDaysProductAid(map);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int updateProductLoanStatus(String productNo, String loanStatus) {
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("pp_productNo", productNo);
		map.put("pp_bulkLoanStatus", loanStatus);
		int countaid =loanProductAidMapper.updateLoanProductStatus(map);
		int count =loanProductMapper.updateLoanProductStatus(map);
		if(countaid!=0&&count!=0){
			return 1;
		}
		return 0;
	}

	@Override
	public P2p_loan_product_aid queryNoviceExclusive() {
		
		return loanProductAidMapper.queryNoviceExclusive();
	}
	
	@Override
	public List<P2p_loan_product_aid> queryNoviceExclusives() {
		
		return loanProductAidMapper.queryNoviceExclusives();
	}

	@Override
	public List<P2p_loan_product_aid> findLoanListByActivityType(
			Map<String, Object> params) {
			params.put("now", Utils.now());
		return loanProductAidMapper.findLoanListByActivityType(params);
	}

	@Override
	public int findLoanListByActivityTypeCount(Map<String, Object> params) {
			params.put("now", Utils.now());
		return loanProductAidMapper.findLoanListByActivityTypeCount(params);
	}

	@Override
	public List<P2p_tender_record> queryOldTenderRecord(
			Map<String, Object> params) {
		return tenderRecordMapper.queryOldTenderRecord(params);
	}
	
	@Override
	public Integer selectOldTotal(Map<String, Object> params) {
		return tenderRecordMapper.selectOldTotal(params);
	}

	@Override
	public Map<String, Object> getProductNo(String productNo)
			throws BusinessException {
		
		return loanProductAidMapper.getProductNo(productNo);
	}
	
	@Override
	public Map<String, Object> getequitableAssignments(Map<String, Object> map)
			throws BusinessException {
		if(map==null){
			return map;
		}
		return loanProductAidMapper.getequitableAssignments(map);
	}
	
	@Override
	public Map<String, Object> loanGuaranteeAgreements(Map<String, Object> map) {
		return loanProductAidMapper.loanGuaranteeAgreements(map);
	}

	@Override
	public Map<String, Object> loanAgreements(Map<String, Object> map) {
		if(map ==null){
			return null;
		}
		return loanProductAidMapper.loanAgreements(map);
	}

	@Override
	public Map<String, Object> findByTenderFlowNo(String tenderFlowNo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ptrTenderFlowNo", tenderFlowNo);
		return tenderRecordMapper.findByTenderFlowNo(params);
	}

	@Override
    public List<P2p_loan_product_aid> tenderAssigning(Map<String, Object> params) {
        return loanProductAidMapper.tenderAssigning(params);
    }
    
    @Override
    public int tenderAssigningCount(Map<String, Object> map) {
        return loanProductAidMapper.tenderAssigningCount(map);
    }
    
    @Override
    public List<P2p_loan_product_aid> tenderAssignFinish(Map<String, Object> params) {
        return loanProductAidMapper.tenderAssignFinish(params);
    }
    
    @Override
    public int tenderAssignFinishCount(Map<String, Object> map) {
        return loanProductAidMapper.tenderAssignFinishCount(map);
    }

    @Override
    public Map<String, Object> queryPorductAidAppDirect() {
        return loanProductAidMapper.queryPorductAidAppDirect();
    }

    @Override
    public Map<String, Object> queryPorductAidAppDay() {
        return loanProductAidMapper.queryPorductAidAppDay();
    }

    @Override
    public Integer queryPorductAidAppAttornCount() {
        return loanProductAidMapper.queryPorductAidAppAttornCount();
    }
    
    
}
