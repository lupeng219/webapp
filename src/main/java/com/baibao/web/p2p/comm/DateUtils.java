package com.baibao.web.p2p.comm;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.core.cache.LoadSystemConfigServlet;


public class DateUtils {
	private static Logger logger = LoggerFactory.getLogger(DateUtils.class); 
	public static final String DEFAULT_FORMAT =  "yyyy-MM-dd HH:mm:ss"; 
	
	public static final String DEFAULT_FORMAT_TWO =  "yyyy-MM-dd";  
	
		/**
		 * 返回N个月之后的日期
		 * @param date
		 * @param month
		 * @return
		 */
		public static String MonthOperation(Date date ,Integer month){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formatDate=null;
			try {
			    Calendar c = Calendar.getInstance();
			    c.setTime(date);
			    c.add(Calendar.MONTH, month);
			    date = c.getTime();
			    formatDate = formatter.format(date);
			} catch (Exception e1) {
			    logger.error("MonthOperation", e1);
			}
			return formatDate;
		}
		
		/**
		 * 返回N天之后的日期
		 * @param date
		 * @param month
		 * @return
		 */
		public static String FatalismOperation(Date date ,Integer days){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formatDate=null;
			try {
			    Calendar c = Calendar.getInstance();
			    c.setTime(date);
			    c.add(Calendar.DATE, days);
			    date = c.getTime();
			    formatDate = formatter.format(date);
			} catch (Exception e1) {
			    logger.error("FatalismOperation", e1);
			}
			return formatDate;
		}
		
		/**
		 * 返回N个月之后的日期
		 * @param startDate
		 * @param addmonth
		 * @return
		 */
		public static Date getTimeAfter_N_Months(Date startDate ,Integer addmonth){
			try {
			    Calendar c = Calendar.getInstance();
			    c.setTime(startDate);
			    c.add(Calendar.MONTH, addmonth);
			    return c.getTime();
			} catch (Exception e1) {
			    logger.error("getTimeAfter_N_Months", e1);
			    return null;
			}
		}
		
		
	    public static String daysBetween(Date smdate,Date bdate){
	           long between = 0;
	           try {
	               java.util.Date begin = smdate;
	               java.util.Date end = bdate;
	               between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
	           } catch (Exception ex) {
	               logger.error("daysBetween", ex);
	           }
	           long day = between / (24 * 60 * 60 * 1000);
	           long hour = (between / (60 * 60 * 1000) - day * 24);
	           long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
	           long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
//	           long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
//	                   - min * 60 * 1000 - s * 1000);
	           String x = day + "天" + hour + "小时" + min + "分" + s + "秒";
			return x;
	    }
	    public static String restDays(Date smdate,Date bdate){
	           long between = 0;
	           try {
	               java.util.Date begin = smdate;
	               java.util.Date end = bdate;
	               between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
	           } catch (Exception ex) {
	               logger.error("restDays", ex);
	           }
	           long day = between / (24 * 60 * 60 * 1000);
	           long hour = (between / (60 * 60 * 1000) - day * 24);
	           long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
	           long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
//	           long ms = (between - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000
//	                   - min * 60 * 1000 - s * 1000);
	           String x = day * 24 + hour + "小时" + min + "分";
			System.out.println(x);
			return x;
	    }
	    
	    public static String change(int second){  
	    	          int h = 0;  
	    	          int d = 0;  
	    	         int s = 0;  
	    	         int temp = second%3600;  
	    	              if(second>3600){  
	    	                h= second/3600;  
	    	                     if(temp!=0){  
	    	                if(temp>60){  
	    	                 d = temp/60;  
	    	              if(temp%60!=0){  
	    	                 s = temp%60;  
	    	              }  
	    	              }else{  
	    	                 s = temp;  
	    	              }  
	    	             }  
	    	            }else{  
	    	                d = second/60;  
	    	             if(second%60!=0){  
	    	                s = second%60;  
	    	             }  
	    	            }  
	    	  
	    	           return h+"时"+d+"分"+s+"秒";  
	    	         }  
	    /**
		 * 计算两个日期相差的天数
		 * @param date1 第一个参数
		 * @param date2 第二个参数
		 * @return 返回两个日期相差的天数
		 */
		public static int getBetweenDay(Date date1, Date date2){
			/*Calendar d1 = new GregorianCalendar();
			d1.setTime(date1);
			Calendar d2 = new GregorianCalendar();
			d2.setTime(date2);
			int days = d2.get(Calendar.DAY_OF_YEAR)- d1.get(Calendar.DAY_OF_YEAR);
			int y2 = d2.get(Calendar.YEAR);
			if (d1.get(Calendar.YEAR) != y2) {
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
			}
			return days;*/
			 if (null == date1 || null == date2) {
		           return -1;

		       }
	       long intervalMilli = date1.getTime() - date2.getTime();
	       return (int) (intervalMilli / (24 * 60 * 60 * 1000));
		}
		
		/**
		 * 比较两个日期的大小
		 * @param date1 第一个参数
		 * @param date2 第二个参数
		 * @return 返回1表示第一个日期大于第二个日期；返回-1表示第一个日期小于第二个日期；返回0表示两个日期是同一天
		 */
		public static int compare_date(Date date1, Date date2){
            if (date1.getTime() >= date2.getTime()) {
                 return 1;
            } else {
                 return -1;
            }
		}
		
