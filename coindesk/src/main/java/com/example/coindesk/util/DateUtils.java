package com.example.coindesk.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	// updated
	public static String getUpdated() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}

}
