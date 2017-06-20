package com.baibao.web.p2p.repository.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_creditor_pack;
import com.baibao.web.p2p.generator.dao.P2p_creditor_packMapper;
import com.baibao.web.p2p.repository.CreditorPackRepository;

@Repository
public class CreditorPackRepositoryImpl implements CreditorPackRepository {
    private static Logger logger = LoggerFactory.getLogger(CreditorPackRepositoryImpl.class);

    @Autowired
    private P2p_creditor_packMapper creditorPackMapper;
    
    @Override
    public List<P2p_creditor_pack> findUserByProductNo(Map<String, Object> params) throws RuntimeException
    {
        
        return creditorPackMapper.findByProductNo(params);
    }
    
    @Override
    public Integer selectCountByProductNo(Map<String, Object> params) throws RuntimeException
    {
        
        return creditorPackMapper.selectCountByProductNo(params);
    }
}
