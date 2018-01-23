package com.rom.google.googlerom;

import android.arch.persistence.room.ColumnInfo;

/**
 *
 * @author liujinyuan
 * @date 2018/1/23
 */

public class Address {
    public String street;
    public String state;
    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;
}
