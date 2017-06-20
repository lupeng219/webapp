package com.baibao.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.core.cache.LoadSystemConfigServlet;


/*
 * @author bottle
 * 
 * 处理日期的方法类
 * 
 */
public class CalenderUtil {
	private static Logger logger = LoggerFactory.getLogger(CalenderUtil.class); 
	
	public static final String DEFAULTPATTERN="yyyy-MM-dd HH:mm:ss";
	public  static final String PATTERN_YYYY_MM_DD="yyyy-MM-dd";
	public  static final String PATTERN_yyyyMMddhhmmss="yyyyMMddHHmmss";
	
	/** 返回计算日期
	 * 	value为正则往后,为负则往前
		add的第一个参数:取1加1年,取2加1月,取3/4加1周
		取5加一天.... 
		
	 * @param date
	 * @param value
	 * @return 
	 */
	public static Date getCalculationDate(Date date,int value,int field){
		GregorianCalendar gc=new GregorianCalendar();
		gc.setTime(date);
		gc.add(field,value);
		return gc.getTime();
	}
	public static void main(String[] args) {
		Date date = new Date();
		Date date2 = getCalculationDate(date,10,5);
		SimpleDateFormat sf  =new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sf.format(date));
		System.out.println(sf.format(date2));
	
		
	}
	/*
	 * 生成当前时间  
	 * 
	 * 参数  ：日期格式
	 * 
	 */
	public static String generatorCurrentDate(String pattern){
		if( StringUtil.isEmpty( pattern ))
			pattern = PATTERN_yyyyMMddhhmmss;
		SimpleDateFormat sFormat = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		return sFormat.format(calendar.getTime());
	}
	public static long generatorTime(String pattern){
		if( StringUtil.isEmpty( pattern ))
			pattern = PATTERN_yyyyMMddhhmmss;
		SimpleDateFormat sFormat = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		return Long.parseLong( sFormat.format(calendar.getTime()) );
	}
	
	/*
	 * 获取近一年开始时间 及结束时间
	 * 
	 */
  public static  String[] getStartAndEndTime(String  pattern) throws ParseException{
	  Map<String,String> map =new HashMap<String,String>();
	  String[] result=new String[12];
	  Calendar calendar = Calendar.getInstance();
	  String[]  mounths=getCurrentMonth(12);
	  for(int i=0;i<mounths.length;i++){
		 String month= mounths[i]+"-01";
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 SimpleDateFormat sdf1 = new SimpleDateFormat(pattern);  
		 Calendar cd = Calendar.getInstance(); 
		 cd.setTime(sdf.parse(month));
		 result[i] =sdf1.format(cd.getTime());
	  }
	  return result;
	  
		 
  }
  
  /*
	 * 返回当前时间 month个月以前的时间  
	 */
	@SuppressWarnings("unchecked")
	public static String[] getCurrentMonth( int month) {
		String [] timeMonth=new String[month];
		for(int i=1;i<=timeMonth.length;i++){
			Calendar cc = Calendar.getInstance();
			cc.add(Calendar.MONTH, -i+1);
			timeMonth[i-1]=cc.get(Calendar.YEAR)+"-"+((cc.get(Calendar.MONTH)+1));
			
		}
		for(int i=0;i<timeMonth.length;i++){
			String date=timeMonth[i];
			String[] monthnow=date.split("-");
			if(monthnow[1].length()==1){
				monthnow[1]="0"+monthnow[1];
			}
			String start=monthnow[0]+"-"+monthnow[1];
	//	    String end=monthnow[0]+"-"+monthnow[1];
			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
//			  
//	        Calendar cd = Calendar.getInstance();   
//	        cd.setTime(sdf.parse(start));   
//	        Calendar cd1 = Calendar.getInstance();  
//	        cd1.setTime(sdf.parse(end+"-"+cd.getActualMaximum(Calendar.DATE)));
//	        cd1.add(Calendar.HOUR, 24);
//	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        
			timeMonth[i]=start;
//		System.out.println(sdf1.format(cd.getTime())+"========"+sdf1.format(cd1.getTime()));
		}
		return timeMonth;
	}
	
	/*
	 * 获取当前月的起始时间和结束时间
	 */
	public static String[]  getCurrentMonthStartAndEndTime(String pattern){
		String[] months=new String[2];
		Calendar cc = Calendar.getInstance();
        cc.set(Calendar.DATE, 1);
        cc.set(Calendar.HOUR, 0);
        cc.set(Calendar.MINUTE, 0);
        cc.set(Calendar.SECOND, 0);
        cc.set(Calendar.MILLISECOND, 0);
       
        
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
       
        months[0] =sdf.format(cc.getTime());
      //  System.out.println("==="+months[0]);
        int maxDay=cc.getActualMaximum(Calendar.DATE);
        cc.set(Calendar.DATE, maxDay);
        cc.set(Calendar.HOUR, 23);
        cc.set(Calendar.MINUTE, 59);
        cc.set(Calendar.SECOND, 59);
        cc.set(Calendar.MILLISECOND, 999);
        months[1]=sdf.format(cc.getTime());
  //      System.out.println("***"+months[1]);
		return months;
		
	}
	public static void compareDatesByCompareTo(DateFormat df, Date oldDate, Date newDate) {
        //how to check if date1 is equal to date2
        if (oldDate.compareTo(newDate) == 0) {
            System.out.println(df.format(oldDate) + " and " + df.format(newDate) + " are equal to each other");
        }
        //checking if date1 is less than date 2
        if (oldDate.compareTo(newDate) < 0) {
            System.out.println(df.format(oldDate) + " is less than " + df.format(newDate));
        }
        //how to check if date1 is greater than date2 in java
        if (oldDate.compareTo(newDate) > 0) {
            System.out.println(df.format(oldDate) + " is greater than " + df.format(newDate));
        }
    }

    public static void compareDatesByDateMethods(DateFormat df, Date oldDate, Date newDate) {
        //how to check if two dates are equals in java
        if (oldDate.equals(newDate)) {
            System.out.println(df.format(oldDate) + " and " + df.format(newDate) + " are equal to each other");
        }
        //checking if date1 comes before date2
        if (oldDate.before(newDate)) {
            System.out.println(df.format(oldDate) + " comes before " + df.format(newDate));
        }
        //checking if date1 comes after date2
        if (oldDate.after(newDate)) {
            System.out.println(df.format(oldDate) + " comes after " + df.format(newDate));
        }
    }

    public static void compareDatesByCalendarMethods(DateFormat df, Date oldDate, Date newDate) {
        //creating calendar instances for date comparision
        Calendar oldCal = Calendar.getInstance();
        Calendar newCal = Calendar.getInstance();
        oldCal.setTime(oldDate);
        newCal.setTime(newDate);
        //how to check if two dates are equals in java using Calendar
        if (oldCal.equals(newCal)) {
            System.out.println(df.format(oldDate) + " and " + df.format(newDate) + " are equal to each other");
        }
        //how to check if one date comes before another using Calendar
        if (oldCal.before(newCal)) {
            System.out.println(df.format(oldDate) + " comes before " + df.format(newDate));
        }
        //how to check if one date comes after another using Calendar
        if (oldCal.after(newCal)) {
            System.out.println(df.format(oldDate) + " comes after " + df.format(newDate));
        }
    }
    public static void main1(String args[]) throws AssertionError, ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date enddate =  df.parse( "2015-09-30" );
		Date now = new Date();
		if( now.compareTo( enddate ) <= 0  )
		{
			System.out.println("111111111111");
		}
