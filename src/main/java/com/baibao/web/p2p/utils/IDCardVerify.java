package com.baibao.web.p2p.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDCardVerify {

	private static String _codeError;
	 
    //wi =2(n-1)(mod 11)
	static final int[] wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
    // verify digit
	static final int[] vi = {1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
    private static int[] ai = new int[18];
    private static String[] _areaCode={"11","12","13","14","15","21","22"
        ,"23","31","32","33","34","35","36","37","41","42","43","44"
        ,"45","46","50","51","52","53","54","61","62","63","64","65","71","81","82","91"};
    private static HashMap<String,Integer> dateMap;
    private static HashMap<String,String> areaCodeMap;
    static{
          dateMap=new HashMap<String,Integer>();
          dateMap.put("01",31);
          dateMap.put("02",null);
          dateMap.put("03",31);
          dateMap.put("04",30);
          dateMap.put("05",31);
          dateMap.put("06",30);
          dateMap.put("07",31);
          dateMap.put("08",31);
          dateMap.put("09",30);
          dateMap.put("10",31);
          dateMap.put("11",30);
          dateMap.put("12",31);
          areaCodeMap=new HashMap<String,String>();
          for(String code:_areaCode){
                areaCodeMap.put(code,null);
          }
    }

    //验证身份证位数,15位和18位身份证
    public static boolean verifyLength(String code){
          int length=code.length();
          //if(length==15 || length==18){
          if(length==18){
                return true;
          }else{
                //_codeError="错误：输入的身份证号不是15位和18位的";
                _codeError="输入的身份证号不是18位的";
                return false;
          }
    }

    //判断地区码
    public static boolean verifyAreaCode(String code){
          String areaCode=code.substring(0,2);
//          Element child=  _areaCodeElement.getChild("_"+areaCode);
          if(areaCodeMap.containsKey(areaCode)){
                return true;
          }else{
               // _codeError="错误：输入的身份证号的地区码(1-2位)["+areaCode+"]不符合中国行政区划分代码规定(GB/T2260-1999)";
                _codeError="验证错误";
                return false;
          }
    }

    //判断月份和日期
    public static boolean verifyBirthdayCode(String code){
          //验证月份
          String month=code.substring(10,12);
          boolean isEighteenCode=(18==code.length());
          if(!dateMap.containsKey(month)){
                //_codeError="错误：输入的身份证号"+(isEighteenCode?"(11-12位)":"(9-10位)")+"不存在["+month+"]月份,不符合要求(GB/T7408)";
                _codeError="输入的身份证号月份错误";
                return false;
          }
          //验证日期
          String dayCode=code.substring(12,14);
          Integer day=dateMap.get(month);
          String yearCode=code.substring(6,10);
          Integer year=Integer.valueOf(yearCode);

          //非2月的情况
          if(day!=null){
                if(Integer.valueOf(dayCode)>day || Integer.valueOf(dayCode)<1){
                      //_codeError="错误：输入的身份证号"+(isEighteenCode?"(13-14位)":"(11-13位)")+"["+dayCode+"]号不符合小月1-30天大月1-31天的规定(GB/T7408)";
                      _codeError="输入的身份证号月份错误";
                      return false;
                }
          }
          //2月的情况
          else{
                //闰月的情况
                if((year%4==0&&year%100!=0)||(year%400==0)){
                      if(Integer.valueOf(dayCode)>29 || Integer.valueOf(dayCode)<1){
                            //_codeError="错误：输入的身份证号"+(isEighteenCode?"(13-14位)":"(11-13位)")+"["+dayCode+"]号在"+year+"闰年的情况下未符合1-29号的规定(GB/T7408)";
                            _codeError="输入的身份证号月份错误";
                            return false;
                      }
                }
                //非闰月的情况
                else{
                      if (Integer.valueOf(dayCode) > 28 || Integer.valueOf(dayCode) < 1) {
                           // _codeError="错误：输入的身份证号"+(isEighteenCode?"(13-14位)":"(11-13位)")+"["+dayCode+"]号在"+year+"平年的情况下未符合1-28号的规定(GB/T7408)";
                            _codeError="输入的身份证号月份错误";
                            return false;
                      }
                }
          }
          return true;
    }

    //验证身份除了最后位其他的是否包含字母
    public static boolean containsAllNumber(String code) {
          String str="";
          if(code.length()==15){
                str=code.substring(0,15);
          }else if(code.length()==18){
                str=code.substring(0,17);
          }
          char[] ch = str.toCharArray();
          for (int i = 0; i < ch.length; i++) {
                if (! (ch[i] >= '0' && ch[i] <= '9')) {
                      _codeError="错误：输入的身份证号第"+(i+1)+"位包含字母";
                      return false;
                }
          }
          return true;
    }

    public String getCodeError(){
          return _codeError;
    }

    //验证身份证
    public static boolean verify(String idcard) {
          _codeError="";
          //验证身份证位数,15位和18位身份证
          if(!verifyLength(idcard)){
              return false;
          }
          //验证身份除了最后位其他的是否包含字母
          if(!containsAllNumber(idcard)){
                return false;
          }

          //如果是15位的就转成18位的身份证
          String eifhteencard="";
          if(idcard.length() == 15) {
                eifhteencard = uptoeighteen(idcard);
          }else{
                eifhteencard=idcard;
          }
          //验证身份证的地区码
          if(!verifyAreaCode(eifhteencard)){
                return false;
          }
          //判断月份和日期
          if(!verifyBirthdayCode(eifhteencard)){
                return false;
          }
          //验证18位校验码,校验码采用ISO 7064：1983，MOD 11-2 校验码系统
          if(!verifyMOD(eifhteencard)){
                return false;
          }
          return true;
    }

    //验证18位校验码,校验码采用ISO 7064：1983，MOD 11-2 校验码系统
    public static boolean verifyMOD(String code){
          String verify = code.substring(17, 18);
          if("x".equals(verify)){
                code=code.replaceAll("x","X");
                verify="X";
          }
          String verifyIndex=getVerify(code);
          if (verify.equals(verifyIndex)) {
                return true;
          }
//          int x=17;
//          if(code.length()==15){
//                x=14;
//          }
          _codeError="输入的身份证号最末尾的数字验证码错误";
          return false;
    }

    //获得校验位
    public static String getVerify(String eightcardid) {
          int remaining = 0;
          if (eightcardid.length() == 18) {
                eightcardid = eightcardid.substring(0, 17);
          }
          if (eightcardid.length() == 17) {
                int sum = 0;
                for (int i = 0; i < 17; i++) {
                      String k = eightcardid.substring(i, i + 1);
                      ai[i] = Integer.parseInt(k);
                }
                for (int i = 0; i < 17; i++) {
                      sum = sum + wi[i] * ai[i];
                }
                remaining = sum % 11;
          }
          return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
    }
    //15位转18位身份证
    public static String uptoeighteen(String fifteencardid) {
          String eightcardid = fifteencardid.substring(0, 6);
          eightcardid = eightcardid + "19";
          eightcardid = eightcardid + fifteencardid.substring(6, 15);
          eightcardid = eightcardid + getVerify(eightcardid);
          return eightcardid;
    }
    /**
     * 
     * @param cardNo
     * @return 0：校验正确，其他：错误信息
     */
    public static String verifyCard( String cardNo )
    {
    	if( null == cardNo || "".equals( cardNo ))
    		return "非法输入";
    	if( verify( cardNo ) )
    	{
    		return "0";
    	}
    	return _codeError;
    }
    
    /**
     * 获得身份证年龄
     * @param IDnumber
     * @return
     */
    public static int Age(String IDnumber) {
        int age = 0;
        String birthday = "";
        if (isIDnumber(IDnumber)) 
        {
        	//定义正则表达式提取出身份证中的出生日期  
            Pattern birthpPattern = Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");
            //通过Pattern获得Matcher  
            Matcher birthmMatcher = birthpPattern.matcher(IDnumber);
            //通过Matcher获得用户的出生年月日  
            if(birthmMatcher.find())
            {  
            String  year = birthmMatcher.group(1);  
            String month =birthmMatcher.group(2);  
            String day = birthmMatcher.group(3);  
            //输出用户的出生年月日  
            birthday=year+"-"+month+"-"+day;  
            //计算年龄
            Date date = new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Calendar c1 = Calendar.getInstance();
            long nowmillSeconds = c1.getTimeInMillis();
            Calendar c2 = Calendar.getInstance();
            try {
                    date= sdf.parse(birthday);
                                c2.setTime(date);
                        } catch (ParseException e) {
                                e.printStackTrace();
                        }
            long birmillSeconds = c2.getTimeInMillis();
            Calendar c3 = Calendar.getInstance();
            long millis = nowmillSeconds - birmillSeconds;
            c3.setTimeInMillis(millis);
            int year1 = c3.get(Calendar.YEAR);
            age = year1-1970;
            System.out.println("您的年龄是："+age);
            /*int month1 = c3.get(Calendar.MONTH);
            int day1 = c3.get(Calendar.DAY_OF_MONTH);
            int hour = c3.get(Calendar.HOUR_OF_DAY);
            */
           /* if (year1 > 1970) {
                return year1 - 1970 + "岁";
            } else if (month > Calendar.JANUARY) {
                return month - Calendar.JANUARY + "月";
            } else if (day > 1) {
                return day - 1 + "天";
            }else{
                return "1天";
            }*/
        }
      
        }
        return age;
    }
    
    /**
     * 判断身份证有效性
     * @param IDnumber
     * @return
     */
	public static boolean isIDnumber(String idnumber) {
        boolean  flag=false;
        //定义判别用户身份证号的正则表达式（是18位，还是15位，最后一位可以为字母）  
        Pattern  idpPattern = Pattern.compile("(\\d{17}[a-zA-Z0-9])|(\\d{14}[0-9a-zA-Z])");
        //通过Pattern获得Matcher  
        Matcher idMatcher= idpPattern.matcher(idnumber);
        if (idMatcher.matches()) {
                System.out.println("输入身份证号码合法！");
                flag=true;
        } else {
                System.out.println("输入的身份证号码有误！");
                flag=false;
        }
        return flag;
	}
    
    public static void main(String agrs[])
    {
    	System.out.println( verifyCard("130533198204104216") );
    	
    }
}
