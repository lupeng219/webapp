package com.baibao.web.p2p.comm;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 工具类
 * @author yangyang
 *
 */
public class UtilTools {
	/**
	 * 判断金额是否在某一金额区间之内
	 * @param fromVal 最小金额
	 * @param toVal 最大金额
	 * @param val 比较金额
	 * @param onset 是否取起始金额值
	 * @return
	 */
	public static boolean isBetweenDecimal(BigDecimal fromVal,BigDecimal toVal,BigDecimal val,Boolean onset){
		if(onset){
			
			if(val.compareTo(fromVal)>=0 && val.compareTo(toVal)<0)
				return true;
			return false;
		}else{
			
			if(val.compareTo(fromVal)>0 && val.compareTo(toVal)<0)
				return true;
			return false;
		}
	}
	
	public static String getUUId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
