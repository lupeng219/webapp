package com.baibao.web.p2p.comm;

import java.math.BigDecimal;

/**
 * @author 李维俭
 *
 */
public class Arith {
    private static final int DEF_DIV_SCALE = 10;
    
    public static void main(String[] args) {
    	BigDecimal b1 = new BigDecimal(1);
    	BigDecimal b2 = new BigDecimal(23);
    	
    	//加法
    	System.out.println(b1.add(b2));
    	
    	//减法
    	System.out.println(b1.subtract(b2));
    	
    	//乘法
    	System.out.println(b1.multiply(b2));
    	
    	//除法
    	System.out.println(b1.divide(b2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP));
	}
    
    /**
     * 两个Double数相加
     * @param v1
     * @param v2
     * @return Double
     */
    /*public static Double add(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.add(b2).doubleValue();
    }*/
    
    /**
     * 两个BigDecimal数相加
     * @param v1
     * @param v2
     * @return BigDecimal
     */
    public static BigDecimal add(BigDecimal v1,BigDecimal v2){
        return v1.add(v2);
    }
    
    /**
     * 两个Double数相减
     * @param v1
     * @param v2
     * @return Double
     */
    /*public static Double sub(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).doubleValue();
    }*/
    
    /**
     * 两个BigDecimal数相减
     * @param v1
     * @param v2
     * @return BigDecimal
     */
    public static BigDecimal sub(BigDecimal v1,BigDecimal v2){
        return v1.subtract(v2);
    }
    
    /**
     * 两个Double数相乘
     * @param v1
     * @param v2
     * @return Double
     */
    /*public static Double mul(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.multiply(b2).doubleValue();
    }*/
    
    /**
     * 两个BigDecimal数相乘
     * @param v1
     * @param v2
     * @return BigDecimal
     */
    public static BigDecimal mul(BigDecimal v1,BigDecimal v2){
        return v1.multiply(v2);
    }
    
    /**
     * 两个Double数相除
     * @param v1
     * @param v2
     * @return Double
     */
    /*public static Double div(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
    }*/
    
    /**
     * 两个BigDecimal数相除
     * @param v1
     * @param v2
     * @return BigDecimal
     */
    public static BigDecimal div(BigDecimal v1,BigDecimal v2){
        return v1.divide(v2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 两个Double数相除，并保留scale位小数
     * @param v1
     * @param v2
     * @param scale
     * @return Double
     */
    /*public static Double div(Double v1,Double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
            "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }*/
    
    /**
     * 两个BigDecimal数相除，并保留scale位小数
     * @param v1
     * @param v2
     * @param scale
     * @return BigDecimal
     */
    public static BigDecimal div(BigDecimal v1,BigDecimal v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
            "The scale must be a positive integer or zero");
        }
        return v1.divide(v2,scale,BigDecimal.ROUND_HALF_UP);
    }
}

