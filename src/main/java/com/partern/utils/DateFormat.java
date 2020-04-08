package com.partern.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static String format(Date date){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sf.format(date);
    }
}
