package com.felece.ticket.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    public static DateFormat getDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static Date stringToDate(String stringDate){
        try {
            return getDateFormat().parse(stringDate);
        }catch (Exception e){
            return null;
        }
    }

    public static String dateToString(Date date){
        return getDateFormat().format(date);
    }
}
