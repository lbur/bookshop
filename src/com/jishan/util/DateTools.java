package com.jishan.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {
	public static String dateToString(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		return sdf.format(d) ;
	}
}
