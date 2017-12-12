package cn.qblank.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyUtils {
	
	/**
	 * 获取当前的时间
	 * @return String
	 */
	public static Date getCurTimes(){
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date rentTime = null;
		try {
			java.util.Date date2 =  sdf.parse(sdf.format(date));
			rentTime = new Date(date2.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return rentTime;
	}
}
