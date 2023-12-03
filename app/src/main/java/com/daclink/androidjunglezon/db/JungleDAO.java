package com.daclink.androidjunglezon.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.daclink.androidjunglezon.User;

import java.util.List;

@Dao
public interface JungleDAO {

    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User userLogs);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserID = :userID")
    User getUserByID(int userID);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserName = :userName")
    User getUserByName(String userName);

}
