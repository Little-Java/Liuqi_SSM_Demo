package com.liuqi.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LiuQiUtil {
	
	//求明天的时间
	public static String getTomorrow(String time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义时间格式
		Date dt = null;
		try {
			dt = df.parse(time);//转换接收的时间格式
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();//创建一个时间对象
		cal.setTime(dt);//传入时间
		cal.add(Calendar.DATE, +1);	//加1天
		return df.format(cal.getTime());//日期
	}
	
	//求昨天的时间
	public static String getYesterday(String time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义时间格式
		Date dt = null;
		try {
			dt = df.parse(time);//转换接收的时间格式
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();//创建一个时间对象
		cal.setTime(dt);//传入时间
		cal.add(Calendar.DATE, -1);	//加1天
		return df.format(cal.getTime());//日期
	}
	
	//求上个月时间
	public static String getTheLastMonth(String time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义时间格式
		Date dt = null;
		try {
			dt = df.parse(time);//转换接收的时间格式
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();//创建一个时间对象
		cal.setTime(dt);//传入时间
		cal.add(Calendar.MONTH, -1);	//加1天
		return df.format(cal.getTime());//日期
	}
	
	//求下个月时间
	public static String getNextMonth(String time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义时间格式
		Date dt = null;
		try {
			dt = df.parse(time);//转换接收的时间格式
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();//创建一个时间对象
		cal.setTime(dt);//传入时间
		cal.add(Calendar.MONTH, +1);	//加1天
		return df.format(cal.getTime());//日期
	}
	
	//求今天时间
	public static String getTodayTime(){
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dt);
		return date;
	}
	
	//求今天时间
	public static String getTodayTimes(){
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String date = sdf.format(dt);
		return date;
	}
	
	//求今天时间的月日
	public static String getMonthAndDay(){
		Calendar cal = Calendar.getInstance();//创建一个时间对象
		cal.setTime(new Date());//传入时间
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String months;
		String days;
		if(month<10){
			months = "0"+month;
		}
		else{
			months = ""+month;
		}
		if(day<10){
			days = "0"+day;
		}
		else{
			days = ""+day;
		}
		return months+"-"+days;
	}
	
	//求今天时间的年月
	public static String getYearAndMonth(){
		Calendar cal = Calendar.getInstance();//创建一个时间对象
		cal.setTime(new Date());//传入时间
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		String months;
		if(month<10){
			months = "0"+month;
		}
		else{
			months = ""+month;
		}
		return year+"-"+months;
	}
	
	//求某时间的年月
	public static String getYearAndMonths(String time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();//创建一个时间对象
		Date dt = null;
		try {
			dt = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(dt);//传入时间
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		String months;
		if(month<10){
			months = "0"+month;
		}
		else{
			months = ""+month;
		}
		return year+"-"+months;
	}
	
	//求某个时间到现在的时间差只求小时
	public static String differenceTime(String time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//指定时间格式
		Date nowTime = new Date();//获取当前时间
		Date dt = null;
		try {
			dt = sdf.parse(time);//将字符串转换为指定的时间格式
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long dateDiff = nowTime.getTime() - dt.getTime();
		if(dateDiff > 0){
			float dateTemp = (float)dateDiff/(1000*60*60); //时
			DecimalFormat df = new DecimalFormat("0.0");//格式化小数，不足的补0
			String date = df.format(dateTemp);//返回的是String类型的
			return date;
		}else{
			return 0+"";
		}
	}
	
	/**
	 * 求年、月long会溢出可以用大数值
	 * BigDecimal t = new BigDecimal(times);
	 * BigDecimal x = new BigDecimal(1000 * 60 * 60 * 24 );
	 * BigDecimal multiply = x.multiply(new BigDecimal(30*12));
	 * BigDecimal year = t.divide(multiply,1);
	 */
	//求某个时间到现在的时间差分档次
	public static String differenceTimes(String time){
		if(null == time) return "0";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//指定时间格式
		Date now = null;
		Date dt = null;
		String msg = null;
		try {
			now = sdf.parse(sdf.format(new Date()));
			dt = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long times = now.getTime() - dt.getTime();
		if(times < 0) return 0+"";
		
		long day = times/(1000*60*60*24);
		long hour = times/(1000*60*60) - day*24;
		long minute = times/(1000*60) - day*24 - hour*60;
		if(day>=1){
			msg = day+"天"+hour+"小时";
		}else if(hour>=1){
			msg = hour+"小时"+minute+"分";
		}else if(minute>0){
			msg = minute+"分";
		}
		return msg;
		
//		long dateTemp1=times/1000;		//秒
//		long dateTemp2=dateTemp1/60;	//分钟
//		long dateTemp3=dateTemp2/60;	//小时
//		long dateTemp4=dateTemp3/24;	//天数
//		long dateTemp5=dateTemp4/30;	//月数
//		long dateTemp6=dateTemp5/12;	//年数
//		if(dateTemp6>0){
//			msg = dateTemp6+"年前";
//		}else if(dateTemp5>0){
//			msg = dateTemp5+"个月前";
//		}else if(dateTemp4>0){
//			msg = dateTemp4+"天前";
//		}else if(dateTemp3>0){
//			msg = dateTemp3+"小时前";
//		}else if(dateTemp2>0){
//			msg = dateTemp2+"分钟前";
//		}else if(dateTemp1>0){
//			msg = "刚刚";
//		}
//		return msg;
	}
	
	//比较两者大小相等则返回前者
	public static String comparisonSize(String a,String b){
		if(a==null||b==null){//a或b正常情况不会为null,一旦出现则数据错误直接return,所以这里用||
			return "0";
		}
		if(a!=null&&a.equals(b)){
			return a;
		}
		if(!a.equals(b)){
			Double a1=Double.parseDouble(a);
			Double b1=Double.parseDouble(b);
			if(a1>b1){
				return a;
			}else{
				return b;
			}
		}
		return "0";
	}

	//比较两者时间大小相等则返回前者
	public static String comparisonTime(String a,String b){
		if(null==a && null==b){//a或b正常情况不会为null,一旦出现则数据错误直接return,所以这里用||
			return null;
		}else if(null == a){
			return b;
		}else if(null == b){
			return a;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//指定时间格式
		Date dt = null;//获取当前时间
		Date dts = null;
		try {
			dt = sdf.parse(a);//将字符串转换为指定的时间格式
			dts =  sdf.parse(b);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long dateDiff = dt.getTime() - dts.getTime();
		if(dateDiff >= 0){
			return a;
		}else{
			return b;
		}
	}
	
	//获取某个时间的前八日时间特殊格式用于展示
	public static String getEightDay(String time){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//转换时间格式
		Date dt = null;
		String str= "";//定义一个字符串
		try {
			dt = sdf.parse(time);//获取对象里的时间并转格式
			for(int i=8; i>0; i--){//往前推8天
				Calendar cal = Calendar.getInstance();
				cal.setTime(dt);
				cal.add(Calendar.DATE,-i);//求当前时间的8天前...1天前
				String a =sdf.format(cal.getTime());//用一个字符串接收求出来的时间
				str+="'"+a.substring(5,10)+"',";//将字符串进行拼接:'XX',
			}
			str = str.substring(0, str.length()-1);//截取掉最后一个逗号
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	//获取某个时间的前八日时间用于查询
	public static String[] getEightDays(String time){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//转换时间格式
		Date dt = null;
		String[] str=new String[8];//定义一个长度为8的数组
		try {
			dt = sdf.parse(time);
			for(int i=8; i>0; i--){//往前推8天
				Calendar cal = Calendar.getInstance();
				cal.setTime(dt);
				cal.add(Calendar.DATE,-i);//求当前时间的8天前...1天前
//				String a =sdf.format(cal.getTime());//用一个字符串接收求出来的时间
//				str[7-i]= a +" 00:00:00";//将求出来的时间加上" 00:00:00"
				str[8-i] = sdf.format(cal.getTime());//8-8、8-7...8-1
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args){
//		System.out.println("上个月"+getTheLastMonth("2017-09-30"));
//		System.out.println("下个月"+getNextMonth("2017-09-30"));
//		System.out.println("八日："+getEightDay("2017-09-30"));
//		System.out.println("八日："+getEightDays("2017-09-30"));
//		System.out.println("d:"+getYesterday("2017-09-30"));
//		System.out.println("f:"+getTomorrow("2017-10-01"));
//		System.out.println("today:"+getTodayTime());
//		System.out.println("today:"+getYearAndMonth());
//		System.out.println("today:"+getMonthAndDay());
//		System.out.println("谁大："+comparisonTime("2017-11-12 11:54:39","2017-12-13 22:00:00"));
//		System.out.println("相差："+differenceTime("2017-11-12 11:54:39"));
//		System.out.println("相差："+differenceTimes("2017-12-13 22:00:00"));
		System.out.println(getTodayTimes());
	}
}
