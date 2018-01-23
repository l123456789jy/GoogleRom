package com.rom.google.googlerom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by liujinyuan on 2018/1/23.
 */
@Dao
public interface UserDao {
    @Delete
    public void deleteUsers(User... users);

    /**
     * 会自动进行语法检查出错会提示
     *
     * @return
     */
    @Query("SELECT * FROM users")
    public User[] loadAllUsers();


    @Update
    public void updateUsers(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User... users);

    @Insert
    public void insertBothUsers(User user1, User user2);

    @Insert
    public void insertUsersAndFriends(User user, List<User> friends);


}
