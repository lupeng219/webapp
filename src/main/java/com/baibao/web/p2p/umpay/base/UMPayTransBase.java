package com.baibao.web.p2p.umpay.base;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Component;

import com.baibao.web.p2p.umpay.cons.UMPayBusiType;
import com.umpay.api.common.ReqData;
import com.umpay.api.exception.ReqDataException;
import com.umpay.api.paygate.v40.Mer2Plat_v40;

@Component
public class UMPayTransBase extends UMPayBase{

	/**
	 * 个人客户提现
	 * 接收处理P2P平台发起的个人客户（投资人、融资人）托管账户提现请求，并完成提现到个人客户银行卡，交易结果异步响应商户。
		本接口只是提现申请环节，此时商户只能收到前台通知，作为提现申请的结果反馈，并不能作为交易结果使用。交易结果需要等最终的后台通知。
		验证码有效期：15分钟。
		订单有效期：24小时。	
	 * @param apply_notify_flag		申请成功后台通知标识,提现申请成功后，根据该参数判断是否需要给商户后台通知。通知结果不代表提现最终结果，只作为一个受理成功的结果通知。通知地址与提现结果通知一致，通过service区分。
	 * <br>0：不通知  1：通知  不传默认不通知
	 * @param sourceV	视图类型,传入HTML5可访问手机页面，web不需要传入
	 * @param order_id	商户订单号,商户订单号支持数字、英文字母，其他字符不建议使用,长度4至32位
	 * @param mer_date	商户订单日期,商户生成订单的日期，格式YYYYMMDD
	 * @param user_id	资金账户托管平台的用户号,联动开立的用户号
	 * @param account_id	资金账户托管平台的账户号,联动开立的账户号，商户可以不传递，如果传递必须和开户时返回的保持一致，如果未返回则忽略此字段
	 * @param amount		提现金额,单位：分
	 * @return
	 * @throws ReqDataException
	 */
	public String custWithDrawals(String orderNo,
			String apply_notify_flag,
			String sourceV,
			String user_id,
			String account_id,
			String amount) throws ReqDataException{
		String service = "cust_withdrawals";
		Map<String,String> map = generateRequestBaseMap(service);
		map.put("ret_url", ret_prefix_url + service);
		map.put("notify_url", notify_prefix_url + service);
		
		map.put("apply_notify_flag", apply_notify_flag);
		map.put("sourceV", sourceV);
		map.put("buklFlowNo", orderNo);
		//setOrderIdMerDate(map,user_id, UMPayBusiType.BusiType2.getType(), amount);
		map.put("user_id", user_id);
		map.put("account_id", account_id);
		map.put("amount", amount);
		map.put("order_id", orderNo);
		map.put("mer_date",DateFormatUtils.format(new Date(), "yyyyMMdd"));
		
		ReqData reqData = Mer2Plat_v40.makeReqDataByGet(map);
		String reqURL = reqData.getUrl();
		return reqURL;
	}
	/**
	 * 个人客户提现app
	 * 接收处理P2P平台发起的个人客户（投资人、融资人）托管账户提现请求，并完成提现到个人客户银行卡，交易结果异步响应商户。
		本接口只是提现申请环节，此时商户只能收到前台通知，作为提现申请的结果反馈，并不能作为交易结果使用。交易结果需要等最终的后台通知。
		验证码有效期：15分钟。
		订单有效期：24小时。	
	 * @param apply_notify_flag		申请成功后台通知标识,提现申请成功后，根据该参数判断是否需要给商户后台通知。通知结果不代表提现最终结果，只作为一个受理成功的结果通知。通知地址与提现结果通知一致，通过service区分。
	 * <br>0：不通知  1：通知  不传默认不通知
	 * @param sourceV	视图类型,传入HTML5可访问手机页面，web不需要传入
	 * @param order_id	商户订单号,商户订单号支持数字、英文字母，其他字符不建议使用,长度4至32位
	 * @param mer_date	商户订单日期,商户生成订单的日期，格式YYYYMMDD
	 * @param user_id	资金账户托管平台的用户号,联动开立的用户号
	 * @param account_id	资金账户托管平台的账户号,联动开立的账户号，商户可以不传递，如果传递必须和开户时返回的保持一致，如果未返回则忽略此字段
	 * @param amount		提现金额,单位：分
	 * @return
	 * @throws ReqDataException
	 */
	public String custWithDrawalsApp(String orderNo,
			String apply_notify_flag,
			String sourceV,
			String user_id,
			String account_id,
			String amount) throws ReqDataException{
		String service = "cust_withdrawals";
		Map<String,String> map = generateRequestBaseMap(service);
		map.put("ret_url", ret_prefix_url + "cust_withdrawalsApp");
		map.put("notify_url", notify_prefix_url + service);
		
		map.put("apply_notify_flag", apply_notify_flag);
		map.put("sourceV", sourceV);
		map.put("buklFlowNo", orderNo);
		//setOrderIdMerDate(map,user_id, UMPayBusiType.BusiType2.getType(), amount);
		map.put("user_id", user_id);
		map.put("account_id", account_id);
		map.put("amount", amount);
		map.put("order_id", orderNo);
		map.put("mer_date",DateFormatUtils.format(new Date(), "yyyyMMdd"));
		
		ReqData reqData = Mer2Plat_v40.makeReqDataByGet(map);
		String reqURL = reqData.getUrl();
		return reqURL;
	}
	
}
