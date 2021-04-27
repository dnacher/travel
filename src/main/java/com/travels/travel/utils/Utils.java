package com.travels.travel.utils;

import com.travels.travel.exceptions.TravelException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Utils {

    public static final Integer GMT = -3;

    public static void validateIdNull(Integer id, String errorMsg){
        if (id != null) {
            throw new TravelException(errorMsg);
        }
    }

    public static String getValue(String msg,Integer value){
        return msg + value;
    }

    public static String getValue(String msg,String value){
        return msg + value;
    }

    public static void validateUrlIdEqualsBodyId(int urlId, Integer bodyId, String errorMsg){
        if (bodyId == null || urlId != bodyId.intValue()) {
            throw new TravelException(errorMsg);
        }
    }

    public static Date setDateToSave(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 16);
        return cal.getTime();
    }

    public static Date setTodayDate(){
        Date today = new Date();
        LocalDate localDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        today.setHours(13);
        today.setMinutes(0);
        today.setSeconds(0);
        return today;
    }

    public static Date addHoursToJavaUtilDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 19);
        return calendar.getTime();
    }

}
