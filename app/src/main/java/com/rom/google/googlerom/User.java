package com.rom.google.googlerom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by liujingyuan on 2018/1/23.
 * 代表意思创建一个表名为users，first_name和last_name属性为唯一不能重复
 */
@Entity(tableName = "users", indices = {@Index(value = {"first_name", "last_name"}, unique = true)})
public class User {
    @PrimaryKey
    public int id;
    /**
     * 定义在表中显示的名字
     */
    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    /**
     * 代表引入另一个实体类
     */
    @Embedded
    public Address address;
}
