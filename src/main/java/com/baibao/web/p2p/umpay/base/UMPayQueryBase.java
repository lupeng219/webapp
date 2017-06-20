package com.baibao.web.p2p.umpay.base;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.umpay.api.common.ReqData;
import com.umpay.api.exception.ReqDataException;
import com.umpay.api.paygate.v40.Mer2Plat_v40;

@Component
public class UMPayQueryBase extends UMPayBase{

	/**
	 * 交易查询
	 * 接收处理P2P平台发起的交易查询请求，返还相应交易状态和信息。
		包括充值、提现、标的转账，转账。
	 * @param order_id	商户订单号,商户订单号支持数字、英文字母，其他字符不建议使用
	 * @param mer_date	商户订单日期,商户生成订单的日期，格式YYYYMMDD
	 * @param busi_type	交易类型	取值范围：01充值,02提现,03标的转账,04转账
	 * @return
	 * @throws ReqDataException
	 */
	public Map<String,String> transferSearch(String order_id,
			String mer_date,
			String busi_type) throws ReqDataException{
		String service = "transfer_search";
		Map<String,String> map = generateRequestBaseMap(service);
		
		map.put("order_id", order_id);
		map.put("mer_date", mer_date);
		map.put("busi_type", busi_type);
		
		ReqData reqData = Mer2Plat_v40.makeReqDataByGet(map);
		String reqURL = reqData.getUrl();		
		return analyseResponseResult(reqURL);		
	}
	
	
	/**
	 * 用户查询
	 * <br>
	 * 接收处理P2P商户发起的账户（个人账户和企业账户）查询请求，返还相应用户状态、账户状态、余额
	 * @param user_id	资金账户托管平台用户号,联动开立的用户号
	 * @param is_find_account	是否查询余额,01：查询 02：不查（默认）
	 * @param is_select_agreement	是否查询授权协议,1：查询 0：不查（默认）
	 * @return
	 * @throws ReqDataException
	 */
	public Map<String,String> userSearch(String user_id,
			String is_find_account,
			String is_select_agreement) throws ReqDataException{
		String service = "user_search";
		Map<String,String> map = generateRequestBaseMap(service);
		
		map.put("user_id", user_id);
		map.put("is_find_account", is_find_account);
		map.put("is_select_agreement", is_select_agreement);
		
		ReqData reqData = Mer2Plat_v40.makeReqDataByGet(map);
		String reqURL = reqData.getUrl();		
		return analyseResponseResult(reqURL);
	}

}
