package com.ibm.dpm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * @ClassName: DateUtil
 * @author: Anthony Y Li
 */
public class DateUtil {

	public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/*
	 * @param String givendate 
	 * @return Date 'yyyy-mm-dd'
	 */
	public static Date getDate(String givendate) throws ParseException {
		return sdf.parse(givendate);
	}
	
	/*
	 * @param Date givendate Mon Sep 10 00:00:00 CST 2018
	 * @return Date first day of the week Mon Sep 10 00:00:00 CST 2018
	 */
	public static Date getFirstDayOfWeekByGivenDate(Date givendate) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(givendate);
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		
		return cal.getTime();
	}
	
	/*
	 * @param String 'yyyy-mm-dd'
	 * @return first day of the week 'yyyy-mm-dd'
	 */
	public static String getFirstDayOfWeekByGivenDate(String givendate) throws ParseException {
		
		Date date = getFirstDayOfWeekByGivenDate(sdf.parse(givendate));
		
		return sdf.format(date);
	}
	
	/*
	 * @param Date givendate Mon Sep 10 00:00:00 CST 2018
	 * @return Date first day of the week Mon Sep 10 00:00:00 CST 2018
	 */
	public static Date getLastDayOfWeekByGivenDate(Date givendate) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(givendate);
		
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek()+6);
		
		return cal.getTime();
	}
	
	/*
	 * @param date 'yyyy-mm-dd'
	 * @return last day of the week 'yyyy-mm-dd'
	 */
	public static String getLastDayOfWeekByGivenDate(String givendate) throws ParseException {
		
		Date date = getLastDayOfWeekByGivenDate(sdf.parse(givendate));
		
		return sdf.format(date);
	}
	
	/*
	 * @param String date 'yyyy-mm-dd'
	 * @return last day of the week 'yyyy-mm-dd'
	 */
	public static int getWeekOfMonth(String date) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(getDate(date));
		
		return cal.get(Calendar.DAY_OF_WEEK);
		
	}
	
}
