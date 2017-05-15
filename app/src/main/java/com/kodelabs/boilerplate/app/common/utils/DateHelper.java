package com.kodelabs.boilerplate.app.common.utils;

import android.support.annotation.Nullable;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Helper class to facilitate date manipulation on conductivities.
 *
 * Created by luisburgos on 9/2/16.
 */
public class DateHelper {

    ///Date patterns.
    private static final String SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String LOCATION_HISTORY_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String HOURS_MINUTES_SECONDS_FORMAT = "HH:mm";
    private static final String DAY_AND_MONTH_FORMAT = "dd/MM";
    private static final String ONLY_DATE_FORMAT = DAY_AND_MONTH_FORMAT +"/yyyy";

    ///Application time zone.
    private static final String AMERICA_MEXICO_CITY = "America/Mexico_City";

    ///Date formatter.
    private static final SimpleDateFormat serverDateFormatter = new SimpleDateFormat(SERVER_DATE_FORMAT);
    private static final DateFormat onlyDateFormatter = new SimpleDateFormat(ONLY_DATE_FORMAT);
    private static final DateFormat dayNMonthDateFormatter = new SimpleDateFormat(DAY_AND_MONTH_FORMAT);
    private static final DateFormat timeDateFormatter = new SimpleDateFormat(HOURS_MINUTES_SECONDS_FORMAT);
    private static final DateFormat locationHistoryFormatter = new SimpleDateFormat(LOCATION_HISTORY_DATE_FORMAT);

    @Nullable
    public static Date getDateFromTimeStamp(String rawTimeStampString){
        Date date = null;
        try {
            return serverDateFormatter.parse(rawTimeStampString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getTimeFromTimeStamp(String rawTimeStampString) {
        return getTimeFromDate(getDateFromTimeStamp(rawTimeStampString));
    }

    public static Date getDateFromUnixTime(long unixTime) {
        return new Date(unixTime);
    }

    public static String getDayAndMonthFromUnixTime(long unixTime) {
        Date date = getDateFromUnixTime(unixTime);
        return getDayAndMonthFromDate(date);
    }

    public static String getOnlyDateFromTimeStamp(String rawTimeStampString) {
        Date date = getDateFromTimeStamp(rawTimeStampString);
        return getOnlyDateFromDate(date);
    }

    public static String getDayAndMonthFromTimeStamp(String rawTimeStampString) {
        Date date = getDateFromTimeStamp(rawTimeStampString);
        return getDayAndMonthFromDate(date);
    }

    public static String getDayAndMonthFromDate(Date date){
        return dayNMonthDateFormatter.format(date);
    }

    public static String getOnlyDateFromDate(Date date){
        return onlyDateFormatter.format(date);
    }

    public static String getTimeFromDate(Date date) {
        return timeDateFormatter.format(date);
    }

    public static String getPrettyTime(String rawTimeStampString) {
        return getPrettyTime(getDateFromTimeStamp(rawTimeStampString));
    }

    public static String getPrettyTime(Date date) {
        PrettyTime prettyTime = new PrettyTime(new Locale("es"));
        return prettyTime.format(date);
    }

    private static Date fromGMTtoAmericaMexicoDate(Date dateInGMT) throws ParseException {
        String dateInAmericaMexico = getDateStringWithTimeZone(dateInGMT, AMERICA_MEXICO_CITY);
        return serverDateFormatter.parse(dateInAmericaMexico);
    }

    private static String getDateStringWithTimeZone(Date date, String timeZone){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat format = new SimpleDateFormat(SERVER_DATE_FORMAT);

        format.setTimeZone(TimeZone.getTimeZone(timeZone));
        Date differedDate = calendar.getTime();

        return format.format(differedDate);
    }


    public static String getYesterday() {
        DateFormat dateFormat = locationHistoryFormatter;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return dateFormat.format(cal.getTime());
    }

    public static String getToday() {
        DateFormat df = locationHistoryFormatter;
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }

    public static String toBirthdate(String birthdate) {
        Date date = getDateFromTimeStamp(birthdate);
        return getOnlyDateFromDate(date);
    }

    public static Date getDAteFromSimpleBirthdate(String currentDateString) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(currentDateString);//catch exception

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }


}
