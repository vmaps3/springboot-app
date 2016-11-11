package com.wangsong.commons.util;

import java.util.Date;

public class DateUtil {
	public static String dateToString(Date date){
		if(date==null){
			return "";
		}else{
			java.text.DateFormat format2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format2.format(date);
		}
	}
	
}
