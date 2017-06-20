
package com.baibao.core.utils;

import java.math.BigDecimal;

/**  
 *  
 * @author bottle  
 * 
 * 金额计算的工具类
 * 
 */

public class MathUtil {
	
	
    /*
     * 提供两个数字的精确加法
     * 
     */
	public static BigDecimal  add(BigDecimal para1,BigDecimal para2) {
		BigDecimal sum=para1.add(para2);
		 return sum ;
		 
	}
	
	/*
     * 提供两个数字的精确减法
     * @para1 减数
     * @para2 被减数
     *  
     * 返回值得精确度取para1 he para2中较大的一个
     * 
     */
	public static BigDecimal  subtraction(BigDecimal para1,BigDecimal para2) {
		BigDecimal sum=para1.subtract(para2);
		 return sum ;
		 
	}
	/*
	 * 提供两个数字的精确乘法
	 * 结果的精确度=乘数的精确度+被乘数的精确度
	 * 
	 */
	public static BigDecimal  multiplication(BigDecimal para1,BigDecimal para2) {
		BigDecimal sum=para1.multiply(para2);
		 return sum ;
		 
	}
	/*
	 * @除数 para1
	 * @被除数 para2
	 * 结果的精确度=para1的精确度 ，处理方式：四舍五入
	 */
	public static BigDecimal  divide(BigDecimal para1,BigDecimal para2) {
		BigDecimal sum=para1.divide(para2, BigDecimal.ROUND_HALF_UP);
		 return sum ;
		 
	}
	
	
	/*
	 * BigDecimal 保留n位小数(四舍五入)
	 * 
	 */
	public static BigDecimal retainDecimal(BigDecimal para1,int n){
		BigDecimal result=para1.setScale(n, BigDecimal.ROUND_HALF_UP);
		return result;
	}
	
	
	
	
//	public static void main(String[] args) {
////		String a1="10.001";
////		BigDecimal a=new BigDecimal(a1);
//		String a2="15.0000";//21.0211
//		BigDecimal b=new BigDecimal(a2);
////		add(a,b);
//		String a1="3";
//		BigDecimal a=new BigDecimal(a1);
//		divide(b,a);
//		
//	}
	
}