//        //comparing date using compareTo method in Java
//        System.out.println("Comparing two Date in Java using CompareTo method");
//        compareDatesByCompareTo(df, df.parse("2015-07-30"), new Date());
//        compareDatesByCompareTo(df, df.parse("02-03-2012"), df.parse("04-05-2012"));
//        compareDatesByCompareTo(df, df.parse("02-03-2012"), df.parse("01-02-2012"));
//
//        //comparing dates in java using Date.before, Date.after and Date.equals
//        System.out.println("Comparing two Date in Java using Date's before, after and equals method");
//        compareDatesByDateMethods(df, df.parse("01-01-2012"), df.parse("01-01-2012"));
//        compareDatesByDateMethods(df, df.parse("02-03-2012"), df.parse("04-05-2012"));
//        compareDatesByDateMethods(df, df.parse("02-03-2012"), df.parse("01-02-2012"));
//
//        //comparing dates in java using Calendar.before(), Calendar.after and Calendar.equals()
//        System.out.println("Comparing two Date in Java using Calendar's before, after and equals method");
//        compareDatesByCalendarMethods(df, df.parse("01-01-2012"), df.parse("01-01-2012"));
//        compareDatesByCalendarMethods(df, df.parse("02-03-2012"), df.parse("04-05-2012"));
//        compareDatesByCalendarMethods(df, df.parse("02-03-2012"), df.parse("01-02-2012"));

    }
	public static void main2(String[] args) throws ParseException {
		//getCurrentMonth(12);
		//getStartAndEndTime("yyyy-MM-dd HH:mm:ss");
		//getCurrentMonthStartAndEndTime("yyyy-MM-dd HH:mm:ss");
		DateFormat df = new SimpleDateFormat("yyyyMMdd"); 
        try { 
                Date dt1 = df.parse("20150928"); 
                Date dt2 = df.parse("20150929"); 
                if (dt1.getTime() > dt2.getTime()) { 
                        System.out.println("dt1 在dt2前"); 
                } else if (dt1.getTime() < dt2.getTime()) { 
                        System.out.println("dt1在dt2后"); 
                } else { 
                } 
        } catch (Exception exception) { 
                exception.printStackTrace(); 
        } 
	}
	
}
