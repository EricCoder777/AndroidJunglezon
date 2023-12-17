/**
 * @title AppDatabase
 * @author Eric Rodriguez
 * @date 12-03-2023
 * @abstract This abstract class initialized the database for Junglezon app
 */
package com.daclink.androidjunglezon.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.daclink.androidjunglezon.User;
import com.daclink.androidjunglezon.Item;
import com.daclink.androidjunglezon.UserItems;

@Database(entities = {User.class, Item.class, UserItems.class}, version = 9)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "JUNGLEZON_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String ITEM_TABLE = "ITEM_TABLE";
    public static final String USER_ITEM_TABLE = "USER_ITEM_TABLE";

    public abstract JungleDAO getJungleDAO();
}