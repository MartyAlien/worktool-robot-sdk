package com.github.alien.sdk.wxrobot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * <br/>
 *
 * @author alien at 2024/3/19 15:53
 */
public class DateUtil {
    private DateUtil() {
        throw new UnsupportedOperationException("DateUtil is a utility class and cannot be instantiated");
    }

    private static final SimpleDateFormat FORMAT_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatToDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return FORMAT_1.format(date);
    }

    public static String format(Date date, String pattern) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        }
        if (pattern == null || pattern.isEmpty()) {
            throw new IllegalArgumentException("pattern is empty");
        }
        return new SimpleDateFormat(pattern).format(date);
    }
}
