package com.rom.google.googlerom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 *
 * @author liujinyuan
 * @date 2018/1/23
 */

@Database(entities = {User.class}, version = 1,exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AbstractAppDatabase extends RoomDatabase {
    private static AbstractAppDatabase INSTANCE;
    private static final Object sLock = new Object();

    public abstract UserDao userDao();

    public static AbstractAppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(), AbstractAppDatabase.class, "user.db").allowMainThreadQueries()
                                .build();
            }
            return INSTANCE;
        }
    }
}
