package com.baiHoo.utils.format;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtils {
	public static final String formatDate(Long time){
		if(time==null) return "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(new Date(time));
	}
	public static final String formatTime(Long time){
		if(time==null) return "";
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(new Date(time));
	}
	public static final String formatDatatime(Long time){
		if(time==null) return "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date(time));
	}
	
	public static final Long parseDate(String dateCharacter){
		if(dateCharacter==null) return 0l;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = dateFormat.parse(dateCharacter);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static  final String  formatMoney(Double price){
		if(price ==null)
			return  "非法格式";
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(price);
	}
}
