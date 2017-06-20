package com.baibao.web.p2p.generator.dao;

import java.util.List;

import com.baibao.web.p2p.generator.bean.P2p_Pay_Message;

/**
 * 
 * @author Denny
 * @date 2016年6月23日
 */
public interface Pay_MessageMapper {

    public List<P2p_Pay_Message> findPayMessageByChannel(String channel);
    
}
