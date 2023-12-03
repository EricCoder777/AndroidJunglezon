package com.daclink.androidjunglezon;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.daclink.androidjunglezon.db.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int mUserID;
    private String mUserName;
    private String mUserPassword;
    private Boolean isAdmin;

    public User(String mUserName, String mUserPassword) {
        this.mUserName = mUserName;
        this.mUserPassword = mUserPassword;
        this.isAdmin = false;
    }

    public int getUserID() {
        return mUserID;
    }

    public void setUserID(int mUserID) {
        this.mUserID = mUserID;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getUserPassword() {
        return mUserPassword;
    }

    public void setUserPassword(String mUserPassword) {
        this.mUserPassword = mUserPassword;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}