		public static void strToDate(HttpServletRequest request){
			String time=(String) request.getAttribute("time");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatDate=null;
			Date result=null;
			try {
				if(time!=null && !"".equals(time)){
					result=formatter.parse(time);
				}
			} catch (Exception e1) {
			    logger.error("strToDate", e1);
			}
			request.setAttribute("resultTime", result);
		}
		public static Date strToDate(String time){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date result=null;
			try {
				if(time!=null && !"".equals(time)){
					result=formatter.parse(time);
				}
			} catch (Exception e1) {
				logger.error("strToDate", e1);
			}
			return result;
		}
		
		public static void calendarToDate(HttpServletRequest request){
			Timestamp realRepaymentTime=(Timestamp) request.getAttribute("realRepaymentTime");
			int index= (Integer)request.getAttribute("index");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			Date temp=realRepaymentTime;
			Date result=null;
			Random rand = new Random();
			Calendar cal=Calendar.getInstance();
			cal.setTime(temp);
			//cal.add(Calendar.HOUR,24-index*4); 
			int i=cal.get(Calendar.HOUR);
			cal.add(Calendar.MINUTE,60-index);
			cal.add(Calendar.SECOND,60-index);
			result=cal.getTime();
			request.setAttribute("realRepaymentTime", result);
		}
		
		public static void strToDateTwo(HttpServletRequest request){
			String realRepaymentTime=(String) request.getAttribute("realRepaymentTime");
			int index=(Integer)request.getAttribute("index");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date temp=null;
			Date result=null;
			try {
				temp=fmt.parse(realRepaymentTime);
				Random rand = new Random();
				Calendar cal=Calendar.getInstance();
				cal.setTime(temp);
				cal.add(Calendar.HOUR,24*10*3-index); 
				int i=cal.get(Calendar.HOUR);
				cal.add(Calendar.MINUTE,60-index);
				cal.add(Calendar.SECOND,60-index);
				result=cal.getTime();
			} catch (ParseException e) {
				logger.error("strToDateTwo", e);
			}
			
			request.setAttribute("realRepaymentTime", result);
		}
		
		/**
		 * yyyy-MM-dd HH:mm:ss年月日 时分秒
		 * 
		 * @param aDate
		 * @return
		 */
		public static String getDateToString(Date aDate) {
			String returnValue = "";
			SimpleDateFormat df = null;
			if (aDate != null) {
				df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //年月日 时分秒
				returnValue = df.format(aDate);
			}
			return returnValue;
		}
		/**
		 * 字符串转时间
		 * @param date
		 * @param format
		 * @return
		 */
		public static Date string2Date(String date,String format){
			Date d = null;
			try {
				SimpleDateFormat df = new SimpleDateFormat(format);
				d = df.parse(date);
			} catch (Exception e) {
				logger.error("string2Date", e);
			}
			return d;
		}
		/**
		 * 时间段返回年月
		 * @param begin
		 * @param end
		 * @return
		 */
		public static List getDatedifference(String begin,String end){
			List list = new ArrayList();
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
				Date begin_ = formatter.parse(begin);//开始
				Date end_ = formatter.parse(end);//结束
				Calendar calendar = Calendar.getInstance();//定义日期实例
				calendar.setTime(begin_);//设置日期起始时间
				while(calendar.getTime().before(end_) || calendar.getTime().compareTo(end_)==0){//判断是否到结束日期
					String str = formatter.format(calendar.getTime());
					//System.out.println(str);//输出日期结果
					calendar.add(Calendar.MONTH, 1);//进行当前日期月份加1
					list.add(str);
				}
			} catch (ParseException e) {
				logger.error("getDatedifference", e);
			}
			return list;
		}
		
		/**
		 * date ==>string
		 * @param date
		 * @param month
		 * @return
		 */
		public static String DateTOString(Date date ,String dateFormate){
			SimpleDateFormat formatter = new SimpleDateFormat(dateFormate);
			String formatDate=null;
			try {
				formatDate = formatter.format(date);
			} catch (Exception e1) {
			    logger.error("DateTOString", e1);
			}
			return formatDate;
		}
		
		public static boolean isBetweenDate(Date fromDate,Date toDate,Date date){
			Long d = date.getTime();
			Long fd = fromDate.getTime();
			Long td = toDate.getTime();
			if(d.longValue()>fd.longValue() && d.longValue()<td.longValue())
				return true;
			return false;
		}
		public static String formatDateTime(String pattern) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String now = sdf.format(new Date());
			return now;
		}
		public static void main(String[] args) throws ParseException {
			/*SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//小写的mm表示的是分钟  
			String dstr="20160130";  
			java.util.Date date = null;
			try {
				date = sdf.parse(dstr);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			System.out.println("" + getBetweenDay(date,sdf.parse(sdf.format(new Date()))));*/
			//System.out.println("*****" + getBetweenDayString("2016-01-06","2016-01-08"));
			/*String  strstart ="2015-10-12 15:30:12";
			String  strend ="2016-01-12 15:30:12";
			Date startDate =DateUtils.strToDate(strstart);
			Date endDate =DateUtils.strToDate(strend);
			Boolean  flag =DateUtils.isBetweenDate(startDate, endDate, new Date());
			System.out.println(flag);*/
			/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
			String start = formatter.format(new Date());
			String  a = MonthOperation(new Date(), 1);
			System.out.println("*****" + a);
			
			String b = FatalismOperation(new Date(), 3);
			System.out.println("" + b);*/
		}
		
}
