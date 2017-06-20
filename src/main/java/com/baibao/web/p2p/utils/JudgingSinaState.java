package com.baibao.web.p2p.utils;

import java.util.Map;
public class JudgingSinaState {
	
	/*private static final String[] _sina_pay_status = {"SUCCESS","PROCESSING"};
	private static final String[] _sina_trade_status = {"WAIT_PAY","PAY_FINISHED","TRADE_FINISHED"};
	private static final String[] _sina_pay_fail_status = {"FAILED"};
	private static final String[] _sina_trade_fail_status = {"TRADE_FAILED","TRADE_CLOSED"};*/
	
	/**
	 * 判断还款代收代付的状态
	 * @param map
	 * @return
	 */
	public static boolean judgingState(Map<String, Object> tendMap){
		Boolean result = false;
		if(ControllerRetType.OPT_SUCC.getTransCode().equals(tendMap.get("retCode"))){
			result = true;
		}else{
			//申请失败
			result = false;
		}
		return result;
	};
}
