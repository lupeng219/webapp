package com.baibao.web.p2p.repository.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.generator.bean.P2p_Pay_Message;
import com.baibao.web.p2p.generator.dao.Pay_MessageMapper;
import com.baibao.web.p2p.repository.Pay_MessageRepository;

@Repository
public class Pay_MessageRepositoryImpl implements Pay_MessageRepository {

    private static Logger logger = LoggerFactory.getLogger(Pay_MessageRepositoryImpl.class);

    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private Pay_MessageMapper pay_MessageMapper;

    @Override
    public String getPayChannelMessage(String code)
    {
        logger.info(" findPayMessageByChannel  by Fuiou  code: %s ", code);

        String message = jedisUtil.getValue("PAY_CHANNEL_MESSAGE_" + code);
        if (StringUtil.isEmpty(message))
        {
            List<P2p_Pay_Message> list = pay_MessageMapper.findPayMessageByChannel("fuiou");
            for (P2p_Pay_Message p2p_Pay_Message : list)
            {
                jedisUtil.setValue("PAY_CHANNEL_MESSAGE_" + p2p_Pay_Message.getPay_code(), p2p_Pay_Message.getPay_message());
            }
            message = jedisUtil.getValue("PAY_CHANNEL_MESSAGE_" + code);
        }
        return message;
    }

}
