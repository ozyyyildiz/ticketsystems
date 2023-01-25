package com.felece.ticket.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final DateFormat DATE_FORMAT = SIMPLE_DATE_FORMAT;

    public static Date stringToDate(String stringDate){
        try {
            return SIMPLE_DATE_FORMAT.parse(stringDate);
        }catch (Exception e){
            return null;
        }
    }

    public static String dateToString(Date date){
        return DATE_FORMAT.format(date);
    }
}
