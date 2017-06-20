package com.baibao.web.p2p.service;

import com.baibao.web.p2p.controller.pay.CommonAnswer;
import com.baibao.web.p2p.controller.pay.FuyouResponse;

public interface FuyouPayService
{
	public FuyouResponse<CommonAnswer>
		depositNofity(
			String resp_code, String resp_desc,
			String mchnt_cd, String mchnt_txn_ssn,
			String login_id, String rem, Long amt, String signature);
	
	public FuyouResponse<CommonAnswer>
    appDepositNofity(
        String resp_code, String resp_desc,
        String mchnt_cd, String mchnt_txn_ssn,
        String login_id, Long amt, String signature);
	
	public FuyouResponse<CommonAnswer>
		withdrawNofity(
			String resp_code, String resp_desc,
			String mchnt_cd, String mchnt_txn_ssn, String login_id, Long amt,
			String signature, boolean sendSms);
	
	public FuyouResponse<CommonAnswer> changePhone(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn,
		String login_id, String new_mobile, String signature);

	public FuyouResponse<CommonAnswer> changeCard(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn, String signature);
}
