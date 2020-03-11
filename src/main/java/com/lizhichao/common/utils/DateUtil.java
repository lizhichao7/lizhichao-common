package com.lizhichao.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 给一个时间对象，返回该时间所在月的1日0时0分0秒
	 * @param src
	 * @return
	 */
	public static String getDateByInitMonth(String src) {
		Date date = null;
		try {
			date  = new SimpleDateFormat("yyyy-MM-dd").parse(src);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		//设置为1号，当月日期为本月第一天
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		//将小时至0
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		//将分钟至0
		c.set(Calendar.MINUTE, 0);
		
		//将秒至0
		c.set(Calendar.SECOND, 0);
		
		//将毫秒至0
		c.set(Calendar.MILLISECOND, 0);
		
		//本月第一天的时间戳转换为字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			date = sdf.parse(sdf.format(new Date(new Long(c.getTimeInMillis()))));
			
			return sdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return src;
		
	}
	
	/**
	 * 给任意一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况
	 * @param src
	 * @return
	 */
	public static String getDateByFullMonth(String src) {
		Date date = null;
		try {
			new SimpleDateFormat("yyyy-MM-dd").parse(src);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(date);
		
		//设置为当月最后一天
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		//将小时至23
		c.set(Calendar.HOUR_OF_DAY, 23);
		
		//将分钟至59
		c.set(Calendar.MINUTE, 59);
		
		//将秒至59
		c.set(Calendar.SECOND, 59);
		
		//将毫秒至999
		c.set(Calendar.MILLISECOND, 999);
		
		//本月第一天的时间戳转换为字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			date = sdf.parse(sdf.format(new Date(new Long(c.getTimeInMillis()))));
			
			return sdf.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return src;
				
	}
}
