package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadPoolExecutor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.pay.BussStatus;
import com.baibao.pay.PayLoggerService;
import com.baibao.pay.PayService;
import com.baibao.utils.JaxbHelper;
import com.baibao.utils.JsonHelper;
import com.baibao.utils.MapBuilder;
import com.baibao.utils.Utils;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.controller.pay.CommonAnswer;
import com.baibao.web.p2p.controller.pay.FuyouResponse;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_public_order;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.repository.AccountRepository;
import com.baibao.web.p2p.repository.CustAccountRepository;
import com.baibao.web.p2p.repository.PublicOrderRepository;
import com.baibao.web.p2p.service.BankCardService;
import com.baibao.web.p2p.service.FuyouPayService;
import com.baibao.web.p2p.utils.SMSUtil;
import com.esotericsoftware.minlog.Log;
import com.fuiou.util.SecurityUtils;

@Service("fuyouPayService")
public class FuyouPayServiceImpl
	implements FuyouPayService
{
    private static final Logger log = LoggerFactory.getLogger(FuyouPayServiceImpl.class);

	@Autowired
	private PayLoggerService payLoggerService;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	protected CustAccountRepository custAccountRepository;

	@Autowired
	protected PayService payService;

	@Autowired
	protected BankCardService bankCardService;

	@Autowired
	protected ThreadPoolExecutor threadPool;

	@Value("${service-tel}")
	protected String serviceTel;

	protected SimpleDateFormat dateFormater =
		new SimpleDateFormat("yyyy-MM-dd");

	@Override
	@Transactional
	public FuyouResponse<CommonAnswer>
		depositNofity(
			String resp_code, String resp_desc,
			String mchnt_cd, String mchnt_txn_ssn,
			String login_id, String rem, Long amt, String signature)
	{
		FuyouResponse<CommonAnswer> response =
			new FuyouResponse<CommonAnswer>();
		
		CommonAnswer answer = new CommonAnswer();

		answer.setMchnt_cd(mchnt_cd);
		answer.setMchnt_txn_ssn(mchnt_txn_ssn);
		
		boolean verifySign = false;
		verifySign = SecurityUtils.verifySign(
                Utils.joinStr(new String[] {
                    String.valueOf(amt), login_id, mchnt_cd,
                    mchnt_txn_ssn, rem, resp_code
                }, "|"), signature);
		
		if (verifySign)
		{
			int code = Integer.parseInt(resp_code);

			if (code == 0)
			{
				response.setMessage("成功");
			} else
			{
				response.setMessage(String.format("失败（%s）", resp_desc));
			}
			
			P2p_cust_account account =
				accountRepository.getCustAccountByIdOrCustNo(login_id);

			if (account != null)
			{
				custAccountRepository.updateAccountBalance(
					account.getPcaAccountno(), account.getPcaCustNo());
			}

			payLoggerService.logback(
				Utils.now(), mchnt_txn_ssn,
				JsonHelper.formatJson(
					new MapBuilder<String, Object>()
						.append("resp_code", resp_code)
						.append("resp_desc", resp_desc)
						.append("mchnt_cd", mchnt_cd)
						.append("mchnt_txn_ssn", mchnt_txn_ssn)
						.append("login_id", login_id)
						.append("rem", rem)
						.append("amt", amt)
						.append("signature", signature)
						.toMap()),
				(code == 0)? BussStatus.success: BussStatus.failed);

			accountRepository.updateSuspiciousFlow(
				mchnt_txn_ssn, (code == 0)? Const.success: Const.fail);

			answer.setResp_code("0000");
		} else
		{
			answer.setResp_code("0010");
			
			response.setMessage(String.format("失败（%s）", resp_desc));
		}

		response.setPlain(answer);
		response.setSignature(
			SecurityUtils.sign(JaxbHelper.formatXml(answer)));

		return response;
	}
	
	@Override
    @Transactional
    public FuyouResponse<CommonAnswer>
        appDepositNofity(
            String resp_code, String resp_desc,
            String mchnt_cd, String mchnt_txn_ssn,
            String login_id, Long amt, String signature)
    {
        FuyouResponse<CommonAnswer> response =
            new FuyouResponse<CommonAnswer>();
        
        CommonAnswer answer = new CommonAnswer();

        answer.setMchnt_cd(mchnt_cd);
        answer.setMchnt_txn_ssn(mchnt_txn_ssn);
        
        boolean verifySign = false;
        verifySign = SecurityUtils.verifySign(
                Utils.joinStr(new String[] {
                    String.valueOf(amt), login_id, mchnt_cd,
                    mchnt_txn_ssn, resp_code
                }, "|"), signature);

        if (!verifySign)
        {
        	verifySign = SecurityUtils.verifySign(
                Utils.joinStr(new String[] {
                    String.valueOf(amt), login_id, mchnt_cd,
                    mchnt_txn_ssn, resp_code, resp_desc
                }, "|"), signature);
        }
        
        if (verifySign)
        {
            int code = Integer.parseInt(resp_code);

            if (code == 0)
            {
                response.setMessage("成功");
            } else
            {
                response.setMessage(String.format("失败（%s）", resp_desc));
            }
            
            P2p_cust_account account =
                accountRepository.getCustAccountByIdOrCustNo(login_id);

            if (account != null)
            {
                custAccountRepository.updateAccountBalance(
                    account.getPcaAccountno(), account.getPcaCustNo());
            }

            payLoggerService.logback(
                Utils.now(), mchnt_txn_ssn,
                JsonHelper.formatJson(
                    new MapBuilder<String, Object>()
                        .append("resp_code", resp_code)
                        .append("resp_desc", resp_desc)
                        .append("mchnt_cd", mchnt_cd)
                        .append("mchnt_txn_ssn", mchnt_txn_ssn)
                        .append("login_id", login_id)
                        .append("rem", "")
                        .append("amt", amt)
                        .append("signature", signature)
                        .toMap()),
                (code == 0)? BussStatus.success: BussStatus.failed);

            accountRepository.updateSuspiciousFlow(
                mchnt_txn_ssn, (code == 0)? Const.success: Const.fail);

            answer.setResp_code("0000");
        } else
        {
            answer.setResp_code("0010");
            
            response.setMessage(String.format("失败（%s）", resp_desc));
        }

        response.setPlain(answer);
        response.setSignature(
            SecurityUtils.sign(JaxbHelper.formatXml(answer)));

        return response;
    }

	@Override
	@Transactional
	public FuyouResponse<CommonAnswer>
		withdrawNofity(
			String resp_code, String resp_desc,
			String mchnt_cd, String mchnt_txn_ssn,
			final String login_id, final Long amt,
			String signature, boolean sendSms)
	{
		FuyouResponse<CommonAnswer> response =
			new FuyouResponse<CommonAnswer>();
		
		CommonAnswer answer = new CommonAnswer();

		answer.setMchnt_cd(mchnt_cd);
		answer.setMchnt_txn_ssn(mchnt_txn_ssn);

		if (SecurityUtils.verifySign(
				Utils.joinStr(new String[] {
					String.valueOf(amt), login_id, mchnt_cd,
					mchnt_txn_ssn, resp_code
				}, "|"), signature))
		{
			int code = Integer.parseInt(resp_code);

			if (code == 0)
			{
				response.setMessage("成功");
			} else
			{
				response.setMessage(String.format("失败（%s）", resp_desc));
			}

			final P2p_cust_account account =
				accountRepository.getCustAccountByIdOrCustNo(login_id);

			if (account != null)
			{
				custAccountRepository.updateAccountBalance(
					account.getPcaAccountno(), account.getPcaCustNo());
			}

			payLoggerService.logback(
				Utils.now(), mchnt_txn_ssn,
				JsonHelper.formatJson(
					new MapBuilder<String, Object>()
						.append("resp_code", resp_code)
						.append("resp_desc", resp_desc)
						.append("mchnt_cd", mchnt_cd)
						.append("mchnt_txn_ssn", mchnt_txn_ssn)
						.append("login_id", login_id)
						.append("amt", amt)
						.append("signature", signature)
						.toMap()),
				(code == 0)? BussStatus.success: BussStatus.failed);

			accountRepository.updateSuspiciousFlow(
				mchnt_txn_ssn, (code == 0)? Const.success: Const.fail);

			answer.setResp_code("0000");
			

			if (sendSms)
			{
				threadPool.execute(new Runnable() {
					@Override
					public void run()
					{
						try
						{
							log.info(String.format("send withd sms: %s", login_id));
	
							bankCardService.refreshCard(
								account.getPcaAccountno(),
								account.getPcaCustNo());
							
							P2p_bank_card card =
								bankCardService.getBankCardByCustNo(
									account.getPcaCustNo());
							
							SMSUtil.sendMessage(MessageType.WITHDRAW,
								login_id,
								new MapBuilder<String, Object>()
									.append("#date#", dateFormater.format(Utils.now()))
									.append("#price#",
										String.valueOf(new BigDecimal(amt).divide(new BigDecimal(100))))
									.append("#bank#", card.getPbcBankcardno().substring(card.getPbcBankcardno().length() - 4))
									.append("#telephone#", serviceTel)
									.toMap());
						} catch(Exception e)
						{
							log.error("", e);
						}
					}
				});
			}
		} else
		answer.setResp_code("0010");

		response.setPlain(answer);
		response.setSignature(
			SecurityUtils.sign(JaxbHelper.formatXml(answer)));

		return response;
	}

	@Override
	public FuyouResponse<CommonAnswer> changePhone(
		String resp_code, String resp_desc, String mchnt_cd,
		String mchnt_txn_ssn, String login_id,
		String new_mobile, String signature)
	{
		FuyouResponse<CommonAnswer> response =
			new FuyouResponse<CommonAnswer>();
		
		CommonAnswer answer = new CommonAnswer();

		answer.setMchnt_cd(mchnt_cd);
		answer.setMchnt_txn_ssn(mchnt_txn_ssn);
		
		if (SecurityUtils.verifySign(
				Utils.joinStr(new String[] {
					login_id, mchnt_cd, mchnt_txn_ssn,
					new_mobile, resp_code, resp_desc
				}, "|"), signature))
		{

			int code = Integer.parseInt(resp_code);

			if (code == 0)
			{
				response.setMessage("成功");
			} else
			{
				response.setMessage(String.format("失败（%s）", resp_desc));
			}

			payLoggerService.logback(
				Utils.now(), mchnt_txn_ssn,
				JsonHelper.formatJson(
					new MapBuilder<String, Object>()
						.append("mchnt_cd", mchnt_cd)
						.append("mchnt_txn_ssn", mchnt_txn_ssn)
						.append("resp_code", resp_code)
						.append("resp_desc", resp_desc)
						.append("login_id", login_id)
						.append("new_mobile", new_mobile)
						.append("signature", signature)
						.toMap()),
				BussStatus.success);

			accountRepository.updateSuspiciousFlow(
				mchnt_txn_ssn, Const.success);

			answer.setResp_code("0000");
		} else
		answer.setResp_code("0010");

		response.setPlain(answer);
		response.setSignature(
			SecurityUtils.sign(JaxbHelper.formatXml(answer)));

		return response;
	}

	@Override
	@Transactional
	public FuyouResponse<CommonAnswer> changeCard(
		String resp_code, String resp_desc, String mchnt_cd,
		String mchnt_txn_ssn, String signature)
	{
		FuyouResponse<CommonAnswer> response =
			new FuyouResponse<CommonAnswer>();
		
		CommonAnswer answer = new CommonAnswer();

		answer.setMchnt_cd(mchnt_cd);
		answer.setMchnt_txn_ssn(mchnt_txn_ssn);
		
		if (SecurityUtils.verifySign(
				Utils.joinStr(new String[] {
					mchnt_cd, mchnt_txn_ssn, resp_code, resp_desc
				}, "|"), signature))
		{
			int code = Integer.parseInt(resp_code);

			if (code == 0)
			{
				response.setMessage("成功");
			} else
			{
				response.setMessage(String.format("失败（%s）", resp_desc));
			}

			/*payLoggerService.logback(
				Utils.now(), mchnt_txn_ssn,
				JsonHelper.formatJson(
					new MapBuilder<String, Object>()
						.append("mchnt_cd", mchnt_cd)
						.append("mchnt_txn_ssn", mchnt_txn_ssn)
						.append("resp_code", resp_code)
						.append("resp_desc", resp_desc)
						.append("signature", signature)
						.toMap()),
				BussStatus.success);*/

			answer.setResp_code("0000");
		} else
		answer.setResp_code("0010");

		response.setPlain(answer);
		response.setSignature(
			SecurityUtils.sign(JaxbHelper.formatXml(answer)));

		return response;
	}
}
