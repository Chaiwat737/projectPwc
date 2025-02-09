package com.pwc.config;


import lombok.extern.slf4j.Slf4j;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Slf4j
public class DateUtil {
	public static final String DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_PATTERN = "dd/MM/yyyy";
	public static final String DATE_PATTERNYEAR = "yyyy/MM/dd";
	public static final String DATE_PATTERN2 = "dd-MM-yyyy";
	public static final String FMT_DB_YYYYMMDD = "yyyyMMdd";
	public static final String FMT_VIEW_TIMESTAMP = "HH:mm:ss";
	public static final String FMT_DB_DDMMYYYY = "ddMMyyyy";
	public static final String FMT_DATE_YYYY = "yyyy";
	public static final String DATE_TIME_PATTERN2 = "yyyy-MM-dd HH:mm:ss";
	public static final String ISO_LOCAL_DATE_TIME_S = "yyyy-MM-dd HH:mm:ss.S";
	public static final String THAI_BUDDHIST_MONTH_YEAR = "MMMM yyyy";

	public static final Locale LOCALE_TH = new Locale("th", "TH");
	public static final Locale LOCALE_EN = new Locale("en", "EN");
	public static final String TIME_ZONE = "GMT+07:00";

	public static Timestamp getCurrentDate() {
        Timestamp today = null;
        try {
            Date nowDate = Calendar.getInstance().getTime();
            today = new Timestamp(nowDate.getTime());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return today;
    }


}
