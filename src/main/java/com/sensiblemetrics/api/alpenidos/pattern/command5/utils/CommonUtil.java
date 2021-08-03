package com.sensiblemetrics.api.alpenidos.pattern.command5.utils;

import java.util.Calendar;

public class CommonUtil {

    public static int daysOfTwo(final Calendar befor, final Calendar after) {
        final int day1 = befor.get(Calendar.DAY_OF_YEAR);
        final int day2 = after.get(Calendar.DAY_OF_YEAR);
        return day2 - day1;
    }
}
