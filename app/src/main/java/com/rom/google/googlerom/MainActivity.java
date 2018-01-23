package com.rom.google.googlerom;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author liujinyuan
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AbstractAppDatabase instance = AbstractAppDatabase.getInstance(getApplicationContext());
        User user = new User();
        user.firstName="liu";
        instance.userDao().insertUsers(user);

    }


    /**
     * 按照顺序执行数据库表的升级
     */
    void updateDateBase() {


        Migration MIGRATION_1_2 = new Migration(1, 2) {
            @Override
            public void migrate(SupportSQLiteDatabase database) {
                database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, "
                        + "`name` TEXT, PRIMARY KEY(`id`))");
            }
        };

        Migration MIGRATION_2_3 = new Migration(2, 3) {
            @Override
            public void migrate(SupportSQLiteDatabase database) {
                database.execSQL("ALTER TABLE Book "
                        + " ADD COLUMN pub_year INTEGER");
            }
        };

       /* Room.databaseBuilder(getApplicationContext(), MyDb.class, "database-name")
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3).build();*/
    }

}
