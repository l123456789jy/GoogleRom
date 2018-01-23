package com.rom.google.googlerom;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by liujinyuan on 2018/1/23.
 * 数据库中直接插入具体的日期
 */

public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
