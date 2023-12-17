/**
 * @title JugleDAO
 * @author Eric Rodriguez
 * @date 12-103-2023
 * @abstract This interface initializes the SQLite commands for the database in Junglezon app
 */

package com.daclink.androidjunglezon.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.daclink.androidjunglezon.Item;
import com.daclink.androidjunglezon.User;
import com.daclink.androidjunglezon.UserItems;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface JungleDAO {
    @Insert
    void insert(UserItems... userItems);
    @Update
    void update(UserItems... userItems);
    @Delete
    void delete(UserItems userItem);
    @Insert
    void insert(Item... items);
    @Update
    void update(Item... items);
    @Delete
    void delete(Item item);

    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserID = :userID")
    User getUserByID(int userID);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserName = :userName")
    User getUserByName(String userName);

    @Query("SELECT * FROM " + AppDatabase.ITEM_TABLE)
    List<Item> getAllItems();
    @Query("SELECT * FROM " + AppDatabase.ITEM_TABLE + " WHERE mItemID = :itemID")
    Item getItemByID(int itemID);
    @Query("SELECT * FROM " + AppDatabase.ITEM_TABLE + " WHERE mItemName = :itemName")
    Item getItemByName(String itemName);
    @Query("SELECT mItemName FROM " + AppDatabase.ITEM_TABLE)
    String getItemNames();




}
