package com.haneet.infsec.keylogapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateTimeHelper {

    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    private final static Calendar calendar = Calendar.getInstance(new Locale("tr"));


    public static Date getCurrentDay() {

        Date date = new Date();
        simpleDateFormat.format(date);
        return date;
    }

    public static String getTheDateInString(Date baseDate) {

        if (baseDate == null) {
            return "";
        }

        String dateString = simpleDateFormat.format(baseDate);

        return dateString == null ? "" : dateString;
    }

    public static Date getTheDateInDate(String baseDate) {

        if (baseDate == null) {
            return new Date();
        }

        Date date = null;

        try {
            date = simpleDateFormat.parse(baseDate);

        } catch (ParseException e) {

            e.printStackTrace();
        }

        return date == null ? new Date() : date;
    }

    public static Date getMondayOfTheWeek(Date date) {
        return getDayOfTheWeek(date, 1);
    }

    public static String getFirstDayOfWeek(Date date) {
        return getTheDateInString(getMondayOfTheWeek(date));
    }
    public static Date getSundayOfTheWeek(Date date) {
        return getDayOfTheWeek(date, 7);
    }

    public static String getLastDayOfWeek(Date date) {
        return getTheDateInString(getSundayOfTheWeek(date));
    }

    private static Date getDayOfTheWeek(Date date, int daySort) {

        calendar.setTime(date);

        if (daySort == 1) {

            // Set the calendar to MONDAY of the current week
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        } else if (daySort == 7) {

            // Set the calendar to SUNDAY of the current week
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }

        return calendar.getTime();
    }

    public static List<String> getAllDaysOfTheWeek() {

        List<String> dateList = new ArrayList<String>();

        calendar.setTime(new Date()); // What day is today?


        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        dateList.add(getTheDateInString(calendar.getTime()));

        for (int i = 1; i <= 6; i++) {

            calendar.add(Calendar.DAY_OF_WEEK, 1);
            dateList.add(getTheDateInString(calendar.getTime()));
        }

        return dateList;
    }

    /* Akif - FormattedDateBuilder */

    public static String getFirstDayOfMonth(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date dddd = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        return sdf1.format(dddd);
    }

    public static String getLastDayOfMonth(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date dddd = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        return sdf1.format(dddd);
    }

    public static int getNumericLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static int getCurrentWeekNumber() {
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }

    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}